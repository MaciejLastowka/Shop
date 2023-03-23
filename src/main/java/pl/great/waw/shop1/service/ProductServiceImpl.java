package pl.great.waw.shop1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.great.waw.shop1.Mapper.ProductMapper;
import pl.great.waw.shop1.domain.Product;
import pl.great.waw.shop1.repository.ProductRepository;


@Service
public class ProductServiceImpl {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
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

}
