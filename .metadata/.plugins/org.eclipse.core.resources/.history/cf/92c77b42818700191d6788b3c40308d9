<%@include file="Header.jsp"%>
<%@page isELIgnored="false" %>

<div class="container">
  <form:form action="InsertProduct" modelAttribute="product" method="post" enctype="multipart/form-data">
  <table align="center" class="table table-borderless">
    <tr>
		<td colspan="2" align="center"><Strong>Product Management</Strong></td>
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
  		     <input type="submit" value="Insert Product" class="btn btn-success"/>
  		   </td>
  		</tr>  
  </table>  
  </form:form>
  
  <br/><br/>
  
  <table align="center" class="table table-bordered">
     <tr bgcolor="pink">
     	  <th>Product ID</th>
          <th>Product Name</th>
          <th>Product Desc</th>
          <th>Stock</th>
          <th>Price</th>
          <th>Category</th>
          <th>Supplier</th>
          <th>Operation</th>     
     </tr>
  <c:forEach items="${productList}" var="product">
  <tr>
  		<td>${product.productId}</td>
  		<td>${product.productName}</td>
  		<td>${product.productDesc}</td>
  		<td>${product.stock}</td>
  		<td>${product.price}</td>
  		<td>${product.categoryId}</td>
  		<td>${product.supplierId}</td>
  		<td>
  	 			<a href="<c:url value="/editProduct/${product.productId}"/>"><img alt="Edit" src="<c:url value="/resources/images/edit.jpg"/>" style="width:42px;height:42px;"/></a>
  	 			<a href="<c:url value="/deleteProduct/${product.productId}"/>"><img alt="Delete" src="<c:url value="/resources/images/delete.jpg"/>" style="width:40px;height:40px;"/></a>
  	 	</td>
  </tr>
  </c:forEach>  
  </table>
  </div>
</body>
</html>