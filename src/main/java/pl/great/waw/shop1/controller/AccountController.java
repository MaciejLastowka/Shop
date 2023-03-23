package pl.great.waw.shop1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.great.waw.shop1.service.AccountDto;
import pl.great.waw.shop1.service.AccountServiceImpl;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountServiceImpl accountService;

    public AccountController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }


    @GetMapping(value = "/{name}")
    public AccountDto get(@PathVariable String name) {
        return accountService.getAccount(name);
    }
}
