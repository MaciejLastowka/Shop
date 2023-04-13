package pl.great.waw.shop1.service;

import org.springframework.stereotype.Service;
import pl.great.waw.shop1.Mapper.CartMapper;
import pl.great.waw.shop1.domain.Cart;
import pl.great.waw.shop1.repository.CartRepository;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    public CartService(CartRepository cartRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
    }

    public CartDto getCart(Long id) {
        Cart cart = cartRepository.findCartById(id);
        return this.cartMapper.cartToDto(cart);
    }

    public void deleteAllCarts() {
        cartRepository.deleteAll();
    }
    public void deleteCart(Long id) {
        cartRepository.deleteOne(id);
    }
}
