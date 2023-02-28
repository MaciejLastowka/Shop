package pl.great.waw.shop1.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.great.waw.shop1.domain.Product;
import pl.great.waw.shop1.repository.ProductRepository;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {


    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD, ElementType.METHOD})
    public @interface Rule {
        int DEFAULT_ORDER = -1;

        int order() default -1;
    }

    private static final String PRODUCT_TITLE = "iPhone 14";
    private static final String DESCRIPTION = "The iPhone is a line of smartphones by Apple";
    private static final BigDecimal PRICE = BigDecimal.valueOf(999);
    private static final String PRODUCT_TITLE1 = "iPhone";
    private static final String DESCRIPTION1 = "The iPhone is a line Apple";
    private static final BigDecimal PRICE1 = BigDecimal.valueOf(9);
    private static final LocalDateTime time1 = LocalDateTime.now();
    private static final LocalDateTime time2 = LocalDateTime.now();

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;

    private Product productFromRepo;
    private ProductDto productFromController;


    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @BeforeEach
    public void setUp() {
        this.productFromRepo = new Product(PRODUCT_TITLE, DESCRIPTION, PRICE, time1, time2);
        this.productFromController = new ProductDto(PRODUCT_TITLE, DESCRIPTION, PRICE, time1, time2);
    }

    @Test
    void create() {
//        //given
//        when(productRepository.create(any())).thenReturn(productFromRepo);
//        //when
//        ProductDto productFromController = productService.create(productFromService);
//        //then
//        assertEquals(productFromController, productService.create(getProductFromController()));

    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}