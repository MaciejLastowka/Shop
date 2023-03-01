package pl.great.waw.shop1.service;

import org.springframework.stereotype.Service;
import pl.great.waw.shop1.domain.Product;
import pl.great.waw.shop1.repository.ProductRepository;

import static pl.great.waw.shop1.mapper.MapperProduct.mapProductDtoToProduct;
import static pl.great.waw.shop1.mapper.MapperProduct.mapProductToProductDto;

@Service
public class ProductServiceImpl {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDto create(ProductDto productDto) {
        Product product = productRepository.create(mapProductDtoToProduct(productDto));
        return mapProductToProductDto(product);
    }

    public ProductDto read(Long id) {
        return mapProductToProductDto(productRepository.findById(id));
    }

    public ProductDto update(ProductDto productDto) {
        Product product = productRepository.update(mapProductDtoToProduct(productDto));
        return mapProductToProductDto(product);
    }

    public boolean delete(Long id) {
        this.productRepository.deleteById(id);
        return true;
    }
}
