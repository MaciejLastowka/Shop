package pl.great.waw.shop1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.great.waw.shop1.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;
    List<OrderLineItem> orderList = new ArrayList<OrderLineItem>();

    @Transactional
    public Orders newOrder(){
        return new Orders();
    }

    @Transactional
    public OrderLineItem addProductToOrderList(Orders order, Product product, Long amount){
        OrderLineItem productToSaveOnOrderLineItemList = new OrderLineItem(order,product,amount);
        orderList.add(productToSaveOnOrderLineItemList);
        return this.entityManager.merge(productToSaveOnOrderLineItemList);
    }

    @Transactional
    public Orders createOrder(Orders order) {
        return this.entityManager.merge(order);
    }
    public Orders findOrderById(Long orderId) {
        return this.entityManager.find(Orders.class, orderId);
    }
    public List<Orders> findOrdersByAccountId(Long accountId){
        Query query = this.entityManager.createQuery("from Orders where account_id=:id");
        query.setParameter("id", accountId);
        return query.getResultList();
    }

}

