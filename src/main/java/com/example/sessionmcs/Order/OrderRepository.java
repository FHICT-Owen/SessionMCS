package com.example.sessionmcs.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    void deleteOrdersBySessionId(Integer sessionId);
    void deleteOrderById(Long id);
}