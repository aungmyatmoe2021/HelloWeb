package com.helloweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter output = response.getWriter();
		String strUserName = "",strPassword="";
		
		
//		System.out.println("User Name is "+request.getParameter("txtUserName"));
		if(request.getParameter("txtUserName") != null)
			strUserName = request.getParameter("txtUserName");
		
//		System.out.println("Password is "+request.getParameter("txtPassword"));
		if(request.getParameter("txtPassword") != null)
			strPassword = request.getParameter("txtPassword");
		
		output.write("<!DOCTYPE html>");
		output.write("<head><title>Log In</title></head>");
		output.write("<body>");
		
		// Check the user name and password is blank or null once the page load in firsttime
		if(request.getParameter("txtUserName") == null && request.getParameter("txtPassword") == null) {
			output.write(loginFormGUI(strUserName, strPassword));
		}else {
			if(strUserName.equals("aungmyatmoe2021@gmail.com")) {
				if(strPassword.equals("adminace")) {
					System.out.println("successful");
					output.write("<div style='color:green;'>");
					output.write("<label>Log In Successful</label>");
					output.write("</div>");
					
					response.sendRedirect("http://localhost:8080/helloweb/success.html");
					
				}else {
					output.write("<div style='position:fixed;top:25%;left:25%;'>");
					output.write("<div style='color:red;margin-bottom:5px;'>");
					output.write("<label>Password is incorrect!</label>");
					output.write("</div>");
					output.write(loginFormGUI(strUserName, strPassword));
				}
			}else {
				output.write(loginFormGUI(strUserName, strPassword));
			}
		}
		
		output.write("</body>");
		output.write("</html>");
		
		output.flush();
		output.close();
	}
	
	// For UI Only
	private String loginFormGUI(String strUserName, String strPassword) {
		System.out.println("Login GUI method start here");
		String gui = "";
		
		gui += "<div style='position:fixed;top:25%;left:25%;'>";
		gui += "<form method='get'>";
		gui += "<div style='width: 100%;margin-bottom:5px;'>";
		gui += "<label for='txtUserName'>User Name</label>";
		gui += "</div>";

		gui += "<div style='width: 100%;margin-bottom:5px;'>";
		gui += "<input type='text' name='txtUserName' id='txtUserName' value='"+strUserName+"'/>";
		gui += "</div>";

		gui += "<div style='width: 100%;margin-bottom:5px;'>";
		gui += "<label for='txtPassword'>Password</label>";
		gui += "</div>";

		gui += "<div style='width: 100%;margin-bottom:5px;'>";
		gui += "<input type='password' name='txtPassword' id='txtPassword' value='"+strPassword+"'/>";
		gui += "</div>";

		gui += "<div style='width: 100%;margin-bottom:5px;'>";
		gui += "<input type='submit' Value='Log In'>";
		gui += "<input type='reset' Value='Cancel'>";
		gui += "</div>";
		
		gui += "</form>";
		gui += "</div>";
		System.out.println("Login GUI method end here");
		
		return gui;
	}

}
