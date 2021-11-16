package com.example.sessionmcs.Order;

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
    private Integer id;
    private Integer sessionId;
    @ElementCollection
    private Set<String> dishes;
    private String comments;
    private Boolean isApproved;
    private Boolean isServed;

    public FoodOrder() {}

    public FoodOrder(Integer id, Integer sessionId, String comments, Boolean isApproved, Boolean isServed) {
        this.id = id;
        this.sessionId = sessionId;
        this.comments = comments;
        this.isApproved = isApproved;
        this.isServed = isServed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Set<String> getDishes() {
        return dishes;
    }

    public void setDishes(Set<String> dishes) {
        this.dishes = dishes;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public Boolean getIsServed() { return isServed; }

    public void setIsServed(Boolean isServed) { this.isServed = isServed; }
}
