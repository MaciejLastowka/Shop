package pl.great.waw.shop1.mapper;

import pl.great.waw.shop1.domain.Product;
import pl.great.waw.shop1.service.ProductDto;

public class MapperProduct {

    public static ProductDto mapProductToProductDto(Product product) {
        return new ProductDto(product.getTitle(), product.getDescription(), product.getPrice());
    }

    public static Product mapProductDtoToProduct(ProductDto productDto) {
        return new Product(productDto.getTitle(), productDto.getDescription(), productDto.getPrice());
    }
}
