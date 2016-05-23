/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ga.persistence.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class Assigntask.
 *
 * @author NIRAJ
 */
@Entity
@Table(name = "assigntask")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Assigntask.findAll", query = "SELECT a FROM Assigntask a"),
        @NamedQuery(name = "Assigntask.findById", query = "SELECT a FROM Assigntask a WHERE a.id = :id") })
public class Assigntask implements Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    
    /** The assign task id. */
    @JoinColumn(name = "AssignTask_Id", referencedColumnName = "Task_Id")
    @OneToOne
    private Task assignTaskId;
    
    /** The assign user id. */
    @JoinColumn(name = "AssignUser_Id", referencedColumnName = "User_Id")
    @OneToOne
    private User assignUserId;

    /**
     * Instantiates a new assigntask.
     */
    public Assigntask() {
    }

    /**
     * Instantiates a new assigntask.
     *
     * @param id the id
     */
    public Assigntask(Integer id) {
        this.id = id;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the assign task id.
     *
     * @return the assign task id
     */
    public Task getAssignTaskId() {
        return assignTaskId;
    }

    /**
     * Sets the assign task id.
     *
     * @param assignTaskId the new assign task id
     */
    public void setAssignTaskId(Task assignTaskId) {
        this.assignTaskId = assignTaskId;
    }

    /**
     * Gets the assign user id.
     *
     * @return the assign user id
     */
    public User getAssignUserId() {
        return assignUserId;
    }

    /**
     * Sets the assign user id.
     *
     * @param assignUserId the new assign user id
     */
    public void setAssignUserId(User assignUserId) {
        this.assignUserId = assignUserId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assigntask)) {
            return false;
        }
        Assigntask other = (Assigntask) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Assigntask [id=" + id + ", assignTaskId=" + assignTaskId + ", assignUserId=" + assignUserId + "]";
    }

}
