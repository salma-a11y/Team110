package com.vaccine4.vaccine4.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;


import com.vaccine4.vaccine4.model.Dto.UserDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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
   @Column(name="Email",unique = true)
   @NotNull
   private String email;
    @Column(name="Password")
    @JsonIgnore
    @NotNull
    private String password;
    @Column(name="Role")
    @NotNull
    private String role;
public static User toEntity(UserDto userDto){
    return User.builder()
            .password(userDto.getPassword())
            .email(userDto.getEmail())
            .role("")
            .build();

}
}
