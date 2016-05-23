package com.ga.mapper.impl;

import org.hibernate.classic.Session;

import com.ga.domain.util.HibernateUtil;
import com.ga.exception.GAException;
import com.ga.mapper.AdminDao;
import com.ga.persistence.entity.User;

public class AdminDaoImpl implements AdminDao {

	@Override
	public void saveUser(User user) throws GAException{
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

}
