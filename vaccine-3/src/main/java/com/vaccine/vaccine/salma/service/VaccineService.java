package com.vaccine.vaccine.salma.service;

import com.vaccine.vaccine.salma.model.entity.Patient;
import com.vaccine.vaccine.salma.model.entity.Vaccine;
import com.vaccine.vaccine.salma.repository.VaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VaccineService {
    @Autowired
    private VaccineRepo vaccineRepo;

    public Vaccine getUser(Long id){
        Optional<Vaccine> vaccine= this.vaccineRepo.findById(id);
        return vaccine.orElse(null);
    }

    public Vaccine save(Vaccine vaccine){
        return  this.vaccineRepo.save(vaccine);
    }

    public List<Vaccine> findAllById(List<Long> ids) {
        return vaccineRepo.findAllById(ids);
    }


}

