package pl.great.waw.shop1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.great.waw.shop1.domain.OrderLineItem;
import pl.great.waw.shop1.domain.Orders;
import pl.great.waw.shop1.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    @PersistenceContext
    @Autowired
    private EntityManager entityManager;
    List<OrderLineItem> orderList = new ArrayList<OrderLineItem>();

    @Transactional
    public Orders newOrder() {
        return new Orders();
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
//    public OrderLineItem addProductToOrderList(Orders order, Product product, Long amount) {
//        OrderLineItem productToSaveOnOrderLineItemList = new OrderLineItem(order, product, amount);
//        productToSaveOnOrderLineItemList.setOrders(order); // set the Orders object
//        orderList.add(productToSaveOnOrderLineItemList);
//        return this.entityManager.merge(productToSaveOnOrderLineItemList);
//    }


//    public OrderLineItem addProductToOrderList(Orders order, Product product, Long amount) {
//        OrderLineItem productToSaveOnOrderLineItemList = new OrderLineItem(order, product, amount);
//        orderList.add(productToSaveOnOrderLineItemList);
//        return this.entityManager.merge(productToSaveOnOrderLineItemList);
//    }

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
        Query query = this.entityManager.createQuery("SELECT o FROM Orders o LEFT JOIN FETCH o.orderLineItems where o.id=:orderId");
        query.setParameter("orderId", orderId);
        Object singleResult = query.getSingleResult();
        return (Orders) singleResult;
    }
//    public Orders findOrderById(Long orderId) {
//        Query query = this.entityManager.createQuery("SELECT o FROM Orders o LEFT JOIN FETCH o.orderLineItems where o.id=:orderId");
//        query.setParameter("orderId", orderId);
//        Object singleResult = query.getSingleResult();
//        return (Orders) singleResult;
//    }

    public List<Orders> findOrdersByAccountId(Long accountId) {
        Query query = this.entityManager.createQuery("from Orders where account_id=:id");
        query.setParameter("id", accountId);
        return query.getResultList();
    }


    public BigDecimal getTotalPrice(Long orderId) {
        Orders order = findOrderById(orderId);
        Query query = this.entityManager.createQuery("Orderlineitem from Orders where order_id=:id");
        query.setParameter("id", order.getId());
        List<OrderLineItem> orderLineItemList = query.getResultList();
        BigDecimal totalPrice = orderLineItemList.stream()
                .map(OrderLineItem -> (OrderLineItem.getProduct().getPrice())
                        .multiply(BigDecimal.valueOf(OrderLineItem.getAmount())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        order.setTotalPrice(totalPrice);

        return order.getTotalPrice();
    }

//    public BigDecimal getTotalPrice(Long orderId) {
//        Orders order = entityManager.find(Orders.class, orderId);
//        BigDecimal totalPrice = BigDecimal.ZERO;
//        for (OrderLineItem item : order.getOrderLineItems()) {
//            totalPrice = totalPrice.add(item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getAmount())));
//        }
//        return totalPrice;
//    }

//    public BigDecimal getTotalPrice(Long orderId) {
//        Query query = this.entityManager.createQuery("from ORDERLINEITEM where order_id=:id");
//        query.setParameter("id", orderId);
//        List<OrderLineItem> orderLineItemList = query.getResultList();
//        BigDecimal totalPrice = orderLineItemList.stream()
//                .map(OrderLineItem -> (OrderLineItem.getProduct().getPrice())
//                        .multiply(BigDecimal.valueOf(OrderLineItem.getAmount())))
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//        findOrderById(orderId).setTotalPrice(totalPrice);
//
//        return findOrderById(orderId).getTotalPrice();
//    }

}

