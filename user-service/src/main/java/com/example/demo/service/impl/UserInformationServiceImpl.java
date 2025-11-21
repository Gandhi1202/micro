package com.example.demo.service.impl;

import com.example.demo.entity.UserInformation;
import com.example.demo.repository.UserInformationRepository;
import com.example.demo.service.UserInformationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserInformationServiceImpl  implements UserInformationService {
    private  final UserInformationRepository userInformationRepository;

    public UserInformationServiceImpl(UserInformationRepository userInformationRepository) {
        this.userInformationRepository = userInformationRepository;
    }


    @Override
    public UserInformation createUser(UserInformation userInformation) {

        UserInformation users= userInformationRepository.save(userInformation);
        return  users;

    }

    @Override
    public Optional<UserInformation> getUser(Long id) {
      Optional<UserInformation> user=  userInformationRepository.findById(id);
      return  user;
    }
}
