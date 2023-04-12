package com.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entities.Product;
import com.exceptions.ProductNotFoundException;

@Service
public interface IProductService {
	
	

	Product getProductById(int id) throws ProductNotFoundException;

	Product addProduct(Product p1) throws ProductNotFoundException;

	Product updateProduct(Product p1)throws ProductNotFoundException;

	Product deleteProduct(int id) throws ProductNotFoundException;

	Product updateById(Product p1, int id)throws ProductNotFoundException;

	List<Product> getProducts();

	
	
	 

}
