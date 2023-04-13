package com.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Orders;
import com.entities.Product;
import com.exceptions.OrderAlreadyExistsException;
import com.exceptions.OrderDetailsNotFoundException;
import com.exceptions.ProductNotFoundException;
import com.repositories.IOrderRepository;
import com.services.IOrderService;

@RestController
public class OrderController {

	@Autowired
	private IOrderService service;

	@Autowired
	private IOrderRepository repo;

	@GetMapping("/getOrdersDetails")
	public List<Orders> GetOrders() {

		return service.getOrders();
	}

	@GetMapping("/getOrderDetails/{id}")
	public Orders getUser(@PathVariable int id) throws OrderDetailsNotFoundException {
		return service.getOrderDetailsById(id);
	}

	@PostMapping("/addOrderDetails")
	public Orders addOrderDetails(@RequestBody Orders p1) throws OrderAlreadyExistsException {
		{
			return service.addOrderDetails(p1);
		}
	}

	@PutMapping("/updateOrder")
	public Orders updateOrderDetails(@RequestBody Orders p1) throws OrderDetailsNotFoundException {
		{
			return service.updateOrderDetails(p1);
		}

	}
	
	 @PutMapping("updateOrderDetails/{id}")

		public Orders updateOrderDetailsById(@PathVariable int id,  @RequestBody Orders p1) throws OrderDetailsNotFoundException {
			
			return service.updateOrderDetailsById(p1, id);
		}
	 
	 @DeleteMapping("/deleteOrder/{id}")
	  	public Orders deleteOrder(@PathVariable int id) throws OrderDetailsNotFoundException {
	  	{
	  		return service.deleteOrder(id);
	  	}

}
}
