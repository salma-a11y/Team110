package com.vaccine.vaccine.salma.service;

import com.vaccine.vaccine.salma.model.entity.User;
import com.vaccine.vaccine.salma.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User getUser(Long id){
        Optional<User> user = this.userRepo.findById(id);
        return user.orElse(null);
    }


    public User save(User user){
        return  this.userRepo.save(user);
    }
}
