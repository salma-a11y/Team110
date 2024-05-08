package com.vaccine4.vaccine4.model.Dto;





import com.vaccine4.vaccine4.model.entity.VaccinationCenter;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Entity
public class VaccinationCenterDto {
    @Id
private Long id;
private String Location;
    private List<VaccineDto> vaccines;
    public void addVaccine(VaccineDto vaccineDto){
        if(vaccines==null){
            vaccines=new ArrayList<>();
        }
        vaccines.add(vaccineDto);
    }
//private Set<VaccineVaccinationCenter> vaccineVaccinationCenters=new HashSet<>();

//private Set<Vaccine> vaccines;
public static VaccinationCenterDto toDto(VaccinationCenter vaccinationCenter){
    return VaccinationCenterDto.builder()
            .id(vaccinationCenter.getId())
            .Location(vaccinationCenter.getLocation())
            .build();
}
}
