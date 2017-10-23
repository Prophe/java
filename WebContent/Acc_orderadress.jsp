<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ page import="java.util.*,com.neusoft.entity.*,com.neusoft.Dao.*,com.neusoft.Dao.Impl.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Acc_orderadress.jsp</title>
<script type="text/javascript" src="js/jquery-3.2.1.js" ></script>
<script type="text/javascript" src="js/bootstrap.js" ></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<script type="text/javascript" src="js/jsAddress.js"></script>  
    </head>  
     
     
    <body>  
    <form action="Acc_Address.do">
    	
    		<table style="width: 100%;" class="table" >
				<tr style="background-color: lavender">
					<td colspan="2">添加地址</td>
				</tr>
				<tr>
					<td style="width: 9%;">
						收货人姓名
					</td>
					<td>
						<input type="text" name="name" />
					</td>
				</tr>
				
				<tr>
					<td width="9%">
						地址:
					</td>
					<td>
						<select id="cmbProvince" name="provice"></select>  
    					<select id="cmbCity" name="city"></select>  
    					<select id="cmbArea" name="Area"></select>  
					</td>
				</tr>
				<tr>
					<td>联系方式</td>
					<td><input type="text" name="tel" /></td>
				</tr>
    	     
			
				<tr rowspan="3">
					<td>详细地址</td>
					<td colspan="2">
						<input style="width: 100%;height: 100%;border: 1px;" placeholder="点击编辑备注" name="addr"/>
					</td>
				</tr>
			
    
      
      </table>
      <br />
      <table style="width: 100%;">
				<tr style="background-color: lavender">
					<td >订单信息</td>
				</tr  class="active">
				<tr>
				 <!-- 
	  //订单号
      request.setAttribute("orderno", orderno);
      //总商品数
      request.setAttribute("tol", tol);
      //购物车
      request.setAttribute("list", list); -->
					
					<td>订单号</td>
					<td>编号</td>
					<td>商品名称</td>
					<td>商品数量</td>
					<td>价格</td>
					
					<td>共计</td>
					
					<td>&nbsp;&nbsp;&nbsp;操作</td>
				</tr >
				  
				  <%Object obj=request.getAttribute("list");
				  if(obj !=null){
					  List<CartItem> list=(List<CartItem>)obj;
					  for(int i=0;i<list.size();i++){
						%>
						<tr  class="active">
						 
						 <td>${orderno}</td> 
						 <td><%=i%></td> 
						 <td><%=list.get(i).getProduct().getPname()%></td>
						<td><%=list.get(i).getQuantity()%></td>
					<td><%=list.get(i).getProduct().getPrice() %></td>
					
					<td><%=(list.get(i).getProduct().getPrice())*(list.get(i).getQuantity())%></td>  
				      
					<td><a>修改</a>|<a>删除</a></td>
					</tr>
					 <%
					 }
				  }
				  %>
				
					</table>
					
			
      <input type="submit" value="确认" />
      </form>
                   <script type="text/javascript">  
                        addressInit('cmbProvince', 'cmbCity', 'cmbArea');  
                   </script>  
    </body>  
    </html>  
