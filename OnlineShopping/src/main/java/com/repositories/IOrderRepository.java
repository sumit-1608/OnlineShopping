package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Orders;

@Repository
public interface IOrderRepository extends JpaRepository<Orders, Long> {

}
