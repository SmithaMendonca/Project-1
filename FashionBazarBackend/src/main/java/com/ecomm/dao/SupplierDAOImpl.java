package com.ecomm.dao;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.dao.SupplierDAO;
import com.ecomm.model.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
			return true;			
		}
		catch(Exception e) {
			System.out.println("Error:"+e);
			return false;			
		}				
	}

	@Override
	public boolean deleteSupplier(Supplier supplier) {
		
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;			
		}
		catch(Exception e) {
			System.out.println("Error:"+e);
			return false;			
		}
	}

	@Override
	public boolean updateSupplier(Supplier supplier) {
		
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;			
		}
		catch(Exception e) {
			System.out.println("Error:"+e);
			return false;			
		}
	}

	@Override
	public Supplier getSupplier(int supplierId) {
		
		Session session=sessionFactory.openSession();
		Supplier supplier=session.get(Supplier.class,supplierId);
		session.close();
		return supplier;
	}

	@Override
	public List<Supplier> listSuppliers() {
		Session session=sessionFactory.openSession();
		Query<Supplier> query=session.createQuery("from Supplier");
		List<Supplier> supplierList=query.list();
		session.close();
		return supplierList;		
	}
}
