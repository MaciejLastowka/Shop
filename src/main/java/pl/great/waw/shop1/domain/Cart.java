package pl.great.waw.shop1.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CART")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<CartLineItem> cartLineItemList = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    private Account account;

    private BigDecimal totalAmount = BigDecimal.ZERO; //totalPrice?

    public Cart(List<CartLineItem> cartLineItemList, Account account, BigDecimal totalAmount) {
        this.cartLineItemList = cartLineItemList;
        this.account = account;
        this.totalAmount = totalAmount;
    }

    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartLineItem> getCartLineItemList() {
        return cartLineItemList;
    }

    public void setCartLineItemList(List<CartLineItem> cartLineItemList) {
        this.cartLineItemList = cartLineItemList;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
