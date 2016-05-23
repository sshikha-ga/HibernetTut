/*
 * 
 */
package com.ga.repository.impl;

import java.util.List;

import com.ga.mapper.TaskDao;
import com.ga.mapper.impl.TaskDaoImpl;
import com.ga.persistence.entity.Task;
import com.ga.persistence.entity.User;
import com.ga.repository.TaskService;

/**
 * The Class TaskServiceImpl.
 */

public class TaskServiceImpl implements TaskService {

	/** The task dao. */
	private TaskDao taskDao;
	
    /*return list of tasks*/
    /* (non-Javadoc)
     * @see com.ga.repository.TaskService#getAllTasks()
     */
    public List<Task> getAllTasks() {
         taskDao = new TaskDaoImpl();
        return taskDao.getAllTasks();
    }

    /*add tasks*/
    /* (non-Javadoc)
     * @see com.ga.repository.TaskService#addTask(com.ga.persistence.entity.Task)
     */
    @Override
    public void addTask(Task task,List<User> assignedUserList) {
         taskDao = new TaskDaoImpl();
        taskDao.addTask(task,assignedUserList);
    }

    /*display task details*/
    /* (non-Javadoc)
     * @see com.ga.repository.TaskService#getTaskDetails(int)
     */
    @Override
    public Task getTaskDetails(int task_id) {
         taskDao = new TaskDaoImpl();
        return taskDao.getTaskDetails(task_id);
    }

    /* (non-Javadoc)
     * @see com.ga.repository.TaskService#getUsers()
     */
    @Override
    public List<User> getUsers() {
         taskDao = new TaskDaoImpl();
        return taskDao.getUsers();
    }

    /* (non-Javadoc)
     * @see com.ga.repository.TaskService#getUserList(int)
     */
    @Override
    public User getUserList(int user_id) {
         taskDao = new TaskDaoImpl();
        return taskDao.getUserList(user_id);
    }

	@Override
	public List<Task> getAllTasks(int user_id) {
		taskDao = new TaskDaoImpl();
        return taskDao.getAllTasks(user_id);
	}

}
