package com.product.demo.dao;

import java.util.List;

import com.product.demo.entity.Product;

public interface ProductDao {

	public boolean saveProduct(Product product);

	public Product getProductById(String productId);

	public List<Product> getAllProducts();

	public boolean updateProduct(Product product);

	public boolean deleteProduct(String productId);
}
