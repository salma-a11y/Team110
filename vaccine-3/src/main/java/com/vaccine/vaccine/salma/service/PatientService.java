package com.vaccine.vaccine.salma.service;

import com.vaccine.vaccine.salma.model.entity.Patient;
import com.vaccine.vaccine.salma.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepo patientRepo;

    public Patient getUser(Long id){
        Optional<Patient> patient= this.patientRepo.findById(id);
        return patient.orElse(null);
    }

    public Patient save(Patient patient){
        return  this.patientRepo.save(patient);
    }

    public Patient reserveDose1(Long patientId, String dose1) {
        Optional<Patient> optionalPatient = patientRepo.findById(patientId);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            patient.setFirstDose(dose1);
            patient.setReserve(true);
            return patientRepo.save(patient);
        } else {
            if (!optionalPatient.isPresent()) {
                return null;
            }
            Patient patient = optionalPatient.get();

            return patientRepo.save(patient);
        }
    }

    public Patient reserveDose2(Long patientId, String dose2) {
        Optional<Patient> optionalPatient = patientRepo.findById(patientId);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            patient.setSecondDose(dose2);
            patient.setReserve(true);
            return patientRepo.save(patient);
        } else {
            if (!optionalPatient.isPresent()) {
                return null;
            }
            Patient patient = optionalPatient.get();

            return patientRepo.save(patient);
        }
        }
    }



