package com.vaccine.vaccine.salma.model.Dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Data
//@Entity
public class PatientsDto {
    @Id
    private Long id;

    private String email;
    private String password;
    private String firstDose;
    private String secondDose;
    private String certificate;
    private boolean reserve;
    

}