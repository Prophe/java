package com.neusoft.product_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.Dao.DaoFactory;
import com.neusoft.Dao.ProductDao;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.product_services.proServices;

/**
 * Servlet implementation class prosearch
 */
@WebServlet("/prosearch.do")
public class prosearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ProductDao pro=DaoFactory.getInstance("productDao");  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public prosearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub Propage.do
		String name=request.getParameter("pro_search");
		PageModel<Product>  product=null;
		if(name==null||name==""){
			request.getRequestDispatcher("Propage.do").forward(request, response);
		}
		 List<Product> productList=  pro.getProList(name);
		if(productList!=null) {
			product.setPageNo(1);
			product.setDatas(productList);
			product.setTotalcount(productList.size());
			int totalPageSize= (product.getTotalcount()%5==0?product.getTotalcount()/5:product.getTotalcount()/6);
			product.setTotalPageSize(totalPageSize);
		}
		
		request.setAttribute("product", product);
		request.getRequestDispatcher("goods2.jsp").forward(request, response);
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
