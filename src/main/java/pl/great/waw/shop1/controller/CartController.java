package pl.great.waw.shop1.controller;

import org.springframework.web.bind.annotation.*;
import pl.great.waw.shop1.service.CartDto;
import pl.great.waw.shop1.service.CartService;

@RestController
@RequestMapping("cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping(value = "/{id}")
    public CartDto get(@PathVariable Long id) {
        return cartService.getCart(id);
    }

    @DeleteMapping(value = "/deleteAll")
    public void deleteAll() {
        cartService.deleteAllCarts();
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        cartService.deleteCart(id);
    }

}
