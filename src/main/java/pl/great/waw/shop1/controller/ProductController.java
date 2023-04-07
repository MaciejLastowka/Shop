package pl.great.waw.shop1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.great.waw.shop1.domain.CategoryName;
import pl.great.waw.shop1.hooks.ProductInEachCategory100;
import pl.great.waw.shop1.service.ProductDto;
import pl.great.waw.shop1.service.ProductServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{id}")
    public ProductDto get(@PathVariable Long id) {
        return productService.get(id);
    }

    @GetMapping(value = "byCategory/{categoryName}")
    public List<ProductDto> get(@PathVariable CategoryName categoryName) {
        return productService.getByCategory(categoryName);
    }

    @PostMapping
    public ProductDto create(@RequestBody ProductDto productDto) {
        productService.create(productDto);
        return productDto;
    }

    @DeleteMapping(value = "{id}")
    public boolean delete(@PathVariable Long id) {
        return productService.delete(id);
    }

    @PutMapping(value = "/{id}")
    public ProductDto update(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return productService.update(productDto);
    }

    @PostMapping(value = "/add100")
    public boolean add100products(){
        productService.add100products();
        return true;
    }
}
