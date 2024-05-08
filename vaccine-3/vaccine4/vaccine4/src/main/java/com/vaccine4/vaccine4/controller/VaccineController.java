package com.vaccine4.vaccine4.controller;





import com.vaccine4.vaccine4.model.Dto.VaccineDto;
import com.vaccine4.vaccine4.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vaccine")
public class VaccineController {
    @Autowired
    private VaccineService vaccineService;
    @GetMapping("/getAll")
    public List<VaccineDto> get(){
        return vaccineService.getAll();

    }
    @PostMapping("/add")
    public VaccineDto post(@RequestBody VaccineDto vaccineDto){
        return vaccineService.post(vaccineDto);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody VaccineDto vaccineDto){
        if(vaccineService.update(vaccineDto)){
            return ResponseEntity.ok("the update is success");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("the vaccine isn't exist");
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id){
        return vaccineService.delete(id);
    }
}
