package com.vaccine.vaccine.salma.model.Dto;

import java.util.List;

import com.vaccine.vaccine.salma.model.entity.VaccinationCenter;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Data
@Builder
public class VaccinationCenterDto {
    
    @Id
private Long id;
private String Location;
private List<VaccineDto> vaccines;
public VaccinationCenterDto toDto(VaccinationCenter vaccinationCenter){
    return VaccinationCenterDto.builder()
            .id(vaccinationCenter.getId())
            .Location(vaccinationCenter.getLocation())
            .build();
}
}
