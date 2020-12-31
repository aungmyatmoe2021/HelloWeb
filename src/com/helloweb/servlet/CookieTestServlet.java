package com.helloweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieTestServlet
 */
@WebServlet("/cookietest")
public class CookieTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		Cookie cuser = new Cookie("cookieUser", "ABC");
		Cookie cpwd = new Cookie("cookiePwd", "123");
		
		cuser.setComment("Cookie User");
		cuser.setMaxAge(60*60);
		cpwd.setComment("Cookie Password");
		cpwd.setMaxAge(60*60);
		
		// cookie send to Client Browser
		response.addCookie(cuser);
		response.addCookie(cpwd);
		
		response.sendRedirect(request.getContextPath()+"/cookie.jsp");
//		Cookie[] cookieArray = request.getCookies();
		
//		System.out.println("Cookie length : "+cookieArray.length);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
