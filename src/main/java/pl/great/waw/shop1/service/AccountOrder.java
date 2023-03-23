package pl.great.waw.shop1.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AccountOrder {

    private BigDecimal totalPrice;
    private LocalDate createAt;

    public AccountOrder() {
    }

    public AccountOrder(BigDecimal totalPrice, LocalDate createAt) {
        this.totalPrice = totalPrice;
        this.createAt = createAt;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }
}
