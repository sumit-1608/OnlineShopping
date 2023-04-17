package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Cart;
import com.exceptions.CartAlreadyExistsException;
import com.exceptions.CartNotFoundException;
import com.repositories.ICartRepository;

@Service
public class CartServiceImpl implements ICartService{

	@Autowired
	private ICartRepository cartDao;
	
	@Override
	public List<Cart> getCart() {
		return cartDao.findAll();
	}

	@Override
	public Cart getCartById(Long cartId) {
		if(cartDao.findById(cartId).isEmpty()) {
			throw new CartNotFoundException();
		}
		return cartDao.findById(cartId).get();
	}

	@Override
	public Cart addCart(Cart cart) {
		if(cartDao.existsById(cart.getCartId())) {
			throw new CartAlreadyExistsException();
		}
		return cartDao.save(cart);
	}

	@Override
	public Cart updateCart(Long cartId, Cart cart) {
		if(cartDao.findById(cartId).isEmpty()) {
			throw new CartAlreadyExistsException();
		}
		return cartDao.save(cart);
	}

	@Override
	public void deleteCart(Long cartId) {
		if(cartDao.findById(cartId).isEmpty()) {
			throw new CartNotFoundException();
		}
		
		
		Cart cart = cartDao.findById(cartId).get();
		
		cartDao.delete(cart);
		
	}

}
