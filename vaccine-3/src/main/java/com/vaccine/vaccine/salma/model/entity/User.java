package com.vaccine.vaccine.salma.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;


@Table(name = "users")
@Entity
@Data
@Builder
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Email",nullable = false,unique = true)
    private String email;

    @Column(name="Password",nullable = false)
    @JsonIgnore
    private String password;

    @Column(name="Role",nullable = false)
    private String role;

}