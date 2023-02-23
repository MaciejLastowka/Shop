package pl.great.waw.shop1.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.great.waw.shop1.domain.Product;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductRepositoryTest {

    private static final String PRODUCT_TITLE = "iPhone 14";
    private static final String DESCRIPTION = "The iPhone is a line of smartphones by Apple";
    private static final BigDecimal PRICE = BigDecimal.valueOf(999);

    @Autowired
    private ProductRepository productRepository;

    @Test
    void create() {
        Product product = this.productRepository.create(new Product(PRODUCT_TITLE, DESCRIPTION, PRICE));
        Product savedProduct = this.productRepository.findById(product.getId());

        assertEquals(product,savedProduct );

    }

    @Test
    void findById() {
    }
}