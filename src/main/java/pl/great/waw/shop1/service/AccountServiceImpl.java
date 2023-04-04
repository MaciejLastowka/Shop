package pl.great.waw.shop1.service;

import org.springframework.stereotype.Service;
import pl.great.waw.shop1.Mapper.AccountMapper;
import pl.great.waw.shop1.domain.Account;
import pl.great.waw.shop1.repository.AccountRepository;

@Service
public class AccountServiceImpl {

    private final AccountMapper accountMapper;

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountMapper accountMapper, AccountRepository accountRepository) {
        this.accountMapper = accountMapper;
        this.accountRepository = accountRepository;
    }

    public AccountDto getAccount(String name) {
        Account byName = accountRepository.findByName(name);
        return accountMapper.accountToDto(byName);
    }

}
