package pl.great.waw.shop1.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.great.waw.shop1.controller.dto.CartLineView;
import pl.great.waw.shop1.domain.CartLineItem;

@Mapper(componentModel = "spring")
public interface CartLineMapper {
    @Mapping(source = "product.price", target = "price")
    @Mapping(source = "product.title", target = "productTitle")
    CartLineView map(CartLineItem cartLineItem);

    @Mapping(target = "product.price", source = "price")
    @Mapping(target = "product.title", source = "productTitle")
    CartLineItem map(CartLineView cartLineView);
}
