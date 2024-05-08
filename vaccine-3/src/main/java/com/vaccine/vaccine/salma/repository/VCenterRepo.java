package com.vaccine.vaccine.salma.repository;

import com.vaccine.vaccine.salma.model.entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VCenterRepo extends JpaRepository<VaccinationCenter, Long> {
}
