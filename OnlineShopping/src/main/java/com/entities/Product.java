package com.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "ProductMaster")
public class Product {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	
	private int productCode;

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

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
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
	

	public Product( String productName, int productCode, int quantity, double price, String status) {
		super();
	
		this.productName = productName;
		this.productCode = productCode;
		this.quantity = quantity;
		this.price = price;

	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

}
