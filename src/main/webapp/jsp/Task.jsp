<%@page import="com.ga.persistence.entity.User"%>
<%@page import="com.ga.domain.modal.TaskDto"%>
<%@page import="com.ga.persistence.entity.Task"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/datepicker.min.css"
	rel="stylesheet" type="text/css" />

<!--Jquery and Angular js-->
<script type="application/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.11.1.min.js"></script>
<script type="application/javascript"
	src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script type="application/javascript"
	src="<%=request.getContextPath()%>/js/datepicker.min.js"></script>

<!-- <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css"> -->

<!--fonts-->

<link
	href='https://fonts.googleapis.com/css?family=Istok+Web:400,400italic,700,700italic'
	rel='stylesheet' type='text/css'>

<script type="text/javascript">
	window.history.forward(1);
</script>
</head>
<body>

	<jsp:include page="Header.jsp"></jsp:include>

	<%
		int user_id = (Integer)session.getAttribute("User");
		int role_id = (Integer)session.getAttribute("UserRoleId");
			ArrayList<TaskDto> taskList = (ArrayList<TaskDto>)request.getAttribute("TaskList");
		    ArrayList<User> userList = (ArrayList<User>)request.getAttribute("UserList");
	%>

	<script>

		function worklog(id) {
				$("#taskId").val(id);
		}

		function validate() {
			var time = $("#totalTime").val();
		}

		function validateTimePattern(e){

		var str = $("#totalTime").val();
			
			$.get("/HibernetTaskExample/UserController?action=validateTimePattern",{TotalTime:str}, function(result){
				if(result==1){
					$('#addWorklogBtn').attr('disabled',false);
				}else{
					alert("please enter time in 0d 0h 0m formate");
					$('#addWorklogBtn').attr('disabled',true);
					return false;
				}
			});	
		}
		
		function validateTask(e) {
			var taskTitleLength = $.trim($("#taskTitle").val().length);
			var taskDesc = $.trim($("#taskDesc").val().length);
			var startDate = $.trim($("#startDate").val().length);
			var endDate = $.trim($("#endDate").val().length);
			
			if(taskTitleLength==0){
				e.preventDefault();
			}

			if(taskDesc==0){
				e.preventDefault();
			}

			if(startDate==0){
				e.preventDefault();
			}

			if(endDate==0){
				e.preventDefault();
			}

		}

		function demo(id) {
			
			$.get("/HibernetTaskExample/TaskController?action=getTaskDetails",{Task_Id:id}, function(result){
				var a = JSON.parse(result);
				var str = "";
				if(result=="[]"){
					str += "No Worklogs found";
				}else{
					for(x in a){
						str += a[x].userName + " - " + a[x].totalDays + " days " + a[x].totalHours + " hours "+a[x].totalMinutes + " minutes " + "<br>";
					}
				}
				
				$("#myModal2 .modal-body").html(str);
			 });
		}
	</script>


	<section class="container">
	<h3 class="text-center">
		<b>List of Tasks</b>
	</h3>
	<hr>
	<%
		if(role_id !=1){
	%>
	<button type="button" class="btn btn-info pull-right"
		data-toggle="modal" data-target="#myModal">Add Task</button>
	<%
		}
	%> <br>
	<br>
	<table id="example" class="table  table-bordered text-center"
		cellspacing="0" width="100%">
		<thead>
			<tr>
				<th class="text-center">Title</th>
				<th class="text-center">Description</th>
				<th class="text-center">Start Date</th>
				<th class="text-center">End Date</th>
				<%
					if(role_id !=1){
				%>
				<th class="text-center">View Detail</th>
				<th class="text-center">WorkLog Detail</th>
				<%
					}
																if(role_id==1){
				%>
				<th class="text-center">Task WorkLog</th>
				<%
					}
				%>
			</tr>
		</thead>

		<tbody>
		
			<%if(taskList.size()==0){ %>
			<tr>
				<td colspan="6">No data found</td>
			</tr>
			<%
				}else{for(int i=0;i<taskList.size();i++){
															        TaskDto task = taskList.get(i);
			%>
			<tr>
				<td><%=task.getTitle()%></td>
				<td><%=task.getDescription()%></td>
				<td><%=task.getStartDate()%></td>
				<td><%=task.getEndDate()%></td>

				<%
					if(role_id !=1){
				%>
				<td>
					<button type="button" class="btn btn-info" data-toggle="modal"
						id="WorkLogBtn" value="<%=task.getTaskId()%>"
						data-target="#myModal1" onclick="worklog(<%=task.getTaskId()%>)">Add
						WorkLog</button>
				</td>
				<td>
					<button type="button" class="btn btn-info" data-toggle="modal"
						id="WorkLogDetailsBtn" value="<%=task.getTaskId()%>"
						data-target="#myModal2" onclick="demo(<%=task.getTaskId()%>)">WorkLog
						Details</button>
				</td>
				<%
					}
																if(role_id==1){
				%>
				<td><%=task.getDays()%> days <%=task.getHours()%> hours <%=task.getMinutes()%>
					Minutes</td>
				<%
					}
				%>

			</tr>
			<%
				}}
			%>

		</tbody>
	</table>

	<!-- Add Task Form -->
	<form id="login-form" class="text-left"
		action="<%=request.getContextPath()%>/TaskController?action=saveTask"
		method="post">
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog modal-sm ">

				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Add</h4>
					</div>
					<div class="modal-body">

						<div class="form-group">
							<input type="text" class="form-control" placeholder="Title"
								id="taskTitle" name="title" required>
						</div>
						<div class="form-group">
							<textarea type="text" class="form-control"
								placeholder="Description" name="desc" id="taskDesc" required></textarea>
						</div>
						<div class="form-group">
							<input type="text" class="form-control datepicker"
								placeholder="start date" data-provide="datepicker"
								name="startDate" id="startDate" required>
						</div>

						<div class="form-group">
							<input type="text" class="form-control datepicker"
								placeholder="end date" name="endDate" id="endDate" required>
						</div>
						<div class="form-group">
							<select class="form-control" multiple="multiple"
								name="AssignedUsers" required>
								<option>Assign to</option>
								<%
									for(int i=0;i<userList.size();i++){
																																																																						User user = userList.get(i);
								%>
								<option value="<%=user.getUserId()%>"><%=user.getUserName()%></option>
								<%
									}
								%>
							</select>
						</div>
					</div>
					<script type="text/javascript">
						$(document).ready(function(){
							
							$('.datepicker').datepicker({
								 format: 'mm/dd/yyyy',
								    startDate: '-3d'
							});
						});

						</script>
					<div class="modal-footer">
						<input type="submit" class="btn btn-default" value="ADD"
							id="addTask" onclick="validateTask(event)">
						<button type="button" class="btn btn-default" data-dismiss="modal">CANCEL</button>
					</div>
				</div>
			</div>
		</div>
	</form>

	<!-- Add WorkLog Form -->
	<form
		action="<%=request.getContextPath()%>/UserController?action=addWorkLog"
		method="post">
		<div class="modal fade" id="myModal1" role="dialog">
			<div class="modal-dialog modal-sm ">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Add Logs</h4>
					</div>
					<div class="modal-body">

						<div class="form-group">
							<input type="text" class="form-control"
								placeholder="start time Hours" name="startTime" required>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" id="totalTime"
								onblur="validateTimePattern(event)" placeholder="Time spent" name="totalTime"
								required>
						</div>

						<div class="form-group">
							<input type="hidden" class="form-control" id="taskId"
								name="taskId">
						</div>

					</div>
					<div class="modal-footer">
						<input type="submit" onclick="validateTimePattern(event)" 
							class="btn btn-default" value="ADD Worklog" id="addWorklogBtn">
						<button type="button" class="btn btn-default" data-dismiss="modal">CANCEL</button>
					</div>
				</div>
			</div>
		</div>
	</form>

	<div class="modal fade" id="myModal2" role="dialog">
		<div class="modal-dialog modal-sm ">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Work Logs</h4>
				</div>
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">CANCEL</button>
				</div>
			</div>
		</div>
	</div>

	</section>

</body>
</html>