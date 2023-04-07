package pl.great.waw.shop1.repository;

import org.springframework.stereotype.Repository;
import pl.great.waw.shop1.domain.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CategoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Category findByTitle(String title) {
        Query query = this.entityManager.createQuery("from Category where title=:title");
        query.setParameter("title", title);
        Object singleResult = query.getSingleResult();
        return (Category) singleResult;
    }

    public List<Category> findAll(){
        Query query = this.entityManager.createQuery("from Category");
        return query.getResultList();
    }

}
