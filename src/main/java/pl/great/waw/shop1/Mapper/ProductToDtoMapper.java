package pl.great.waw.shop1.Mapper;

import pl.great.waw.shop1.domain.Product;
import pl.great.waw.shop1.service.ProductDto;

public class ProductToDtoMapper {
    public static ProductDto productToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setDescription(product.getDescription());
        productDto.setTitle(product.getTitle());
        productDto.setPrice(product.getPrice());

        return productDto;
    }


    public static Product dtoToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setDescription(productDto.getDescription());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());

        return product;
    }
}
