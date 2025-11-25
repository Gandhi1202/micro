package com.example.demo.service;

import com.example.demo.Dto.UserResponseDto;
import com.example.demo.entity.UserInformation;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

public interface UserInformationService {
    public UserInformation createUser(UserInformation userInformation);

    public Optional<UserInformation> getUser(Long id);

    public List<LinkedHashMap> getAllOrders();

}
