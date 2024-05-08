package com.vaccine.vaccine.salma.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="patients")
public class Patient {

    @Id
    private Long id;
    @Column(name="Email",nullable = false,unique = true)

    private String email;
    @Column(name="userName",nullable = false)

    private String userName;
    @Column(name="address",nullable = false)

    private String address;
    @Column(name="firstDose",nullable = false)

    private String firstDose;
    @Column(name="secondDose",nullable = false)

    private String secondDose;
    @Column(name="certificate",nullable = false)

    private String certificate;
    @Column(name="Password",nullable = false)
    @JsonIgnore
    private String password;
    @Column(columnDefinition = "boolean default null")
    private boolean reserve;
    @Column(columnDefinition = "boolean default true")
    private boolean isApproved;


}

