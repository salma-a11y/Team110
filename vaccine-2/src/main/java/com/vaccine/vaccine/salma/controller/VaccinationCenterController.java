package com.vaccine.vaccine.salma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaccine.vaccine.salma.model.Dto.VaccinationCenterDto;
import com.vaccine.vaccine.salma.model.entity.VaccinationCenter;
import com.vaccine.vaccine.salma.service.VaccinationCenterService;



@RestController
@RequestMapping("/api/v1")
public class VaccinationCenterController {
    private final VaccinationCenterService vaccinationCenterService;

    @Autowired
    public VaccinationCenterController(VaccinationCenterService vaccinationCenterService) {
        this.vaccinationCenterService = vaccinationCenterService;
    }

    @GetMapping("/List")
    public ResponseEntity<List<VaccinationCenter>> getVaccinationCenters() {
        List<VaccinationCenter> vaccinationCenters = vaccinationCenterService.getAllVaccinationCenters();
        return ResponseEntity.ok(vaccinationCenters);
    }
    
    @PostMapping("/create")
    public ResponseEntity<Void> createVaccinationCenter(@RequestBody VaccinationCenterDto vaccinationCenterDto) {
        vaccinationCenterService.createVaccinationCenter(vaccinationCenterDto);
        return ResponseEntity.ok().build();
    }
}
