package com.neusoft.login_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Account_Consumer;
import com.neusoft.login_services.Account_login;

/**
 * Servlet implementation class Acc_login
 */
@WebServlet("/Acc_login.do")
public class Acc_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
	//	PrintWriter pw = response.getWriter();
		
	//	String erro = (String) request.getAttribute("erro");
		String isCheck = request.getParameter("check");
		System.out.println(isCheck);
		String command = request.getParameter("command");
		if("login".equals(command)){
			String _username = request.getParameter("username");
			String _password = request.getParameter("password");
			System.out.println(_username);
			System.out.println(_password);
			Account_Consumer mAcc = new Account_Consumer();
			mAcc.setLoginname(_username);
			mAcc.setPassword(_password);
			mAcc.setIp(request.getRemoteAddr());
			
			if(_username !=null || _username != "" && _password !=null || _password != ""){
				System.out.println("页面信息"+mAcc);
				mAcc = new Account_login().Acclogin(mAcc);
			}
			if(mAcc!=null){
//				if(isCheck != null && isCheck.equals("1")){
//					//编码
//					Cookie use_ck = new Cookie("username",URLEncoder.encode(_username,"utf-8"));
//					use_ck.setMaxAge(7*24*60*60);
//					//加密
//					Cookie psw_ck = new Cookie("password",MD5Utils.GetMD5Code(_password));
//					System.out.println(MD5Utils.GetMD5Code(_password));
//					psw_ck.setMaxAge(7*24*60*60);
//					response.addCookie(use_ck);
//					response.addCookie(psw_ck);
//				}
				request.setAttribute("accId",mAcc.getId());
				request.setAttribute("username", _username);
				request.getRequestDispatcher("AccHome.jsp").forward(request, response);		
			}else{
				System.out.println("============用户名密码错误!==========");
				//request.setAttribute("erro", "用户名或密码错误,登陆失败");
				//request.getRequestDispatcher("LoginServlet").forward(request, response);
				response.sendRedirect("login.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
