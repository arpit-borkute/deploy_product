package com.product.demo.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.product.demo.dao.SupplierDao;
import com.product.demo.entity.Supplier;

import jakarta.persistence.PersistenceException;

@Repository
public class SupplierDaoIMPL implements SupplierDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public boolean saveSupplier(Supplier supplier) {
		boolean isAdded = false;
		Session session = null;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(supplier);
			transaction.commit();
			isAdded = true;
		} catch (PersistenceException e) {
			e.printStackTrace();
			isAdded = false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isAdded;
	}
}
