package pl.great.waw.shop1.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.great.waw.shop1.controller.dto.CategoryDto;
import pl.great.waw.shop1.domain.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(source = "title", target = "name")
    CategoryDto map(Category category);
}
