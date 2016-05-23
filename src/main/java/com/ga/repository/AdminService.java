package com.ga.repository;

import com.ga.exception.GAException;
import com.ga.persistence.entity.User;

public interface AdminService {
	public void saveUser(User user) throws GAException;
}
