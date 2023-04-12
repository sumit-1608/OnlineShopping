package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Order;
import com.entities.Product;
import com.repositories.IOrderRepository;
import com.services.IOrderService;

@RestController
public class OrderController {
	
	
	@Autowired
	private IOrderService service;
	
	@Autowired
	private IOrderRepository repo;
	
	 @GetMapping("/getOrders")
	    public List<Order> GetOrders() {

	        return service.getOrders();
	    }

}
