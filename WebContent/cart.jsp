<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ page import="java.util.*,com.neusoft.entity.*,com.neusoft.Dao.*,com.neusoft.Dao.Impl.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
	</head>
	 
	
	<body style="text-align:center">
		<div class="ibar_plugin_content"  style="border: 1px solid red;">
			<div class="ibar_cart_group ibar_cart_product">
				<div class="ibar_cart_group_header">
					
					<h3 href="#">我的购物车</h3>
					</div>
					
				
				
				<form  action="Acc_ord.do?">
				<%
			Enumeration<String> s=request.getSession().getAttributeNames();
					if(s==null){
						%>
						<font color="red">您的购物袋还是空的哦！！</font><br/>      
		       您可以  
	   	       <a href="Acc_Propage.do">点击此处进入购买页面</a>
						<% 
					};
			        %>
				
				
				
				
				<%while(s.hasMoreElements()){
			          Object obj =  request.getSession().getAttribute(s.nextElement());
			          if(obj instanceof Product)
			          {
			        	  Product pb = (Product)obj;
			        	  %>
			        	  <div style="border: 1px solid saddlebrown;display:flex; width: 100%;font-size: 20px;">
						<div class="cart_item_pic" style="border: 1px solid seagreen; width: 20%;">
							<a href="#"><img src="img/<%=pb.getPic() %>"  style="width: 200px;height: 200px;"/></a>
						</div>
						<div style="border: 1px solid seagreen; width: 80%;">
							<div class="cart_item_desc">
							<p href="#" class="cart_item_name"  name="<%=pb.getId()%>">
								<%=pb.getPname()%>
							</p>
							<div class="cart_item_desc" style=height:84px;;>
							<p href="#" class="cart_item_name">
							<%=pb.getPdetail()%>
							</p>
							</div>
							<div class="cart_item_sku">
								<span>尺码：38码（精工限量版）</span><span class="cart_price">￥<%=pb.getPrice()%></span><span>数量： <input type="text" name="quantity" value="1" onchange="changequantity(this,)"/>  
           </span>             <input  type="hidden" name="pid" value="<%=pb.getId()%>"/>
							</div>
							
						   </div>	
						</div>
					</div>
			        	  
			        	  <%
			        	 
			        	  }} %>
				
				 
					  
	
			<div class="cart_handler" style="border: 1px solid blue;" >
				<div class="cart_handler_header">
					<span class="cart_handler_left">共<span class="cart_price">1</span>件商品</span>
					<span class="cart_handler_right">￥${shoppingBag.price }</span>
				</div>
				<input type="submit"  value="结算" class="cart_go_btn" target="_blank">
					
				</input>
			</div>
			</form>		
		</div>
		</div>
	</body>
</html>
