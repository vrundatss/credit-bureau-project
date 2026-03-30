package com.creditbureau.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "citizens", indexes = {
        @Index(name = "idx_pan_number", columnList = "pan_number", unique = true)
})
@Getter @Setter @NoArgsConstructor
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "pan_number", unique = true, nullable = false, length = 10)
    private String panNumber;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

//    @Column(nullable = false)
//    private Integer creditScore;
}