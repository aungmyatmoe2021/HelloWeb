<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Read Cookie Data</title>
</head>
<body>
	<% 
		Cookie cookie = null;
		Cookie[] cookieArray = request.getCookies(); 
	%>
	<div><%= cookieArray.length %></div>
	<%
	if(cookieArray != null) {
		for (int i = 0; i < cookieArray.length; i++) {
			cookie = cookieArray[i];
			System.out.println(cookie.toString());
			System.out.println(cookie.getValue());
			out.write("Comment : " + cookie.getComment() + "<br />");
			out.write("Domain : " + cookie.getDomain() + "<br />");
			out.write("Time : " + cookie.getMaxAge() + "<br />");
			out.write("Path : " + cookie.getPath() + "<br />");
			
			out.write("Name : " + cookie.getName() + "<br />");
			out.write("Value : " + cookie.getValue() + "<br />");
		}
	}
	%>
</body>
</html>