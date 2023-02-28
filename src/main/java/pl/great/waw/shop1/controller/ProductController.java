package pl.great.waw.shop1.controller;

import org.springframework.web.bind.annotation.*;
import pl.great.waw.shop1.service.ProductDto;
import pl.great.waw.shop1.service.ProductServiceImpl;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductServiceImpl productService;

    public ProductController (ProductServiceImpl productService) {this.productService = productService;}

    @GetMapping(value = "/id")
    public ProductDto get(@PathVariable Long id){
        return productService.get(id);
    }
    @DeleteMapping(value = "{id}")
    public boolean delete(@PathVariable Long id){
        return productService.delete(id);
    }
    @PutMapping
    public ProductDto update(@PathVariable Long id, @RequestBody ProductDto productDto){
        return productService.update(productDto);
    }
}
