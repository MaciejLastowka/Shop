package pl.great.waw.shop1.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.great.waw.shop1.Mapper.OrderLineItemMapper;
import pl.great.waw.shop1.Mapper.OrderMapper;
import pl.great.waw.shop1.controller.dto.OrderDto;
import pl.great.waw.shop1.domain.Orders;
import pl.great.waw.shop1.repository.OrderRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    private static final Long ID = 1L;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderMapper orderMapper;

    @InjectMocks
    private OrderService orderService;

    @Mock
    OrderLineItemMapper orderLineItemMapper;

    @Test
    void create() {
        //given
        OrderDto orderDto = new OrderDto();
        Orders orders = new Orders();
        when(orderMapper.map(orderDto)).thenReturn(orders);
        when(orderRepository.createOrder(orders)).thenReturn(orders);
        when(orderRepository.findOrderById(orders.getId())).thenReturn(orders);
        //when
        OrderDto result = orderService.create(orderDto);
        //then
        assertEquals(orders, orderMapper.map(result));
    }

    @Test
    void findById() {
        //given
        Orders order = new Orders();
        order.setId(ID);
        Orders orders = new Orders();
        when(orderRepository.findOrderById(ID)).thenReturn(orders);
        //when
        when(orderRepository.findOrderById(ID)).thenReturn(order);
        OrderDto result = orderService.findById(ID);
        //then
        assertEquals(orders, orderMapper.map(result));
    }
}