package com.ecomm.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import java.util.List;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryDAOTest {
	
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");				
	}
	
	@Ignore
	@Test
	public void addCategoryTest() {
		Category category= new Category();
		category.setCategoryName("Raymond");
		category.setCategoryDesc("Best formal shirt for office");
		assertTrue("Problem in Adding Category",categoryDAO.addCategory(category));
	}
	@Ignore
	@Test
	public void deleteCategoryTest() {
		Category category=categoryDAO.getCategory(2);
		assertTrue("Problem in deleting category",categoryDAO.deleteCategory(category));
	}

	
	@Test
	public void updateCategoryTest() {
		Category category=categoryDAO.getCategory(5);
		category.setCategoryName("Accessories");
		category.setCategoryDesc("Jewellery");
		assertTrue("Problem in Updating Category",categoryDAO.updateCategory(category));
	}
	
	@Ignore
	@Test
	public void listCategoryTest() {
		List<Category> categoryList=categoryDAO.listCategeories();
		assertTrue("Problem in Listing Categories",categoryList.size()>0);
		
		for(Category category:categoryList) {
			System.out.print(category.getCategoryId()+":::");
			System.out.print(category.getCategoryName()+":::");
			System.out.println(category.getCategoryDesc());			
		}
		
		
	}

}
