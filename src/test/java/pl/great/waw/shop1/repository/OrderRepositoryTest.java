package pl.great.waw.shop1.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.great.waw.shop1.domain.Category;
import pl.great.waw.shop1.domain.OrderLineItem;
import pl.great.waw.shop1.domain.Orders;
import pl.great.waw.shop1.domain.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderRepositoryTest {
    private static final String PRODUCT_TITLE = "iPhone 14";
    private static final String DESCRIPTION = "The iPhone is a line of smartphones by Apple";
    private static final BigDecimal PRICE = BigDecimal.valueOf(999);
    private static final LocalDateTime time1 = LocalDateTime.now();


    @Autowired
    private OrderRepository orderRepository ;


    @Test
    public void addProductToOrderList() {
        Category category2 = new Category();
        category2.setTitle("DOM");
        Orders order = new Orders();
        Product temp = new Product(category2,PRODUCT_TITLE, DESCRIPTION, PRICE, time1, time1);
        OrderLineItem test = this.orderRepository.addProductToOrderList(order, temp, 1L);
        assertEquals(temp.getId(), test.getProduct().getId());
    }

    @Test
    public void createOrder() {
    }

    @Test
    public void findOrderById() {
    }

    @Test
    public void findOrdersByAccountId() {
    }
}