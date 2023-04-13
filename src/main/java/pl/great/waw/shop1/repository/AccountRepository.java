package pl.great.waw.shop1.repository;

import org.springframework.stereotype.Repository;
import pl.great.waw.shop1.domain.Account;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Account findByName(String name) {
        Query query = this.entityManager.createQuery("from Account where name=:name");
        query.setParameter("name", name);
        Object singleResult = query.getSingleResult();
        return (Account) singleResult;

    }

    public Account findById(String accountId) {
        Query query = this.entityManager.createQuery("from Account where id=:id");
        query.setParameter("id", accountId);
        Object singleResult = query.getSingleResult();
        return (Account) singleResult;
    }

    public List<Account> findAll() {
        Query query = this.entityManager.createQuery("from Account ");
        return query.getResultList();
    }
}
