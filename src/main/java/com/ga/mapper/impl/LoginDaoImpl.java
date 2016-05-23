/*
 * 
 */
package com.ga.mapper.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ga.common.ErrorCodes;
import com.ga.domain.util.HibernateUtil;
import com.ga.exception.GAException;
import com.ga.mapper.LoginDao;
import com.ga.persistence.entity.Permission;
import com.ga.persistence.entity.User;

/**
 * The Class LoginDaoImpl.
 */
public class LoginDaoImpl implements LoginDao {

    /** The sql get login. */
    public static String SQL_GET_LOGIN = "from User where UserName = :UserName AND Password = :Password";
    
    /** The sql get permission. */
    public static String SQL_GET_PERMISSION = "from Permission where permissionId IN (select permissionId from RolePermission where roleId.roleId = :roleId)";

    
    /* (non-Javadoc)
     * @see com.ga.mapper.LoginDao#getLogin(com.ga.persistence.entity.User)
     */
    public User getLogin(User user) throws GAException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery(SQL_GET_LOGIN);
        query.setParameter("UserName", user.getUserName());
        query.setParameter("Password", user.getPassword());
        List<User> userList = query.list();

        Iterator<User> iterator = userList.iterator();
        User userObj = new User();

        if (iterator.hasNext()) {
            userObj = iterator.next();
        }else{
        	
        	throw new GAException(ErrorCodes.GA_AUTH_FAILED);
        }

        return userObj;

    }

    /*get permissions of the user by role*/
    /* (non-Javadoc)
     * @see com.ga.mapper.LoginDao#getPermission(int)
     */
    public List<Permission> getPermission(int role_id){

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery(SQL_GET_PERMISSION);
        query.setParameter("roleId", role_id);
        List<Permission> permissionList = query.list();
        return permissionList;
    }

}
