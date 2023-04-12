package com.services;

import java.util.List;

import com.entities.Order;
import com.entities.Product;
import com.exceptions.OrderDeatilsNotFoundException;

public interface IOrderService {

	List<Order> getOrders();

	Order getOrderDetailsById(int id) throws OrderDeatilsNotFoundException;

	Order addOrderDetails(Order p1)throws OrderDeatilsNotFoundException;

	Order updateOrderDetails(Order p1)throws OrderDeatilsNotFoundException;

	

	Order updateOrderDetailsById(Order p1, int id)throws OrderDeatilsNotFoundException;

	Order deleteOrder(int id) throws OrderDeatilsNotFoundException;

}
