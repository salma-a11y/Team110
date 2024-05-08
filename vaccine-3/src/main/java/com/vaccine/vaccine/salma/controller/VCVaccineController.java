package com.vaccine.vaccine.salma.controller;

import com.vaccine.vaccine.salma.model.entity.Vaccine;
import com.vaccine.vaccine.salma.service.VCVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/centers")
public class VCVaccineController {

    private final VCVaccineService vcVaccineService;
    @Autowired
    public VCVaccineController(VCVaccineService vcVaccineService) {
        this.vcVaccineService = vcVaccineService;
    }

    @GetMapping("/{centerId}/vaccines")
    public ResponseEntity<List<Vaccine>> getAllVaccinesByCenter(@PathVariable Long centerId) {
        List<Vaccine> vaccines = vcVaccineService.getAllVaccinesByCenter(centerId);
        if (!vaccines.isEmpty()) {
            return new ResponseEntity<>(vaccines, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
