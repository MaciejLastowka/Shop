package pl.great.waw.shop1.hooks;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.great.waw.shop1.domain.Category;
import pl.great.waw.shop1.domain.CategoryName;
import pl.great.waw.shop1.domain.Product;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Locale;


@Component
public class ProductInEachCategory100  {

  //  @PersistenceContext
    private EntityManager entityManager;

    private final Faker faker = new Faker(new Locale("pl-PL"));

    private final int numberOfProducts = 100;

   // @PostConstruct
    @Transactional
    public void initData(String... args) {
        for (int i = 0; i < numberOfProducts; i++) {
            Product product1 = new Product();
            product1.setTitle(faker.commerce().productName());
            product1.setDescription(faker.lorem().paragraph());
            product1.setPrice(BigDecimal.valueOf(faker.number().randomDouble(2, 1, 1000)));
            product1.setCreated(LocalDateTime.now());
            product1.setUpdated(LocalDateTime.now());
            product1.setCategory(CategoryName.DOM);
            entityManager.persist(product1);

            Product product2 = new Product();
            product2.setTitle(faker.commerce().productName());
            product2.setDescription(faker.lorem().paragraph());
            product2.setPrice(BigDecimal.valueOf(faker.number().randomDouble(2, 1, 1000)));
            product2.setCreated(LocalDateTime.now());
            product2.setUpdated(LocalDateTime.now());
            product2.setCategory(CategoryName.MOTO);
            entityManager.persist(product2);

            Product product3 = new Product();
            product3.setTitle(faker.commerce().productName());
            product3.setDescription(faker.lorem().paragraph());
            product3.setPrice(BigDecimal.valueOf(faker.number().randomDouble(2, 1, 1000)));
            product3.setCreated(LocalDateTime.now());
            product3.setUpdated(LocalDateTime.now());
            product3.setCategory(CategoryName.ELEKTRO);
            entityManager.persist(product3);
        }
    }
}
