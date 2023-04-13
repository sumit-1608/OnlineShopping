package com.services;

import java.util.List;


import org.springframework.stereotype.Service;

import com.entities.Orders;
import com.entities.Product;
import com.exceptions.OrderAlreadyExistsException;
import com.exceptions.OrderDetailsNotFoundException;

public interface IOrderService {

	List<Orders> getOrders();

	Orders getOrderDetailsById(int id) throws OrderDetailsNotFoundException;

	Orders addOrderDetails(Orders p1)throws OrderAlreadyExistsException;

	Orders updateOrderDetails(Orders p1)throws OrderDetailsNotFoundException;

	

	Orders updateOrderDetailsById(Orders p1, int id)throws OrderDetailsNotFoundException;

	Orders deleteOrder(int id) throws OrderDetailsNotFoundException;

}
