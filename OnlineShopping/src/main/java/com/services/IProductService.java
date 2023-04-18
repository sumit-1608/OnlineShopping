package com.services;

import java.util.List;


import com.entities.Product;
import com.exceptions.ProductNotFoundException;


public interface IProductService {
	
	public List<Product> getProducts();
	public Product getProductById(Long productId);
	public Product addProduct(Product product);
	public Product updateProduct(Long productId, Product product);
	public void deleteProduct(Long productId);

	

	
	
	 

}
