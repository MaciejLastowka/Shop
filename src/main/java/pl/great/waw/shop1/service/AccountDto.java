package pl.great.waw.shop1.service;

import org.springframework.data.domain.jaxb.SpringDataJaxb;
import pl.great.waw.shop1.repository.AccountRepository;

import java.util.List;

public class AccountDto extends AccountRepository {
    private String name;
    private List<SpringDataJaxb.OrderDto> costumerOrders;

    public AccountDto() {
    }

    public AccountDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SpringDataJaxb.OrderDto> getCostumerOrders() {
        return costumerOrders;
    }

    public void setCostumerOrders(List<SpringDataJaxb.OrderDto> costumerOrders) {
        this.costumerOrders = costumerOrders;
    }
}
