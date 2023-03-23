package pl.great.waw.shop1.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.great.waw.shop1.domain.Account;
import pl.great.waw.shop1.service.AccountDto;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Mapping(source = "accountOrders", target = "costumerOrders")
    AccountDto toDto(Account account);

    @Mapping(source = "costumerOrders", target = "accountOrders")
    Account toEntity(AccountDto accountDto);
}

