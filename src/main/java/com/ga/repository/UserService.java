/*
 * 
 */
package com.ga.repository;

import java.util.List;

import com.ga.persistence.entity.Worklog;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserService.
 */
public interface UserService {
     
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
