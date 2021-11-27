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
    private Boolean isCanceled;
    private Boolean isBeingPrepared;
    private Boolean isReady;
    private Long timeStamp;

    public FoodOrder() {}

    public FoodOrder(
            Integer id,
            Integer sessionId,
            Set<String> dishes,
            String comments,
            Boolean isApproved,
            Boolean isCanceled,
            Boolean isBeingPrepared,
            Boolean isReady,
            Long timeStamp
    ) {
        this.id = id;
        this.sessionId = sessionId;
        this.dishes = dishes;
        this.comments = comments;
        this.isApproved = isApproved;
        this.isCanceled = isCanceled;
        this.isBeingPrepared = isBeingPrepared;
        this.isReady = isReady;
        this.timeStamp = timeStamp;
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
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean approved) {
        isApproved = approved;
    }

    public Boolean getIsCanceled() {
        return isCanceled;
    }

    public void setIsCanceled(Boolean canceled) {
        isCanceled = canceled;
    }

    public Boolean getIsBeingPrepared() {
        return isBeingPrepared;
    }

    public void setIsBeingPrepared(Boolean beingPrepared) {
        isBeingPrepared = beingPrepared;
    }

    public Boolean getIsReady() {
        return isReady;
    }

    public void setIsReady(Boolean ready) {
        isReady = ready;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void approveOrder() {
        this.isApproved = true;
    }
}
