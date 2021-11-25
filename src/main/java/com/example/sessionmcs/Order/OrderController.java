package com.example.sessionmcs.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<FoodOrder> GetOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    public void addNewOrder(@RequestBody FoodOrder foodOrder) {
        orderService.createOrder(foodOrder);
    }

    @PutMapping ("/approve/{id}")
    public void approveOrder(@PathVariable Integer id){ orderService.approveOrder(id); }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Integer id){ orderService.removeOrderById(id);}

    @DeleteMapping("/session/{sessionId}/all")
    public void deleteOrders(@PathVariable("sessionId") Integer sessionId){ orderService.removeOrdersBySessionId(sessionId);}
}
