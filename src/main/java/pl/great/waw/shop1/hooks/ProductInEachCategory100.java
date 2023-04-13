package pl.great.waw.shop1.hooks;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.great.waw.shop1.domain.Category;
import pl.great.waw.shop1.domain.CategoryName;
import pl.great.waw.shop1.domain.Product;
import pl.great.waw.shop1.repository.CategoryRepository;
import pl.great.waw.shop1.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.stream.IntStream;

@Component
public class ProductInEachCategory100 {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final Faker faker = new Faker(new Locale("pl-PL"));

    public ProductInEachCategory100(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public void initData() {

        int numberOfProducts = 10;
        IntStream.range(0, numberOfProducts).forEach(i -> {
            Product product = new Product();
            String title = faker.commerce().productName();
            if (title.length() > 254) {
                title = title.substring(0, 255);
            }
            product.setTitle(title);
            String description = faker.lorem().paragraph();
            if (description.length() > 255) {
                description = description.substring(0, 255);
            }
            product.setDescription(description);
            product.setPrice(BigDecimal.valueOf(faker.number().randomDouble(2, 1, 1000)));
            Category byTitle = categoryRepository.findByTitle(String.valueOf(CategoryName.DOM));
            product.setCategory(byTitle);
            productRepository.create(product);
        });


        IntStream.range(0, numberOfProducts).forEach(i -> {
            Product product = new Product();
            String title = faker.commerce().productName();
            if (title.length() > 255) {
                title = title.substring(0, 255);
            }
            product.setTitle(title);
            String description = faker.lorem().paragraph();
            if (description.length() > 255) {
                description = description.substring(0, 255);
            }
            product.setDescription(description);
            product.setPrice(BigDecimal.valueOf(faker.number().randomDouble(2, 1, 1000)));
            Category byTitle = categoryRepository.findByTitle(String.valueOf(CategoryName.MOTORYZACJA));
            product.setCategory(byTitle);
            productRepository.create(product);
        });


        IntStream.range(0, numberOfProducts).forEach(i -> {
            Product product = new Product();
            String title = faker.commerce().productName();
            if (title.length() > 255) {
                title = title.substring(0, 255);
            }
            product.setTitle(title);
            String description = faker.lorem().paragraph();
            if (description.length() > 255) {
                description = description.substring(0, 255);
            }
            product.setDescription(description);
            product.setPrice(BigDecimal.valueOf(faker.number().randomDouble(2, 1, 1000)));
            Category byTitle = categoryRepository.findByTitle(String.valueOf(CategoryName.ELEKTRO));
            product.setCategory(byTitle);
            productRepository.create(product);
        });
    }
}
