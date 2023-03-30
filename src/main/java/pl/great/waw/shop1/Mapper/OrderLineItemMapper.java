package pl.great.waw.shop1.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.great.waw.shop1.controller.dto.OrderLineItemDto;
import pl.great.waw.shop1.domain.OrderLineItem;

@Mapper(componentModel = "spring")
public abstract class OrderLineItemMapper {
//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "amount", source = "amount")
//    @Mapping(target = "product", source = "product")
    public abstract OrderLineItem map(OrderLineItemDto dto);
}
