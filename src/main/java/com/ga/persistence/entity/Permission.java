/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ga.persistence.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The Class Permission.
 *
 * @author NIRAJ
 */
@Entity
@Table(name = "permission")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Permission.findAll", query = "SELECT p FROM Permission p"),
        @NamedQuery(name = "Permission.findByPermissionId", query = "SELECT p FROM Permission p WHERE p.permissionId = :permissionId"),
        @NamedQuery(name = "Permission.findByPermissionName", query = "SELECT p FROM Permission p WHERE p.permissionName = :permissionName"),
        @NamedQuery(name = "Permission.findByAction", query = "SELECT p FROM Permission p WHERE p.action = :action") })
public class Permission implements Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The permission id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Permission_Id")
    private Integer permissionId;
    
    /** The permission name. */
    @Column(name = "PermissionName")
    private String permissionName;
    
    /** The action. */
    @Column(name = "Action")
    private String action;
    
    /** The role permission collection. */
    @OneToMany(mappedBy = "permissionId")
    private Collection<RolePermission> rolePermissionCollection;

    /**
     * Instantiates a new permission.
     */
    public Permission() {
    }

    /**
     * Instantiates a new permission.
     *
     * @param permissionId the permission id
     */
    public Permission(Integer permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * Gets the permission id.
     *
     * @return the permission id
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * Sets the permission id.
     *
     * @param permissionId the new permission id
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * Gets the permission name.
     *
     * @return the permission name
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * Sets the permission name.
     *
     * @param permissionName the new permission name
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    /**
     * Gets the action.
     *
     * @return the action
     */
    public String getAction() {
        return action;
    }

    /**
     * Sets the action.
     *
     * @param action the new action
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * Gets the role permission collection.
     *
     * @return the role permission collection
     */
    @XmlTransient
    public Collection<RolePermission> getRolePermissionCollection() {
        return rolePermissionCollection;
    }

    /**
     * Sets the role permission collection.
     *
     * @param rolePermissionCollection the new role permission collection
     */
    public void setRolePermissionCollection(Collection<RolePermission> rolePermissionCollection) {
        this.rolePermissionCollection = rolePermissionCollection;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permissionId != null ? permissionId.hashCode() : 0);
        return hash;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permission)) {
            return false;
        }
        Permission other = (Permission) object;
        if ((this.permissionId == null && other.permissionId != null)
                || (this.permissionId != null && !this.permissionId.equals(other.permissionId))) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Permission [permissionId=" + permissionId + ", permissionName=" + permissionName + ", action=" + action
                + ", rolePermissionCollection=" + rolePermissionCollection + "]";
    }

}
