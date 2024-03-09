package com.example.Cafe.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;


@Data
@Entity
public class User implements Serializable {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private  String name;

    private  String  phone;

    private Long bill;




}
