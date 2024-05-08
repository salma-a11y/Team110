package com.vaccine4.vaccine4.model.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Data
//@Entity
public class PatientsDto {
    @Id
    private Long id;
    private boolean isApproved;


}