package com.helloweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doProcess Method is start here");
		response.setContentType("text/html");
		PrintWriter output = response.getWriter();
		String strFirstName = "",strLastName = "", strUserName="",strPassword="",strRetypePassword="",strDOB = "", strGender="";
		
		if(request.getParameter("txtFirstName") != null)
			strFirstName = request.getParameter("txtFirstName");
		if(request.getParameter("txtLastName") != null)
			strLastName = request.getParameter("txtLastName");
		if(request.getParameter("txtUserName") != null)
			strUserName = request.getParameter("txtUserName");
		if(request.getParameter("txtPassword") != null)
			strPassword = request.getParameter("txtPassword");
		if(request.getParameter("txtRetypePassword") != null)
			strRetypePassword = request.getParameter("txtRetypePassword");
		if(request.getParameter("txtDOB") != null)
			strDOB = request.getParameter("txtDOB");
		if(request.getParameter("optGender") != null)
			strGender = request.getParameter("optGender");
		
		System.out.println("Password "+strPassword);
		System.out.println("Re Password "+strRetypePassword);
		
		output.write("<!DOCTYPE html>");
		output.write("<head><title>Register</title></head>");
		output.write("<body>");
		
		if(request.getParameter("txtFirstName") == null && request.getParameter("txtLastName") == null && request.getParameter("txtUserName") == null && request.getParameter("txtPassword") == null && request.getParameter("txtRetypePassword") == null && request.getParameter("txtDOB") == null) {
			output.write(registerFormGUI( strFirstName, strLastName, strUserName,  strDOB, strGender));
		}else if(!strPassword.equals(strRetypePassword)) {
			output.write("<div style='position:fixed;top:25%;left:25%;'>");
			output.write("<div style='color:red;'>");
			output.write("<label>Password doesn't same</label>");
			output.write("</div>");
			output.write(registerFormGUI( strFirstName, strLastName, strUserName,  strDOB, strGender));
		}else {
			output.write("<div style='position:fixed;top:25%;left:25%;'>");
			output.write("<div style='color:green;'>");
			output.write("<label>Register Successful</label>");
			output.write("</div>");
			output.write("</div>");
		}
		
		output.write("</body>");
		output.write("</html>");
		
		output.flush();
		output.close();
		System.out.println("doProcess Method is end here");
	}
	
	private String registerFormGUI(String strFirstName,String strLastName,String strUserName, String strDOB,String strGender) {
		System.out.println("registerFormGUI Method is start here");
		String gui ="";
		gui += "<div style='position:fixed;top:25%;left:25%;'>";
		gui += "<form method='get'>";
		gui += "<div style='margin-bottom:2px;'>";
		gui += "<input type='text' name='txtFirstName' placeholder='First name' style='width: 200%;'  value='"+strFirstName+"'  required />";
		gui += "</div>";
		
		gui += "<div style='margin-bottom:2px;'>";
		gui += "<input type='text' name='txtLastName' placeholder='Last name' style='width: 200%;' value='"+strLastName+"' required />";
		gui += "</div>";
		
		gui += "<div style='margin-bottom:2px;'>";
		gui += "<input type='text' name='txtUserName' placeholder='Mobile number or email address' style='width: 200%;' value='"+strUserName+"' required />";
		gui += "</div>";

		gui += "<div style='margin-bottom:2px;'>";
		gui += "<input type='password' name='txtPassword' placeholder='Password' style='width: 200%;' required />";
		gui += "</div>";
		
		gui += "<div style='margin-bottom:2px;'>";
		gui += "<input type='password' name='txtRetypePassword' placeholder='Retype Password' style='width: 200%;' required />";
		gui += "</div>";
		
		gui += "<div style='margin-bottom:2px;'>";
		gui += "<label for='txtDOB'>Date of Birth</label>";
		gui += "<input type='date' name='txtDOB' placeholder='dd/mm/yyyy' style='width: 200%;' value='"+strDOB+"' required />";
		gui += "</div>";
		
		gui += "<div style='margin-bottom:2px;'>";
		gui += "<label>Gender</label>";
		gui += "<select name='optGender' value='"+strGender+"'>";
		gui += "<option value='male'>Male</option>";
		gui += "<option value='female'>Female</option>";
		gui += "</select>";
		gui += "</div>";

		gui += "<div>";
		gui += "<center>";
		gui += "<input type='submit' Value='Sign Up' style='width: 203%;background:gray;height:40%'>";
		gui += "</center>";
		gui += "</div>";
		
		gui += "</form>";
		gui += "</div>";
		
		System.out.println("registerFormGUI Method is end here");
		return gui;
	}

}
