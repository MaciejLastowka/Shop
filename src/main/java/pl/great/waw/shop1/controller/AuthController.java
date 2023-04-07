package pl.great.waw.shop1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.great.waw.shop1.controller.dto.AccountDto;

@RestController
@RequestMapping("auth")
public class AuthController {

    @GetMapping
    public AccountDto getUser(@RequestHeader("Authorization") String auth) {
        return new AccountDto("mikołaj");
    }
}
