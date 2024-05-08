package com.vaccine4.vaccine4.service;




import com.vaccine4.vaccine4.Repository.VaccineRepo;
//import com.vaccine4.vaccine4.aspect.LogExecutionTime;
import com.vaccine4.vaccine4.model.Dto.VaccineDto;
import com.vaccine4.vaccine4.model.entity.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VaccineService {
    @Autowired
    private VaccineRepo vaccineRepo;
//   @LogExecutionTime
    public List<VaccineDto> getAll() {
        List<Vaccine> vaccines = vaccineRepo.findAll();
        List<VaccineDto> vaccineDtos = vaccines.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());

        return vaccineDtos;

    }

    private VaccineDto mapToDto(Vaccine vaccine) {
      return   VaccineDto.toDto(vaccine);

    }


    public VaccineDto post(VaccineDto vaccineDto) {

        return VaccineDto.toDto(vaccineRepo.save(Vaccine.toEntity(vaccineDto)));


    }
    public boolean update(VaccineDto vaccineDto){
        Vaccine vaccine=Vaccine.toEntity(vaccineDto);
        if(vaccineRepo.existsById(vaccine.getId())){
            vaccineRepo.save(vaccine);
            return true;
        }
        return false;
    }
    public ResponseEntity<?> delete(Long id){
     Optional<Vaccine> vaccine=vaccineRepo.findById(id);
     if(vaccine.isEmpty()) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("the vaccine isn't exist");
     }
vaccineRepo.deleteById(id);
     return ResponseEntity.ok("the delete is success");
    }
}