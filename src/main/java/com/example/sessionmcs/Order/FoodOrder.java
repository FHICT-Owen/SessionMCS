package com.example.sessionmcs.Order;
import com.example.sessionmcs.Dish.Dish;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
public class FoodOrder {
    @Id
    @SequenceGenerator(
            name ="session_sequence",
            sequenceName = "session_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "session_sequence"
    )
    private Long id;
    private Integer sessionId;
    @OneToMany
    private List<Dish> dishes;
    private String comments;
    private Boolean isApproved;
    private Boolean isServed;

    public FoodOrder() {}

    public FoodOrder(Long id, Integer sessionId, List<Dish> dishes, String comments, Boolean isApproved, Boolean isServed) {
        this.id = id;
        this.sessionId = sessionId;
        this.dishes = dishes;
        this.comments = comments;
        this.isApproved = isApproved;
        this.isServed = isServed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    public Boolean getServed() { return isServed; }

    public void setServed(Boolean isServed) { this.isServed = isServed; }
}
