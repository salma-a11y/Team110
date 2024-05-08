package com.vaccine.vaccine.salma.controller;

import com.vaccine.vaccine.salma.model.entity.VaccinationCenter;
import com.vaccine.vaccine.salma.service.VCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/centers")
public class VCenterController {

    private final VCenterService vCenterService;

    @Autowired
    public VCenterController(VCenterService vCenterService) {
        this.vCenterService = vCenterService;
    }

    @GetMapping
    public ResponseEntity<List<VaccinationCenter>> getAllVaccinationCenters() {
        List<VaccinationCenter> centers = vCenterService.getAllVaccinationCenters();
        if (!centers.isEmpty()) {
            return new ResponseEntity<>(centers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
