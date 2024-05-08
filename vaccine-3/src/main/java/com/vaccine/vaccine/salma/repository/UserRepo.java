package com.vaccine.vaccine.salma.repository;

import com.vaccine.vaccine.salma.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
