package pl.great.waw.shop1.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.great.waw.shop1.domain.Product;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class ProductRepositoryTest {

    private static final String PRODUCT_TITLE = "iPhone 14";
    private static final String DESCRIPTION = "The iPhone is a line of smartphones by Apple";
    private static final BigDecimal PRICE = BigDecimal.valueOf(999);
    private static final String PRODUCT_TITLE1 = "iPhone";
    private static final String DESCRIPTION1 = "The iPhone is a line  Apple";
    private static final BigDecimal PRICE1 = BigDecimal.valueOf(9);

    private Product product;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setBefore() {
        this.product = productRepository.create(new Product(PRODUCT_TITLE, DESCRIPTION, PRICE));
    }

    @AfterEach
    void tearDown() {
        this.productRepository.deleteAll();
    }

    @Test
    void create() {
        Product savedProduct = this.productRepository.findById(product.getId());

        assertEquals(product, savedProduct);

    }

    @Test
    void findById() {
        Product byId = productRepository.findById(product.getId());
        assertEquals(product, byId);
    }

    @Test
    void deleteById() {
        productRepository.deleteById(product.getId());
        assertNull(productRepository.findById(product.getId()));
    }

    @Test
    void update() {
        Product product1 = new Product(PRODUCT_TITLE1, DESCRIPTION1, PRICE1);
        Product updated = this.productRepository.update(product1);

        assertEquals(updated, product1);

    }
}