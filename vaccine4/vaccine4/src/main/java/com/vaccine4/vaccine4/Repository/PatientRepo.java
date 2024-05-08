package com.vaccine4.vaccine4.Repository;



import com.vaccine4.vaccine4.model.entity.Patients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepo extends JpaRepository<Patients,Long> {
    Patients findByEmail(String email);


    List<Patients> findUserNamesByIsApprovedTrue();
}
