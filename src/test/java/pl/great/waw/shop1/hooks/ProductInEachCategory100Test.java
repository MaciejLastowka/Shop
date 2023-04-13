package pl.great.waw.shop1.hooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import pl.great.waw.shop1.domain.Category;
import pl.great.waw.shop1.domain.Product;
import pl.great.waw.shop1.repository.CategoryRepository;
import pl.great.waw.shop1.repository.ProductRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class ProductInEachCategory100Test {

    @InjectMocks
    private ProductInEachCategory100 productInEachCategory100;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Category category2 = new Category();
        category2.setTitle("DOM");
        when(categoryRepository.findByTitle(anyString())).thenReturn(category2);

    }

    @Test
    void testInitData_expectedNumberOfProductsCreated() {
        //given
        Product product = new Product();
        product.setTitle("example");
        when(productRepository.create(any(Product.class))).thenReturn(product);
        //when
        productInEachCategory100.initData();
        //then
        verify(productRepository, times(30)).create(any(Product.class));
    }
}