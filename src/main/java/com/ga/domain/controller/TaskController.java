/*
 * 
 */
package com.ga.domain.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ga.domain.modal.TaskDto;
import com.ga.domain.modal.TempDTO;
import com.ga.domain.modal.TimeDto;
import com.ga.persistence.entity.Task;
import com.ga.persistence.entity.User;
import com.ga.persistence.entity.Worklog;
import com.ga.repository.TaskService;
import com.ga.repository.UserService;
import com.ga.repository.impl.TaskServiceImpl;
import com.ga.repository.impl.UserServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class TaskController.
 */
public class TaskController extends HttpServlet {

	/** The service. */
	TaskService taskService;
	UserService userService;
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new task controller.
	 */
	public TaskController() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			doProgress(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			doProgress(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Do progress.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws Exception
	 */
	protected void doProgress(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/*
		 * display list of all the task and disply recent tasks on the top of
		 * list
		 */
		if (request.getParameter("action").equalsIgnoreCase("displayTask")) {

			displayTasks(request, response);
		}
		/* Forwards to add Task Jsp */
		else if (request.getParameter("action").equalsIgnoreCase("addTask")) {

			taskService = new TaskServiceImpl();
			List<User> userList = taskService.getUsers();
			request.setAttribute("UserList", userList);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/AddTask.jsp");
			rd.forward(request, response);
		}
		/* create task */
		else if (request.getParameter("action").equalsIgnoreCase("saveTask")) {
			System.out.println("on action");
			addTask(request, response);
		}
		/* display details of particular task */
		else if (request.getParameter("action").equalsIgnoreCase(
				"getTaskDetails")) {
			Gson gson = new Gson();
			PrintWriter out = response.getWriter();
			ArrayList<TempDTO> worklogList = getTaskDetails(request, response);
			String output = gson.toJson(worklogList);
			out.print(output);

		}
		/* Forwards to index */
		else if (request.getParameter("action").equalsIgnoreCase("displayMenu")) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}

	}

	/**
	 * Display tasks.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void displayTasks(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		int user_id = (Integer) session.getAttribute("User");
		int role_id = (Integer) session.getAttribute("UserRoleId");

		ArrayList<Worklog> worklogList = new ArrayList<Worklog>();
		taskService = new TaskServiceImpl();
		userService = new UserServiceImpl();
		List<Task> taskList = new ArrayList<Task>();
		if (role_id == 1) {
			taskList = taskService.getAllTasks();
		} else {
			taskList = taskService.getAllTasks(user_id);
		}

		ArrayList<TaskDto> tasklist2 = new ArrayList<TaskDto>();

		int minutes = 0;
		int hours = 0;
		int days = 0;

		for (int i = 0; i < taskList.size(); i++) {

			Task task = taskList.get(i);
			TaskDto taskDto = new TaskDto();
			taskDto.setTaskId(task.getTaskId());
			taskDto.setTitle(task.getTitle());
			taskDto.setDescription(task.getDescription());
			taskDto.setStartDate(task.getStartDate());
			taskDto.setEndDate(task.getEndDate());
			taskDto.setCreatedBy(task.getCreatedBy().getUserId());

			worklogList = (ArrayList<Worklog>) userService
					.getWorkLogDetails(task.getTaskId());

			for (int j = 0; j < worklogList.size(); j++) {

				days += Integer.parseInt(worklogList.get(j).getTotalDays());
				hours += Integer.parseInt(worklogList.get(j).getTotalHours());
				minutes += Integer.parseInt(worklogList.get(j)
						.getTotalMinutes());
			}

			TimeDto timeDto = ConvertTime(String.valueOf(days),
					String.valueOf(hours), String.valueOf(minutes));

			taskDto.setDays(timeDto.getDays());
			taskDto.setHours(timeDto.getHours());
			taskDto.setMinutes(timeDto.getMinutes());

			tasklist2.add(taskDto);
			hours = 0;
			minutes = 0;
		}

		taskService = new TaskServiceImpl();
		List<User> userList = taskService.getUsers();
		List<User> newUserList = getUsers(userList,request);
		request.setAttribute("UserList", newUserList);
		request.setAttribute("TaskList", tasklist2);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Task.jsp");
		rd.forward(request, response);
	}

	/**
	 * Adds the task.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void addTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			Exception {
		System.out.println("addtask");
		taskService = new TaskServiceImpl();
		Task task = new Task();
		task.setTitle(request.getParameter("title"));
		System.out.println(request.getParameter("title"));
		task.setDescription(request.getParameter("desc"));
		task.setStartDate(request.getParameter("startDate"));
		task.setEndDate(request.getParameter("endDate"));
		HttpSession session = request.getSession();
		Date date = new Date();
		task.setCreatedDate(new SimpleDateFormat("MM-dd-yyyy hh:mm:ss")
				.format(date));
		task.setCreatedBy(new User((Integer) session.getAttribute("User")));

		String[] assignedUser = request.getParameterValues("AssignedUsers");
		System.out.println("assignedUser size " + assignedUser.length);

		List<String> assignedUserList = new ArrayList<String>(
				Arrays.asList(assignedUser));
		// assignedUserList.add(String.valueOf(task.getCreatedBy().getUserId()));
		System.out.println("assignedUserList size " + assignedUserList.size());
		List<User> userList = new ArrayList<User>();

		for (int i = 0; i < assignedUserList.size(); i++) {
			System.out.println("assignedUserList.get(i) " + assignedUserList.get(i));
			User user = taskService.getUserList(Integer.parseInt(assignedUserList.get(i)));
			if (user == null) {
				throw new Exception();
			}
			System.out.println("user on task :" + user.toString());

			userList.add(user);
		}
		System.out.println("task.getCreatedBy() "+task.getCreatedBy().toString());
		userList.add(task.getCreatedBy());
		taskService.addTask(task, userList);
		System.out.println("assign task added bnow go for display task");
		
		response.sendRedirect("TaskController?action=displayTask");
	}

	/**
	 * Gets the task details.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the task details
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private ArrayList<TempDTO> getTaskDetails(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int task_id = Integer.parseInt(request.getParameter("Task_Id"));

		userService = new UserServiceImpl();
		ArrayList<Worklog> worklogList = (ArrayList<Worklog>) userService
				.getWorkLogDetails(task_id);
		System.out.println("worklogList : " + worklogList);
		ArrayList<TempDTO> tempDTOList = new ArrayList<TempDTO>();
		for (Worklog worklog : worklogList) {
			TempDTO dto = new TempDTO();
			dto.setWorkLogId(worklog.getWorkLogId());

			TimeDto timeDto = ConvertTime(worklog.getTotalDays(),
					worklog.getTotalHours(), worklog.getTotalMinutes());

			dto.setTotalDays(String.valueOf(timeDto.getDays()));
			dto.setTotalHours(String.valueOf(timeDto.getHours()));
			dto.setTotalMinutes(String.valueOf(timeDto.getMinutes()));
			dto.setStartTime(worklog.getStartTime());
			dto.setUserId(worklog.getUserId().getUserId());
			dto.setUserName(worklog.getUserId().getUserName());
			tempDTOList.add(dto);
		}
		return tempDTOList;
	}

	private TimeDto ConvertTime(String days, String hours, String minutes) {

		TimeDto timeDto = new TimeDto();
		int day = Integer.parseInt(days);
		int hour = Integer.parseInt(hours);
		int minute = Integer.parseInt(minutes);

		while ((minute - 60) > 0) {
			hour++;
			minute = minute - 60;
		}

		while ((hour - 8) > 0) {
			day++;
			hour = hour - 8;
		}

		timeDto.setDays(day);
		timeDto.setHours(hour);
		timeDto.setMinutes(minute);
		return timeDto;
	}
	
	private List<User> getUsers(List<User> userList,HttpServletRequest request){
		
		HttpSession session = request.getSession();
		int user_id = (Integer) session.getAttribute("User");
		List<User> newUserList = new ArrayList<User>();
		Iterator<User> iterator = userList.iterator();
		
		while(iterator.hasNext()){
			User user = iterator.next();
			if(user.getUserId()==user_id){
				continue;
			}
			newUserList.add(user);
		}
		return newUserList;
	}

}
