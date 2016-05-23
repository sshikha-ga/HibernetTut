/*
 * 
 */
package com.ga.repository.impl;

import java.util.List;

import com.ga.mapper.UserDao;
import com.ga.mapper.impl.UserDaoImpl;
import com.ga.persistence.entity.Worklog;
import com.ga.repository.UserService;

/**
 * The Class UserServiceImpl.
 */
public class UserServiceImpl implements UserService{

	/** The userdao. */
	UserDao userdao;
	
    /* (non-Javadoc)
     * @see com.ga.repository.UserService#addWorkLog(com.ga.persistence.entity.Worklog)
     */
    @Override
    public void addWorkLog(Worklog log) {
          userdao = new UserDaoImpl();
         userdao.addWorkLog(log);
         
    }

    /* (non-Javadoc)
     * @see com.ga.repository.UserService#getWorkLogDetails(int)
     */
    @Override
    public List<Worklog> getWorkLogDetails(int task_id) {
         userdao = new UserDaoImpl();
        return userdao.getWorkLogDetails(task_id);
    }   

}
