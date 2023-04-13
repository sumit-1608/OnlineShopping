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

import com.entities.Product;
import com.exceptions.ProductAlreadyExistsException;
import com.exceptions.ProductNotFoundException;
import com.repositories.IProductRepository;
import com.services.IProductService;

@RestController
public class ProductController {

	
    @Autowired
    private IProductRepository repo;
    
    @Autowired
    private IProductService service;
    
    
    @GetMapping("/getProducts")
    public List<Product> getProducts() {

        return service.getProducts();
    }
    
    @GetMapping("/getProduct/{id}")
  	public Product getUser(@PathVariable Long id) throws ProductNotFoundException{
  		return service.getProductById(id);
  	}
    
    @PostMapping("/addProduct")
    public Product addProduct( @RequestBody Product p1) throws ProductAlreadyExistsException{
    {
    	return service.addProduct(p1);
    }
}
    
    @PutMapping("/updateProduct")
   	public Product updateProduct( @RequestBody Product p1) throws ProductNotFoundException{
   	{
   		return service.updateProduct(p1);
   	}
   	
   	
}
    @PutMapping("updateProduct/{id}")

	public Product updateById(@PathVariable Long id,  @RequestBody Product p1) 
			throws ProductNotFoundException {
		return service.updateById(p1, id);
	}
    
    @DeleteMapping("/deleteProduct/{id}")
  	public Product deleteProduct(@PathVariable Long id) throws ProductNotFoundException
  	{
  		return service.deleteProduct(id);
  	}
    
    
      
    
}
