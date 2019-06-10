package com.ecomm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping(value="/login")
	public String showLoginPage()
	{
		System.out.println("---Login---");
		return "Login";
	}
	
	@RequestMapping(value="/register")
	public String showRegisterPage()
	{
		System.out.println("---Register---");
		return "Register";
	}

	@RequestMapping("/aboutus")	
	public String sayAbout() 
	{			
	return "AboutUs";
	}

	@RequestMapping("/contactus")	
	public String contact() 
	{			
	return "ContactUs";
	}

	

}
