package pl.great.waw.shop1.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.great.waw.shop1.domain.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class OrderRepositoryTest {
    private static final Long ID = 1L;
    private static final String PRODUCT_TITLE = "iPhone 14";
    private static final String DESCRIPTION = "The iPhone is a line of smartphones by Apple";
    private static final BigDecimal PRICE = BigDecimal.valueOf(999);
    private static final LocalDateTime time1 = LocalDateTime.now();
    private static final String NAME = "TEST";

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private AccountRepository accountRepository;
    private final List<OrderLineItem> orderList = new ArrayList<OrderLineItem>();

    @BeforeEach
    void setBefore() {
        //category
        Category category = new Category();
        category.setTitle("DOM");
        category.setId(ID);

        //Product
        Product product = new Product(category, PRODUCT_TITLE, DESCRIPTION, PRICE, time1, time1);
        product.setId(1L);
        product.setCategory(category);
        product.setTitle(PRODUCT_TITLE);
        product.setDescription(DESCRIPTION);
        product.setPrice(PRICE);
        product.setUpdated(time1);
        product.setCreated(time1);
        Account account = new Account(NAME, null, null);

    }


    @Test
    void createOrder() {
        //given

        Orders order = new Orders();
        order.setAccount(accountRepository.findByName(NAME));
        //when
        Orders savedOrder = orderRepository.createOrder(order);
        //then
        assertEquals(savedOrder.getId(), order.getId());
        assertNotNull(savedOrder.getId());

    }

    @Test
    void findOrderById() {
        //given
        Orders order = new Orders();
        order.setAccount(accountRepository.findByName(NAME));
        Orders savedOrder = orderRepository.createOrder(order);

        //when
        Orders findOrder = orderRepository.findOrderById(savedOrder.getId());

        //then
        assertEquals(savedOrder.getId(), findOrder.getId());
    }
}

