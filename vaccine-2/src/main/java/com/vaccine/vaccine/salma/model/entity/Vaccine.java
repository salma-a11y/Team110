package com.vaccine.vaccine.salma.model.entity;

import java.util.List;

import com.vaccine.vaccine.salma.model.Dto.VaccineDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Vaccines")
@Builder
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="Name",nullable = false)
    private String name;
    @Column(name="TimeGap",nullable = false)
    private int time_gap;
    @Column(name="precautions",nullable = false)
    private String precaution;
    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patients;

    @ManyToMany
    @JoinTable(name = "VaccineCenter",joinColumns=@JoinColumn(name="vaccine_id"),
    inverseJoinColumns=@JoinColumn(name="center_id"))
    private List<VaccinationCenter> vaccinationCenters;



public static Vaccine toEntity(VaccineDto vaccineDto){
    return Vaccine.builder()
            .id(vaccineDto.getId())
            .name(vaccineDto.getName())
            .time_gap(vaccineDto.getTime_gap())
            .precaution(vaccineDto.getPrecaution())
            .build();
}

}
