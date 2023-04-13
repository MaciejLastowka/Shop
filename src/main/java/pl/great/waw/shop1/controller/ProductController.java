package pl.great.waw.shop1.controller;

import org.springframework.web.bind.annotation.*;
import pl.great.waw.shop1.controller.dto.CartDto;
import pl.great.waw.shop1.controller.dto.CartLineView;
import pl.great.waw.shop1.domain.CategoryName;
import pl.great.waw.shop1.service.CartService;
import pl.great.waw.shop1.service.ProductDto;
import pl.great.waw.shop1.service.ProductServiceImpl;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductServiceImpl productService;

    private final CartService cartService;

    public ProductController(ProductServiceImpl productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }


    @GetMapping(value = "/{title}")
    public ProductDto get(@PathVariable String title) {
        return productService.getByTitle(title);
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

    @PostMapping("/{productTitle}/{amount}/addToCart")
    public CartDto addToCart(@PathVariable String productTitle, @PathVariable int amount) {
        return cartService.add(new CartLineView(0, productTitle, amount, BigDecimal.ZERO));
    }


    @PostMapping(value = "/add100")
    public boolean add100products() {
        productService.add100products();
        return true;
    }
}
