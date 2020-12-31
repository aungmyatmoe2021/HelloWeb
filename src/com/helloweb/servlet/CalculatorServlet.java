package com.helloweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/calculatorservlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter output = response.getWriter();
		String str1 = "0", str2 = "0";
		int result = 0;
		
		if(request.getParameter("txt1") != null)
			str1 = request.getParameter("txt1");
		
		if(request.getParameter("txt2") != null)
			str2 = request.getParameter("txt2");
		
		if(request.getParameter("butAdd") != null && request.getParameter("butAdd").equals("Add"))
			result = Integer.parseInt(str1) + Integer.parseInt(str2);
		if(request.getParameter("butSub") != null && request.getParameter("butSub").equals("Sub"))
			result = Integer.parseInt(str1) - Integer.parseInt(str2);
		if(request.getParameter("butMultiple") != null && request.getParameter("butMultiple").equals("Multiple"))
			result = Integer.parseInt(str1) * Integer.parseInt(str2);
		if(request.getParameter("butDivision") != null && request.getParameter("butDivision").equals("Division"))
			result = Integer.parseInt(str1) / Integer.parseInt(str2);
		
		output.print("<form method='get'>");
		output.print("<input type='text' name='txt1' />");
		output.print("<input type='text' name='txt2' />");
		output.print("<input type='submit' name='butAdd' value='Add' />");
		output.print("<input type='submit' name='butSub' value='Sub' />");
		output.print("<input type='submit' name='butMultiple' value='Multiple' />");
		output.print("<input type='submit' name='butDivision' value='Division' />");
		output.print("<label>"+result+"</label>");
		output.print("</form>");
		
		output.flush();
		output.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
