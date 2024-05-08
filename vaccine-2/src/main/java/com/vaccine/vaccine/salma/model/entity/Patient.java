package com.vaccine.vaccine.salma.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Patients")
public class Patient {

    @Id
    @NotNull
    private Long id;
    @Column(name="Email",nullable = false,unique = true)
    @NotEmpty
    private String email;
    @Column(name="userName",nullable = false)
    @NotEmpty
    private String userName;
    @Column(name="address",nullable = false)

    private String address;
    @Column(name="firstDose",nullable = true)

    private String firstDose;
    @Column(name="secondDose",nullable = true)

    private String secondDose;
    @Column(name="certificate",nullable = false)

    private String certificate;
    @Column(name="Password",nullable = false)
    @JsonIgnore
    @Min(value=8)
    @Max(value=10)
    private String password;
    @Column(columnDefinition = "boolean default null")
    private boolean reserve;
    public Boolean getReserve() {
        return reserve;
    }
    @Column(columnDefinition = "boolean default true")
    private boolean isApproved;
    


}
