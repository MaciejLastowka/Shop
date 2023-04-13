package pl.great.waw.shop1.controller.dto;

import java.math.BigDecimal;

public class CartLineView {

    private int cartIndex;
    private String productTitle;
    private int quantity;
    private BigDecimal price;

    public CartLineView(int cartIndex, String title, int quantity, BigDecimal price) {
        this.cartIndex = cartIndex;
        this.productTitle = title;
        this.quantity = quantity;
        this.price = price;
    }

    public CartLineView() {
    }

    public int getCartIndex() {
        return cartIndex;
    }

    public void setCartIndex(int cartIndex) {
        this.cartIndex = cartIndex;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
