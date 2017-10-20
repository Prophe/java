package com.neusoft.ord_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Orderinfo;
import com.neusoft.ord_services.ordServices;

/**
 * Servlet implementation class ord_page
 */
@WebServlet("/ord_page")
public class ord_page extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ord_page() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Orderinfo> list=null;
		ordServices ords=new ordServices();
		String OrderId=request.getParameter("OrderId");
		System.out.println("String:"+OrderId);
//		if(OrderId==null||OrderId.equals("")){
//			
//		}
		int id=Integer.parseInt(OrderId);
		System.out.println(id==2);
		
		if(OrderId.equals("1")){
			System.out.println("++++++++++++++");
			list=ords.intOne();
			request.setAttribute("list", list);
			request.getRequestDispatcher("orderList.jsp").forward(request, response);
		}else if(id==2){
			list=ords.intTwo();
			request.setAttribute("list", list);
			request.getRequestDispatcher("orderList.jsp").forward(request, response);
		}else if(id==3){
			list=ords.intThree();
			request.setAttribute("list", list);
			request.getRequestDispatcher("orderList.jsp").forward(request, response);
		}else if(id==4){
			list=ords.intFour();
			request.setAttribute("list", list);
			request.getRequestDispatcher("orderList.jsp").forward(request, response);
		}
		System.out.println("-----------");
		
		   
	
	}
	
	
	
	
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
