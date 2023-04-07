package pl.great.waw.shop1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.great.waw.shop1.Mapper.ProductMapper;
import pl.great.waw.shop1.domain.CategoryName;
import pl.great.waw.shop1.domain.Product;
import pl.great.waw.shop1.hooks.ProductInEachCategory100;
import pl.great.waw.shop1.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDto> getByCategory(CategoryName categoryName){
       return this.productRepository.findByCategory(categoryName.name()).stream()
                .map(productMapper::productToDto)
                .collect(Collectors.toList());
    }

    public ProductDto get(Long id) {
        Product product = productRepository.findById(id);
        return productMapper.productToDto(product);
    }


    public ProductDto create(ProductDto productDto) {
        Product product = productRepository.create(productMapper.dtoToProduct(productDto));
        return productMapper.productToDto(product);
    }


    public ProductDto update(ProductDto productDto) {
        Product product = productMapper.dtoToProduct(productDto);
        Product updatedProduct = productRepository.update(product);
        return productMapper.productToDto(updatedProduct);
    }


    public boolean delete(Long id) {
        return productRepository.deleteById(id);
    }

    public boolean add100products(){
        ProductInEachCategory100 productInEachCategory100 = new ProductInEachCategory100();
        productInEachCategory100.initData();
        return true;
    }

}
