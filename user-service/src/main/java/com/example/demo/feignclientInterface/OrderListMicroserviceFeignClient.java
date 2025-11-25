package com.example.demo.feignclientInterface;

import com.example.demo.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "order-service")
public interface OrderListMicroserviceFeignClient {

//    @GetMapping("/orders/all")
//    List<OrderDto> getOrderListItem();

    @RequestMapping(method = RequestMethod.GET,path="orders/all")
    List<OrderDto> getOrderListItem();

}
