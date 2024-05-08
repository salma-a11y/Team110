package com.vaccine.vaccine.salma.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Table(name = "vaccination_center")
@Entity
@Data
@Builder
public class VaccinationCenter {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String location;

}