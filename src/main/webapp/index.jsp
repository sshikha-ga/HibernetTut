<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<!--stylesheet-->
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/login.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/icons.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/input.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/datatable.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=request.getContextPath()%>/css/bootstrap-datepicker.min.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/menu.css"
	rel="stylesheet" type="text/css" />

<!--Jquery and Angular js-->
<script type="application/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.11.1.min.js"></script>
<script type="application/javascript"
	src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>

<!--fonts-->

<link
	href='https://fonts.googleapis.com/css?family=Istok+Web:400,400italic,700,700italic'
	rel='stylesheet' type='text/css'>

<script type="text/javascript">
	window.history.forward(1);
</script>

</head>
<body>


	<!-- Where all the magic happens -->
	<!-- LOGIN FORM -->
	<div class="text-center wrapper">

		<!-- Main Form -->
		<div class="container">
			<div class="login-form-1">
				<form id="login-form" class="text-left"
					action="<%=request.getContextPath()%>/LoginController?action=login"
					method="post">
					<div class="login-form-main-message"></div>
					<div class="main-login-form">

						<div class="login-group">
							<div class="group">
								<input type="text" name="username" required> <span
									class="highlight"></span> <span class="bar"></span> <label>Username</label>
							</div>
							<div class="group">
								<input type="password" name="password" required> <span
									class="highlight"></span> <span class="bar"></span> <label>Password</label>
							</div>
							<br>

							<%
								if (request.getAttribute("LoginMsg") != null) {
							%>
							<p><%=request.getAttribute("LoginMsg").toString()%></p>
							<%
								}
							%>

							<!-- <a href="" class="pull-right"><p>Register Here</p></a> -->
							<a href="">
								<button type="submit" value="login" class="login-button">
									<span class="glyphicon glyphicon-arrow-right"
										aria-hidden="true"></span> <i class="fa fa-"></i>
								</button>
							</a>
						</div>

					</div>

				</form>
			</div>
		</div>
		<!-- end:Main Form -->
	</div>

	<%-- <h4><a href="<%=request.getContextPath() %>/TaskController?action=displayTask">Display Tasks</a></h4>
<h4><a href="<%=request.getContextPath() %>/TaskController?action=addTask">Add Tasks</a></h4>
 --%>

	<%-- <h2>Login</h2>
	<form
		action="<%=request.getContextPath()%>/LoginController?action=login"
		method="post">

		<label>User name : </label> <input type="text" name="username">
		<br> <label>Password : </label> <input type="text"
			name="password"> <br> <input type="submit" value="login">

	</form>
 --%>

</body>
</html>