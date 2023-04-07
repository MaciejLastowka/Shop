package pl.great.waw.shop1.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JoinColumn(name = "account_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private Account account;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<OrderLineItem> orderLineItems = new ArrayList<>();

    private BigDecimal totalPrice;

    public Orders(Account account, List<OrderLineItem> orderLineItems) {
        this.account = account;
        this.orderLineItems = orderLineItems;
    }

    public Orders() {
    }

    public Long getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<OrderLineItem> getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(List<OrderLineItem> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
