package pl.great.waw.shop1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.great.waw.shop1.Mapper.OrderLineItemMapper;
import pl.great.waw.shop1.Mapper.OrderMapper;
import pl.great.waw.shop1.Mapper.OrderMapperView;
import pl.great.waw.shop1.controller.dto.OrderDto;
import pl.great.waw.shop1.controller.dto.OrderDtoView;
import pl.great.waw.shop1.domain.OrderLineItem;
import pl.great.waw.shop1.domain.Orders;
import pl.great.waw.shop1.domain.Product;
import pl.great.waw.shop1.repository.OrderRepository;
import pl.great.waw.shop1.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    OrderMapperView orderMapperView;

    @Autowired
    private OrderLineItemMapper orderLineItemMapper;

    @Autowired
    private OrderRepository repository;
    @Autowired
    private ProductRepository productRepository;


    @PersistenceContext
    private EntityManager entityManager;

    public OrderDto create(OrderDto orderDto) {
        Orders orders = orderMapper.map(orderDto);
        orders.setOrderLineItems(Arrays.asList());
        Orders orderFromDb = repository.createOrder(orders);

        Orders order = repository.findOrderById(orderFromDb.getId());

        List<OrderLineItem> orderLineItems = orderDto.getOrderLineItems().stream()
                .map(orderLineItem -> {
                    OrderLineItem lineItem = orderLineItemMapper.map(orderLineItem);
                    lineItem.setOrders(order);
                    return lineItem;
                })
                .collect(Collectors.toList());

        order.setOrderLineItems(orderLineItems);
        List<OrderLineItem> orderLineItemList = order.getOrderLineItems();
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (OrderLineItem orderLineItem : orderLineItemList) {
            Long productId = orderLineItem.getProduct().getId();
            Product product = productRepository.findById(productId);
            BigDecimal lineItemTotalPrice = product.getPrice().multiply(BigDecimal.valueOf(orderLineItem.getAmount()));
            totalPrice = totalPrice.add(lineItemTotalPrice);
        }
//        BigDecimal totalPrice = orderLineItemList.stream()
//                .map(OrderLineItem -> (OrderLineItem.getProduct().getPrice())
//                        .multiply(BigDecimal.valueOf(OrderLineItem.getAmount())))
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
        order.setTotalPrice(totalPrice);

        repository.createOrder(order);

        return orderMapper.map(repository.findOrderById(orderFromDb.getId()));
    }

    public OrderDtoView findById(Long id) {
        return orderMapperView.map(repository.findOrderById(id));
    }




    public void setOrderTotalPrice(Long orderId) {
        Orders order = repository.findOrderById(orderId);
        List<OrderLineItem> orderLineItemList = order.getOrderLineItems();
        BigDecimal totalPrice = orderLineItemList.stream()
                .map(OrderLineItem -> (OrderLineItem.getProduct().getPrice())
                        .multiply(BigDecimal.valueOf(OrderLineItem.getAmount())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        order.setTotalPrice(totalPrice);

    }
    public BigDecimal getTotalPrice(Long orderId) {
        Orders order = repository.findOrderById(orderId);
        return order.getTotalPrice();
    }
}
