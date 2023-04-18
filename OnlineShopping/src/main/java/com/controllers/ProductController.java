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

import com.entities.*;
import com.exceptions.ProductNotFoundException;
import com.services.IProductService;

@RestController
public class ProductController {
    
    @Autowired
    private IProductService productService;
    
    
    @GetMapping("/products")
    public List<Product> getProducts() {

        return this.productService.getProducts();
    }
    
    @GetMapping("/product/{productId}")
  	public Product getUser(@PathVariable Long productId) throws ProductNotFoundException{
  		return this.productService.getProductById(productId);
  	}
    
    @PostMapping("/product")
    public Product addProduct( @RequestBody Product product){
    {
    	return this.productService.addProduct(product);
    }
}
    
    @PutMapping("/product/{productId}")
   	public Product updateProduct( @PathVariable Long productId, @RequestBody Product product) throws ProductNotFoundException{
   	{
   		return this.productService.updateProduct(productId, product);
   	}
   	
   	
}
//    @PutMapping("updateProduct/{id}")
//
//	public Product updateById(@PathVariable Long id,  @RequestBody Product p1) 
//			throws ProductNotFoundException {
//		return service.updateById(p1, id);
//	}
    
    @DeleteMapping("/deleteProduct/{productId}")
  	public void deleteProduct(@PathVariable Long productId) throws ProductNotFoundException
  	{
  		productService.deleteProduct(productId);
  	}
    
    
      
    
}
