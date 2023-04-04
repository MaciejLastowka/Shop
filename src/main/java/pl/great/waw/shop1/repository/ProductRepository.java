package pl.great.waw.shop1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.great.waw.shop1.domain.Category;
import pl.great.waw.shop1.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public Product create(Product product) {
        product.setCreated(LocalDateTime.now());
        product.setUpdated(LocalDateTime.now());
        return this.entityManager.merge(product);
    }

    public Product findById(Long id) {
        return this.entityManager.find(Product.class, id);
    }

    @Transactional
    public List<Product> findByCategory(String title) {
        Category category = this.categoryRepository.findByTitle(title);
        Query query = this.entityManager.createQuery("from Product where category=:category");
        query.setParameter("category", category);
        return query.getResultList();

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
