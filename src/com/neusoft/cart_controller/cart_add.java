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

/**
 * Servlet implementation class cart_add
 */
@WebServlet("/cart_add.do")
public class cart_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cart_add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
  ShoppingBagService sbs=new ShoppingBagService();
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	HttpSession session=request.getSession();
	if(session.isNew()){
		System.out.println("新的session"+session.getId());
	}else{
		 System.out.println("不是新的session"+session.getId());
	}
	//获得商品
	int sid=Integer.parseInt(request.getParameter("PID"));
	Product product = sbs.findProduct(sid);
	session.setAttribute("shopping"+sid, product);
	//request.setAttribute("shopping", product);
//	System.out.println("把商品添加到购物车中  ");
	request.getRequestDispatcher("Acc_Propage.do").forward(request, response);
	
	
	//System.out.println(product);
	//2.得到购物车  
	
	// ShoppingBag shoppingBag=(ShoppingBag)session.getAttribute("shoppingBag");  
	 
	 
//     if(shoppingBag==null){  
//         shoppingBag=new ShoppingBag();  
//         session.setAttribute("shopping", shoppingBag);  
//     }  	
     //3.把商品添加到购物车中  
    
   //  shoppingBag.add(product); 
 //    session.setAttribute("shopping", shoppingBag);  
   //  System.out.println("把商品添加到购物车中  ");
    // request.getRequestDispatcher("Acc_goods.jsp").forward(request, response);
 //   response.sendRedirect("Acc_Propage.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
