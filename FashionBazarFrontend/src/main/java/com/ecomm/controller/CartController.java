package com.ecomm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CartDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Cart;
import com.ecomm.model.Product;

@Controller
public class CartController {
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/addToCart/{productId}")
	public String addToCart(@PathVariable("productId")int productId,@RequestParam("quantity")int quantity,Model m,HttpSession session)
	{
		Product product=productDAO.getProduct(productId);
		
		String username=(String)session.getAttribute("username");
		
		Cart cart= new Cart();
		cart.setProductId(product.getProductId());
		cart.setProductName(product.getProductName());
		cart.setQuantity(quantity);
		cart.setPrice(product.getPrice());
		cart.setUsername(username);
		cart.setStatus("NP");
		
		cartDAO.addToCart(cart);
		
		List<Cart> listCartItems=cartDAO.listCartItems(username);
		m.addAttribute("cartItems",listCartItems );
		m.addAttribute("grandTotal",this.calcGrandTotal(listCartItems));
		return "Cart";
		
	}
	
	@RequestMapping("/showCart")
	public String showCart(Model m,HttpSession session)
	{   
		String username=(String)session.getAttribute("username");
		
		List<Cart> listCartItems=cartDAO.listCartItems(username);
		m.addAttribute("cartItems",listCartItems );
		m.addAttribute("grandTotal",this.calcGrandTotal(listCartItems));
		
		return "Cart";
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
	
	@RequestMapping("/deleteCartItem/{cartItemId}")
	public String deleteCartItem(@PathVariable("cartItemId")int cartItemId,Model m,HttpSession session)
	{
		Cart cart=cartDAO.getCartItem(cartItemId);
		cartDAO.deleteItemFromCart(cart);
		
		String username=(String)session.getAttribute("username");
		
		List<Cart> listCartItems=cartDAO.listCartItems(username);
		m.addAttribute("cartItems",listCartItems );
		m.addAttribute("grandTotal",this.calcGrandTotal(listCartItems));
		
		return "Cart";
	}
	
	@RequestMapping("/updateCartItem/{cartItemId}")
	public String updateCartItem(@PathVariable("cartItemId")int cartItemId,@RequestParam("quantity")int quantity,Model m,HttpSession session)
	{
		Cart cart=cartDAO.getCartItem(cartItemId);
		cart.setQuantity(quantity);
		
		cartDAO.updateCartItem(cart);
		
		String username=(String)session.getAttribute("username");
		
		List<Cart> listCartItems=cartDAO.listCartItems(username);
		m.addAttribute("cartItems",listCartItems );
		m.addAttribute("grandTotal",this.calcGrandTotal(listCartItems));
		
		return "Cart";
	}
}   
