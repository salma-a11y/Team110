package com.vaccine.vaccine.salma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vaccine.vaccine.salma.aspect.LogExecutionTime;
import com.vaccine.vaccine.salma.model.entity.Patient;
import com.vaccine.vaccine.salma.service.PatientService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1")
public class ViewReserveController {
    private final PatientService patientService;

    @Autowired
    public ViewReserveController(PatientService patientService) {
        this.patientService = patientService;
    }
    

    @GetMapping("/ListReservations")
    @LogExecutionTime
    public ResponseEntity<List<Patient>> getAllReserves() {
        List<Patient> patientsWithReserve = patientService.getAllPatientsWithReserve();
        return ResponseEntity.ok(patientsWithReserve);
    }

    @PutMapping("/Approve")
    @LogExecutionTime
    public ResponseEntity<String> approvePatient(@RequestParam @Valid Long id) {
        return patientService.approvePatient(id);
    }


    @PutMapping("/Prevent")
    public ResponseEntity<String> preventPatient(@RequestParam @Valid Long id) {
        return patientService.preventPatient(id);
    }



    @PutMapping("/UploadCertificate")
    public ResponseEntity<String> uploadCertificate(@RequestParam @Valid Long id) {
        return patientService.uploadCertificate(id);
    }
}
