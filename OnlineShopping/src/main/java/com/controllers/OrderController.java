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
	private IOrderService orderService;

	@GetMapping("/orders")
	public List<Orders> GetOrders(){

		return orderService.getOrders();
	}

	@GetMapping("/orders/{orderId}")
	public Orders getUser(@PathVariable Long orderId) throws OrderDetailsNotFoundException {
		return orderService.getOrderDetailsById(orderId);
	}

	@PostMapping("/order")
	public Orders addOrderDetails(@RequestBody Orders order) throws OrderAlreadyExistsException {
		{
			return orderService.addOrderDetails(order);
		}
	}

	@PutMapping("/order/{orderId}")
	public Orders updateOrderDetails(@PathVariable Long orderId, @RequestBody Orders orders) throws OrderDetailsNotFoundException {
		{
			return this.orderService.updateOrderDetails(orderId, orders);
		}

	}
	
	 
	@DeleteMapping("/deleteOrder/{orderId}")
	  	public void deleteOrder(@PathVariable Long orderId) throws OrderDetailsNotFoundException {
	  	{
	  		this.orderService.deleteOrder(orderId);
	  	}

}
}
