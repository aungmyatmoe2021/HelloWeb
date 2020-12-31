package com.helloweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWordServlet
 */
@WebServlet("/HelloWordServlet")
public class HelloWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String str1 = "0",str2 = "0";
		
		if(request.getParameter("txt1") != null)
			str1 = request.getParameter("txt1");
		
		if(request.getParameter("txt2") != null)
			str2 = request.getParameter("txt2");
		
		int result = 0;
		result = Integer.parseInt(str1) + Integer.parseInt(str2);
		
		out.print("hello word");
		out.print("<form method='get'>");
		out.print("<input type='text' name='txt1'>");
		out.print("<input type='text' name='txt2'>");
		out.print("<input type='submit' value='click'>");
		out.print("</form>");
		
		out.print("<label>"+ result +"</label>");
		
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
