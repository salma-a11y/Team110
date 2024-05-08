package com.vaccine.vaccine.salma.model.Dto;
import com.vaccine.vaccine.salma.model.entity.Vaccine;
import lombok.*;




@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VaccineDto {

    private Long id;
    private String name;
    private int time_gap;
    private String precaution;
    public static VaccineDto toDto(Vaccine vaccine){
        return VaccineDto.builder()
                .id(vaccine.getId())
                .name(vaccine.getName())
                .time_gap(vaccine.getTime_gap())
                .precaution(vaccine.getPrecaution())
                .build();
    }
}
