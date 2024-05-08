package com.vaccine4.vaccine4.controller;



import com.vaccine4.vaccine4.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patient")
public class patientController {
    @Autowired
    private PatientService patientService;
    @GetMapping("getall")
    public Object get()
    {
        return patientService.get();

    }
    @PutMapping("{id}/Accept")
    public ResponseEntity<?> accept(@PathVariable Long id){
        return patientService.accept(id);
    }
    @PutMapping("{id}/Reject")
    public ResponseEntity<?> reject(@PathVariable Long id){
        return patientService.reject(id);
    }
}
