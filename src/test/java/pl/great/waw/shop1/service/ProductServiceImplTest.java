package pl.great.waw.shop1.service;

import org.junit.Rule;
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

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    private static final String TITLE = "iPhone 14";
    private static final String DESCRIPTION = "The iPhone is a line of smartphones by Apple";
    private static final BigDecimal PRICE = BigDecimal.valueOf(999.0);
    private static final String TITLE1 = "iPhone 14";
    private static final String DESCRIPTION1 = "The iPhone is a line of smartphones by Apple";
    private static final BigDecimal PRICE1 = BigDecimal.valueOf(999.0);
    private static final LocalDateTime TIME1 = LocalDateTime.now();
    private static final LocalDateTime TIME2 = LocalDateTime.now();

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;

    private Product productFromRepo;

    private ProductDto productFromService;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();


    @BeforeEach
    public void setup() {
        this.productFromRepo = new Product(TITLE, DESCRIPTION, PRICE);
        this.productFromService = new ProductDto(TITLE1, DESCRIPTION1, PRICE1);
    }

    @Test
    void create() {
        //given
        when(productRepository.create(any())).thenReturn(this.productFromRepo);
        //when
        ProductDto createdProduct = productService.create(this.productFromService);
        //then
        assertEquals(productFromService, createdProduct);
    }

    @Test
    void read() {
        //given
        when(productRepository.findById(any())).thenReturn(this.productFromRepo);
        //when
        ProductDto readedProduct = productService.read(productFromRepo.getId());
        //then
        assertEquals(productFromService, readedProduct);
    }

    @Test
    void update() {
        //given
        when(productRepository.update(any())).thenReturn(this.productFromRepo);
        //when
        ProductDto updatedProduct = productService.update(productFromService);
        //then
        assertEquals(productFromService, updatedProduct);
    }

    @Test
    void delete() {
        //given
        when(productRepository.deleteById(any())).thenReturn(true);
        //when
        boolean deletedProduct = productService.delete(productFromRepo.getId());
        //then
        verify(productRepository).deleteById(productFromRepo.getId());
    }
}