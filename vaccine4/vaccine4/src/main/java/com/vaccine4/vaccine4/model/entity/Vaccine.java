package com.vaccine4.vaccine4.model.entity;



import com.vaccine4.vaccine4.model.Dto.VaccineDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;



import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Vaccine")
@Builder
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="Name")
    @NotNull
    private String name;
    @Column(name="TimeGap")
    @NotNull
    private int time_gap;
    @Column(name="precautions")
    @NotNull
    private String precautions;
    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patients patients;

//
    @OneToMany(mappedBy = "vaccine",cascade = CascadeType.ALL)
    private Set<VaccineVaccinationCenter> vaccineVaccinationCenters= new HashSet<>();

    public Vaccine(String name) {

    }


    public static Vaccine toEntity(VaccineDto vaccineDto){
    return Vaccine.builder()
            .id(vaccineDto.getId())
            .name(vaccineDto.getName())
            .time_gap(vaccineDto.getTime_gap())
            .precautions(vaccineDto.getPrecautions())
            .build();
}

}
