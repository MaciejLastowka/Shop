package pl.great.waw.shop1.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import pl.great.waw.shop1.Mapper.OrderMapper;
import pl.great.waw.shop1.domain.*;
import pl.great.waw.shop1.repository.OrderRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class OrderServiceTest {
    private static final String PRODUCT_TITLE = "iPhone 14";
    private static final String DESCRIPTION = "The iPhone is a line of smartphones by Apple";
    private static final BigDecimal PRICE = BigDecimal.valueOf(999);
    private static final String PRODUCT_TITLE1 = "iPhone";
    private static final String DESCRIPTION1 = "The iPhone is a line Apple";
    private static final BigDecimal PRICE1 = BigDecimal.valueOf(9);
    private static final LocalDateTime time1 = LocalDateTime.now();
    @Mock
    OrderRepository orderRepository;

    @Mock
    private OrderMapper orderMapper;

    @InjectMocks
    OrderService orderService;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @BeforeEach
    public void setUp() {
//        Category category2 = new Category();
//        Product product = new Product(category2,PRODUCT_TITLE, DESCRIPTION, PRICE, time1, time1);
//        List<OrderLineItem> orderLineItems= new ArrayList<>();
//        Orders orderFromRepo = new Orders();
//        orderFromRepo.setId(1L);
//        OrderLineItem orderLineItem1 = new OrderLineItem(orderFromRepo,product,1L);
//        OrderLineItem orderLineItem2 = new OrderLineItem(orderFromRepo,product,2L);
//        orderLineItems.add(orderLineItem1);
//        orderLineItems.add(orderLineItem2);
//        orderFromRepo.setOrderLineItems(orderLineItems);
//        Account account = new Account();
//        account.setId(1L);
//        orderFromRepo.setAccount(account);
//        OrderDto orderDtoFromController = orderMapper.map(orderFromRepo);
//        when(orderRepository.findOrderById(anyLong())).thenReturn(orderFromRepo);
    }


    @Test
    public void create() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void getTotalPrice() {
        Category category2 = new Category();
        Product product = new Product(category2, PRODUCT_TITLE, DESCRIPTION, PRICE, time1, time1);
        List<OrderLineItem> orderLineItems = new ArrayList<>();
        Orders orderFromRepo = new Orders();
        orderFromRepo.setId(1L);
        OrderLineItem orderLineItem1 = new OrderLineItem(orderFromRepo, product, 1L);
        OrderLineItem orderLineItem2 = new OrderLineItem(orderFromRepo, product, 2L);
        orderLineItems.add(orderLineItem1);
        orderLineItems.add(orderLineItem2);
        orderFromRepo.setOrderLineItems(orderLineItems);
        Account account = new Account();
        account.setId(1L);
        orderFromRepo.setAccount(account);
        when(orderRepository.findOrderById(anyLong())).thenReturn(orderFromRepo);
        this.orderService.setOrderTotalPrice(1L);
        BigDecimal totalPrice = this.orderService.getTotalPrice(1L);
        assertEquals(BigDecimal.valueOf(2997), totalPrice);
    }
}