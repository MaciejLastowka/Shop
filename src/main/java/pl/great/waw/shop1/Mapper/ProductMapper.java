package pl.great.waw.shop1.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import pl.great.waw.shop1.domain.Category;
import pl.great.waw.shop1.domain.CategoryName;
import pl.great.waw.shop1.domain.Product;
import pl.great.waw.shop1.service.ProductDto;


@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "category", target = "categoryName", qualifiedByName = "categoryToCategoryName")
    ProductDto productToDto(Product product);

    @Mapping(source = "categoryName", target = "category", qualifiedByName = "categoryToCategoryId")
    Product dtoToProduct(ProductDto productDto);

    @Named("categoryToCategoryId")
    static Category categoryToCategoryId(CategoryName categoryName) {
        Category category = new Category();
        category.setId(categoryName.getId());
        return category;
    }

    @Named("categoryToCategoryName")
    static CategoryName categoryIdToCategoryName(Category category) {
        return CategoryName.valueOf( category.getTitle() );
    }
}

