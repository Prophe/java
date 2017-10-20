package com.neusoft.cart_controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.cart_service.ShoppingBagService;
import com.neusoft.entity.CartItem;
import com.neusoft.entity.Product;

/**
 * Servlet implementation class Acc_orderaddress
 */
@WebServlet("/Acc_ord.do")
public class Acc_orderaddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	List<CartItem> list=new ArrayList<CartItem>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Acc_orderaddress() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		 ShoppingBagService sbs=new ShoppingBagService();
		//int sid=Integer.parseInt(request.getParameter("PID"));
		 //��Ʒ�������
		
		String[] pids=request.getParameterValues("pid");
		
		//��Ʒ��������
        String[] quantitys=request.getParameterValues("quantity");
        //��Ʒ����
        int tol=0;
        //����Ʒ�ܼ�
    //    Double price;
        //���ﳵ�ܼ�
       // Double sum;
      for(int i=0;i<pids.length;i++){
    	  int id=Integer.parseInt(pids[i]);
    	  Product product = sbs.findProduct(id);
    	  int quantity=Integer.parseInt(quantitys[i]);
    	  //����Ʒ�ܼ�
    	 //  price= product.getPrice()*quantity;
    	  
    	System.out.println(product.getPname()+"����"+quantity);
    	  tol+=quantity;
    	 CartItem cart= new CartItem(product, quantity);
    	 
    	  list.add(cart);
      }
      System.out.println(list.size());
      String orderno= UUID.randomUUID().toString().substring(0, 8);
      //������cartitem
      request.setAttribute("orderno", orderno);
      //����Ʒ��
      request.setAttribute("tol", tol);
      //���ﳵ
      request.setAttribute("list", list);
      
      request.getRequestDispatcher("Acc_orderadress.jsp").forward(request, response);
      
//      int id=Integer.parseInt(pids[i]);
//	  Product product = sbs.findProduct(id);
//	  String s=quantitys[i];
//	  int quantity=Integer.parseInt(quantitys[i]);
//	  list.add(new CartItem(product, quantity));
//	  
	   
	    //  int quatity=Integer.parseInt(request.getParameter("quantity"));
//	    System.out.println("���� int"+quatity);
//	    Double s=(product.getPrice())*quatity;
//	    CartItem cart=new CartItem(product, quatity, s);
//	   String orderno= UUID.randomUUID().toString().substring(0, 8);
//	   //������
//	   request.setAttribute("orderno", orderno);
//	   //���ﳵ
//	   request.setAttribute("cart", cart);
//	   request.getRequestDispatcher("Acc_orderadress.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
