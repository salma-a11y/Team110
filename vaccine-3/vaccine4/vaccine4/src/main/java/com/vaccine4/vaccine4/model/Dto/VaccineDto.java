package com.vaccine4.vaccine4.model.Dto;


import com.vaccine4.vaccine4.model.entity.Vaccine;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class VaccineDto {
   @Id
    private Long id;
    private String name;
    private int time_gap;
    private String precautions;
    public static VaccineDto toDto(Vaccine vaccine){
        return VaccineDto.builder()
                .id(vaccine.getId())
                .name(vaccine.getName())
                .time_gap(vaccine.getTime_gap())
                .precautions(vaccine.getPrecautions())
                .build();
    }
}
