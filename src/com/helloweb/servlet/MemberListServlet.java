package com.helloweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helloweb.dao.MemberDAO;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/memberlist")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListServlet() {
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
		doGet(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter output = response.getWriter();
		
		output.write("<script type='text/javascript' src='http://localhost:8080/helloweb/js/userrole.js'></script>");
		
		List<String> getResult = null;
		getResult = new MemberDAO().selectAllMember();
		
		output.write("<form method='get' name='frmMemberList'>");
		output.write("<table border=1>");
		for(int i=0;i<getResult.size();i++) {
			String temp = getResult.get(i).substring(1,getResult.get(i).indexOf("]"));
			output.write("<tr>");
//			for(String result : value.split(",")) {
//				result = result.replace('[', ' ');
//				result = result.replace(']', ' ');
//				output.write("<td>"+ result +"</td>");
//			}
			output.write("<td>"+temp.split(",")[1].trim()+"</td>");
			output.write("<td>"+temp.split(",")[2].trim()+"</td>");
			output.write("<td><input type='button' name='butUpdate' value='Update' onclick='location.href=\"/helloweb/userroleentry?hidID="+temp.split(",")[0].trim()+"&hidStatus=Update\"' /></td>");
			output.write("<td><input type='button' name='butDelete' value='Delete' onclick='deleteRoleRecord("+temp.split(",")[0].trim()+")' /></td>");
			output.write("</tr>");
		}
		output.write("<input type='hidden' name='hidID' />");
		output.write("<input type='hidden' name='hidStatus'/>");
		output.write("</table>");
		output.write("</form>");
		
		output.write("</div>");
		
		output.flush();
		output.close();
	}
}
