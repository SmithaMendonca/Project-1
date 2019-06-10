package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Product;

public class ProductDAOTest {

	static ProductDAO productDAO;
	
	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	@Ignore
	@Test
	public void addProductTest() {
		Product product= new Product();
		product.setProductName("Pearl set");
		product.setProductDesc("Zaveri Pearl zinc set");
		product.setStock(50);
		product.setPrice(400);
		product.setCategoryId(5);
		product.setSupplierId(3);
		assertTrue("Problem in adding Product",productDAO.addProduct(product));		
	}
	@Ignore
	@Test
	public void deleteProductTest() {
		Product product=productDAO.getProduct(2);
		assertTrue("Problem in deleting Product",productDAO.deleteProduct(product));
	}
	
	@Ignore
	@Test
	public void updateProductTest() {
		Product product=productDAO.getProduct(33);
//		product.setProductName("Sarees");
//		product.setProductDesc("Indira Silk Sarees");
//		product.setPrice(480);
//		product.setStock(600);
//		product.setCategoryId(3);
		assertTrue("Problem in updating Product",productDAO.updateProduct(product));
	}
	@Ignore
	@Test
	public void listProductTest() {
		List<Product> productList=productDAO.getProductList();
		assertTrue("Problem in Listing Products", productList.size()>0);
		
		for(Product product:productList) {
			System.out.print(product.getProductId()+":::");
			System.out.print(product.getProductName()+":::");
			System.out.print(product.getProductDesc()+":::");
			System.out.print(product.getStock()+":::");
			System.out.println(product.getPrice());			
		}			
	}
	
	//@Ignore
	@Test
	public void showProductListCategoryWiseTest() {
		
		List<Product> showproductList=productDAO.getProductListCategoryWise(5);
		assertTrue("Problem in Listing Products", showproductList.size()>0);
		
		for(Product product:showproductList) {
			System.out.print(product.getProductId()+":::");
			System.out.print(product.getProductName()+":::");
			System.out.print(product.getProductDesc()+":::");
			System.out.print(product.getStock()+":::");
			System.out.println(product.getPrice());			
		}			
	}
}
