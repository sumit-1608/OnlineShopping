package com.services;

import java.util.List;



import org.springframework.stereotype.Service;

import com.entities.Orders;
import com.entities.Product;
import com.exceptions.OrderDetailsNotFoundException;

public interface IOrderService {

	public List<Orders> getOrders();
	public Orders getOrderDetailsById(Long orderId);
	public Orders addOrderDetails(Orders orders);
//	public Orders updateOrderDetails(Long orderId, Orders orders);
	public void deleteOrder(Long orderId);

}
