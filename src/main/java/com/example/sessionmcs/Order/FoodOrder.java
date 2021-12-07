package com.example.sessionmcs.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private Boolean isArchived;
    private Long timeStamp;

    public void approveOrder() {
        this.isApproved = true;
    }
}
