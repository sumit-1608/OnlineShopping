package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Order;

public interface IOrderRepository extends JpaRepository<Order, Integer> {

}
