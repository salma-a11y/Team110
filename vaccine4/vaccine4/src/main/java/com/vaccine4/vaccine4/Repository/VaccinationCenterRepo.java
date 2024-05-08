package com.vaccine4.vaccine4.Repository;



import com.vaccine4.vaccine4.model.entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VaccinationCenterRepo extends JpaRepository<VaccinationCenter,Long> {
List<VaccinationCenter> findAll();

}
