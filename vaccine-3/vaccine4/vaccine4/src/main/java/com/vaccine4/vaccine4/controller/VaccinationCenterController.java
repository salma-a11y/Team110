package com.vaccine4.vaccine4.controller;


//import com.vaccine.backend.vaccine.aspect.LogExecutionTime;




import com.vaccine4.vaccine4.model.Dto.VaccinationCenterDto;
import com.vaccine4.vaccine4.service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("VaccinationCenter")
public class VaccinationCenterController {
    @Autowired
    VaccinationCenterService vaccinationCenterService;
    @PostMapping("/post")
    public ResponseEntity<?> post(@RequestBody VaccinationCenterDto vaccinationCenterDto) {
return vaccinationCenterService.post(vaccinationCenterDto);

    }
    @GetMapping("/get")
//   @LogExecutionTime
    public List<VaccinationCenterDto> getAll(){
        return vaccinationCenterService.getAll();
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id){
        return vaccinationCenterService.delete(id);
    }
    @PutMapping("/update")
    public void put(@RequestBody VaccinationCenterDto vaccinationCenterDto){
         vaccinationCenterService.update(vaccinationCenterDto);
    }
}
