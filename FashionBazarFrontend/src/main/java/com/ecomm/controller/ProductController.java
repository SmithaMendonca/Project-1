package com.ecomm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.SupplierDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.Supplier;

@Controller
public class ProductController {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	SupplierDAO supplierDAO;
	
//	MultipartFile fileImage=null;
	
	@RequestMapping("/product")
	public String showProduct(Model m)
	{
		Product product=new Product();
		m.addAttribute("product",product);
		
		List<Product> productList=productDAO.getProductList();
		m.addAttribute("productList",productList);
		
		List<Category> categoryList=categoryDAO.listCategeories();
		m.addAttribute("categoryList",this.getCategoryList(categoryList));
		
		List<Supplier> supplierList=supplierDAO.listSuppliers();
		m.addAttribute("supplierList",this.getSupplierList(supplierList));
		
		return "Product";
	}
	
	public LinkedHashMap<Integer,String> getCategoryList(List<Category> categoryList)
	{
		LinkedHashMap<Integer,String> listCategory=new LinkedHashMap<Integer,String>();
		int i=0;
		while(i<categoryList.size()) {
			Category category=(Category)categoryList.get(i);
			listCategory.put(category.getCategoryId(),category.getCategoryName());
			i++;
		}
		return listCategory;
	}
	
	public LinkedHashMap<Integer,String> getSupplierList(List<Supplier> supplierList)
	{
		LinkedHashMap<Integer,String> listSupplier=new LinkedHashMap<Integer,String>();
		int i=0;
		while(i<supplierList.size()) {
			Supplier supplier=(Supplier)supplierList.get(i);
			listSupplier.put(supplier.getSupplierId(),supplier.getSupplierName());
			i++;
		}
		return listSupplier;
	}
	
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product")Product product,@RequestParam("pimage")MultipartFile fileImage,Model m) 
	{
		productDAO.addProduct(product);
		
		//Adding Image
		String path="C:\\Users\\SMITHA\\eclipse-workspace\\FashionBazarFrontend\\src\\main\\webapp\\resources\\images\\";
		path=path+String.valueOf(product.getProductId())+".jpg";
		File imageFile=new File(path);			
		if(!fileImage.isEmpty()) 
		 {			
			try {
				byte[] buffer=fileImage.getBytes();
				FileOutputStream fos=new FileOutputStream(imageFile);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(buffer);
				bs.close();
			    }		
			catch(Exception e) {
				
				System.out.println("Exception Arised:"+ e);				
			}			
		}
		else 
		{
			System.out.println("Error Occured:");
		}
				
		List<Product> productList=productDAO.getProductList();
		m.addAttribute("productList",productList);
		
		Product product1=new Product();
		m.addAttribute("product",product1);
						
		List<Category> categoryList=categoryDAO.listCategeories();
		m.addAttribute("categoryList",this.getCategoryList(categoryList));
		
		List<Supplier> supplierList=supplierDAO.listSuppliers();
		m.addAttribute("supplierList",this.getSupplierList(supplierList));
	
		return "Product";
	}
	
	@RequestMapping(value="/editProduct/{productId}")
	public String editProduct(@PathVariable("productId")int productId,Model m) 
	{	
		//System.out.println("------Edit------");
		Product product=productDAO.getProduct(productId);
		m.addAttribute("product",product);
		
		List<Product> productList=productDAO.getProductList();
		m.addAttribute("productList",productList);
		
		List<Category> categoryList=categoryDAO.listCategeories();
		m.addAttribute("categoryList",this.getCategoryList(categoryList));
		
		List<Supplier> supplierList=supplierDAO.listSuppliers();
		m.addAttribute("supplierList",this.getSupplierList(supplierList));
		
		//System.out.println(">>>>>>>>> continue edit>>>>");
		return "UpdateProduct";
	}
	
	@RequestMapping(value="/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId")int productId,Model m) 
	{
		Product product=productDAO.getProduct(productId);
		productDAO.deleteProduct(product);
		
		List<Product> productList=productDAO.getProductList();
		m.addAttribute("productList",productList);
		
		Product product1=new Product();
		m.addAttribute("product",product1);
		
		List<Category> categoryList=categoryDAO.listCategeories();
		m.addAttribute("categoryList",this.getCategoryList(categoryList));

		return "Product";		
	}
	
	@RequestMapping(value="/UpdateProduct",method= {RequestMethod.POST})
	public String updateProduct(@ModelAttribute("product")Product product,@RequestParam("pimage")MultipartFile fileImage,Model m) 
	{	
		//System.out.println(">>>>Welcome to Update>>>>>");
		
		productDAO.updateProduct(product);
		
		//Adding Image
		String path="C:\\Users\\SMITHA\\eclipse-workspace\\FashionBazarFrontend\\src\\main\\webapp\\resources\\images\\";
		path=path+String.valueOf(product.getProductId())+".jpg";
		File imageFile=new File(path);			
		if(!fileImage.isEmpty()) 
		 {			
			try {
				byte[] buffer=fileImage.getBytes();
				FileOutputStream fos=new FileOutputStream(imageFile);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(buffer);
				bs.close();
			    }		
			catch(Exception e) {
				
				System.out.println("Exception Arised:"+ e);				
			}			
		}
		else 
		{
			System.out.println("Error Occured:");
		}
				
		List<Product> productList=productDAO.getProductList();
		m.addAttribute("productList",productList);
		
		Product product1=new Product();
		m.addAttribute("product",product1);	
		
		List<Category> categoryList=categoryDAO.listCategeories();
		m.addAttribute("categoryList",this.getCategoryList(categoryList));
		
		List<Supplier> supplierList=supplierDAO.listSuppliers();
		m.addAttribute("supplierList",this.getSupplierList(supplierList));
		
		return "Product";	
	}
	
	@RequestMapping(value="/productPage")
	public String displayProductPage(Model m) {
		
		List<Product> productList=productDAO.getProductList();
	    m.addAttribute("productList",productList);
	   // System.out.println("------Product Page-------");
		return "ProductPage";		
	}
	
	@RequestMapping(value="/totalProductDisplay/{productId}")
	public String totalProductDisplay(@PathVariable("productId")int productId,Model m) 
	{
		Product product=productDAO.getProduct(productId);
		m.addAttribute("product",product);
	//	System.out.println(">>>>>>>>>Product Display Page>>>>");
		return "TotalProductDisplay";
	}
}
