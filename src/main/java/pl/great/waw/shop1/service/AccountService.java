package pl.great.waw.shop1.service;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.great.waw.shop1.repository.AccountRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

public class AccountService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public AccountDto create(AccountDto accountRepository) {
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

    @Repository
    public interface UserRepository extends JpaRepository<User, Long> {
        Optional<User> findByUsername(String username);
    }
}
