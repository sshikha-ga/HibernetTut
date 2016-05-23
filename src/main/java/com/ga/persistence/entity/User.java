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
import javax.xml.bind.annotation.XmlTransient;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 *
 * @author NIRAJ
 */
@Entity
@Table(name = "user")
@NamedQueries({ @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
        @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
        @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
        @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email") })
public class User implements Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The user id. */
    @Id
    // @Basic(optional = false)
    @Column(name = "User_Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer userId;
    
    /** The user name. */
    @Lob
    @Column(name = "UserName")
    private String userName;
    
    /** The password. */
    @Column(name = "Password")
    private String password;
    
    /** The email. */
    @Column(name = "Email")
    private String email;
    
    /** The task collection. */
    @OneToMany(mappedBy = "createdBy")
    private Collection<Task> taskCollection;
    
    /** The worklog collection. */
    @OneToMany(mappedBy = "userId")
    private Collection<Worklog> worklogCollection;
    
    @OneToMany(mappedBy = "assignUserId",cascade=CascadeType.ALL)
    private Collection<Assigntask> assigntaskCollection;
    
    /** The role id. */
    @JoinColumn(name = "Role_Id", referencedColumnName = "Role_Id")
    @ManyToOne
    private Role roleId;

    /**
     * Instantiates a new user.
     */
    public User() {
    }

    /**
     * Instantiates a new user.
     *
     * @param userId the user id
     */
    public User(Integer userId) {
        this.userId = userId;
    }

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId the new user id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Gets the user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user name.
     *
     * @param userName the new user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the task collection.
     *
     * @return the task collection
     */
    @XmlTransient
    public Collection<Task> getTaskCollection() {
        return taskCollection;
    }

    /**
     * Sets the task collection.
     *
     * @param taskCollection the new task collection
     */
    public void setTaskCollection(Collection<Task> taskCollection) {
        this.taskCollection = taskCollection;
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

    /**
     * Gets the role id.
     *
     * @return the role id
     */
    public Role getRoleId() {
        return roleId;
    }

    /**
     * Sets the role id.
     *
     * @param roleId the new role id
     */
    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
                + "]";
    }    
}
