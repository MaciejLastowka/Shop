package pl.great.waw.shop1.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.great.waw.shop1.Mapper.OrderMapper;
import pl.great.waw.shop1.Mapper.OrderViewMapper;
import pl.great.waw.shop1.controller.dto.OrderDto;
import pl.great.waw.shop1.controller.dto.OrderDtoView;
import pl.great.waw.shop1.domain.*;
import pl.great.waw.shop1.repository.AccountRepository;
import pl.great.waw.shop1.repository.CartRepository;
import pl.great.waw.shop1.repository.OrderRepository;
import pl.great.waw.shop1.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final AccountRepository accountRepository;
    private final OrderMapper orderMapper;
    private final OrderViewMapper orderMapperView;

    public OrderService(OrderRepository repository, ProductRepository productRepository, CartRepository cartRepository,
                        AccountRepository accountRepository, OrderMapper orderMapper, OrderViewMapper orderMapperView) {
        this.repository = repository;
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.accountRepository = accountRepository;
        this.orderMapper = orderMapper;
        this.orderMapperView = orderMapperView;
    }

    public OrderDtoView findById(Long id) {
        return orderMapperView.map(repository.findOrderById(id));
    }

    public OrderDto create() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        Account account = accountRepository.findByName(name);

        Cart cart = cartRepository.get(name);
        Orders orders = new Orders();

        List<CartLineItem> cartLineItemList = cart.getCartLineItemList();
        List<OrderLineItem> orderLineItemList = mapToOrderLineItem(orders, cartLineItemList);
        BigDecimal totalPrice = calculateTotalPrice(orderLineItemList);

        orders.setAccount(account);
        orders.setOrderLineItems(orderLineItemList);
        orders.setTotalPrice(totalPrice);

        Orders order = repository.createOrder(orders);

        cart.reset();
        cartRepository.update(cart);

        return orderMapper.map(order);
    }

    private BigDecimal calculateTotalPrice(List<OrderLineItem> orderLineItemList) {
        return orderLineItemList.stream()
                .map(orderLineItem1 -> {
                    Long productId = orderLineItem1.getProduct().getId();
                    Product product = productRepository.findById(productId);
                    return product.getPrice().multiply(BigDecimal.valueOf(orderLineItem1.getAmount()));
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private List<OrderLineItem> mapToOrderLineItem(Orders orders, List<CartLineItem> cartLineItemList) {
        return cartLineItemList.stream()
                .map(cartLineItem -> {
                    String productTitle = cartLineItem.getProduct().getTitle();
                    Product product = productRepository.findByTitle(productTitle);
                    Long amount = (long) cartLineItem.getQuantity();
                    return new OrderLineItem(orders, product, amount);
                })
                .collect(Collectors.toList());
    }
}
