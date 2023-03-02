package pl.great.waw.shop1.controller;

import org.springframework.web.bind.annotation.*;
import pl.great.waw.shop1.service.ProductDto;
import pl.great.waw.shop1.service.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductServiceImpl productService;


    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping(value = "{id}")
    public ProductDto get(@PathVariable Long id){
        return productService.read(id);
    }

    @PostMapping
    public ProductDto create(@RequestBody ProductDto productDto){
       return productService.create(productDto);
    }

    @PutMapping
    public ProductDto update(@RequestBody ProductDto productDto){
        return productService.update(productDto);
    }

    @DeleteMapping(value = "{id}")
    public boolean delete(@PathVariable Long id) {
        return productService.delete(id);
    }

}
