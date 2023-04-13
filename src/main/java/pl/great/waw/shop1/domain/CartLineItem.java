package pl.great.waw.shop1.domain;


import javax.persistence.*;

@Entity
@Table(name = "CART_LINE_ITEM")
public class CartLineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private int cartIndex;
    private int quantity;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Cart cart;

    public CartLineItem(int cartIndex, int quantity, Product product, Cart cart) {
        this.cartIndex = cartIndex;
        this.quantity = quantity;
        this.product = product;
        this.cart = cart;
    }

    public CartLineItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCartIndex() {
        return cartIndex;
    }

    public void setCartIndex(int cartIndex) {
        this.cartIndex = cartIndex;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
