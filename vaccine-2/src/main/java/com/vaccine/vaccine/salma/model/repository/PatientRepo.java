package com.vaccine.vaccine.salma.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaccine.vaccine.salma.model.entity.Patient;

public interface PatientRepo extends JpaRepository <Patient ,Long> {
    List<Patient> findAllByReserveIsTrue();
    

}
