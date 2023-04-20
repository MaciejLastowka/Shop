package pl.great.waw.shop1.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.great.waw.shop1.domain.OrderLineItem;
import pl.great.waw.shop1.domain.Orders;
import pl.great.waw.shop1.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class OrderRepository {

    private final EntityManager entityManager;

    public OrderRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public OrderLineItem addProductToOrderList(Orders orders, Product product, Long amount) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setOrders(orders);
        orderLineItem.setProduct(product);
        orderLineItem.setAmount(amount);
        orders.getOrderLineItems().add(orderLineItem);
        return orderLineItem;
    }

    @Transactional
    public Orders createOrder(Orders order) {
        Orders merge = this.entityManager.merge(order);
        this.entityManager.flush();
        return merge;
    }


    public Orders findOrderById(Long orderId) {
        if (orderId == null) {
            return null;
        }
        Query query = this.entityManager.createQuery("SELECT o FROM Orders o " +
                "LEFT JOIN FETCH o.orderLineItems " +
                "where o.id=:orderId");
        query.setParameter("orderId", orderId);
        Object singleResult = query.getSingleResult();
        return (Orders) singleResult;
    }
}

