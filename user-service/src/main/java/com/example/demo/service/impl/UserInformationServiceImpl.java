package com.example.demo.service.impl;

import com.example.demo.entity.UserInformation;
import com.example.demo.repository.UserInformationRepository;
import com.example.demo.service.UserInformationService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;
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


    @Override
    public List<LinkedHashMap> getAllOrders() {

        String url = "http://localhost:8888/order-service/orders/all";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<LinkedHashMap>> restResponse =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<LinkedHashMap>>() {}
                );

        return restResponse.getBody();
    }

}
