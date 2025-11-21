package com.example.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private  String email;
    private String mobileNumber;
    private  String fullName;
    private  String password;
}
