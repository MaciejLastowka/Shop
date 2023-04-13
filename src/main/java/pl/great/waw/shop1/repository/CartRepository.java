package pl.great.waw.shop1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.great.waw.shop1.domain.Account;
import pl.great.waw.shop1.domain.Cart;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Repository
public class CartRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public Cart create(String name) {

        Account account = accountRepository.findByName(name);

        Cart cart = new Cart(Arrays.asList(), account, BigDecimal.ZERO);
        entityManager.persist(cart);

        return cart;
    }

    public Cart get(String name) {

        Account account = accountRepository.findByName(name);

        Query query = this.entityManager.createQuery("from Cart where account=:account ");
        query.setParameter("account", account);
        List resultList = query.getResultList();

        if (resultList.isEmpty()) {
            return null;
        }
        return (Cart) resultList.get(0);
    }

    @Transactional
    public Cart update(Cart cart) {
        return entityManager.merge(cart);
    }
}
