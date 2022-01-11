package com.digitalmenu.sessionservice.Session;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Session {
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
    @NotNull
    @Column(nullable = false)
    private Integer tableId;
    @NotBlank
    @Column(nullable = false)
    private String secret;
}

