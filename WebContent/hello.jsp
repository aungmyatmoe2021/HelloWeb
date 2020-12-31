<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%! 
		String a ="Hello World";
		int num1=100,num2=200;
	%>
	<h1><%=a %></h1>
	<h5>Result <%= num1+num2 %></h5>
	<% System.out.println("HELLO JSP"); %>
	<% System.out.println("HELLO JSP"); %>
</body>
</html>