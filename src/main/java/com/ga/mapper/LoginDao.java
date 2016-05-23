package com.ga.mapper;

import java.util.List;

import com.ga.exception.GAException;
import com.ga.persistence.entity.Permission;
import com.ga.persistence.entity.User;

/**
 * The Interface LoginDao.
 */
public interface LoginDao {
    
    /**
     * Gets the login.
     *
     * @param user the user
     * @return the login
     * @throws GAException 
     */
    public User getLogin(User user) throws GAException;
    
    /**
     * Gets the permission.
     *
     * @param role_id the role_id
     * @return the permission
     * @throws GAException 
     */
    public List<Permission> getPermission(int role_id);
}
