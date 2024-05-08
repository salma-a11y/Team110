package com.vaccine.vaccine.salma.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Table(name = "vaccine")
@Entity
@Data
@Builder
public class Vaccine {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String precautions;
    private Integer timeGap;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;


}