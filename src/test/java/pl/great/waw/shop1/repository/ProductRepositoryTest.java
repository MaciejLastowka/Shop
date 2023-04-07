package pl.great.waw.shop1.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.great.waw.shop1.domain.Category;
import pl.great.waw.shop1.domain.CategoryName;
import pl.great.waw.shop1.domain.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    private static final String PRODUCT_TITLE = "iPhone 14";
    private static final String DESCRIPTION = "The iPhone is a line of smartphones by Apple";
    private static final BigDecimal PRICE = BigDecimal.valueOf(999);
    private static final String PRODUCT_TITLE1 = "iPhone";
    private static final String DESCRIPTION1 = "The iPhone is a line Apple";
    private static final BigDecimal PRICE1 = BigDecimal.valueOf(9);
    private static final LocalDateTime time1 = LocalDateTime.now();
    private static final LocalDateTime time2 = LocalDateTime.now();
    private Product product;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setBefore() {
        Product product = new Product();
        Category category = getCategory(1L);
        product.setCategory(category);
        product.setTitle(PRODUCT_TITLE);
        product.setDescription(DESCRIPTION);
        product.setPrice(BigDecimal.TEN);
        product.setUpdated(time1);
        product.setCreated(time1);

        this.product = productRepository.create(product);
    }

    @AfterEach
    void tearDown() {
        this.productRepository.deleteAll();
    }

    //@FIXME
//    @Test
//    void create() {
//        //when
//        Product savedProduct = this.productRepository.findById(product.getId());
//        //then
//        assertNotNull(savedProduct);
//        assertEquals(savedProduct, product);
//    }

   //@FIXME
//    @Test
//    void findById() {
//        //when
//        Product byId = productRepository.findById(product.getId());
//        //then
//        assertEquals(product, byId);
//    }

    @Test
    void deleteById() {
        //when
        productRepository.deleteById(product.getId());
        //then
        assertNull(productRepository.findById(product.getId()));
    }

    @Test
    void update() {
        //given
        Product product1 = new Product(getCategory(1L), PRODUCT_TITLE1, DESCRIPTION1, PRICE1, time1, time2);
        product1.setId(product.getId());
        //when
        Product updated = this.productRepository.update(product1);
        //then
        assertEquals(product1, updated);
    }


    private Category getCategory(Long id) {
        Category category = new Category();
        category.setId(id);
        return category;
    }

    //FIXME
//    @Test
//    void findByCategory() {
//        List<Product> byCategory = this.productRepository.findByCategory(CategoryName.MOTORYZACJA.name());
//        assertFalse(byCategory.isEmpty());
//    }
}