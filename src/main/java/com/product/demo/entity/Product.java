package com.product.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
@Entity
public class Product {

	@Id
	@Column(unique = true, nullable = false)
	private String productId;

	@NotEmpty(message = "product name is required")
	@Column(unique = true, nullable = false)
	private String productName;

	@OneToOne
	private Supplier supplier;

	@OneToOne
	private Category category;

	@Column(nullable = false)
	@Min(1)
	private int productQty;

	@Min(1)
	@Column(nullable = false)
	private double productPrice;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String productId, String productName, Supplier supplier, Category category, int productQty,
			double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.supplier = supplier;
		this.category = category;
		this.productQty = productQty;
		this.productPrice = productPrice;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getProductQty() {
		return productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

}
