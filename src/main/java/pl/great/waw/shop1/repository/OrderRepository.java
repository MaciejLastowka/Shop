//package pl.great.waw.shop1.repository;
//
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//import pl.great.waw.shop1.domain.*;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class OrderRepository {
//    @PersistenceContext
//    private EntityManager entityManager;
//    List<OrderLineItem> orderList = new ArrayList<OrderLineItem>();
//
//    @Transactional
//    public OrderLineItem addProductToOrderList(Long orderId, Long productID, Long amount){
//        OrderLineItem productToSaveOnOrderList = new OrderLineItem(orderId,productID,amount);
//        orderList.add(productToSaveOnOrderList);
//        return productToSaveOnOrderList;
//    }
//
//    @Transactional
//    public Order createOrder(Order order) {
//        return this.entityManager.merge(order);
//    }
//
//
//}
//
