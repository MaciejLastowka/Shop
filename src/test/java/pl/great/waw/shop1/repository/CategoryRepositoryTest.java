package pl.great.waw.shop1.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.great.waw.shop1.domain.Category;
import pl.great.waw.shop1.domain.CategoryName;

@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void findByTitle() {
        Category category = categoryRepository.findByTitle(CategoryName.DOM.name());

    }
}