package com.example.sessionmcs.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public List<FoodOrder> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('create:order')")
    public void addNewOrder(@RequestBody FoodOrder foodOrder) {
        orderService.createOrder(foodOrder);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('update:order')")
    public void updateOrder(@RequestBody FoodOrder foodOrder) {
        orderService.updateOrder(foodOrder);
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('delete:order')")
    public void deleteOrder(@RequestBody FoodOrder foodOrder) {
        orderService.removeOrder(foodOrder);
    }

    @DeleteMapping("/session/{sessionId}")
    @PreAuthorize("hasAuthority('delete:order')")
    public void deleteSessionOrders(@PathVariable("sessionId") Integer sessionId) {
        orderService.removeOrdersBySessionId(sessionId);
    }
}
