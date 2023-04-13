package com.services;

import java.util.List;

import com.entities.Product;
import com.exceptions.ProductAlreadyExistsException;
import com.exceptions.ProductNotFoundException;


public interface IProductService {
	
	

	Product getProductById(Long id) throws ProductNotFoundException;

	Product addProduct(Product p1) throws ProductAlreadyExistsException;

	Product updateProduct(Product p1)throws ProductNotFoundException;

	Product deleteProduct(Long id) throws ProductNotFoundException;

	Product updateById(Product p1, Long id)throws ProductNotFoundException;

	List<Product> getProducts();

	
	
	 

}
