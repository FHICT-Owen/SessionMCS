package com.digitalmenu.sessionservice.Order;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    @PreAuthorize("hasAuthority('access:liveview')")
    public List<FoodOrder> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('access:liveview')")
    public ResponseEntity<FoodOrder> createOrder(@RequestBody @Valid FoodOrder order) {
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.CREATED);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('access:liveview')")
    public ResponseEntity<FoodOrder> updateOrder(@RequestBody @Valid FoodOrder foodOrder) {
        orderService.updateOrder(foodOrder);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('access:session')")
    public void deleteOrder(@RequestBody FoodOrder foodOrder) {
        orderService.deleteOrder(foodOrder);
    }

    @DeleteMapping("/session/{sessionId}")
    @PreAuthorize("hasAuthority('access:session')")
    public void deleteSessionOrders(@PathVariable("sessionId") String sessionId) {
        orderService.deleteOrdersBySessionId(sessionId);
    }
}
