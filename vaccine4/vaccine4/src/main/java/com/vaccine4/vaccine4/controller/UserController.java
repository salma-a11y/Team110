package com.vaccine4.vaccine4.controller;




import com.vaccine4.vaccine4.model.Dto.UserDto;
import com.vaccine4.vaccine4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("user")
public class UserController {
     @Autowired
    private UserService userService;
     @GetMapping("")
     public String test(){
         return "Hello";
     }

@PostMapping("/save")
    public UserDto save(@RequestBody UserDto userDto){
         return userService.save(userDto);
}

@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody UserDto userDto){


       return   userService.login(userDto);

}

}