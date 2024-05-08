package com.vaccine4.vaccine4.Repository;



import com.vaccine4.vaccine4.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

User findByEmail(String email);


}
