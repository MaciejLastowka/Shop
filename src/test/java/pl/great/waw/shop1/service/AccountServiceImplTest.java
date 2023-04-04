package pl.great.waw.shop1.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.great.waw.shop1.Mapper.AccountMapper;
import pl.great.waw.shop1.domain.Account;
import pl.great.waw.shop1.repository.AccountRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {
    final private Long ID = 1L;
    final private String NAME = "TEST";
    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AccountMapper accountMapper;

    @InjectMocks
    private AccountServiceImpl accountService;

    @Test
    void getAccountShouldReturnCorrectAccount() {
        // given
        Account account = new Account();
        account.setName(NAME);
        when(accountRepository.findByName(NAME)).thenReturn(account);

        AccountDto accountDto = new AccountDto();
        accountDto.setId(ID);
        when(accountMapper.accountToDto(account)).thenReturn(accountDto);
        // when
        AccountDto result = accountService.getAccount(NAME);
        // then
        assertEquals(accountDto, result);
    }
}
