package com.example.sessionmcs.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<FoodOrder, Integer> {
    boolean existsFoodOrderById(Integer id);
    boolean existsFoodOrderBySessionId(Integer id);
    void deleteFoodOrdersBySessionId(Integer sessionId);
}
