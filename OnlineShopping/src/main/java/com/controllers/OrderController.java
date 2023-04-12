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

import com.entities.Order;
import com.entities.Product;
import com.exceptions.OrderDeatilsNotFoundException;
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
	public List<Order> GetOrders() {

		return service.getOrders();
	}

	@GetMapping("/getOrderDetails/{id}")
	public Order getUser(@PathVariable int id) throws OrderDeatilsNotFoundException {
		return service.getOrderDetailsById(id);
	}

	@PostMapping("/addOrderDetails")
	public Order addOrderDetails(@RequestBody Order p1) throws OrderDeatilsNotFoundException {
		{
			return service.addOrderDetails(p1);
		}
	}

	@PutMapping("/updateOrder")
	public Order updateOrderDetails(@RequestBody Order p1) throws OrderDeatilsNotFoundException {
		{
			return service.updateOrderDetails(p1);
		}

	}
	
	 @PutMapping("updateOrderDetails/{id}")

		public Order updateOrderDetailsById(@PathVariable int id,  @RequestBody Order p1) throws OrderDeatilsNotFoundException {
			
			return service.updateOrderDetailsById(p1, id);
		}
	 
	 @DeleteMapping("/deleteOrder/{id}")
	  	public Order deleteOrder(@PathVariable int id) throws OrderDeatilsNotFoundException {
	  	{
	  		return service.deleteOrder(id);
	  	}

}
}
