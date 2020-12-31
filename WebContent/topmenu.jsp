<%
	if(session.getAttribute("USER_ROLE") != null){
		if(session.getAttribute("USER_ROLE").equals("Administrator")){
%>
			<a href="index.jsp">Home</a>
			<a href="#">Product</a>
			<a href="userinfo.jsp">User Info</a>
			<a href="#">About Us</a>
			<a href="#">Contact Me</a>
			<%@ include file="loginform.jsp" %>
<%
		}
	}else{
%>
			<a href="index.jsp">Home</a>
			<a href="#">Product</a>
			<a href="#">About Us</a>
			<a href="#">Contact Me</a>
			<%@ include file="loginform.jsp" %>
<%	
	}
%>

	