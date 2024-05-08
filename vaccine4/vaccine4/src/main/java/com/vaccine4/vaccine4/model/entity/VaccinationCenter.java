package com.vaccine4.vaccine4.model.entity;



import com.vaccine4.vaccine4.model.Dto.VaccinationCenterDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="VaccinationCenter")
public class VaccinationCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="Location")
    @NotNull
    private String Location;
    public void addVaccine(Vaccine vaccine) {
        this.vaccines.add(vaccine);
        vaccine.getVaccineVaccinationCenters().add(new VaccineVaccinationCenter());
    }
    @ManyToMany(cascade =CascadeType.REMOVE)
    @JoinTable(
            name = "vaccination_center_vaccine",
            joinColumns = @JoinColumn(name = "vaccination_center_id"),
            inverseJoinColumns = @JoinColumn(name = "vaccine_id")
    )
    private List<Vaccine> vaccines = new ArrayList<>();







public static VaccinationCenter toEntity(VaccinationCenterDto vaccinationCenterDto){
    return VaccinationCenter.builder()
            .id(vaccinationCenterDto.getId())
            .Location(vaccinationCenterDto.getLocation())

            .build();
}



}
