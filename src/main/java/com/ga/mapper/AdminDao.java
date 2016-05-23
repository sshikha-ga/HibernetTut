package com.ga.mapper;

import com.ga.exception.GAException;
import com.ga.persistence.entity.User;

public interface AdminDao {
	public void saveUser(User user) throws GAException;
}
