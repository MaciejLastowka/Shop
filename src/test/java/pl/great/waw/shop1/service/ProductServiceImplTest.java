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
import pl.great.waw.shop1.Mapper.ProductToDtoMapper;
import pl.great.waw.shop1.domain.Product;
import pl.great.waw.shop1.repository.ProductRepository;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    private static final String PRODUCT_TITLE = "iPhone 14";
    private static final String DESCRIPTION = "The iPhone is a line of smartphones by Apple";
    private static final BigDecimal PRICE = BigDecimal.valueOf(999);
    private static final String PRODUCT_TITLE1 = "iPhone";
    private static final String DESCRIPTION1 = "The iPhone is a line Apple";
    private static final BigDecimal PRICE1 = BigDecimal.valueOf(9);


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
        this.productFromRepo = new Product(PRODUCT_TITLE, DESCRIPTION, PRICE, null, null);
        this.productFromController = new ProductDto(PRODUCT_TITLE, DESCRIPTION, PRICE, null, null);
    }

    @Test
    void create() {
        //given
        when(productRepository.create(any())).thenReturn(this.productFromRepo);
        //when
        ProductDto productFromDto = productService.create(productFromController);
        //then
        assertEquals(productFromDto, productFromController);

    }

    @Test
    void update() {
        //given
        ProductDto productDto = new ProductDto(PRODUCT_TITLE1, DESCRIPTION1, PRICE1, null, null);
        Product product = ProductToDtoMapper.dtoToProduct(productDto);
        when(productRepository.update(product)).thenReturn(product);
        //when
        ProductDto updatedProductDto = productService.update(productDto);
        //then
        assertThat(updatedProductDto.getPrice(), equalTo(PRICE1));
        assertEquals(product.getTitle(), updatedProductDto.getTitle());
    }

    @Test
    void delete() {
        //given
        Long productId = 12L;
        when(productRepository.deleteById(12L)).thenReturn(true);
        //when
        boolean delete = productService.delete(productId);
        //then
        assertTrue(delete);

    }
}
