package com.example.demo.dto;



import lombok.Data;

@Data
public class OrderDto {
    private Long id;
    private String productName;
    private Double productPrice;
}
