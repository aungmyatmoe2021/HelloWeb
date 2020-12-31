<%-- if(request.getParameter("name") != null) {--%>
<% if(session.getAttribute("USER_NAME") != null) {%>
	<h3>Welcome <%= session.getAttribute("USER_NAME").toString().trim() %></h3>
	<input type="button" name="butLogout" value="Log Out" onclick="location.href='/helloweb/logout.jsp'"/>
<% }else{ %>
	<form method="post" name="frmLogin" action="/helloweb/login">
		<input type="text" name="txtUserName">
		<input type="password" name="txtPassword">
		<input type="submit" name="butLogin" value="LogIn"/>
	</form>
<% } %>