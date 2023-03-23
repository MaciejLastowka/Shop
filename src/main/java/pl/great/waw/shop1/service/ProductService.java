package pl.great.waw.shop1.service;

import java.math.BigDecimal;

public interface ProductService {
    ProductDto get(Long id);

    ProductDto create(String productTitle, String description, BigDecimal price);

    ProductDto update(ProductDto productDto);

    boolean delete(Long id);

    AccountDto create(String name);

}
