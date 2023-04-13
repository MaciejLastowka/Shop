package pl.great.waw.shop1.controller.dto;

import java.math.BigDecimal;
import java.util.List;

public class CartDto {

    private List<CartLineView> cartLineItemList;
    private BigDecimal totalAmount;

    public CartDto(List<CartLineView> cartLineItemList, BigDecimal totalAmount) {
        this.cartLineItemList = cartLineItemList;
        this.totalAmount = totalAmount;
    }

    public CartDto() {
    }

    public List<CartLineView> getCartLineItemList() {
        return cartLineItemList;
    }

    public void setCartLineItemList(List<CartLineView> cartLineItemList) {
        this.cartLineItemList = cartLineItemList;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}

