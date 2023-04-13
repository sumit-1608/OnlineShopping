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

import com.entities.Cart;
import com.exceptions.CartAlreadyExistsException;
import com.exceptions.CartNotFoundException;
import com.exceptions.UserNotFoundException;
import com.services.CartServiceImpl;
import com.services.ICartService;

@RestController

public class CartController {
	
	@Autowired
	private ICartService cartService;
	
	@GetMapping("/carts")
	public List<Cart> getCart(){
		return this.cartService.getCart();
	}
	
	@GetMapping("/cart/{cartId}")
	public Cart getCartById(@PathVariable Long cartId) throws CartNotFoundException{
		return this.cartService.getCartById(cartId);
	}
	
	@PostMapping("/cart")
	public Cart addCart(@RequestBody Cart cart) throws CartAlreadyExistsException{
		return this.cartService.addCart(cart);
	}
	
	@PutMapping("/cart/{cartId}")
	public Cart updateCart(@PathVariable Long cartId, @RequestBody Cart cart) throws CartNotFoundException{
		return this.cartService.updateCart(cartId, cart);
	}
	
	@DeleteMapping("/cart/{cartId}")
	public void deleteCart(@PathVariable Long cartId) throws CartNotFoundException{
		this.cartService.deleteCart(cartId);
	}

}
