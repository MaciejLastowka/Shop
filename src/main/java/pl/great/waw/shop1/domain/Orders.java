package pl.great.waw.shop1.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JoinColumn(name = "account_id", nullable = false)
    @ManyToOne()
    private Account account;

    @OneToMany(mappedBy = "orders")
    private List<OrderLineItem> orderLineItems = new ArrayList<>();

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

}
