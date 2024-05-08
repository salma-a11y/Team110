package com.vaccine.vaccine.salma.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vaccine.vaccine.salma.model.Dto.VaccinationCenterDto;
import com.vaccine.vaccine.salma.model.entity.VaccinationCenter;
import com.vaccine.vaccine.salma.model.repository.VaccinationCenterRepo;

@Service
public class VaccinationCenterService {
    private final VaccinationCenterRepo vaccinationCenterRepo;

    public VaccinationCenterService(VaccinationCenterRepo vaccinationCenterRepo) {
        this.vaccinationCenterRepo = vaccinationCenterRepo;
    }

    public List<VaccinationCenter> getAllVaccinationCenters() {
        return vaccinationCenterRepo.findAll();
    }
   

     public void createVaccinationCenter(VaccinationCenterDto vaccinationCenterDto) {
        if (vaccinationCenterDto == null) {
            throw new IllegalArgumentException("VaccinationCenterDto cannot be null.");
        }

        VaccinationCenter vaccinationCenter = new VaccinationCenter();
        vaccinationCenter.setLocation(vaccinationCenterDto.getLocation());

        vaccinationCenterRepo.save(vaccinationCenter);
    }



}
