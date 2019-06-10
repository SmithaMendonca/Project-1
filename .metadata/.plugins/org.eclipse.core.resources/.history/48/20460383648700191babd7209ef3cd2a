<%@include file="Header.jsp"%>
<%@page isELIgnored="false" %>

<div class="container">
	<form action="<c:url value="/InsertCategory"/>" method="post">
     <table align="center" class="table table-borderless">
	<tr>
		<td colspan="2" align="center"><Strong> Category Management</Strong> </td>
	</tr>
	<tr>
		<th> Category Name </th>
		<td> <input type="text" name="categoryName"/></td>
	</tr>
	<tr>
		<th> Category Desc </th>
		<td> <textarea cols="20" rows="7" name="categoryDesc"/></textarea></td>
	</tr>
	<tr>
	 <td colspan="2" align="center"> 	
	 		<input type="submit" value="Insert Category" class="btn btn-success">
	 	</td>
	</tr>
 </table>
  </form>
 </div>
 
  <br/><br/>
  
  <div class="container">
  <table align="center" class="table table-bordered">
  	 <tr bgcolor="pink">
  	    <th> Category ID </th>
  	    <th> Category Name</th>
  	    <th> Category Desc</th>
  	    <th> Operation</th>
  	 </tr>
  	 <c:forEach items="${categoryList}" var="category" >
  	 <tr>
  	 		<td>${category.categoryId}</td>
  	 		<td>${category.categoryName}</td>
  	 		<td>${category.categoryDesc}</td>
  	 		<td>
  	 			<a href="<c:url value="/editCategory/${category.categoryId}"/>"><img alt="Edit" src="<c:url value="/resources/images/edit.jpg"/>" style="width:42px;height:42px;"/></a>
  	 			<a href="<c:url value="/deleteCategory/${category.categoryId}"/>"><img alt="Delete" src="<c:url value="/resources/images/delete.jpg"/>" style="width:40px;height:40px;"/></a>
  	 		</td>
  	 </tr>
  	 </c:forEach>
  </table>
  </div>
</body>
</html>