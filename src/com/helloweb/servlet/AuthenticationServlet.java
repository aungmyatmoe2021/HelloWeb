package com.helloweb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.helloweb.dao.MemberDAO;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet("/login")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("[AuthenticationServlet]doGet Method is starting here");
		doProcess(request, response);
		System.out.println("[AuthenticationServlet]doGet Method is ending here");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("[AuthenticationServlet]doPost Method is starting here");
		doProcess(request, response);
		System.out.println("[AuthenticationServlet]doPost Method is ending here");
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[AuthenticationServlet]doProcess Method is starting here");
		String strUserName="";
		String strPassword="";

		HttpSession session = request.getSession();
		
		if(request.getParameter("txtUserName") != null) {
			strUserName = request.getParameter("txtUserName");
		}
		if(request.getParameter("txtPassword") != null) {
			strPassword= request.getParameter("txtPassword") ;
		}
		
		List<String> record = new MemberDAO().checkUserLogin(strUserName, strPassword);
		if(record.size()==1) {
			session.setAttribute("USER_NAME", strUserName);
			session.setAttribute("USER_ROLE", strPassword);
			response.sendRedirect("/helloweb/index.jsp?name="+strUserName);
		}
		System.out.println("[AuthenticationServlet]doProcess Method is ending here");
	}

}
