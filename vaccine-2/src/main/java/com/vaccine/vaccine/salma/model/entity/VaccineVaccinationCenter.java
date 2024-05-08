package com.vaccine.vaccine.salma.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vaccine_vaccination_centers")
public class VaccineVaccinationCenter {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long vaccineId;
    private Long centerId;

}
