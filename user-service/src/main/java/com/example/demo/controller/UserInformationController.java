package com.example.demo.controller;

import com.example.demo.Dto.UserRequestDto;
import com.example.demo.Dto.UserResponseDto;
import com.example.demo.entity.UserInformation;
import com.example.demo.service.impl.UserInformationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")

public class UserInformationController {

    private final UserInformationServiceImpl userInformationServiceImpl;

    public UserInformationController(UserInformationServiceImpl userInformationServiceImpl) {
        this.userInformationServiceImpl = userInformationServiceImpl;
    }

    @PostMapping("/post")
    public ResponseEntity<UserInformation> createUser(@RequestBody UserInformation userInformation){
        UserInformation userRepo= userInformationServiceImpl.createUser(userInformation);

        return  new ResponseEntity<>(userRepo, HttpStatus.CREATED);
    }

    @GetMapping("eid/{id}")
    public ResponseEntity<Optional<UserInformation>> getUser(@PathVariable Long id)
    {
        Optional<UserInformation> uu= userInformationServiceImpl.getUser(id);
        return  new ResponseEntity<>(uu,HttpStatus.OK);
    }



}
