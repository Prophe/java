package com.neusoft.ord_services;

import java.util.List;

import com.neusoft.Dao.DaoFactory;
import com.neusoft.Dao.OrderinfoDao;
import com.neusoft.entity.Orderinfo;

public class ordServices {
	OrderinfoDao order= DaoFactory.getInstance("order");
	
//	public void getOrdpage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String pageNo=request.getParameter("pageNo");
//		String pageSize=request.getParameter("pageSize");
//		PageModel<Orderinfo>  product=null;
//		if(pageNo==null||pageNo==""){
//			pageNo="1";
//		}
//		if(pageSize==null||pageSize==""){
//			pageSize="5";
//		}
//		try {
//			int _pageNo=Integer.parseInt(pageNo);
//			int _pageSize=Integer.parseInt(pageSize);
//			
//			product=order.getPageModel(_pageNo,_pageSize);
//			if(product!=null) {
//				int totalPageSize= (product.getTotalcount()%_pageSize==0?product.getTotalcount()/_pageSize:product.getTotalcount()/_pageSize+1);
//				product.setTotalPageSize(totalPageSize);
//				product.setPageNo(_pageNo);
//			}
//			
//			request.setAttribute("product", product);
//			request.getRequestDispatcher("orderlistBy.jsp").forward(request, response);
//		}catch(NumberFormatException e) {
//			e.printStackTrace();
//		}
//		
//
//		
//		
//	
//	}
	/**
	 * 删除订单
	 * */
	public boolean delOre(int id){
		
		if(order.deleOrdByid(id)){
			return true;
		}
		return false;
	}
	
	/**
	 * 查询
	 * */
   public Orderinfo findOrd(int id){
	   return order.getByid(id);
	}
	/**
	 * 修改
	 * */
	public Orderinfo uOrd(Orderinfo order){
		
		return order;
		
	//	order.
	}
	
	
	/**
	 * 查询不同的list
	 * **/
	
	public List<Orderinfo> intOne(){
		List<Orderinfo> list= order.getweifukuan();
		return list;
		
	}
	public List<Orderinfo> intTwo(){
		List<Orderinfo> list= order.getyifukuan();
		return list;
		
	}
	public List<Orderinfo> intThree(){
		List<Orderinfo> list= order.getyifahuo();
		return list;
	}
	public List<Orderinfo> intFour(){
		List<Orderinfo> list= order.getyiwancheng();
		return list;
	}
	
}
