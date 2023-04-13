package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Product;

public interface IProductRepository extends JpaRepository<Product,Integer> {

}
