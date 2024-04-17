package com.product.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.demo.dao.SupplierDao;
import com.product.demo.entity.Supplier;
import com.product.demo.service.SupplierService;

@Service
public class SupplierServiceIMPL implements SupplierService {

	@Autowired
	private SupplierDao supplierDao;

	@Override
	public boolean saveSupplier(Supplier supplier) {
		boolean isAdded = supplierDao.saveSupplier(supplier);
		return isAdded;

	}

}
