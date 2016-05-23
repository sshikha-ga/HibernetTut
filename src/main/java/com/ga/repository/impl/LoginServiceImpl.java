/*
 * 
 */
package com.ga.repository.impl;

import java.util.List;

import com.ga.exception.GAException;
import com.ga.mapper.LoginDao;
import com.ga.mapper.impl.LoginDaoImpl;
import com.ga.persistence.entity.Permission;
import com.ga.persistence.entity.User;
import com.ga.repository.LoginService;

/**
 * The Class LoginServiceImpl.
 */
public class LoginServiceImpl implements LoginService{
    
	/** The login dao. */
	LoginDao loginDao;
	
    /* (non-Javadoc)
     * @see com.ga.repository.LoginService#getLogin(com.ga.persistence.entity.User)
     */
    @Override
    public User getLogin(User user) throws GAException {
         loginDao = new LoginDaoImpl();
        return loginDao.getLogin(user);
    }

    /* (non-Javadoc)
     * @see com.ga.repository.LoginService#getPermission(int)
     */
    @Override
    public List<Permission> getPermission(int role_id){
         loginDao = new LoginDaoImpl();
        return loginDao.getPermission(role_id);
    }
    
}
