package com.vaccine.vaccine.salma.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vaccine.vaccine.salma.model.entity.Patient;
import com.vaccine.vaccine.salma.model.repository.PatientRepo;


@Service
public class PatientService {
    
    private final PatientRepo patientRepo;

    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }


    public List<Patient> getAllPatientsWithReserve() {
        
        return patientRepo.findAllByReserveIsTrue();
    }

    
    
    public ResponseEntity<String> approvePatient(Long id) {
        Patient patient = patientRepo.findById(id).orElse(null);
        if (patient == null) {
            return ResponseEntity.ok().body("The Patient does not exist");
        }

        if (patient.getSecondDose() == null || (patient.getFirstDose() == null && patient.getSecondDose() == null)) {
            patient.setReserve(false);
        } else {
            return ResponseEntity.badRequest().body("You should reserve the first dose");
        }

        patientRepo.save(patient);
        return ResponseEntity.ok("\nApproved"+ patient.getReserve());
    }



    public ResponseEntity<String> preventPatient(Long id) {
       
        Patient patient = patientRepo.findById(id).orElse(null);
        if (patient == null) {
            return ResponseEntity.ok().body("The Patient does not exist");
        }

        if (!patient.getReserve() || (patient.getFirstDose() != null && patient.getSecondDose() != null)) {
            return ResponseEntity.badRequest().body("You can't reserve this vaccine again");
        }

        patient.setReserve(false);
        patientRepo.save(patient);

        return ResponseEntity.ok( "\nPrevent" + patient.getReserve());
    }




    public ResponseEntity<String> uploadCertificate(Long id) {
        Patient patient = patientRepo.findById(id).orElse(null);
        if (patient == null) {
            return ResponseEntity.ok().body("The Patient does not exist");
        }

        if (patient.getSecondDose() != null) {
            patient.setCertificate("Taken");
        } else {
            patient.setCertificate("Not Taken");
        }

        patientRepo.save(patient);

        return ResponseEntity.ok("Certificate uploaded\n" + patient.getCertificate());
    }

}
