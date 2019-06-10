<%@include file="Header.jsp"%>
<html>
<head> 
<style type="text/css">
.product{
	border: 1px solid #dddddd;
	height: 321px;
} 
  .product>img{
	max-width: 230px;
 }
 .product-title{
	font-size: 20px;
 }

.product-desc{
	font-size: 14px;
}

.product-price{
	font-size: 22px;
}

.product-stock{
	color: #74DF00;
	font-size: 20px;
	margin-top: 10px;
}

.content-wrapper {
	max-width: 1140px;
	background: #fff;
	margin: 0 auto;
	margin-top: 25px;
	margin-bottom: 10px;
	border: 0px;
	border-radius: 0px;
}
.container {
	padding-left: 0px;
	padding-right: 0px;
	max-width: 100%;
}
</style>
</head>
<body>
<div class="container">
	<div class="content-wrapper">	
		<div class="item-container">	
			<div class="container">	
			   <div class="row">
				<div class="col-md-6 col-lg-6 col-sm-6 col-xs-12">
					<div class="product col-md-3 service-image-left">
					    <center>                   
						<img id="item-display" src="<c:url value="/resources/images/${product.productId}.jpg"/>" alt="img"></img>
					    </center>
					</div>
				</div>
				
			<form action="<c:url value="/addToCart/${product.productId}"/>" method="get">				
				<div class="col-md-6 col-lg-6 col-sm-6 col-xs-12">
					<div class="product-title">${product.productName}</div>
					<div class="product-desc">${product.productDesc}</div>
					<hr>
					<div class="product-price">INR ${product.price}/-</div>
					<div class="product-stock">In Stock</div>
					<div class="product-price">Quantity
					     <select name="quantity">
					           <option value="1">1</option>
					           <option value="2">2</option>
					           <option value="3">3</option>
					           <option value="4">4</option>
					      </select>
					</div>					
					<hr>
					<div class="btn-group cart">
						<input type="submit" value="Add to Cart" class="btn btn-success"> 
					</div>
				</div>
			</form>
		</div> 
	  </div>
   </div>
 </div> 
</div>    			
</body>
</html>