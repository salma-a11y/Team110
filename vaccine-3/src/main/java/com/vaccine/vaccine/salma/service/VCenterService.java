package com.vaccine.vaccine.salma.service;

import com.vaccine.vaccine.salma.model.entity.VaccinationCenter;
import com.vaccine.vaccine.salma.repository.VCenterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class VCenterService {
    @Autowired
    private VCenterRepo vCenterRepo;

    public VaccinationCenter getVaccinationCenter(Long id){
        Optional<VaccinationCenter> vaccinationCenter = vCenterRepo.findById(id);
        return vaccinationCenter.orElse(null);
    }

    public VaccinationCenter save(VaccinationCenter vaccinationCenter){
        return vCenterRepo.save(vaccinationCenter);
    }

    public List<VaccinationCenter> findAllById(List<Long> ids) {
        return vCenterRepo.findAllById(ids);
    }

    @Autowired
    public VCenterService(VCenterRepo vCenterRepo) {
        this.vCenterRepo = vCenterRepo;
    }

    public List<VaccinationCenter> getAllVaccinationCenters() {
        return vCenterRepo.findAll();
    }
}


