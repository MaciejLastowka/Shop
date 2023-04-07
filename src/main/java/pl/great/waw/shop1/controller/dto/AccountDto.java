package pl.great.waw.shop1.controller.dto;

public class AccountDto
{
    private String username;


    public AccountDto(String username) {
        this.username = username;
    }

    public AccountDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
