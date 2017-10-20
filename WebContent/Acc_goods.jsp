<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
     
<%@ page import="java.util.*,com.neusoft.entity.*,com.neusoft.Dao.*,com.neusoft.Dao.Impl.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />




	</head>
	<body>
	
		<div class="main">
           
    <div id="plist" >
       <div class="change_div_1_class" id="change_div_1_id" >
				 
					<input placeholder="商品编号/名称" name="pro_search" id="change_div_1_input class="change_div_1_input"/>
				   <button class="change_div_1_" id="change_div_search"><a>搜索</a></button>
				</div>
				<ul>
				
				<%   Object obj=request.getAttribute("product");
             if(obj!=null){// 
       	     PageModel<Product> pp=(PageModel<Product>)obj;
       	     CateDao s=new CateDaoImpl();
       	    
      	    
              for(int j=0;j<pp.getDatas().size();j++){
            	 
            	  %>
          <li>
                <div class="lh_wrap">
                    <div class="p-img"><a target="_blank" href="goods.php?id=147"><img alt="<%=pp.getDatas().get(j).getPname() %>" src="img/<%=pp.getDatas().get(j).getPic() %>" title="<%=pp.getDatas().get(j).getPname() %>" width="240" height="240"></a></div>
                    <div class="p-name"><a target="_blank" href="goods.php?id=147" title="<%=pp.getDatas().get(j).getPname() %>"><%=pp.getDatas().get(j).getPname() %></a></div>
                    <div class="p-price"><strong>￥<%=pp.getDatas().get(j).getPrice() %></strong><span id="p200"></span></div>
                    <div class="extra"><a href="#">已售出0件</a></div>
                    <div class="btns">
                        <a  href="cart_add.do?PID=<%=pp.getDatas().get(j).getId()%>" onclick="goumai(<%=pp.getDatas().get(j).getId()%>)"  class="add_cart_large btnCart">加入购物车</a>
                        <a href="javascript:;" class="add_cart_small btnCart">关注</a>
                        <a class="btn-compare">
                            <input id="147"  type="checkbox">
                            <label for="147">对比</label>
                        </a>
                    </div>
                </div>
            </li>
				 	
				 	
				 	
				 
				 	<%}
             
				 	%> 
				 	</ul>
				 	</div>
			<div style="margin-left:120px" >
				共<%=pp.getTotalcount() %>条记录 <%=pp.getPageNo()%>/<%=pp.getTotalPageSize()%>页
				&nbsp;<a href="Acc_Propage.do?pageNo=1&pageSize=6" onclick="topPage()" >首页</a> 
				<a href="Acc_Propage.do?pageNo=<%=pp.getPageNo() - 1==0?pp.getPageNo():pp.getPageNo() - 1%>&pageSize=6" onclick="previousPage()">上一页</a>&nbsp;
				<a href="Acc_Propage.do?pageNo=<%=pp.getPageNo() + 1==pp.getTotalPageSize()?pp.getTotalPageSize():pp.getPageNo()+1%>&pageSize=6" >下一页</a> 
				<a href="Acc_Propage.do?pageNo=<%=pp.getTotalPageSize()%>&pageSize=6" onclick="bottomPage()" >尾页</a>
				&nbsp;第<select onChange="if(this.value==1){location='http://localhost:8080/Message/Acc_Propage.do?reqType=2&pageNo=1&pageSize=6'}else{location='http://localhost:8080/Message/Acc_Propage.do?reqType=2&pageNo='+this.value+'&pageSize=6'}this.disabled='disabled'">
        <%
           if(pp!=null){
        	   int _totalPageSize=pp.getTotalPageSize();
        	   for(int i=0;i<_totalPageSize;i++){
        	     
        		    if(pp.getPageNo()==(i+1)){%>
        		    	
        		    <option value="<%=i+1 %>" selected="selected"><%=(i+1)%></option>
        		  <%  }else{%>
        			  <option value="<%=i+1 %>" ><%=(i+1)%></option>
        		  <%
        		  }
        	   }
           }
             }
            %> 
        
						</select>页
				</div>
				
				
				
				
			</div>
			
			

</html>