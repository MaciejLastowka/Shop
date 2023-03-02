package pl.great.waw.shop1.database;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import pl.great.waw.shop1.configuration.ProductJpaConfiguration;
import pl.great.waw.shop1.domain.Product;
import pl.great.waw.shop1.repository.ProductRepositoryInterface;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InMemoryTest {
    private static final String TITLE = "iPhone 14";
    private static final String DESCRIPTION = "The iPhone is a line of smartphones by Apple";
    private static final BigDecimal PRICE = BigDecimal.valueOf(999.0);
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(
            classes = { ProductJpaConfiguration.StudentJpaConfig.class },
            loader = AnnotationConfigContextLoader.class)
    @Transactional
    public class InMemoryDBTest {

        @Resource
        private ProductRepositoryInterface.ProductRepository productRepository;

        @Test
        public void givenStudent_whenSave_thenGetOk() {
            Product product1 = new Product(TITLE,DESCRIPTION,PRICE);
            productRepository.save(product1);

            Product product2 = new Product(TITLE,DESCRIPTION,PRICE);
            assertEquals(product1.getTitle(), product2.getTitle());
        }
    }
}
