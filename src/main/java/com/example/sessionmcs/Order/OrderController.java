package com.example.sessionmcs.Order;

import com.example.sessionmcs.Dish.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {this.orderService = orderService; }

    @GetMapping
    public List<FoodOrder> GetOrders(){ return orderService.getOrders();}

    @PostMapping
    public void addNewOrder(@RequestBody FoodOrder foodOrder) {
        orderService.createOrder(foodOrder);
    }

    @PutMapping("/session/{sessionId}/delete")
    public void deleteOrder(@PathVariable("sessionId") Integer sessionId, @RequestBody List<Dish> dishes){ orderService.removeOrderBySessionIdAndDishes(sessionId, dishes);}

    @PutMapping ("/session/{sessionId}/approve")
    public void approveOrder(@PathVariable("sessionId") Integer sessionId, @RequestBody List<Dish> dishes){ orderService.approveOrder(sessionId, dishes);}

    @DeleteMapping("/session/{sessionId}/all")
    public void deleteOrders(@PathVariable("sessionId") Integer sessionId){ orderService.removeOrdersBySessionId(sessionId);}
}
