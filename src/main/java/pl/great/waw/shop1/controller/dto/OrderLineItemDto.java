package pl.great.waw.shop1.controller.dto;

import pl.great.waw.shop1.service.ProductView;

public class OrderLineItemDto {

    private ProductView product;
    private Long amount;

    public OrderLineItemDto(ProductView productDto, Long amount) {
        this.product = productDto;
        this.amount = amount;
    }

    public OrderLineItemDto() {
    }


    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public ProductView getProduct() {
        return product;
    }

    public void setProduct(ProductView product) {
        this.product = product;
    }
}
