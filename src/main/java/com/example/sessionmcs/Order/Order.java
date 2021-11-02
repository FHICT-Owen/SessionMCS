package com.example.sessionmcs.Order;
import com.example.sessionmcs.Dish.Dish;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
public class Order {
    @Id
    @SequenceGenerator(
            name ="session_sequence",
            sequenceName = "session_sequence",
            allocationSize =1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "session_sequence"
    )
    private Long id;
    private Integer sessionId;
    @OneToMany
    private List<Dish> dishes;
    private String Comments;
    private Boolean isApproved;
    private Boolean served;

    public Order() {}

    public Order(Long id, Integer sessionId, List<Dish> dishes, String comments, Boolean isApproved, Boolean served) {
        this.id = id;
        this.sessionId = sessionId;
        this.dishes = dishes;
        Comments = comments;
        this.isApproved = isApproved;
        this.served = served;
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
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    public Boolean getServed() { return served; }

    public void setServed(Boolean served) { this.served = served; }
}
