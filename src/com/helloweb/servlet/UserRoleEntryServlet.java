package com.helloweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helloweb.dao.MemberDAO;

/**
 * Servlet implementation class UserRoleEntryServlet
 */
@WebServlet("/userroleentry")
public class UserRoleEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRoleEntryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		String userName = "";
		String userRole = "";
		String errMessage = "";
		String userId = "";
		String status = "New";
		
		if(request.getParameter("hidID") != null) {
			userId = request.getParameter("hidID");
		}
		if(request.getParameter("hidStatus") != null) {
			status = request.getParameter("hidStatus");
		}
		
		System.out.println("Status is "+status);
		
		if(request.getParameter("txtUserName") != null && request.getParameter("txtUserRole") != null) {
			userName= request.getParameter("txtUserName");
			userRole = request.getParameter("txtUserRole");
			
			if(status.equals("New"))
				errMessage = new MemberDAO().insertMember(userName, userRole);
			
			if(status.equals("Update"))
				errMessage = new MemberDAO().updateMember(userId, userName, userRole);
			
			if(errMessage.equals("success"))
				response.sendRedirect("http://localhost:8080/helloweb/memberlist");
			else
				response.sendRedirect("http://localhost:8080/helloweb/userroleentry");
		}
		
		if(status.equals("D")) {
			errMessage = new MemberDAO().deleteMember(userId);
			if(errMessage.equals("success"))
				response.sendRedirect("http://localhost:8080/helloweb/memberlist");
			else
				response.sendRedirect("http://localhost:8080/helloweb/userroleentry");
		}
		
		output.write(userRoleEntryGUI(userId,status));
		
		output.flush();
		output.close();
	}
	
	private String userRoleEntryGUI(String user_role_id,String butValue) {
		String gui = "";
		
		gui += "<form method='get'>";
		gui += "<div><input type='text' name='txtUserName' /></div>";
		gui += "<div><input type='text' name='txtUserRole' /></div>"; 
		gui += "<div><input type='submit' name='butSubmit' value='"+ butValue +"' /></div>"; 
		gui += "<div><input type='reset' name='butCancel' value='Cancel' /></div>"; 
		gui += "<div><input type='hidden' name='hidID' value='"+user_role_id+"' /></div>"; 
		gui += "<div><input type='hidden' name='hidStatus' value='"+butValue+"' /></div>"; 
		gui += "</form>";
		
		return gui;
	}

}
