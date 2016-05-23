/*
 * 
 */
package com.ga.mapper;

import java.util.List;

import com.ga.persistence.entity.Worklog;

/**
 * The Interface UserDao.
 */
public interface UserDao {
     
     /**
      * Adds the work log.
      *
      * @param log the log
      */
     void addWorkLog(Worklog log);
     
     /**
      * Gets the work log details.
      *
      * @param task_id the task_id
      * @return the work log details
      */
     List<Worklog> getWorkLogDetails(int task_id);
}
