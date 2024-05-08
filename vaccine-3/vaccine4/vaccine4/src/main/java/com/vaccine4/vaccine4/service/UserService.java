package com.vaccine4.vaccine4.service;
import com.vaccine4.vaccine4.Repository.UserRepo;
import com.vaccine4.vaccine4.model.Dto.UserDto;
import com.vaccine4.vaccine4.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;




public UserDto save(UserDto userDto){

    return UserDto.toDto(userRepo.save(User.toEntity(userDto)));
}
public ResponseEntity<String> login(UserDto userDto){

    User users=User.toEntity(userDto);
    User user= userRepo.findByEmail(users.getEmail());
    if (user!=null){
       if( Objects.equals(user.getPassword(), userDto.getPassword())){
           return ResponseEntity.ok("hello,sir");
       }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body("the password isnot match");
    }
   return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");



}
}







