/*
 * 
 */
package com.ga.repository;

import java.util.List;

import com.ga.persistence.entity.Task;
import com.ga.persistence.entity.User;

public interface TaskService {
    
    List<Task> getAllTasks();
    void addTask(Task task,List<User> assignedUserList);
    Task getTaskDetails(int task_id);
    public List<User> getUsers();
    public User getUserList(int user_id);
}
