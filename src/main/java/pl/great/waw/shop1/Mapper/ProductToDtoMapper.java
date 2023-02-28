package pl.great.waw.shop1.Mapper;

import pl.great.waw.shop1.domain.Product;
import pl.great.waw.shop1.service.ProductDto;

public class ProductToDtoMapper {
    public static ProductDto productToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setDescription(product.getDescription());
        productDto.setTitle(product.getTitle());
        productDto.setPrice(product.getPrice());
        productDto.setCreated(product.getCreated());
        productDto.setUpdated(product.getUpdated());
        return productDto;
    }


    public static Product DtoToProduct(ProductDto productDto) {
        return new Product();
    }
}
