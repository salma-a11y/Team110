package com.vaccine4.vaccine4.model.entity;

import jakarta.persistence.*;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "vaccine_vaccination_center")
public class VaccineVaccinationCenter {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
//    private Long vaccineId;
//    private Long centerId;
    @ManyToOne
    @JoinColumn(name="vaccine_id")
    private Vaccine vaccine;
    @ManyToOne
    @JoinColumn(name="center_id")
    private VaccinationCenter center;

}
