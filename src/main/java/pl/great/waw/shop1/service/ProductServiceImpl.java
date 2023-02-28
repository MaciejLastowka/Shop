package pl.great.waw.shop1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.great.waw.shop1.Mapper.ProductToDtoMapper;
import pl.great.waw.shop1.domain.Product;
import pl.great.waw.shop1.repository.ProductRepository;

import static pl.great.waw.shop1.Mapper.ProductToDtoMapper.productToDto;

@Service
public class ProductServiceImpl {


    private final ProductRepository productRepository;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public ProductDto get(Long id) {
        Product product = productRepository.findById(id);
        return productToDto(product);
    }


    public ProductDto create(ProductDto productDto) {
        //Product product = productRepository.create(productToDto(productDto));
        //return productToDto(product);
        return null;
    }


    public ProductDto update(ProductDto productDto) {
        Product product = ProductToDtoMapper.DtoToProduct(productDto);
        productRepository.update(product);
        return productToDto(product);
    }


    public boolean delete(Long id) {
        return productRepository.deleteById(id);
    }

}
