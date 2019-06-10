<%@include file="Header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h3 align="center">Edit Product</h3>
<div class="container">
<c:url var="addAction" value="/UpdateProduct"/>
 <form:form action="${addAction}" modelAttribute="product" method="post" enctype="multipart/form-data">
  <table align="center" class="table table-bordered">
    <tr>
		<td colspan="2" align="center"><Strong> Product Management</Strong></td>
	</tr>
		<tr>
  			<th></th>
  			<td><form:hidden path="productId"/></td>  		
  		</tr>
  		<tr>
  			<th>Product Name</th>
  			<td><form:input path="productName"/></td>  		
  		</tr>
  	<tr>
  			<th>Product Desc</th>
  			<td><form:input path="productDesc"/></td>  		
  		</tr>
  		<tr>
  			<th>Stock</th>
  			<td>
  			<form:input path="stock"/>
  			</td>  		
  		</tr>
  		<tr>
  			<th>Price</th>
  			<td>
  			<form:input path="price"/>  			
  			</td>  		
  		</tr>
  		<tr>
  			<th>Category</th>
  			<td>
  			   <form:select path="categoryId">
  			   <form:option value="0" label="---Select List----" />
  			   <form:options items="${categoryList}" />
  			   </form:select>
  			</td>  		
  		</tr>
  		<tr>
  			<th>Supplier</th>
  			<td>
  			   <form:select path="supplierId">
  			   <form:option value="0" label="---Select List----" />
  			   <form:options items="${supplierList}" />
  			   </form:select>
  			</td>  			
  		</tr>
  		   <tr>
  		   		<th>Product Image</th>
  		   		<td>
  		   		<form:input type="file" path="pimage"/>
  		   		</td>
  		   </tr>
  		<tr>
  		    <td colspan="2" align="center">
  		     <input type="submit" value="Update" class="btn btn-success"/>
  		   </td>
  		</tr>  
  </table>  
  </form:form> 
 </div> 
</body>
</html>