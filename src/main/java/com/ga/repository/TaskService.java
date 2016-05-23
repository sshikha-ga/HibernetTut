/*
 * 
 */
package com.ga.repository;

import java.util.List;

import com.ga.persistence.entity.Task;
import com.ga.persistence.entity.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface TaskService.
 */
public interface TaskService {
    
    /**
     * Gets the all tasks.
     *
     * @return the all tasks
     */
    List<Task> getAllTasks();
    
    /**
     * Adds the task.
     *
     * @param task the task
     * @param assignedUserList the assigned user list
     */
    void addTask(Task task,List<User> assignedUserList);
    
    /**
     * Gets the task details.
     *
     * @param task_id the task_id
     * @return the task details
     */
    Task getTaskDetails(int task_id);
    
    /**
     * Gets the users.
     *
     * @return the users
     */
    public List<User> getUsers();
    
    /**
     * Gets the user list.
     *
     * @param user_id the user_id
     * @return the user list
     */
    public User getUserList(int user_id);

    List<Task> getAllTasks(int user_id);
}
