package com.digitalmenu.sessionservice.Order;

import com.vladmihalcea.hibernate.type.array.ListArrayType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@TypeDef(
        name = "list-array",
        typeClass = ListArrayType.class
)
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
    private String sessionId;
    @NotNull
    @Column(nullable = false)
    private Integer tableNumber;
    @NotEmpty
    @Type(type = "list-array")
    @Column(columnDefinition = "text[]")
    private List<String> dishes;
    private String comments;
    @NotNull
    @Column(nullable = false)
    private OrderState orderState;
    @NotNull
    @Column(nullable = false)
    private Long timeStamp;

    enum OrderState {
        isUnapproved,
        isApproved,
        isBeingPrepared,
        isReady,
        isArchived,
        isCanceled
    }
}
