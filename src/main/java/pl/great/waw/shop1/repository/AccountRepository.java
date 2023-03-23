

package pl.great.waw.shop1.repository;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AccountRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public AccountRepository create(AccountRepository accountRepository) {
        this.entityManager.persist(accountRepository);
        return accountRepository;
    }

    public AccountRepository findById(Long id) {
        return this.entityManager.find(AccountRepository.class, id);
    }

    @Transactional
    public void deleteAll() {
        entityManager.createQuery("delete from User").executeUpdate();
    }

    @Transactional
    public boolean deleteById(Long id) {
        AccountRepository accountRepository = entityManager.find(AccountRepository.class, id);
        if (accountRepository == null) {
            return false;
        }
        entityManager.remove(accountRepository);
        return true;
    }

    @Transactional
    public AccountRepository update(AccountRepository accountRepository) {
        return entityManager.merge(accountRepository);
    }

}
