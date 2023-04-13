package pl.great.waw.shop1.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import pl.great.waw.shop1.controller.dto.CartDto;
import pl.great.waw.shop1.controller.dto.CartLineView;
import pl.great.waw.shop1.domain.Cart;
import pl.great.waw.shop1.domain.CartLineItem;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class CartMapper {

    @Autowired
    private CartLineMapper cartLineMapper;

    @Mapping(source = "cartLineItemList", target = "cartLineItemList", qualifiedByName = "mapCartLineItemToCartLineView")
    public abstract CartDto map(Cart cart);

    @Mapping(source = "cartLineItemList", target = "cartLineItemList", qualifiedByName = "mapCartLineViewToCartLineItem")
    public abstract Cart map(CartDto cart);

    @Named("mapCartLineItemToCartLineView")
    List<CartLineView> mapOrderLineItemDtoToOrderLineItem(List<CartLineItem> cartLineItems) {
        return cartLineItems.stream().map(cartLineItem -> this.cartLineMapper.map(cartLineItem))
                .collect(Collectors.toList());
    }

    @Named("mapCartLineViewToCartLineItem")
    List<CartLineItem> mapOrderLineViewToOrderLineItem(List<CartLineView> cartLineItems) {
        return cartLineItems.stream().map(cartLineItem -> this.cartLineMapper.map(cartLineItem))
                .collect(Collectors.toList());
    }
}
