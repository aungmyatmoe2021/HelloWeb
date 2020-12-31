<%@page import="com.helloweb.dao.MemberDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="topmenu.jsp" %>
	<%
		String id="",status="New",strName="",strDesp="";
		if(request.getParameter("status")!=null){
			status=request.getParameter("status").trim();
		}
		if(status.equals("Update")){
			if(request.getParameter("id")!=null){
				id = request.getParameter("id");
				List<String> record = new MemberDAO().selectMemberByID(request.getParameter("id").toString().trim());
				strName = record.get(0).substring(1,record.get(0).indexOf("]")).split(",")[1].trim();
				strDesp = record.get(0).substring(1,record.get(0).indexOf("]")).split(",")[2].trim();
				System.out.println("Record is "+record.get(0));
			}
		}
	%>
	<div style="margin-top: 120px;margin-bottom: 120px;">
	<form method="get" name="frmTestEntry" action="/helloweb/testentry">
		<div><input type="text" name="txtUserRoleName" value="<%= strName %>" /></div>
		<div><input type="text" name="txtUserRoleDesp" value="<%= strDesp %>" /></div>
		<div>
			<input type="submit" name="butNew" value="<%= status %>" />
			<input type="reset" name="butCancel" value="Cancel" />
		</div>
		<input type="hidden" name="hidID" value="<%= id %>"/>
		<input type="hidden" name="hidStatus" value="<%= status %>"/>
	</form>
	</div>
	<%@ include file="bottommenu.jsp" %>
</body>
</html>