package com.vaccine4.vaccine4.service;

import com.vaccine4.vaccine4.Repository.PatientRepo;
import com.vaccine4.vaccine4.model.entity.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {
    @Autowired
    private PatientRepo patientRepo;
    public List<String> get(){


List<Patients> patients= patientRepo.findUserNamesByIsApprovedTrue();
List<String> names=patients.stream().map(Patients::getUserName).collect(Collectors.toList());
return names;
    }
  public ResponseEntity<?> accept(Long id){
  Patients patients=patientRepo.findById(id).
          orElseThrow(()->new IllegalArgumentException("Invalid item ID"));
patients.setApproved(false);
patientRepo.save(patients);
return ResponseEntity.ok("Success");

  }
  public ResponseEntity<?> reject(Long id){
      Patients patients=patientRepo.findById(id).
              orElseThrow(()->new IllegalArgumentException("Invalid item ID"));
      patientRepo.delete(patients);
      return ResponseEntity.ok("Success");

  }
}
