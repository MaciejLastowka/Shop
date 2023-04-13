package pl.great.waw.shop1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.great.waw.shop1.controller.dto.CartDto;
import pl.great.waw.shop1.service.CartService;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public CartDto get() {
        return cartService.get();
    }

    @DeleteMapping("/{index}")
    public boolean delete(@PathVariable int index) {
        cartService.remove(index);
        return true;
    }
}
