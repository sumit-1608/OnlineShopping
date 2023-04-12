package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Order;

import com.exceptions.OrderDeatilsNotFoundException;

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

	@Override
	public Order getOrderDetailsById(int id) throws OrderDeatilsNotFoundException {
		Optional<Order> result = repo.findById(id);

		if (result.isPresent()) {
			repo.findById(id);
			return result.get();
		}

		else {
			throw new OrderDeatilsNotFoundException("there is no Records found in our database");

		}
	}

	@Override
	public Order addOrderDetails(Order p1) throws OrderDeatilsNotFoundException {
		return repo.saveAndFlush(p1);
	}

	@Override
	public Order updateOrderDetails(Order p1) throws OrderDeatilsNotFoundException {
		Optional<Order> result = repo.findById(p1.getOrderId());
		if (result.isPresent()) {
			return repo.saveAndFlush(p1);
		} else {
			throw new OrderDeatilsNotFoundException("please enter valid  id");
		}
	}

	@Override
	public Order updateOrderDetailsById(Order p1, int id) throws OrderDeatilsNotFoundException {
		if (repo.findById(id).isPresent()) {
			Order e1 = repo.findById(id).get();

			e1.setAddress(p1.getAddress());
			e1.setOrderDate(p1.getOrderDate());
		//	e1.setProduct(p1.getProduct());

			Order e2 = repo.save(e1);
			return e2;

		} else {
			throw new OrderDeatilsNotFoundException("there is no Records found in our database");
		}

	}

	@Override
	public Order deleteOrder(int id) throws OrderDeatilsNotFoundException {
		Optional<Order> result=repo.findById(id);
		if(result.isPresent())
		{
			repo.deleteById(id);
			return result.get();
		}
		else
		{
			throw new OrderDeatilsNotFoundException("there is no record found in our database");
		}
	}

}
