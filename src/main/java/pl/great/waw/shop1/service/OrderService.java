package pl.great.waw.shop1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.great.waw.shop1.Mapper.OrderLineItemMapper;
import pl.great.waw.shop1.Mapper.OrderMapper;
import pl.great.waw.shop1.controller.dto.OrderDto;
import pl.great.waw.shop1.domain.OrderLineItem;
import pl.great.waw.shop1.domain.Orders;
import pl.great.waw.shop1.repository.OrderRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderLineItemMapper orderLineItemMapper;

    @Autowired
    private OrderRepository repository;

    @PersistenceContext
    @Autowired
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

        repository.createOrder(order);

        return orderMapper.map(repository.findOrderById(orderFromDb.getId()));
    }

    public OrderDto findById(Long id) {
        return orderMapper.map(repository.findOrderById(id));
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
