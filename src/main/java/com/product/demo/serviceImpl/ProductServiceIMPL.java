package com.product.demo.serviceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.demo.dao.ProductDao;
import com.product.demo.entity.Product;
import com.product.demo.service.ProductService;

@Service /*---metadata provide kiya, @Service/@Componenet=bean banane ka kam karte
			 hai.IOC*/
public class ProductServiceIMPL implements ProductService {

	@Autowired
	private ProductDao dao;

	@Override
	public boolean saveProduct(Product product) {
		String productId = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now());
		product.setProductId(productId);
		boolean isAdded = dao.saveProduct(product);
		return isAdded;
	}

	@Override
	public Product getProductById(String productId) {
		Product productById = dao.getProductById(productId);
		return productById;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> allProducts = dao.getAllProducts();
		return allProducts;
	}

	@Override
	public boolean updateProduct(Product product) {
		boolean updateProduct = dao.updateProduct(product);
		return updateProduct;
	}

	@Override
	public boolean deleteProduct(String productId) {
		boolean deleteProduct = dao.deleteProduct(productId);
		return deleteProduct;
	}

}
