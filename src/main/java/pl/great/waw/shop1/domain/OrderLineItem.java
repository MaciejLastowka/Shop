package pl.great.waw.shop1.domain;

import javax.persistence.*;

@Entity
@Table(name = "ORDERLINEITEM")
public class OrderLineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders orders;
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    private Long amount;

    public OrderLineItem(){}

    public OrderLineItem(Orders order, Product product, Long amount ) {
        this.orders = order;
        this.product = product;
        this.amount = amount;

    }

    public Long getId() {
        return id;
    }

    public Orders getOrders() {
        return orders;
    }

    public Long getAmount() {
        return amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
