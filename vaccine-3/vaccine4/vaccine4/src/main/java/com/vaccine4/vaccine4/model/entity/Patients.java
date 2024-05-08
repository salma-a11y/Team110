package com.vaccine4.vaccine4.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class Patients {

    @Id
    @NotNull
    private Long id;
    @Column(name="Email",unique = true)
    @NotNull()
    private String email;
    @Column(name="userName")
    @NotNull
    private String userName;
    @Column(name="address")
    @NotNull
    private String address;
    @Column(name="firstDose")
    @NotNull
    private String firstDose;
    @Column(name="secondDose")
    @NotNull
    private String secondDose;
    @Column(name="certificate")
    @NotNull
    private String certificate;
    @Column(name="Password")
    @JsonIgnore
    @NotNull
@Min(value=8)
  @Max(value=10)
    private String password;
    @Column(columnDefinition = "boolean default null")
    private boolean reserve;
    @Column(columnDefinition = "boolean default true")
    private boolean isApproved;


}
