<%@page import="com.ga.persistence.entity.Permission"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%
		String UserName = session.getAttribute("UserName").toString();
		ArrayList<Permission> permissions = (ArrayList<Permission>) session.getAttribute("Permissions");
	%>

		<h1 class="text-center">WEll COME <%=UserName %></h1>
		
		<div id="toggle">
		<p class="vericaltext">M E N U</p>
	</div>
	<div class="menu closed">
		<ul>

			<%
				for(int i=0;i<permissions.size();i++){
					Permission rp = permissions.get(i);
					if(rp.getAction().equalsIgnoreCase("CreateTask") || rp.getAction().equalsIgnoreCase("displayTask")){
			%>

			<li><a
				href="<%=request.getContextPath()%>/TaskController?action=displayTask"><%=rp.getPermissionName()%></a></li>
			
			<%}else{ %>
			<li><a
				href="<%=request.getContextPath()%>/AdminController?action=<%=rp.getAction()%>"><%=rp.getPermissionName()%></a></li>
			<%}%>
			<li><a href="<%=request.getContextPath()%>/LoginController?action=logout">Log out</a></li>
			<%} %>
		</ul>


	</div>

	<%-- <a href="<%=request.getContextPath() %>/TaskController?action=displayTask">Display Task</a> --%>

	<!-- <h1 class="text-center">WEll COME</h1> -->
	<script>
		$("#toggle").click(function() {
			$(".menu").toggleClass("closed");
			$(this).toggleClass("closed");
			$(".content").toggleClass("closed");
			$("#wrapper").toggleClass("closed")
		});
	</script>
</body>
</html>