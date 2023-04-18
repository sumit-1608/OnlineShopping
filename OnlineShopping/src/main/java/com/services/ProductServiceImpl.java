package com.services;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Orders;
import com.entities.Product;
import com.exceptions.OrderDetailsNotFoundException;
import com.exceptions.ProductNotFoundException;
import com.exceptions.UserNotFoundException;
import com.repositories.IProductRepository;


@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private IProductRepository productDao;
	
	@Override
	public List<Product> getProducts(){
		return productDao.findAll();
		
	}
	
	@Override
	public Product getProductById(Long productId){
		if(productDao.findById(productId).isEmpty()) {
			throw new ProductNotFoundException();
		}
		return productDao.findById(productId).get();
	}

	@Override
	public Product addProduct(Product product){
		return productDao.save(product);
	}

	@Override
	public Product updateProduct(Long productId, Product product){
		if(productDao.findById(productId).isPresent())
			{
				Product p = productDao.findById(productId).get();
				
				p.setProductName(product.getProductName());
				p.setPrice(product.getPrice());
				p.setQuantity(product.getQuantity());
				
				Product pro=productDao.save(p);
				return pro;
			}
			else
			{
				throw new ProductNotFoundException(); 
			}
	}
	

	@Override
	public void deleteProduct(Long productId){
		if(productDao.findById(productId).isEmpty()) {
			throw new ProductNotFoundException();
		}
		
		
		Product product = productDao.findById(productId).get();
		
		productDao.delete(product);
	}
}
	
	





