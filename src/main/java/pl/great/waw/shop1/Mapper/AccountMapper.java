package pl.great.waw.shop1.Mapper;

import org.mapstruct.Mapper;
import pl.great.waw.shop1.domain.Account;
import pl.great.waw.shop1.service.AccountDto;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDto accountToDto(Account account);
}
