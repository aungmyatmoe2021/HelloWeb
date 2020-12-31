<%@page import="com.helloweb.dao.MemberDAO"%>
<%@page import="java.util.List"%>
<script type='text/javascript' src='http://localhost:8080/helloweb/js/userrole.js'></script>
<div><input type="button" name="butNew" value="New" onclick="location.href='/helloweb/testentry.jsp'"/></div>
<form name="frmMemberList">
	<table>
	<tr><th>User Role ID</th><th>User Role Name</th><th>User Role Description</th><th colspan='2'>Actions</th></tr>
	<% 
		List<String> lsResults = new MemberDAO().selectAllMember();
		int count = 0;
		for(int i=0;i<lsResults.size();i++){
			String color = (count % 2 == 0) ? "#FFFFFF" : "#CCCCCC";
			String strTemp = lsResults.get(i).substring(1, lsResults.get(i).indexOf("]"));
	%>
		<tr style="background-color:<%= color %> ;">
			<td><%= strTemp.split(",")[0] %></td>
			<td><%= strTemp.split(",")[1] %></td>
			<td><%= strTemp.split(",")[2] %></td>
			<td><input type="button" name="butUpdate" value="Update" onclick="location.href='/helloweb/testentry.jsp?id=<%= strTemp.split(",")[0] %>&status=Update'"/></td>
			<td><input type="button" name="butDelete" value="Delete" onclick="deleteRoleRecord(<%= strTemp.split(",")[0] %>)"/></td>
		</tr>
	<% 
			count++; 
		}
	%>
	<input type="hidden" name="hidID" value=""/>
		<input type="hidden" name="hidStatus" value=""/>
</table>
</form>