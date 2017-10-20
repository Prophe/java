package com.neusoft.cart_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.cart_service.ShoppingBagService;
import com.neusoft.entity.Product;
import com.neusoft.entity.ShoppingBag;

@WebServlet("/GouwucheServlet")
public class GouwucheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GouwucheServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoppingBagService sbs=new ShoppingBagService();
		HttpSession session = request.getSession();
		if(session.isNew()){
			System.out.println(session.getId());
		}
		
		//1.获取要买的商品
		
		int sid=Integer.parseInt(request.getParameter("goumai"));
//         System.out.println(sid);
        Product product= sbs.findProduct(sid);
//        System.out.println(product);
        //2.得到购物车  
        ShoppingBag shoppingBag=(ShoppingBag)session.getAttribute("shoppingBag");  
        if(shoppingBag==null){  
            shoppingBag=new ShoppingBag();  
            session.setAttribute("shoppingBag", shoppingBag);  
        }  
        //3.把商品添加到购物车中  
        shoppingBag.add(product);  
        response.sendRedirect("realshouye.jsp"); 
	
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
