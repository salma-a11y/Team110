package com.vaccine.vaccine.salma.repository;

import com.vaccine.vaccine.salma.model.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineRepo extends JpaRepository<Vaccine, Long> {
}
