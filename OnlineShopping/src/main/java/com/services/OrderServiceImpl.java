package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Order;
import com.repositories.IOrderRepository;
@Service
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private IOrderRepository repo;

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return repo.findAll();

	}

}
