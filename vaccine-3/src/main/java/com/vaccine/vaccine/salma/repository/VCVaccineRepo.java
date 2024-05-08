package com.vaccine.vaccine.salma.repository;
import com.vaccine.vaccine.salma.model.entity.Vaccine;
import com.vaccine.vaccine.salma.model.entity.VCVaccine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VCVaccineRepo extends JpaRepository<VCVaccine, Long> {
    List<Vaccine> findAllByVaccinationCenterId(Long centerId);
}
