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
 * The Class Role.
 *
 * @author NIRAJ
 */
@Entity
@Table(name = "role")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
        @NamedQuery(name = "Role.findByRoleId", query = "SELECT r FROM Role r WHERE r.roleId = :roleId"),
        @NamedQuery(name = "Role.findByRoleName", query = "SELECT r FROM Role r WHERE r.roleName = :roleName") })
public class Role implements Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The role id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Role_Id")
    private Integer roleId;
    
    /** The role name. */
    @Column(name = "RoleName")
    private String roleName;
    
    /** The role permission collection. */
    @OneToMany(mappedBy = "roleId")
    private Collection<RolePermission> rolePermissionCollection;
    
    /** The user collection. */
    @OneToMany(mappedBy = "roleId")
    private Collection<User> userCollection;

    /**
     * Instantiates a new role.
     */
    public Role() {
    }

    /**
     * Instantiates a new role.
     *
     * @param roleId the role id
     */
    public Role(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * Gets the role id.
     *
     * @return the role id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * Sets the role id.
     *
     * @param roleId the new role id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * Gets the role name.
     *
     * @return the role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets the role name.
     *
     * @param roleName the new role name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    /**
     * Gets the user collection.
     *
     * @return the user collection
     */
    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    /**
     * Sets the user collection.
     *
     * @param userCollection the new user collection
     */
    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Role [roleId=" + roleId + ", roleName=" + roleName + ", rolePermissionCollection="
                + rolePermissionCollection + ", userCollection=" + userCollection + "]";
    }

}
