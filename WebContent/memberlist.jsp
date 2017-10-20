<%@page import="com.neusoft.utils.PageModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.neusoft.entity.*,com.neusoft.Dao.*,com.neusoft.Dao.Impl.*" %>     
  <%@ page import="java.util.*,com.neusoft.entity.*,java.text.*" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/member.css" />
<body>
	
			<div style="margin-top: 10px;"></div>
			<div style="width: 70%;margin: 0px auto; display:inline-flex">
			<!--<input type="button" value="按消费日期排序" style= "cursor: pointer;" />
			<input type="button" value="按订单总数排序" style="cursor: pointer;" />
			<input type="button" value="按消费金额排序" style="cursor: pointer;" />-->
			
			
			
			
			</div>
			<div style="margin-top: 5px;"></div>
			<%  ShopConsumerDao member=new ShopConsumerDaoImpl();
			    PageModel<Shoppinginfo_Consumer> shopinfo= member.selectShopCsmAll(1, 5);
			    shopinfo.setPageNo(1);
			    shopinfo.setPageSize(5);
			    shopinfo.setTotalRecords(shopinfo.getList().size()+1);
			    int totalPageSize= (shopinfo.getTotalRecords()%shopinfo.getPageSize()==0?shopinfo.getTotalRecords()/shopinfo.getPageSize():shopinfo.getTotalRecords()/shopinfo.getPageSize()+1);
			  
			%>
		
		<table>
				<tr style="background-color: palevioletred;color: black;font-weight: bold;">
					<td>会员ID</td>
					<td>用户类型</td>
					<td>用户名</td>
					<td>已完成订单金额</td>
					<td>已完成订单总数</td>
					<td>折扣积分</td>
					<td>最近消费</td>
					<td>操作</td>
				</tr>
				<%for(int i=0;i<shopinfo.getList().size();i++){
				%>
					<tr>
					<td><%=shopinfo.getList().get(i).getAid()%></td>
					<td>会员</td>
					<td>浮生物语<%=shopinfo.getList().get(i).getNickname()%></td>
					<td>1232</td>
					<td>10</td>
					<td>折扣积分</td>
					<td><%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(shopinfo.getList().get(i).getLasttime())) %></td>
					<td><a href="#"> 修改&nbsp;| </a><a href="memDele.do?Id=<%=shopinfo.getList().get(i).getId()%>"> 删除 </a></td>
				</tr>
					
					
					<% }%>
				
				
				
				
			
			</table>
		
			
			
		
	</body>
</html>
