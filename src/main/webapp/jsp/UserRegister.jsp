<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!--stylesheet-->
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/style.css"
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
</head>
<body>

	<div class="text-center wrapper">

		<!-- Main Form -->
		<div class="container">
			<div class="login-form-1">
				<form id="login-form" class="text-left"
					action="<%=request.getContextPath()%>/AdminController?action=saveUser" method="post">
					<div class="login-form-main-message"></div>
					<div class="main-login-form">
						<h2 class="text-center">Regiter User</h2>

						<div class="login-group">
							<div class="group">
								<input type="text" name="userName" required> <span
									class="highlight"></span> <span class="bar"></span> <label>Username</label>
							</div>
							<div class="group">
								<input type="password" name="password" required> <span
									class="highlight"></span> <span class="bar"></span> <label>Password</label>
							</div>
							
							<div class="group">
								<input type="text" name="email" required> <span
									class="highlight"></span> <span class="bar"></span> <label>Email</label>
							</div>
							<!--    <div class="group">
                            <input type="password" required >
                            <span class="highlight"></span>
                            <span class="bar"></span>
                            <label>Confirm Password</label>
                        </div> -->
							<div class="group">
								<select class="form-control" name="role">
									<option value="role">role</option>
									<option value="1">Admin</option>
									<option value="2">User</option>

								</select>
							</div>

							<input type="submit" class="btn btn-default pull-right" value="ADD">
							<button type="button" class="btn btn-default pull-right"
								data-dismiss="modal">CANCEL</button>

						</div>

					</div>
				</form>
			</div>
		</div>
		<!-- end:Main Form -->
	</div>

</body>
</html>