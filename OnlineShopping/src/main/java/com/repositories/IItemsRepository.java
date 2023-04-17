package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Cart;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Long>{

}
