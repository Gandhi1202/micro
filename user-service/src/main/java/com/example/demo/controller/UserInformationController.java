package com.example.demo.controller;

import com.example.demo.dto.OrderDto;
import com.example.demo.entity.UserInformation;
import com.example.demo.feignclientInterface.OrderListMicroserviceFeignClient;
import com.example.demo.service.UserInformationService;
import com.example.demo.service.impl.UserInformationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")

public class UserInformationController {

    private final UserInformationServiceImpl userInformationServiceImpl;
    private final OrderListMicroserviceFeignClient orderListMicroserviceFeignClient;
    private final UserInformationService userService;
    public UserInformationController(UserInformationServiceImpl userInformationServiceImpl, OrderListMicroserviceFeignClient orderListMicroserviceFeignClient, UserInformationService userService) {
        this.userInformationServiceImpl = userInformationServiceImpl;
        this.orderListMicroserviceFeignClient = orderListMicroserviceFeignClient;
        this.userService = userService;
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


    @GetMapping("/getAllOrders")
    public List<LinkedHashMap> getOrders() {
        return userInformationServiceImpl.getAllOrders();
    }
    @GetMapping("/getAllOrdersFeign")
    public List<OrderDto> getOrdersFeign() {
        return orderListMicroserviceFeignClient.getOrderListItem();
    }

    @GetMapping("/getAllOrdersFeignRequestMapping")
    public List<OrderDto> getOrdersFeignRequestMethod() {
        return userService.getOrdersUsingFeign();
    }




}
