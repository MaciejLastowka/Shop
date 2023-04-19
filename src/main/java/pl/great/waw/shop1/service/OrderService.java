package pl.great.waw.shop1.service;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.great.waw.shop1.Mapper.CartMapper;
import pl.great.waw.shop1.Mapper.OrderLineItemMapper;
import pl.great.waw.shop1.Mapper.OrderMapper;
import pl.great.waw.shop1.Mapper.OrderMapperView;
import pl.great.waw.shop1.controller.dto.CartDto;
import pl.great.waw.shop1.controller.dto.OrderDto;
import pl.great.waw.shop1.controller.dto.OrderDtoView;
import pl.great.waw.shop1.domain.*;
import pl.great.waw.shop1.repository.CartRepository;
import pl.great.waw.shop1.repository.OrderRepository;
import pl.great.waw.shop1.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.ArrayList;
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
    private CartMapper cartMapper;

    @Autowired
    private OrderRepository repository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;


    @PersistenceContext
    private EntityManager entityManager;

    //FIXME ADD RESL Implementation - Create ORDER BASED on LOGGED USER
    public OrderDto create(CartDto cartDto) {
        Cart cart = cartMapper.map(cartDto);
        Orders orders = new Orders();
        //Orders orderFromDb = repository.createOrder(orders);
        //Orders order = repository.findOrderById(orderFromDb.getId());
        OrderLineItem orderLineItem = new OrderLineItem();
        List<OrderLineItem> orderLineItemList = new ArrayList<>();
        List<CartLineItem> cartLineItemList =  cart.getCartLineItemList();
                cartLineItemList
                .forEach(cartLineItem -> {
                    Long productId = cartLineItem.getProduct().getId();
                    Product product = productRepository.findById(productId);
                    Long amount = (long) cartLineItem.getQuantity();
                    BigDecimal productPrice = cartLineItem.getProduct().getPrice();
                    BigDecimal totalPrice = cartLineItem.getProduct().getPrice().multiply(BigDecimal.valueOf(cartLineItem.getQuantity()));
                    OrderLineItem orderLineItemFromCart = new OrderLineItem(orders, product, amount);
                    orderLineItemList.add(orderLineItemFromCart);
                });
        BigDecimal totalPrice = BigDecimal.ZERO;
                for (OrderLineItem orderLineItemPrice : orderLineItemList) {
                        Long productId = orderLineItem.getProduct().getId();
                        Product product = productRepository.findById(productId);
                        BigDecimal lineItemTotalPrice = product.getPrice().multiply(BigDecimal.valueOf(orderLineItem.getAmount()));
                        totalPrice = totalPrice.add(lineItemTotalPrice);
                    }
            orders.setAccount(cartLineItemList.get(1).getCart().getAccount());
            orders.setOrderLineItems(orderLineItemList);
            orders.setTotalPrice(totalPrice);
            repository.createOrder(orders);
        return orderMapper.map(orders);
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
