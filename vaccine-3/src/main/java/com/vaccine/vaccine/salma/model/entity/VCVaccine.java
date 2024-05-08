package com.vaccine.vaccine.salma.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Table(name = "vaccine_vaccination_center")
@Entity
@Data
@Builder
public class VCVaccine {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "vaccine_id", referencedColumnName = "id")
    private Vaccine vaccine;

    @ManyToOne
    @JoinColumn(name = "vaccination_center_id", referencedColumnName = "id")
    private VaccinationCenter vaccinationCenter;
}
