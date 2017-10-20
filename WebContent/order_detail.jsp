<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ page import="java.util.*,java.text.*,com.neusoft.entity.*,com.neusoft.Dao.*,com.neusoft.Dao.Impl.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order_detaile</title>
</head>
	<style>
		* {
			margin: 5px;
			padding: 0px;
		}
		table {
			width: 80%;
			border: 1px solid darkgray;
			margin-left: 25px;
			margin-bottom: 15px;
		}
	</style>
	<body>
		
		<form action="\">
			<div style="margin-top: 25px;margin-left: 25px;">
				订单状态: <select name="orderstatus"  style="width: 100px;">
					      <option value="1">未付款</option>
					      <option value="2">已付款</option>
					      <option value="3">已发货</option>
					      <option value="4">已完成</option>
				        </select>
			</div>
			
			<table>
				<tr style="background-color: lavender">
					<td colspan="2">订单信息</td>
				</tr>
				<tr>
					<td width="7%">
						订单编号:
					</td>
					<td>
						2432342
					</td>
				</tr>
				
				<tr>
					<td width="7%">
						支付方式:
					</td>
					<td>
						在线支付
					</td>
				</tr>
				
				<tr>
					<td width="7%">
						下单时间:
					</td>
					<td>
						2017-09-02 12:32:33
					</td>
				</tr>
				
				<tr>
					<td width="7%">
						付款时间:
					</td>
					<td>
						2017-09-02 12:32:33
					</td>
				</tr>
				
				</tr>
				
			</table>
			<table>
				<tr style="background-color: lavender" >
					<td colspan="2">收货人信息</td>
					
				</tr>
				<tr>
					<td width="9%">
						收货人姓名: 
					</td>
					<td>
						1232342
					</td>
				</tr>
				<tr>
					<td width="7%">
						地址: 
					</td>
					<td>
						上海浦东市开发区
					</td>
				</tr>
				<tr>
					<td width="7%">
						联系电话:: 
					</td>
					<td>
						1232342232
					</td>
					
				</tr>
			</table>
			
			<table>
				<tr style="background-color: lavender" >
					<td colspan="2">收货人信息</td>
					
				</tr>
				<tr>
					<td width="7%">
						物流公司: 
					</td>
					<td>
						<input type="text" />
					</td>
				</tr>
				<tr>
					<td width="7%">
						物流单号: 
					</td>
					<td>
						<input type="text" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button style="background-color: #87B87F;height: 25px;width: 70px;color: white;margin-left: 110px;">确认发货</button> 
					</td>
					
				</tr>
			</table>
			
			
			<table>
				<tr style="background-color: lavender">
					<td>备注信息</td>
				</tr>
				<tr>
					<td>
						<input style="width: 100%;height: 100%;border: 0px;" placeholder="点击编辑备注" />
					</td>
				</tr>
			</table>
			
			<table>
				<tr style="background-color: lavender">
					<td>商品编号</td>
					<td>商品名称</td>
					<td>商品数量</td>
					<td>商品单价</td>
				</tr>
				<tr>
					<td>
						123123123123
					</td>
					<td>
						黑色色
					</td>
					<td>
						1						
					</td>
					<td>
						5500
					</td>
				</tr>
				
				<tr>
					<td>
						123123123123
					</td>
					<td>
						鞋
					</td>
					<td>
						1						
					</td>
					<td>
						213
					</td>
				</tr>
			</table>
			
		</form>
	</body>
</html>
