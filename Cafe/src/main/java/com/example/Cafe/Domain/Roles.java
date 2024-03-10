package com.example.Cafe.Domain;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
}
