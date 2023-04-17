package com.services;

import java.util.List;


import com.entities.Items;

public interface IItemsService{

	public List<Items> getItems(Long orderId);
	public Items getItemsById(Long itemId);
	public Items addItems(Items items);
	public Items updateItems(Long itemId, Items item);
	public void deleteItems(Long itemId);
}
