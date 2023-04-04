package pl.great.waw.shop1.service;

import pl.great.waw.shop1.domain.CategoryName;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class ProductDto {

    private String title;
    private String description;
    private BigDecimal price;
    private CategoryName categoryName;

    public ProductDto() {

    }
    public ProductDto(CategoryName categoryName,String title, String description, BigDecimal price){
        this.categoryName = categoryName;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public ProductDto(CategoryName categoryName,String title, String description, BigDecimal price, LocalDateTime created, LocalDateTime updated) {

        this(categoryName,title,description,price);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryName getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(CategoryName categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(price, that.price) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, price);
    }
}
