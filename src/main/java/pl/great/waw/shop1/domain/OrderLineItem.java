package pl.great.waw.shop1.domain;

import javax.persistence.*;

@Entity
@Table(name = "ORDERLINEITEM")
public class OrderLineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "Order_id", nullable = false)
    private Orders orders;

    private Long amount;

    @OneToOne
    private Product product;


    public Long getId() {
        return id;
    }

    public Long getAmount() {
        return amount;
    }
}
