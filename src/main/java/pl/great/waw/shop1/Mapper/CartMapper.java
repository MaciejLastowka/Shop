package pl.great.waw.shop1.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import pl.great.waw.shop1.domain.Cart;
import pl.great.waw.shop1.service.CartDto;

@Mapper(componentModel = "spring")
public interface CartMapper {
    @Mapping(source = "accountName", target = "accountName")
    CartDto cartToDto(Cart cart);

    @Named("getAccountName")
    default String getAccountName(Cart cart) {
        return cart.getName();
    }
}
