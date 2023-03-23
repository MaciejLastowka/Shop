package pl.great.waw.shop1.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.great.waw.shop1.domain.Account;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AccountRepositoryTest {
    public static final String NAME = "Bartek";
    @Autowired
    private AccountRepository accountRepository;

    @Test
    void findByName() {
        Account byName = accountRepository.findByName(NAME);
        assertEquals(byName.getName(), "Bartek");
    }
}