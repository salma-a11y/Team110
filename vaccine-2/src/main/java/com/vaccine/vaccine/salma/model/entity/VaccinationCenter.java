package com.vaccine.vaccine.salma.model.entity;

import java.util.List;

import com.vaccine.vaccine.salma.model.Dto.VaccinationCenterDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
@Builder
@Table(name="VaccinationCenters")
public class VaccinationCenter {
    

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="Location",nullable = false)
    private String Location;

    @ManyToMany(mappedBy="vaccinationCenters")
    private List<Vaccine> vaccines;

public static VaccinationCenter toEntity(VaccinationCenterDto vaccinationCenterDto){
    return VaccinationCenter.builder()
            .id(vaccinationCenterDto.getId())
            .Location(vaccinationCenterDto.getLocation())
            .build();
}

}
