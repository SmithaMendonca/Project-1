package com.ecomm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CartDAO;
import com.ecomm.dao.OrderDAO;
import com.ecomm.dao.UserDAO;
import com.ecomm.model.Cart;
import com.ecomm.model.OrderDetail;
import com.ecomm.model.UserDetail;

@Controller
public class PaymentController 
{
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	OrderDAO orderDAO;
	
	@RequestMapping("/checkout")
	public String showOrderConfirmPage(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<Cart> listCartItems=cartDAO.listCartItems(username);
		m.addAttribute("cartItems",listCartItems );
		m.addAttribute("grandTotal",this.calcGrandTotal(listCartItems));
		
		UserDetail user= userDAO.getUserDetail(username);
		m.addAttribute("addr",user.getAddress());
		return "OrderConfirm";
	}
	
	@RequestMapping("/payment")
	public String showPaymentPage(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<Cart> listCartItems=cartDAO.listCartItems(username);
		m.addAttribute("cartItems",listCartItems );
		m.addAttribute("grandTotal",this.calcGrandTotal(listCartItems));
		
		UserDetail user= userDAO.getUserDetail(username);
		m.addAttribute("addr",user.getAddress());
		return "Payment";
	}
	
	@RequestMapping(value="/updateAddr",method=RequestMethod.POST)
	public String updateAddress(@RequestParam("addr")String addr,Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<Cart> listCartItems=cartDAO.listCartItems(username);
		m.addAttribute("cartItems",listCartItems );
		m.addAttribute("grandTotal",this.calcGrandTotal(listCartItems));
		
		UserDetail user= userDAO.getUserDetail(username);
		user.setAddress(addr);
		userDAO.updateUser(user);
		
		m.addAttribute("addr",user.getAddress());
		return "OrderConfirm";
	}
	
	@RequestMapping(value="/pay",method={RequestMethod.POST})
	public String generateReceipt(@RequestParam("pmode")String pmode,Model m,HttpSession session)
	{
		//System.out.println("-----Invoice Page-----");
		
		String username=(String)session.getAttribute("username");
		
		List<Cart> listCartItems=cartDAO.listCartItems(username);
		m.addAttribute("cartItems",listCartItems );
		int grandTotal=this.calcGrandTotal(listCartItems);
		m.addAttribute("grandTotal",grandTotal);
		
		OrderDetail order=new OrderDetail();
		order.setUsername(username);
		order.setOrderDate(new java.util.Date());
		order.setPmode(pmode);
		order.setShoppingAmount(grandTotal);
		
		orderDAO.paymentProcess(order);
		
		if(orderDAO.updateCartItemStatus(username,order.getOrderId()))
		{	

			m.addAttribute("orderInfo",order);
			m.addAttribute("address",userDAO.getUserDetail(username).getAddress());
			return "Receipt";
		}
		else
		{
			System.out.println("Not completed");
			return "Cart";
		}
	}
	
	@RequestMapping("/thanks")
	public String showThankYouPage()
	{
		return "ThankCustomer";
	}
	
	public int calcGrandTotal(List<Cart> listCartItems)
	{
		int count=0,grandTotal=0;
		
		while(count<listCartItems.size())
		{
			grandTotal=grandTotal+(listCartItems.get(count).getQuantity()*listCartItems.get(count).getPrice());
			count++;
		}		
		return grandTotal;
	}
}
