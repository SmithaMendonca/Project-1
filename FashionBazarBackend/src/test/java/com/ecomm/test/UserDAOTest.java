package com.ecomm.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ecomm.dao.UserDAO;
import com.ecomm.model.UserDetail;

public class UserDAOTest {

	static UserDAO userDAO;
	
	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();		
		userDAO=(UserDAO)context.getBean("userDAO");				
	}
	@Ignore
	@Test
	public void registerUserTest() {
		UserDetail user= new UserDetail();
		user.setUserName("Meena");
		user.setPassword("mena123");
		user.setCustomerName("Meena Naik");
		user.setEmail("meena@yahoo.com");
		user.setAddress("Udupi");
		user.setRole("USER");
		user.setEnabled(true);
		assertTrue("Problem in Registering User",userDAO.registerUser(user));
	}
	
	@Test
	public void updateUserTest() {
		UserDetail user=userDAO.getUserDetail(2);
		user.setCustomerName("Teena Sharma");
		user.setAddress("Mumbai");
		user.setUserName("teena");
		user.setPassword("password");
		user.setRole("ADMIN");
		assertTrue("Problem in Updating Category",userDAO.updateUser(user));
	}
}
