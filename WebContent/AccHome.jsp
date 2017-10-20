<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ page import="java.util.*,com.neusoft.entity.*,com.neusoft.Dao.*,com.neusoft.Dao.Impl.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理系统</title>
       <link rel="stylesheet" type="text/css" href="css/commodity.css"/>
		<link rel="stylesheet" href="css/accHome.css" />
		<script type="text/javascript" src="js/onclick.js" ></script>
	</head>
	<body>
		<div id="main">
		
			<div style="background-color: #000000;">
				<img src="img/logo.png" style="padding-top: 16px;height: 40px;width: 40px; display:inline-block;"/>
				<a style="margin:0 auto;display:inline-block;font-size: 24px;color:white ;">微电商后台管理系统</a>
				<a href="#" id="exit" >${username}</a>
				<a href="login.jsp" id="exit" >退出</a>
			</div>
			<div id="nav">
				
				<ul>  
					<li><a href="#">首页</a></li>
			        <li><a href="#">商品</a>
			        	<ul>  
			                <li><a href="#" onclick="goods()">商品列表</a></li>  
			                <li><a href="#"  >商品分类</a></li>  
			                <li><a href="#">商品品牌</a></li>  
			                <li><a href="#">商品类型</a></li>  
			            </ul>          
			        </li>  
			        <li><a href="#" id="accid${accId}">订单</a>  
			            <ul>  
			             <li><a href="#">所有订单</a></li>  
			                <li><a href="#">待支付订单</a></li>  
			                <li><a href="#">已付款订单</a></li>  
			                <li><a href="#">已发货订单</a></li>  
			                <li><a href="#">已完成订单</a></li>  
			            </ul>          
			        </li>  
			        <li><a href="#">会员</a></li>  
			        <li><a href="#" onclick="cart()">购物车</a></li>  
			        <li><a href="#">统计</a></li>  
			        <li><a href="#">系统</a></li>  
			        <li><a href="#">账号管理</a></li>  
			        
			    </ul>  
			</div>
			
			
		</div>
		<div class="right" id="right">
			<iframe id="iframeHtml" src="Acc_Propage.do" style="width: 100%; height: 100%;"></iframe>
		</div>
		<script type="text/javascript">
		function goods(){
			var str=document.getElementById("iframeHtml");
			str.src="Acc_Propage.do";
			
		}
		
		function order(a){
			var str=document.getElementById("iframeHtml");
			str.src="ord_page?OrderId="+a;
			
		}
		function cart(){
			var str=document.getElementById("iframeHtml");
			str.src="cart.jsp";
			
		}
		</script>
	</div>
</div>
	</body>
</html>
