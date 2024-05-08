package com.vaccine.vaccine.salma.repository;

import com.vaccine.vaccine.salma.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {
}
