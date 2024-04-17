package com.product.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.demo.entity.Supplier;
import com.product.demo.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	@PostMapping("/save-supplier")
	public ResponseEntity<Boolean> saveSupplier(@RequestBody Supplier supplier) {

		boolean isAdded = supplierService.saveSupplier(supplier);
		if (isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		}
		return new ResponseEntity<Boolean>(isAdded, HttpStatus.NO_CONTENT);

	}
}
