package pl.great.waw.shop1.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import pl.great.waw.shop1.controller.dto.OrderDto;
import pl.great.waw.shop1.controller.dto.OrderDtoView;
import pl.great.waw.shop1.controller.dto.OrderLineItemDto;
import pl.great.waw.shop1.domain.OrderLineItem;
import pl.great.waw.shop1.domain.Orders;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class OrderViewMapper {
    @Autowired
    private OrderLineItemMapper orderLineItemMapper;

    public abstract OrderDtoView map(Orders orders);

    @Mapping(source = "orderLineItems", target = "orderLineItems", qualifiedByName = "mapOrderLineItemDtoToOrderLineItem")
    public abstract Orders map(OrderDto orders);

    @Mapping(source = "orderLineItems", target = "orderLineItems", qualifiedByName = "mapOrderLineItemDtoToOrderLineItem")
    public abstract Orders map(OrderDtoView orders);

    @Named("mapOrderLineItemDtoToOrderLineItem")
    List<OrderLineItem> mapOrderLineItemDtoToOrderLineItem(List<OrderLineItemDto> orderLineItems) {
        return orderLineItems.stream().map(orderLineItem -> this.orderLineItemMapper.map(orderLineItem))
                .collect(Collectors.toList());
    }
}