package com.example.sessionmcs.Order;

import com.example.sessionmcs.Dish.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<FoodOrder, Long> {
    Optional<FoodOrder> findFoodOrderBySessionIdAndDishesIn(Integer sessionId, List<Dish> dishes);
    boolean existsBySessionId(Integer sessionId);
    boolean existsBySessionIdAndDishesIn(Integer sessionId, List<Dish> dishes);
    void deleteOrdersBySessionId(Integer sessionId);
    void deleteOrderBySessionIdAndDishesIn(Integer sessionId, List<Dish> dishes);
}
