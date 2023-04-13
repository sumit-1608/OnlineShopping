package com.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Orders;
import com.exceptions.OrderAlreadyExistsException;
import com.exceptions.OrderDetailsNotFoundException;

import com.repositories.IOrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderRepository repo;

	@Override
	public List<Orders> getOrders() {
		// TODO Auto-generated method stub
		return repo.findAll();

	}

	@Override
	public Orders getOrderDetailsById(int id) throws OrderDetailsNotFoundException {
		Optional<Orders> result = repo.findById(id);

		if (result.isPresent()) {
			repo.findById(id);
			return result.get();
		}

		else {
			throw new OrderDetailsNotFoundException("there is no Records found in our database");

		}
	}

	@Override
	public Orders addOrderDetails(Orders p1) throws OrderAlreadyExistsException {
		return repo.saveAndFlush(p1);
	}

	@Override
	public Orders updateOrderDetails(Orders p1) throws OrderDetailsNotFoundException {
		Optional<Orders> result = repo.findById(p1.getOrderId());
		if (result.isPresent()) {
			return repo.saveAndFlush(p1);
		} else {
			throw new OrderDetailsNotFoundException("please enter valid  id");
		}
	}

	@Override
	public Orders updateOrderDetailsById(Orders p1, int id) throws OrderDetailsNotFoundException {
		if (repo.findById(id).isPresent()) {
			Orders e1 = repo.findById(id).get();

			e1.setAddress(p1.getAddress());
			e1.setOrderDate(p1.getOrderDate());
		//	e1.setProduct(p1.getProduct());

			Orders e2 = repo.save(e1);
			return e2;

		} else {
			throw new OrderDetailsNotFoundException("there is no Records found in our database");
		}

	}

	@Override
	public Orders deleteOrder(int id) throws OrderDetailsNotFoundException {
		Optional<Orders> result=repo.findById(id);
		if(result.isPresent())
		{
			repo.deleteById(id);
			return result.get();
		}
		else
		{
			throw new OrderDetailsNotFoundException("there is no record found in our database");
		}
	}

}
