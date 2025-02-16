package com.example.bookstorerest.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Table(name = "operation")

@Entity
@Data
@RequiredArgsConstructor
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final Double num1;
    private final Double num2;
    private Double result;
    private TypeOperation type;

    @OneToOne(cascade = CascadeType.REMOVE)
    private User user;
}
