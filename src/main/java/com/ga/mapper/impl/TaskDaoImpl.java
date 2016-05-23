/*
 * 
 */
package com.ga.mapper.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ga.domain.util.HibernateUtil;
import com.ga.mapper.TaskDao;
import com.ga.persistence.entity.Assigntask;
import com.ga.persistence.entity.Task;
import com.ga.persistence.entity.User;

/**
 * The Class TaskDaoImpl.
 */
public class TaskDaoImpl implements TaskDao {

	private static String SQL_FIND_BY_USERID = "SELECT u FROM User u WHERE u.userId = :userId";
	private static String SQL_FIND_TASKS_BY_USERID = "FROM Task WHERE taskId IN (SELECT assignTaskId FROM Assigntask WHERE assignUserId.userId = :userId) Order By createdDate Desc ";
	
    /*return list of tasks*/
    /* (non-Javadoc)
     * @see com.ga.mapper.TaskDao#getAllTasks()
     */
    public List<Task> getAllTasks() {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.getNamedQuery("Task.findAll");
        List<Task> listTask = query.list();
        
        return listTask;
    }

    /*add tasks*/
    /* (non-Javadoc)
     * @see com.ga.mapper.TaskDao#addTask(com.ga.persistence.entity.Task)
     */
    @Override
	public void addTask(Task task, List<User> assignedUserList) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.saveOrUpdate(task);

		for (int i = 0; i < assignedUserList.size();i++){
            Assigntask assigntask = new Assigntask();
            assigntask.setAssignUserId(assignedUserList.get(i));
            //assigntask.setAssignTaskId(new Task(task.getTaskId()));
            assigntask.setAssignTaskId(task);
            session.saveOrUpdate(assigntask);
            System.out.println("assign task add");            
        }        
        session.getTransaction().commit();
        session.close();
    }

    
    /* (non-Javadoc)
     * @see com.ga.mapper.TaskDao#getUserList(int)
     */
    public User getUserList(int user_id){
        System.out.println("in getUserList() "+user_id);
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Query query = session.createQuery(SQL_FIND_BY_USERID);
        query.setParameter("userId",user_id);
        List<User> userList = query.list();
        System.out.println("size :"+userList.size());
        for(User user : userList){
        	System.out.println("user :"+user.toString());
        }
        
        return userList.get(0);
    }
    /*display task details*/
    /* (non-Javadoc)
     * @see com.ga.mapper.TaskDao#getTaskDetails(int)
     */
    @Override
    public Task getTaskDetails(int task_id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.getNamedQuery("Task.findByTaskId");
        query.setParameter("taskId", task_id);
        List<Task> tasklist = query.list();
        
        Iterator<Task> iterator = tasklist.iterator();
        Task task = new Task();
        
        if(iterator.hasNext()){
            task = iterator.next();
        }
        
        return task;
    }
    
    /* (non-Javadoc)
     * @see com.ga.mapper.TaskDao#getUsers()
     */
    public List<User> getUsers(){

           Session session = HibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           Query query = session.getNamedQuery("User.findAll");
           
           List<User> userList = query.list();
           return userList;
    }

	@Override
	public List<Task> getAllTasks(int user_id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery(SQL_FIND_TASKS_BY_USERID);
        query.setParameter("userId", user_id);
        List<Task> listTask = query.list();

        return listTask;
	}

}
