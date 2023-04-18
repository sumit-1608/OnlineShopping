package com.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Orders;
import com.entities.Users;
import com.exceptions.ItemNotFoundException;
import com.exceptions.OrderAlreadyExistsException;
import com.exceptions.OrderDetailsNotFoundException;
import com.exceptions.UserAlreadyExistsException;
import com.exceptions.UserNotFoundException;
import com.repositories.IOrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderRepository orderDao;

	@Override
	public List<Orders> getOrders() {
		return orderDao.findAll();

	}

	@Override
	public Orders getOrderDetailsById(Long orderId){
		if(orderDao.findById(orderId).isEmpty()) {
			throw new OrderDetailsNotFoundException();
		}
		return orderDao.findById(orderId).get();
	
	}

	@Override
	public Orders addOrderDetails(Orders orders){
		return orderDao.save(orders);
	}

	@Override
	public Orders updateOrderDetails(Long orderId, Orders orders){
		if(orderDao.findById(orderId).isEmpty()) {
			throw new OrderDetailsNotFoundException();
		}
		return orderDao.save(orders);
	}

	@Override
	public void deleteOrder(Long orderId){
		
		if(orderDao.findById(orderId).isEmpty()) {
			throw new OrderDetailsNotFoundException();
		}
		
		
		Orders order = orderDao.findById(orderId).get();
		
		orderDao.delete(order);
	}

}
