package com.vaccine4.vaccine4.service;



import com.vaccine4.vaccine4.Repository.VaccinationCenterRepo;
import com.vaccine4.vaccine4.Repository.VaccineRepo;
import com.vaccine4.vaccine4.Repository.VaccineVaccinationCenterRepo;
import com.vaccine4.vaccine4.model.Dto.VaccinationCenterDto;
import com.vaccine4.vaccine4.model.Dto.VaccineDto;
import com.vaccine4.vaccine4.model.entity.VaccinationCenter;
import com.vaccine4.vaccine4.model.entity.Vaccine;
import com.vaccine4.vaccine4.model.entity.VaccineVaccinationCenter;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VaccinationCenterService {
    @Autowired
    private VaccinationCenterRepo vaccinationCenterRepo;
    @Autowired
    private VaccineRepo vaccineRepo;
    @Autowired
    private VaccineVaccinationCenterRepo vaccineVaccinationCenterRepo;

    public ResponseEntity<?> post(VaccinationCenterDto vaccinationCenterDto) {
        VaccinationCenter center = new VaccinationCenter();
        center.setLocation((vaccinationCenterDto.getLocation()));
        vaccinationCenterRepo.save(center);
        if (vaccinationCenterDto.getVaccines() != null) {
            for (VaccineDto vaccineDto : vaccinationCenterDto.getVaccines()) {
                Vaccine vaccine = Vaccine.toEntity(vaccineDto);
                Vaccine vc = vaccineRepo.findByName(vaccineDto.getName());
                if(vc==null) {
                    vc = new Vaccine();
                    vc.setName(vaccineDto.getName());
                    vc.setTime_gap(vaccineDto.getTime_gap());
                    vc.setPrecautions(vaccineDto.getPrecautions());
                    vc= vaccineRepo.save(vaccine);
                }

                VaccineVaccinationCenter mapping = new VaccineVaccinationCenter();
                mapping.setCenter(center);
                mapping.setVaccine(vc);
                vaccineVaccinationCenterRepo.save(mapping);
            }
        }
        return ResponseEntity.ok("VaccinationCenter created successfully");
    }


    public List<VaccinationCenterDto> getAll() {
        List<VaccinationCenter> vaccinationCenters = vaccinationCenterRepo.findAll();
        List<VaccinationCenterDto> dtos = new ArrayList<>();


        for (VaccinationCenter center : vaccinationCenters) {
            VaccinationCenterDto centerDto = VaccinationCenterDto.toDto(center);
            List<Vaccine> vaccine = vaccineVaccinationCenterRepo.findByCenterId(center.getId())
                    .stream()
                    .map(VaccineVaccinationCenter::getVaccine)
                    .collect(Collectors.toList());
            List<VaccineDto> va1 = new ArrayList<>();
            for (Vaccine vac : vaccine) {
                va1.add(VaccineDto.toDto(vac));
            }
            centerDto.setVaccines(va1);
            dtos.add(centerDto);

        }


        return dtos;
    }

    public ResponseEntity<?> delete(Long id) {
        Optional<VaccinationCenter> vaccinationCenter = vaccinationCenterRepo.findById(id);
        if (vaccinationCenter.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The vaccination center doesn't exist");
        }

        try {
            // Delete associated records first
            List<VaccineVaccinationCenter> associatedRecords = vaccineVaccinationCenterRepo.findByCenterId(id);
            for (VaccineVaccinationCenter record : associatedRecords) {
                vaccineVaccinationCenterRepo.delete(record);
            }

            // Now delete the vaccination center record
            vaccinationCenterRepo.deleteById(id);

            return ResponseEntity.ok("The deletion was successful");
        } catch (Exception e) {
            // Handle any exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the vaccination center");
        }
    }


    public ResponseEntity<?> update(VaccinationCenterDto dto) {
        VaccinationCenter center=vaccinationCenterRepo.findById(dto.getId()).orElseThrow(EntityExistsException::new);
        center.setLocation(dto.getLocation());
        List<Vaccine> vaccines =new ArrayList<>();
        for(VaccineDto vaccinedto:dto.getVaccines()) {
            Vaccine vaccine;
            if (vaccinedto.getId() != null) {
                // If vaccine has an ID, it exists in the database, update it
                vaccine = vaccineRepo.findById(vaccinedto.getId())
                        .orElseThrow(EntityNotFoundException::new);
                vaccine.setName(vaccinedto.getName());
                vaccine.setPrecautions(vaccinedto.getPrecautions());
                vaccine.setTime_gap(vaccinedto.getTime_gap());
        }else{
                vaccine=Vaccine.toEntity(vaccinedto);
                vaccineRepo.save(vaccine);
            }
            vaccines.add(vaccine);
        }
       center.setVaccines(vaccines);
       vaccinationCenterRepo.save(center);

        return ResponseEntity.ok("the delete is success");
    }

//public void update(VaccinationCenterDto dto) {
//
//
// VaccinationCenter center=vaccinationCenterRepo.findById(dto.getId()).orElseThrow(EntityNotFoundException::new);
// center.setId(dto.getId());
//
//
//
//    center.setLocation(dto.getLocation());
//    VaccinationCenter vac=center.get();
//    vaccineVaccinationCenterRepo.save(center);
//// List<Vaccine> vaccines=new ArrayList<>();
//// for(VaccineDto vaccineDto:dto.getVaccines()) {
////     Vaccine vaccine = vaccineRepo.findById(vaccineDto.getId()).orElseThrow(EntityNotFoundException::new);
////     vaccines.add(vaccine);
//// }
//    for(VaccineDto vaccineDto:dto.getVaccines()){
//                 Vaccine vaccine=Vaccine.toEntity(vaccineDto);
//                 Vaccine existingVaccine=vaccineRepo.findByName(vaccineDto.getName());
//                 if(existingVaccine!=null){
//                     existingVaccine.setName(vaccineDto.getName());
//                     existingVaccine.setPrecautions(vaccineDto.getPrecautions());
//                     existingVaccine.setTime_gap(vaccineDto.getTime_gap());
//                     vaccineRepo.save(existingVaccine);
//                     center.setVaccines();
//
//
// vaccinationCenterRepo.save(center);
}










