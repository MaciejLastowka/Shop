package pl.great.waw.shop1.controller.dto;

public class CategoryDto
{
    private String name;

    public CategoryDto(String name) {
        this.name = name;
    }

    public CategoryDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
