package com.ga.repository.impl;

import com.ga.exception.GAException;
import com.ga.mapper.AdminDao;
import com.ga.mapper.impl.AdminDaoImpl;
import com.ga.persistence.entity.User;
import com.ga.repository.AdminService;

public class AdminServiceImpl implements AdminService{

	AdminDao adminDao;
	
	@Override
	public void saveUser(User user) throws GAException {
		adminDao = new AdminDaoImpl();
		adminDao.saveUser(user);
	}

}
