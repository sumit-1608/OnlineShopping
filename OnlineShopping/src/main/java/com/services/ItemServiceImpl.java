package com.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.*;
import com.exceptions.ItemAlreadyExistsException;
import com.exceptions.ItemNotFoundException;
import com.exceptions.OrderDetailsNotFoundException;
import com.repositories.IItemsRepository;
import com.repositories.IOrderRepository;

@Service
public class ItemServiceImpl implements IItemsService{
	
	@Autowired
	private IItemsRepository itemDao;
	
	@Override
	public List<Items> getItems() {
		return itemDao.findAll();
		
		
//		Orders order = orderDao.findById(orderId)
//		        .orElseThrow(() -> new OrderDetailsNotFoundException());
//
//		    List<Items> items = new ArrayList<Items>();
//		    items.addAll(order.getItems());
//		    return items;
	}

	@Override
	public Items getItemsById(Long itemId) {
		if(itemDao.findById(itemId).isEmpty()) {
			throw new ItemNotFoundException();
		}
		return itemDao.findById(itemId).get();
	}

	@Override
	public Items addItems(Items item) {
		
		
		if(itemDao.existsById(item.getItemId())) {
			throw new ItemAlreadyExistsException();
		}
		return itemDao.save(item);
		
//		Items items = orderDao.findById(orderId).map(orders -> {
//		      orders.getItems().add(item);
//		      return itemDao.save(item);
//		    }).orElseThrow(() -> new OrderDetailsNotFoundException());
//		
//		return items;
	}

	@Override
	public Items updateItems(Long itemId, Items item) {
		if(itemDao.findById(itemId).isEmpty()) {
			throw new ItemAlreadyExistsException();
		}
		return itemDao.save(item);
	}

	@Override
	public void deleteItems(Long itemId) {
		if(itemDao.findById(itemId).isEmpty()) {
			throw new ItemNotFoundException();
		}
		
		
		Items item = itemDao.findById(itemId).get();
		
		itemDao.delete(item);
		
	}

}
