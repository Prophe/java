<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ page import="java.util.*,java.text.*,com.neusoft.entity.*,com.neusoft.Dao.*,com.neusoft.Dao.Impl.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
		input {
			height: 25px;
			border: 1px solid #D3D3D3;
		}
		span {
			background-color: #EEEEEE;
			display: inline-block;
			height: 26px;
			padding-top:1px;
			border: 1px solid #D3D3D3;
		}
		td {
			border: 1px solid #F4F4F4;
		}
	</style>
</head>

       
			<div style="margin-top: 10px;"></div>
			<div style="width: 70%;margin: 0px auto; display:inline-flex">
			
			
			</div>
			<div style="margin-top: 5px;"></div>
		
			<table style="width: 100%;">
			
				<tr style="background-color: aliceblue;color: black;font-weight: bold;">
					<td>编号</td>
					<td>订单编号</td>
					<td>订单状态</td>
					<td>支付状态</td>
					<td>下单时间</td>
					<td>付款时间</td>
					<td>收货人信息</td>
					<td>详细信息</td>
				</tr>
				<%Object obj=request.getAttribute("list");
             if(obj!=null){// 
            	 List<Orderinfo> pp=(List<Orderinfo>)obj;
                 String Orderstatus=null;
                 String payway=null;
                 
       	       for(int i=0;i<pp.size();i++){
       	       if(pp.get(i).getOrderstatus()==1){
       	    	Orderstatus="未付款";
       	       }else if(pp.get(i).getOrderstatus()==2){
       	    	Orderstatus="已付款";
       	       }else if(pp.get(i).getOrderstatus()==3){
       	    	Orderstatus="已发货";
       	       }else if(pp.get(i).getOrderstatus()==4){
       	    	Orderstatus="已完成";
       	       }
       	       if(pp.get(i).getPaystatus()==1){
       	    	payway="线上支付";
       	       }else{
       	    	payway="货到付款";   
       	       }
       	   
       	       %>
       	       
       	    	   
       	    	<tr>
				<td><%=i+1 %></td>
				<td><%=pp.get(i).getOrderno()%></td>
				<td><%=Orderstatus%> </td>
				
				<td><%=payway %></td>
				<td><%= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(pp.get(i).getOrdertime())) %></td>
				<td><%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(pp.get(i).getPaytime()))  %></td>
				<td><%=pp.get(i).getAddrinfo() %></td>
				<td><a href="#"> 查看详情&nbsp;| </a><a href="orddele.do?deleId=<%=pp.get(i).getId()%>">删除 </a></td>
			</tr>
			 
       	     <%  }
             
             
              }
            	  %>
  <!-- int  id  ;      // 订单id
	 String	 orderno ;   // 订单编号
	 int orderstatus ;     //   ,-- 订单状态     1:未付款 2:已付款 3:已发货 4:已完成
	 int  paystatus ;         // ,-- 1:线上支付  2：货到付款
	 long	ordertime  ;   //  ,-- 下单时间
	 long		  paytime ;//     bigint    ,-- 付款时间
	 int  addrinfo ;       //  ,-- 收货人信息，引用自cosumer_addr表中的id
	 String	  mask;       //  varchar(200) -- 备注信息 -->
				
				
				
					
			</table>
		
				
		
	</body>
</html>
