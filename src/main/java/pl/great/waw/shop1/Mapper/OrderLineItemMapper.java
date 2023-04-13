package pl.great.waw.shop1.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.great.waw.shop1.controller.dto.OrderLineItemDto;
import pl.great.waw.shop1.domain.OrderLineItem;

@Mapper(componentModel = "spring")
public abstract class OrderLineItemMapper {

    public abstract OrderLineItem map(OrderLineItemDto dto);
}
