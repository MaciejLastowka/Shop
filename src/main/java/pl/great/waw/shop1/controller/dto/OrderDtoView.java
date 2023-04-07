package pl.great.waw.shop1.controller.dto;

import pl.great.waw.shop1.service.AccountDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderDtoView {

    private AccountDto account;

    private List<OrderLineItemDto> orderLineItems = new ArrayList<>();

    public OrderDtoView(List<OrderLineItemDto> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }
    private BigDecimal totalPrice;

    public OrderDtoView() {
    }

    public AccountDto getAccount() {
        return account;
    }

    public void setAccount(AccountDto account) {
        this.account = account;
    }

    public List<OrderLineItemDto> getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(List<OrderLineItemDto> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
