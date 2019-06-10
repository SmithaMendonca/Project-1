<%@include file="Header.jsp"%>
<html>
<head>
<style type="text/css">
body { margin-top:20px; }
.panel-title {display: inline;font-weight: bold;}
.checkbox.pull-right { margin: 0; }
.pl-ziro { padding-left: 0px; }
</style>	   
</head>
<body>
<div class="container">
    <div class="row">
      <form action="<c:url value="/pay"/>" role="form" method="post">
        <div class="col-xs-12 col-md-4">
            <div class="panel panel-default">
               <form role="form">
                 <div class="panel-heading">
                    <h3 class="panel-title">
                        Payment Details
                    </h3>
                    <div class="checkbox pull-right">
                        <label>
                            <input type="radio" name="pmode" id="cc" value="CC"/>CC
                            <input type="radio" name="pmode" id="cod"  value="COD"/>COD                       
                        </label>
                    </div>
                </div>
           
                        
                <div class="panel-body">                                 
                    <div class="form-group">
                        <label for="cardNumber">
                            CARD NUMBER</label>
                        <div class="input-group">
                            <input type="text" class="form-control" id="cardNumber" maxlength="16" pattern="\d{16}" placeholder="Valid Card Number"
                                required autofocus />
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                        </div>
                    </div>
                       <div class="form-group">
                        <label for="cardNumber">
                            CARD HOLDER NAME</label>
                        <div class="input-group">
                            <input type="text" class="form-control" id="cardHolderName"  placeholder="Card Holder Name"
                                required autofocus />
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-7 col-md-7">
                            <div class="form-group">
                                <label for="expityMonth">
                                    EXPIRY DATE</label>
                                <div class="col-xs-6 col-lg-6 pl-ziro">
                                    <select class="form-control" id="expityMonth" size="0" >
                                    		<option value="01">01</option>
                                            <option value="02">02</option>
                                            <option value="03">03</option>
                                            <option value="04">04</option>
                                            <option value="05">05</option>
                                            <option value="06">06</option>
                                            <option value="07">07</option>
                                            <option value="08">08</option>
                                            <option value="09">09</option>
                                            <option value="10">10</option>
                                            <option value="11">11</option>
                                            <option value="12">12</option>
                                    </select>
                                </div>
                                <div class="col-xs-6 col-lg-6 pl-ziro">
                                    <select class="form-control" id="expityYear" size="0" >
                                            <option>2020</option>
                                            <option>2021</option>
                                            <option>2022</option>
                                            <option>2023</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-5 col-md-5 pull-right">
                            <div class="form-group">
                                <label for="cvCode">
                                    CVV CODE</label>
                                <input type="password" class="form-control" maxlength="3" pattern="\d{3}" id="cvCode" placeholder="CV" required />
                            </div>
                        </div>
                    </div>                                                 
                </div>
                   
               </form>                
            </div>                       
            <ul class="nav nav-pills nav-stacked">
                <li class="active"><a href="#"><span class="badge pull-right"><span class="glyphicon glyphicon-usd"></span>${grandTotal}</span> Final Payment</a>
                </li>
            </ul>
            <br/>
            <input type="submit" value="Pay" class="btn btn-success btn-lg btn-block"/>
        </div>
      </form>      
    </div>	
</div>	
</body>
</html>