package com.vaccine4.vaccine4.Repository;


import com.vaccine4.vaccine4.model.entity.VaccineVaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VaccineVaccinationCenterRepo extends JpaRepository<VaccineVaccinationCenter,Long> {

    List<VaccineVaccinationCenter> findByCenterId(Long centerId);
    VaccineVaccinationCenter findByCenterIdAndVaccineId(Long centerId, Long vaccineId);

   // List<VaccineVaccinationCenter> findByVaccinationCenterId(Long id);

}
