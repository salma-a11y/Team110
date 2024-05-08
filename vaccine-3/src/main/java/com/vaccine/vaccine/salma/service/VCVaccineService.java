package com.vaccine.vaccine.salma.service;

import com.vaccine.vaccine.salma.model.entity.VCVaccine;
import com.vaccine.vaccine.salma.model.entity.Vaccine;
import com.vaccine.vaccine.salma.repository.VCVaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VCVaccineService {
    @Autowired
    private VCVaccineRepo vcVaccineRepo;

    public VCVaccine getVCVaccine(Long id){
        Optional<VCVaccine> vcVaccine = vcVaccineRepo.findById(id);
        return vcVaccine.orElse(null);
    }

    public VCVaccine save(VCVaccine vcVaccine){
        return vcVaccineRepo.save(vcVaccine);
    }

    @Autowired
    public VCVaccineService(VCVaccineRepo vcVaccineRepo) {
        this.vcVaccineRepo = vcVaccineRepo;
    }

    public List<Vaccine> getAllVaccinesByCenter(Long centerId) {
        return vcVaccineRepo.findAllByVaccinationCenterId(centerId);
    }
}
