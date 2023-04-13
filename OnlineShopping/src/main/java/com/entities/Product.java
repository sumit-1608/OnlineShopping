package com.entities;

import org.hibernate.annotations.Generated;

import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "product")
public class Product {

	
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	
	@GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
      name = "sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "user_sequence"),
        @Parameter(name = "initial_value", value = "1000"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	private Long productCode;

	@NotBlank(message = "Name Field is mandatory")
	private String productName;

	private int quantity;
	private double price;

	// @Pattern(regexp = "active|deactive", message="dfd")
	// private String status;
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getProductCode() {
		return productCode;
	}

	public void setProductCode(Long productCode) {
		this.productCode = productCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
	

//	public Product( String productName, int productCode, int quantity, double price, String status) {
//		super();
//	
//		this.productName = productName;
//		this.productCode = productCode;
//		this.quantity = quantity;
//		this.price = price;
//
//	}
//
//	public Product() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

}
