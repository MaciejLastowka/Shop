package pl.great.waw.shop1.repository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.great.waw.shop1.domain.Cart;
import pl.great.waw.shop1.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;

@Repository
public class CartRepository {


    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Cart createCart(Cart cart){
        cart.setCreated(LocalDateTime.now());
        cart.setUpdated(LocalDateTime.now());
        this.entityManager.persist(cart);
        return cart;
    }
    public Cart findCartById(Long id) {
        return this.entityManager.find(Cart.class, id);
    }

    @Transactional
    public void deleteAll() {
        entityManager.createQuery("delete from Cart").executeUpdate();
    }
    @Transactional
    public void deleteOne(Long id) {
        Cart cartById = findCartById(id);
        entityManager.remove(cartById);
    }
}
