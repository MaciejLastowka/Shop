package pl.great.waw.shop1.service;

import java.math.BigDecimal;

public interface ProductService {

    ProductDto create(String title, String description, BigDecimal price);

    ProductDto read(Long id);

    ProductDto update(ProductDto productDto);

    ProductDto delete(Long id);
}
