package com.example.sessionmcs.Session;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
            allocationSize =1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "session_sequence"
    )
    private Long id;
    private Integer tableId;
    private String secret;
}

