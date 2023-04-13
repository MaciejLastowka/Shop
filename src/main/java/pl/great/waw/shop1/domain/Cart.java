package pl.great.waw.shop1.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private Orders order;

    @OneToOne
    @JoinColumn(name = "cart", referencedColumnName = "id")
    private OrderLineItem orderLineItem;

    @OneToOne
    private Account account;


    private BigDecimal quantity = BigDecimal.ZERO;
    private LocalDateTime created;
    private LocalDateTime updated;


    public Long getCartId() {
        return id;
    }

    public void setCartId(Long id) {
        this.id = id;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }


}

