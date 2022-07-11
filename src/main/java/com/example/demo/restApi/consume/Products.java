package com.example.demo.restApi.consume;


import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	@Column(name="name" )
	private String name;
	
	@Column(name="unit_Price" )
	private int unitPrice;
	
	@Column(name="descriptions" )
	private String description;
	
	@Column(name="manufacturer" )
	private String manufacturer;
	
	@Column(name="category" )
	private String category;
	
	@Column(name="units_In_Stock" )
	private int unitsInStock;
	
	@Column(name="unitsInOrder" )
	private int unitsInOrder;
	
	@Column(name="discontinued")
	private boolean discontinued;
	
	@Column(name="conditiona" )
	private String condition;
	
	@Lob
	@Column(name="image" )
	 private byte[] image;
	
	public Products(){
      super();
	}

	//setters and getters for all the fields here
	
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int l) {
		this.unitsInStock = l;
	}

	public int getUnitsInOrder() {
		return unitsInOrder;
	}

	public void setUnitsInOrder(int unitsInOrder) {
		this.unitsInOrder = unitsInOrder;
	}

	public boolean isDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", name=" + name + ", unitPrice=" + unitPrice + ", description="
				+ description + ", manufacturer=" + manufacturer + ", category=" + category + ", unitsInStock="
				+ unitsInStock + ", unitsInOrder=" + unitsInOrder + ", discontinued=" + discontinued + ", condition="
				+ condition + ", image=" + Arrays.toString(image) + "]";
	}

	public Products(int productId, String name, int unitPrice, String description, String manufacturer, String category,
			int unitsInStock, int unitsInOrder, boolean discontinued, String condition, byte[] image) {
		super();
		this.productId = productId;
		this.name = name;
		this.unitPrice = unitPrice;
		this.description = description;
		this.manufacturer = manufacturer;
		this.category = category;
		this.unitsInStock = unitsInStock;
		this.unitsInOrder = unitsInOrder;
		this.discontinued = discontinued;
		this.condition = condition;
		this.image = image;
	}

	

	





}
