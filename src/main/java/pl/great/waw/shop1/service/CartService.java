package pl.great.waw.shop1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.great.waw.shop1.Mapper.CartMapper;
import pl.great.waw.shop1.controller.dto.CartDto;
import pl.great.waw.shop1.controller.dto.CartLineView;
import pl.great.waw.shop1.domain.Account;
import pl.great.waw.shop1.domain.Cart;
import pl.great.waw.shop1.domain.CartLineItem;
import pl.great.waw.shop1.domain.Product;
import pl.great.waw.shop1.repository.AccountRepository;
import pl.great.waw.shop1.repository.CartRepository;
import pl.great.waw.shop1.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private final CartRepository cartRepository;

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final AccountRepository accountRepository;

    @Autowired
    private final CartMapper cartMapper;

    public CartService(CartRepository cartRepository, ProductRepository productRepository, AccountRepository accountRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.accountRepository = accountRepository;
        this.cartMapper = cartMapper;

        List<Account> accounts = this.accountRepository.findAll();

        accounts.forEach(account -> {
            Cart cart = cartRepository.get(account.getName());
            if (cart == null) {
                cartRepository.create(account.getName());
            }
        });
    }

    public CartDto get() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        Cart cart = cartRepository.get(name);
        return cartMapper.map(cart);
    }

    public CartDto add(CartLineView cartLineView) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();

        Cart cart = cartRepository.get(name);
        List<CartLineItem> cartLineItemList = cart.getCartLineItemList();
        Product product = productRepository.findByTitle(cartLineView.getProductTitle());
        int index = getIndex(cart);
        cartLineItemList.add(new CartLineItem(index, cartLineView.getQuantity(), product, cart));

        cart.setCartLineItemList(cartLineItemList);
        BigDecimal totalAmount = cart.getTotalAmount();
        totalAmount = totalAmount.add(product.getPrice().multiply(BigDecimal.valueOf(cartLineView.getQuantity())));
        cart.setTotalAmount(totalAmount);

        return cartMapper.map(cartRepository.update(cart));
    }

    public CartDto remove(int index) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();

        Cart cart = cartRepository.get(name);
        List<CartLineItem> cartLineItemList = cart.getCartLineItemList();
        List<CartLineItem> cartLineItemsRemoved = cartLineItemList.stream()
                .filter(cartLineItem -> cartLineItem.getCartIndex() != index).collect(Collectors.toList());

        cart.setCartLineItemList(cartLineItemsRemoved);

        return cartMapper.map(cartRepository.update(cart));
    }

    private int getIndex(Cart cart) {
        int index = 1;
        int size = cart.getCartLineItemList().size();
        if (size > 0) {
            index = size + 1;
        }
        return index;
    }
}
