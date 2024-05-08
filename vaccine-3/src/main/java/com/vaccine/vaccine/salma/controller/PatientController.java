package com.vaccine.vaccine.salma.controller;

import com.vaccine.vaccine.salma.model.entity.Patient;
import com.vaccine.vaccine.salma.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/{id}/reserveDose1")
    public ResponseEntity<Patient> reserveDose1(@PathVariable Long id, @RequestParam String dose1) {
        Patient reservedPatient = patientService.reserveDose1(id, dose1);
        return ResponseEntity.ok(reservedPatient);
    }

    @PostMapping("/{id}/reserveDose2")
    public ResponseEntity<Patient> reserveDose2(@PathVariable Long id, @RequestParam String dose2) {
        Patient reservedPatient = patientService.reserveDose2(id, dose2);
        return ResponseEntity.ok(reservedPatient);
    }
}
