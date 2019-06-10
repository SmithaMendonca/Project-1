package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.SupplierDAO;
import com.ecomm.model.Supplier;

public class SupplierDAOTest {

	static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");		
	}
	@Ignore
	@Test
	public void addSupplierTest() {
		Supplier supplier=new Supplier();
		supplier.setSupplierName("Joe Jonas");
		supplier.setSupplierAddr("Australia");
		
		assertTrue("Problem in adding supplier",supplierDAO.addSupplier(supplier));		
	}
	@Ignore
	@Test
	public void deleteSupplierTest() {
		Supplier supplier= supplierDAO.getSupplier(3);
		assertTrue("Problem in deleting supplier",supplierDAO.deleteSupplier(supplier));		
	}
	@Ignore
	@Test
	public void updateSupplierTest() {
		Supplier supplier= supplierDAO.getSupplier(4);
		supplier.setSupplierAddr("England");;
		assertTrue("Problem in deleting supplier",supplierDAO.updateSupplier(supplier));			
	}
	@Test
	public void listSupplierTest() {
		List<Supplier> supplierList=supplierDAO.listSuppliers();
		assertTrue("Problem in Listing Suppliers", supplierList.size()>0);
		
		for(Supplier supplier:supplierList) {
			System.out.print(supplier.getSupplierId()+":::");
			System.out.print(supplier.getSupplierName()+":::");
			System.out.println(supplier.getSupplierAddr());
		}	
	}
}
