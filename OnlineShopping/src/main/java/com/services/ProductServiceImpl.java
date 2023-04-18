package com.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Orders;
import com.entities.Product;
import com.exceptions.OrderDetailsNotFoundException;
import com.exceptions.ProductAlreadyExistsException;
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
		if(productDao.findById(productId).isEmpty()) {
			throw new ProductNotFoundException();
		}
		return productDao.save(product);
	}
	

	@Override
	public void deleteProduct(Long productId){
		if(productDao.findById(productId).isEmpty()) {
			throw new ProductNotFoundException();
		}
		
		
		Product product = productDao.findById(productId).get();
		
		productDao.delete(product);
	}
	
//	@Override
//	public Product updateById(Product p1, Long id) throws ProductNotFoundException {
//		if(repo.findById(id).isPresent())
//		{
//			Product e1=repo.findById(id).get();
//			
//			e1.setProductName(p1.getProductName());
//			e1.setPrice(p1.getPrice());
//			e1.setQuantity(p1.getQuantity());
//			
//			Product e2=repo.save(e1);
//			return e2;
//			
//		
//	}
//		else
//		{
//			throw new ProductNotFoundException("there is no Records found in our database"); 
//		}
//	
//	}
}
	
	





