package com.vaccine4.vaccine4.Repository;



import com.vaccine4.vaccine4.model.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineRepo extends JpaRepository<Vaccine,Long> {
Vaccine findByName(String name);


}
