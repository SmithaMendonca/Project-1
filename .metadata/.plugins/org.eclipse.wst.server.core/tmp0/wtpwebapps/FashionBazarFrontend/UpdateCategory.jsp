<%@include file="Header.jsp"%>
<div class="container">
 <h3 align="center"> Edit Category</h3>
 <form action="<c:url value="/UpdateCategory"/>" method="post">
<table align="center" class="table table-bordered">
	<tr>
		<td colspan="2" align="center"><Strong> Category Management</Strong> </td>
	</tr>
	<tr>
		<th> Category ID </th>
		<td> <input type="text" name="categoryId" /></td>
	</tr>
	<tr>
		<th> Category Name </th>
		<td> <input type="text" name="categoryName" /></td>
	</tr>
	<tr>
		<th> Category Desc </th>
		<td> <textarea cols="20" rows="7" name="categoryDesc" /></textarea></td>
	</tr>
	<tr>
	 <td colspan="2" align="center"> 	
	 		<input type="submit" value="Update Category" class="btn btn-success">
	 	</td>
	</tr>
 </table>
 </form>
</div> 
</body>
</html>
 