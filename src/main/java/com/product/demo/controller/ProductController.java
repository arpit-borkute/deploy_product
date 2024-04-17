package com.product.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.demo.entity.Product;
import com.product.demo.exception.ProductNotFound;
import com.product.demo.exception.ResourceAlreadyExistsException;
import com.product.demo.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService service;

	@PostMapping("/save-product")
	public ResponseEntity<Boolean> saveProduct(@Valid @RequestBody Product product) {
		boolean isAdded = service.saveProduct(product);
		if (isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		} else {
			// return new ResponseEntity<Boolean>(isAdded, HttpStatus.NO_CONTENT);
			throw new ResourceAlreadyExistsException("Resource Already Exists");

		}
	}

	@PutMapping("/update-product")
	public ResponseEntity<Boolean> updateProduct(@RequestBody Product product) {
		boolean isUpdated = service.updateProduct(product);
		if (isUpdated) {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(isUpdated, HttpStatus.NO_CONTENT);
	}

	@GetMapping("/get-product-by-id/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable String productId) {
		Product product = service.getProductById(productId);
		if (product != null) {
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}
		// return new ResponseEntity<Product>(product, HttpStatus.NO_CONTENT);
		throw new ProductNotFound("Product not found for this id");

	}

	@GetMapping("get-all-products")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = service.getAllProducts();
		if (products.isEmpty()) {
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.NO_CONTENT);

	}

	@DeleteMapping("/delete-product/{productId}")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable String productId) {
		boolean isDeleted = service.deleteProduct(productId);
		if (isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(isDeleted, HttpStatus.NO_CONTENT);

	}
}
