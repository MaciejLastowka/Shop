package pl.great.waw.shop1.Mapper;

import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;
import pl.great.waw.shop1.domain.Product;
import pl.great.waw.shop1.service.ProductDto;



@Mapper(componentModel = "spring")

public interface ProductMapper {
    ProductDto productToDto(Product product);

    Product dtoToProduct(ProductDto productDto);
}

