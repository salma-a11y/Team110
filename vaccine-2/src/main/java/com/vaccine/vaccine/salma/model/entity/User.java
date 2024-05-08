package com.vaccine.vaccine.salma.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vaccine.vaccine.salma.model.Dto.UserDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
@Table(name="Users")

public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @Column(name="Email",nullable = false,unique = true)

   private String email;
    @Column(name="Password",nullable = false)
    @JsonIgnore
    private String password;
    @Column(name="Role",nullable = false)
    private String role;
public static User toEntity(UserDto userDto){
    return User.builder()
            .password(userDto.getPassword())
            .email(userDto.getEmail())
            .role(" ")
            .build();

}
}
