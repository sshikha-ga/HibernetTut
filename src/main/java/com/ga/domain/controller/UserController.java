/*
 * 
 */
package com.ga.domain.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ga.domain.modal.TaskDto;
import com.ga.domain.modal.TimeDto;
import com.ga.persistence.entity.Task;
import com.ga.persistence.entity.User;
import com.ga.persistence.entity.Worklog;
import com.ga.repository.TaskService;
import com.ga.repository.UserService;
import com.ga.repository.impl.TaskServiceImpl;
import com.ga.repository.impl.UserServiceImpl;

/**
 * Servlet implementation class UserController.
 */
public class UserController extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user service. */
	private UserService userService;
	private TaskService taskService;

	/**
	 * Instantiates a new user controller.
	 */
	public UserController() {
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
		doProcess(request, response);
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
		System.out.println("do post");
		doProcess(request, response);
	}

	/**
	 * Do process.
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
	private void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("action").equalsIgnoreCase("WorkLog")) {
			try {
				WorkLog(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (request.getParameter("action")
				.equalsIgnoreCase("addWorkLog")) {
			try {
				addWorkLog(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (request.getParameter("action").equalsIgnoreCase("validateTimePattern")) {
			try {
				validateTimePattern(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Work log.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void WorkLog(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, ServletException,
			IOException {

		int task_id = Integer.parseInt(request.getParameter("task_id"));
		request.setAttribute("task_id", task_id);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/WorkLog.jsp");
		rd.forward(request, response);
	}

	/**
	 * Adds the work log.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void addWorkLog(HttpServletRequest request,
			HttpServletResponse response) throws ClassNotFoundException,
			SQLException, ServletException, IOException {

		Worklog log = new Worklog();
		log.setTaskId(new Task(Integer.parseInt(request.getParameter("taskId"))));
		log.setStartTime(request.getParameter("startTime"));

		String totalTime = request.getParameter("totalTime");
		TimeDto timeDto = splitTime(totalTime);
		log.setTotalDays(String.valueOf(timeDto.getDays()));
		log.setTotalHours(String.valueOf(timeDto.getHours()));
		log.setTotalMinutes(String.valueOf(timeDto.getMinutes()));

		HttpSession session = request.getSession();
		int user_id = (Integer) session.getAttribute("User");
		log.setUserId(new User(user_id));
		Date date = new Date();
		log.setCreatedDate(new SimpleDateFormat("MM-dd-yyyy hh:mm:ss")
				.format(date));

		userService = new UserServiceImpl();
		userService.addWorkLog(log);

		// getTaskDetails(log.getTaskId().getTaskId(), request, response);
		displayTasks(request, response);
	}

	/**
	 * Gets the task details.
	 * 
	 * @param task_id
	 *            the task_id
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
	private void getTaskDetails(int task_id, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		TaskServiceImpl service = new TaskServiceImpl();
		Task task = service.getTaskDetails(task_id);
		request.setAttribute("Task", task);

		userService = new UserServiceImpl();
		ArrayList<Worklog> worklogList = (ArrayList<Worklog>) userService
				.getWorkLogDetails(task_id);

		request.setAttribute("WorkLogList", worklogList);

		RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/TaskDetails.jsp");
		rd.forward(request, response);
	}

	private void displayTasks(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Worklog> worklogList = new ArrayList<Worklog>();
		taskService = new TaskServiceImpl();
		UserServiceImpl userService = new UserServiceImpl();
		List<Task> taskList = taskService.getAllTasks();
		ArrayList<TaskDto> tasklist2 = new ArrayList<TaskDto>();

		int minutes = 0;
		int hours = 0;

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

				hours += Integer.parseInt(worklogList.get(j).getTotalHours());
				minutes += Integer.parseInt(worklogList.get(j)
						.getTotalMinutes());
			}

			taskDto.setHours(hours);
			taskDto.setMinutes(minutes);

			tasklist2.add(taskDto);
			hours = 0;
			minutes = 0;
		}

		taskService = new TaskServiceImpl();
		List<User> userList = taskService.getUsers();
		request.setAttribute("UserList", userList);
		request.setAttribute("TaskList", tasklist2);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Task.jsp");
		rd.forward(request, response);
	}

	private TimeDto splitTime(String totalTime) {

		String num = "", letter = "";
		int days = 0, hours = 0, minutes = 0;
		int count = 1;
		String[] timeArray = totalTime.split(" ");
		for (int i = 0; i < timeArray.length; i++) {

			Matcher matcher = Pattern.compile("\\d+|\\D+")
					.matcher(timeArray[i]);
			while (matcher.find()) {
				if (count == 1) {
					num = matcher.group();
					System.out.println("num :" + num);
					count = 2;
				} else {
					letter = matcher.group();
					System.out.println("letter :" + letter);
					if (letter.equalsIgnoreCase("d")) {
						days = Integer.parseInt(num);
					} else if (letter.equalsIgnoreCase("h")) {
						hours = Integer.parseInt(num);
					} else if (letter.equalsIgnoreCase("m")) {
						minutes = Integer.parseInt(num);
					}

					count = 1;
				}

			}
		}

		TimeDto timeDto = new TimeDto();
		timeDto.setDays(days);
		timeDto.setHours(hours);
		timeDto.setMinutes(minutes);
		System.out.println("Days : " + days + " hours : " + hours
				+ " minutes : " + minutes);
		return timeDto;
	}

	private void validateTimePattern(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		int flag = 0;
		String totalTime = request.getParameter("TotalTime");
		String num = "", letter = "";
		int count = 1;
		String[] timeArray = totalTime.split(" ");
		
		Matcher matcher = Pattern.compile("\\d+[d]\\s\\d+[h]\\s\\d+[m]\\z").matcher(totalTime);
		
		if(matcher.find()){
			flag = 1;
		}
			/*if(timeArray.length!=3){
				System.out.println(timeArray.length);
			}else{
				Matcher matcher = Pattern.compile("\\d+[d]").matcher(timeArray[0]);
				if(matcher.find()){
					matcher = Pattern.compile("\\d+[h]").matcher(timeArray[1]);
					if(matcher.find()){
						matcher = Pattern.compile("\\d+[m]").matcher(timeArray[2]);
						if(matcher.find()){
							flag=1;
						}
					}
				}
			}*/
			PrintWriter out = response.getWriter();
			out.println(flag);
	}

	private boolean checkDigit(String str) {

		int flag = 0;
		for (int j = 0; j < str.length(); j++) {
			if (!Character.isDigit(str.charAt(j))) {
				flag = 1;
				break;
			}
		}

		if (flag == 1) {
			return false;
		}
		return true;
	}

	private boolean checkLetter(String s) {
		
		if(s.length()>1){
			return false;
		}else{
			return Character.isLetter(s.charAt(0));
		}
		
	}
}
