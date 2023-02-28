package pl.great.waw.shop1.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.great.waw.shop1.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;

@Repository
public class ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Product create(Product product) {
        product.setCreated(LocalDateTime.now());
        product.setUpdated(LocalDateTime.now());
        this.entityManager.persist(product);
        return product;
    }

    public Product findById(Long id) {
        return this.entityManager.find(Product.class, id);
    }

    @Transactional
    public void deleteAll() {
        entityManager.createQuery("delete from Product").executeUpdate();
    }

    @Transactional
    public boolean deleteById(Long id) {
        this.entityManager.remove(entityManager.find(Product.class, id));
        return true;
    }


    @Transactional
    public Product update(Product product) {
        return entityManager.merge(product);
    }
}
