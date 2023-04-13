package pl.great.waw.shop1.controller.dto;

import pl.great.waw.shop1.service.AccountDto;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {

    private Long id;
    private AccountDto account;

    private List<OrderLineItemDto> orderLineItems = new ArrayList<>();

    public OrderDto(List<OrderLineItemDto> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public OrderDto(Long id) {
        this.id = id;
    }

    public OrderDto() {
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
