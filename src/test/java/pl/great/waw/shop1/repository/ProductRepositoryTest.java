package pl.great.waw.shop1.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.great.waw.shop1.domain.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class ProductRepositoryTest {
    private Product product;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setBefore() {
        this.product = productRepository.create(new Product());
    }

    @AfterEach
    void tearDown() {
        this.productRepository.deleteAll();
    }

    @Test
    void create() {
        Product savedProduct = this.productRepository.findById(product.getId());
        assertEquals(savedProduct, product);
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
        Product product1 = new Product();
        Product product2 = this.productRepository.create(product1);
        Product updated = this.productRepository.update(product1);
        assertEquals(product2, updated);

    }
}