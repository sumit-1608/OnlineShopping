package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {

}
