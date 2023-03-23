package pl.great.waw.shop1.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "user")
    private List<AccountOrder> accountOrders;

    public Account() {
    }

    public Account(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AccountOrder> getOrders() {
        return accountOrders;
    }

    public void setOrders(List<AccountOrder> accountOrders) {
        this.accountOrders = accountOrders;
    }
}
