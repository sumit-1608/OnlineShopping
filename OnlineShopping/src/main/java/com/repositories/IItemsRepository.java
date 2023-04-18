package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Items;

@Repository
public interface IItemsRepository extends JpaRepository<Items, Long>{

}
