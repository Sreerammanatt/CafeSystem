package com.example.Cafe.Domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;


@Data
@Entity
@Table(name = "cafeUser" ,uniqueConstraints =@UniqueConstraint(columnNames = "email"))
public class User implements Serializable {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  String name;

    private  String  phone;


    private String email;

    private String password;

//    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinTable(name = "users_roles",
//    joinColumns = @JoinColumn(
//            name = "user_id",referencedColumnName = "id"
//    ),inverseJoinColumns = @JoinColumn(
//            name = "role_id",referencedColumnName = "id"
//    ))
//    private Collection<Roles> roles;

    private String role;




}
