package pl.great.waw.shop1.controller;

import org.springframework.web.bind.annotation.*;
import pl.great.waw.shop1.service.ProductDto;
import pl.great.waw.shop1.service.ProductServiceImpl;

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
//    @PostMapping
//    public Account create(@RequestBody Account accountDto) {
//        List<Order> orders = accountDto.getOrders();
//        return (Account) orders;
//    }
}
