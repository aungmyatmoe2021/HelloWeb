<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	if(session.getAttribute("USER_NAME") != null){
		session.setAttribute("USER_NAME", null);
		response.sendRedirect("/helloweb/index.jsp");
	}
%>