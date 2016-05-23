package com.ga.domain.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ga.exception.GAException;
import com.ga.persistence.entity.Role;
import com.ga.persistence.entity.User;
import com.ga.repository.AdminService;
import com.ga.repository.impl.AdminServiceImpl;

public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
    public AdminController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProgress(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProgress(request, response);
	}
	
	protected void doProgress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("action").equalsIgnoreCase("RegisterUser")){
            try {
                
            	RequestDispatcher rd = request.getRequestDispatcher("/jsp/UserRegister.jsp");
            	rd.forward(request, response);
            	
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(request.getParameter("action").equalsIgnoreCase("saveUser")){
            try {
                
            	saveUser(request,response);
            	
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		
	}
	
	public void saveUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		User user = new User();
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setRoleId(new Role(Integer.parseInt(request.getParameter("role"))));
		
		System.out.println(user.getRoleId().getRoleId());
		
		AdminService service = new AdminServiceImpl();
		try {
			service.saveUser(user);
		} catch (GAException e) {
			Logger logger = Logger.getLogger("AdminController");
			logger.info("User could not be registered");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Home.jsp");
		rd.forward(request, response);
		
	}

}
