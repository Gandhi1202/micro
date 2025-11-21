package com.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orders.entity.Order;



public interface OrderRepository extends JpaRepository<Order, Long> {

}
