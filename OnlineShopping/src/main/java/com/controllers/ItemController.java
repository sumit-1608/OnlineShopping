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

import com.entities.Items;
import com.exceptions.ItemNotFoundException;
import com.services.IItemsService;

@RestController

public class ItemController {
	
	@Autowired
	private IItemsService itemService;
	
	@GetMapping("/items")
	public List<Items> getItems(){
		return this.itemService.getItems();
	}
	
	@GetMapping("/item/{itemId}")
	public Items getItemById(@PathVariable Long itemId) throws ItemNotFoundException{
		return this.itemService.getItemsById(itemId);
	}
	
	@PostMapping("/item")
	public Items addItem(@RequestBody Items item){
		return this.itemService.addItems(item);
	}
	
	@PutMapping("/item/{itemId}")
	public Items updateItem(@PathVariable Long itemId, @RequestBody Items item) throws ItemNotFoundException{
		return this.itemService.updateItems(itemId, item);
	}
	
	@DeleteMapping("/item/{itemId}")
	public void deleteCart(@PathVariable Long itemId) throws ItemNotFoundException{
		this.itemService.deleteItems(itemId);
	}

}
