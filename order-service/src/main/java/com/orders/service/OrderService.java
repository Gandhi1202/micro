package com.orders.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.orders.entity.Order;
import com.orders.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	public final OrderRepository orderRepository;
	
	
	public Order  CreateOrder (Order order)
	{
		Order or= orderRepository.save(order);
		 return or;
		
	}
	
	public List<Order> getAllOrders()
	{
		List<Order> org= orderRepository.findAll();
		return org;
	}
	


}
