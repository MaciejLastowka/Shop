package pl.great.waw.shop1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.great.waw.shop1.controller.dto.OrderDto;
import pl.great.waw.shop1.controller.dto.OrderDtoView;
import pl.great.waw.shop1.domain.Orders;
import pl.great.waw.shop1.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public OrderDto create() {
        return orderService.create();
    }

    @GetMapping(path = "/{id}")
    public OrderDtoView get(@PathVariable Long id)
    {
        return orderService.findById(id);
    }


//    @GetMapping(path= "/{userOrders}")
//    public List<Orders> getAccountOrders(@PathVariable String name){
//        return this.orderService.findAccountOrders(getAccountOrders());
//    }

}
