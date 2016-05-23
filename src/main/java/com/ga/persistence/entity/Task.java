/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ga.persistence.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The Class Task.
 *
 * @author NIRAJ
 */
@Entity
@Table(name = "task")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t Order By t.createdDate Desc"),
        @NamedQuery(name = "Task.findByTaskId", query = "SELECT t FROM Task t WHERE t.taskId = :taskId") })
public class Task implements Serializable {
    
    /** The worklog collection. */
    @OneToMany(mappedBy = "taskId")
    private Collection<Worklog> worklogCollection;
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The task id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Task_Id")
    private Integer taskId;
    
    /** The title. */
    @Lob
    @Column(name = "Title")
    private String title;
    
    /** The description. */
    @Lob
    @Column(name = "Description")
    private String description;
    
    /** The start date. */
    @Lob
    @Column(name = "StartDate")
    private String startDate;
    
    /** The end date. */
    @Lob
    @Column(name = "EndDate")
    private String endDate;
    
    /** The created date. */
    @Lob
    @Column(name = "CreatedDate")
    private String createdDate;
    
    /** The created by. */
    @JoinColumn(name = "CreatedBy", referencedColumnName = "User_Id")
    @ManyToOne(cascade=CascadeType.PERSIST)
    private User createdBy;

    @OneToMany(mappedBy = "assignTaskId",cascade=CascadeType.ALL)
    private Collection<Assigntask> assigntaskCollection;
    /**
     * Instantiates a new task.
     */
    public Task() {
    }

    /**
     * Instantiates a new task.
     *
     * @param taskId the task id
     */
    public Task(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * Gets the task id.
     *
     * @return the task id
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * Sets the task id.
     *
     * @param taskId the new task id
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the start date.
     *
     * @return the start date
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date.
     *
     * @param startDate the new start date
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the end date.
     *
     * @return the end date
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date.
     *
     * @param endDate the new end date
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets the created date.
     *
     * @return the created date
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the created date.
     *
     * @param createdDate the new created date
     */
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Gets the created by.
     *
     * @return the created by
     */
    public User getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the created by.
     *
     * @param createdBy the new created by
     */
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskId != null ? taskId.hashCode() : 0);
        return hash;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.taskId == null && other.taskId != null) || (this.taskId != null && !this.taskId.equals(other.taskId))) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Task [worklogCollection=" + worklogCollection + ", taskId=" + taskId + ", title=" + title
                + ", description=" + description + ", startDate=" + startDate + ", endDate=" + endDate
                + ", createdDate=" + createdDate + ", createdBy=" + createdBy + "]";
    }

    /**
     * Gets the worklog collection.
     *
     * @return the worklog collection
     */
    @XmlTransient
    public Collection<Worklog> getWorklogCollection() {
        return worklogCollection;
    }

    /**
     * Sets the worklog collection.
     *
     * @param worklogCollection the new worklog collection
     */
    public void setWorklogCollection(Collection<Worklog> worklogCollection) {
        this.worklogCollection = worklogCollection;
    }

}
