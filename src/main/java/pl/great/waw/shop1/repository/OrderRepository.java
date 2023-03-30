package pl.great.waw.shop1.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.great.waw.shop1.domain.OrderLineItem;
import pl.great.waw.shop1.domain.Orders;
import pl.great.waw.shop1.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;
    List<OrderLineItem> orderList = new ArrayList<OrderLineItem>();

    @Transactional
    public Orders newOrder() {
        return new Orders();
    }

    @Transactional
    public OrderLineItem addProductToOrderList(Orders order, Product product, Long amount) {
        OrderLineItem productToSaveOnOrderLineItemList = new OrderLineItem(order, product, amount);
        orderList.add(productToSaveOnOrderLineItemList);
        return this.entityManager.merge(productToSaveOnOrderLineItemList);
    }

    @Transactional
    public Orders createOrder(Orders order) {
        Orders merge = this.entityManager.merge(order);
        this.entityManager.flush();
        return merge;
    }

    public Orders findOrderById(Long orderId) {
        Query query = this.entityManager.createQuery("SELECT o FROM Orders o LEFT JOIN FETCH o.orderLineItems where o.id=:orderId");
        query.setParameter("orderId", orderId);
        Object singleResult = query.getSingleResult();
        return (Orders) singleResult;
    }

    public List<Orders> findOrdersByAccountId(Long accountId) {
        Query query = this.entityManager.createQuery("from Orders where account_id=:id");
        query.setParameter("id", accountId);
        return query.getResultList();
    }

}

