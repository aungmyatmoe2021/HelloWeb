package com.helloweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helloweb.dao.MemberDAO;

/**
 * Servlet implementation class TestEntryServerlet
 */
@WebServlet("/testentry")
public class TestEntryServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestEntryServerlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet Method is starting here.");
		doProcess(request, response);
		System.out.println("doGet Method is ending here.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost Method is starting here.");
		doProcess(request, response);
		System.out.println("doPost Method is ending here.");
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doProcess Method is starting here.");
		String strUserRoleName = "";
		String strUserRoleDesp = "";
		String strMessage = "";
		String strID = "";
		
		if(request.getParameter("txtUserRoleName") != null) {
			strUserRoleName = request.getParameter("txtUserRoleName").trim();
		}
		if(request.getParameter("txtUserRoleDesp") != null) {
			strUserRoleDesp = request.getParameter("txtUserRoleDesp").trim();
		}
		if(request.getParameter("hidID") != null) {
			strID = request.getParameter("hidID").trim();
		}
		if(request.getParameter("hidStatus") != null) {
			System.out.println("Hidden id : "+request.getParameter("hidID"));
			System.out.println("Hidden Status : "+request.getParameter("hidStatus"));
			
			if(request.getParameter("hidStatus").equals("Update"))
				strMessage = new MemberDAO().updateMember(strID, strUserRoleName, strUserRoleDesp);
			if(request.getParameter("hidStatus").equals("New")) 
				strMessage =new MemberDAO().insertMember(strUserRoleName, strUserRoleDesp);
			if(request.getParameter("hidStatus").equals("D"))
				strMessage = new MemberDAO().deleteMember(strID);
		}
		
		if (strMessage.equals("success"))
			response.sendRedirect("/helloweb/testlist.jsp");
		else
			response.sendRedirect("/helloweb/testentry.jsp");
		
		System.out.println("doProcess Method is ending here.");
	}
}
