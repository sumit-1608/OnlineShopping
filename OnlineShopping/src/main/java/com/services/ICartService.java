package com.services;

import java.util.List;

import com.entities.Cart;

public interface ICartService{

	public List<Cart> getCart();
	public Cart getCartById(Long cartId);
	public Cart addCart(Cart cart);
	public Cart updateCart(Long cartId, Cart cart);
	public void deleteCart(Long cartId);
}
