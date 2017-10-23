package com.neusoft.cart_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.Dao.Consumer_Addr_Dao;
import com.neusoft.Dao.Impl.Consumer_Addr_DaoImpl;
import com.neusoft.entity.Consumer_Addr;

/**
 * Servlet implementation class Acc_Address
 */
@WebServlet("/Acc_Address.do")
public class Acc_Address extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Consumer_Addr_Dao address=new Consumer_Addr_DaoImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Acc_Address() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//name,addr  1,phone,provice,city,Area 
		//address.insertCsmAddr(new Consumer_Addr());
	String name=request.getParameter("name");
	String addr=request.getParameter("addr");
	String phone=request.getParameter("tel");
	
	String provice=request.getParameter("provice");
	String city=request.getParameter("city");
	String Area=request.getParameter("Area");
	address.insertCsmAddr(new Consumer_Addr(1, name, addr, phone, provice, city, Area));
	System.out.println("卖家地址添加成功");
	 request.getRequestDispatcher("Acc_Propage.do").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
