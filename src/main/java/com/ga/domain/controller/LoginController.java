/*
 * 
 */
package com.ga.domain.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ga.common.ErrorCodes;
import com.ga.exception.GAException;
import com.ga.persistence.entity.Permission;
import com.ga.persistence.entity.User;
import com.ga.repository.LoginService;
import com.ga.repository.impl.LoginServiceImpl;

/**
 * The Class LoginController.
 */
public class LoginController extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	private LoginService loginService;

	/**
	 * Instantiates a new login controller.
	 */
	public LoginController() {
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
		if (request.getParameter("action").equalsIgnoreCase("login")) {
			try {
				checkLogin(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (request.getParameter("action").equalsIgnoreCase("logout")) {
			
			HttpSession session = request.getSession();
			session.setAttribute("UserName", null);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}

	}

	/**
	 * Check login.
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
	public void checkLogin(HttpServletRequest request,
			HttpServletResponse response) throws ClassNotFoundException,
			SQLException, ServletException, IOException {

		RequestDispatcher rd = null;
		User user = new User();
		user.setUserName(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));

		loginService = new LoginServiceImpl();
		User user1 = null;
		try {
			user1 = loginService.getLogin(user);
		} catch (GAException e) {

			if (e.getCode() == ErrorCodes.GA_AUTH_FAILED.getErrorCode()) {
				System.out.println(e.getCode());
				request.setAttribute("LoginMsg", "Wrong user name or password");
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}

		ArrayList<Permission> permissionList = new ArrayList<Permission>();

		try {

			permissionList = (ArrayList<Permission>) loginService.getPermission(user1.getRoleId().getRoleId());
			System.out.println("permission size :: " + permissionList.size());
			rd = request.getRequestDispatcher("/TaskController?action=displayTask");
			request.setAttribute("Permissions", permissionList);
			HttpSession session = request.getSession();
			session.setAttribute("Permissions", permissionList);
			session.setAttribute("User", user1.getUserId());
			session.setAttribute("UserName", user1.getUserName());
			session.setAttribute("UserRoleId", user1.getRoleId().getRoleId());
			rd.forward(request, response);
			
		} catch (NullPointerException e) {
			Logger logger = Logger.getLogger("TaskController");
			logger.info("Permissions Not Found");
		} 

	}
}
