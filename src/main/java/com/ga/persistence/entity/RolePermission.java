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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class RolePermission.
 *
 * @author NIRAJ
 */
@Entity
@Table(name = "role_permission")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "RolePermission.findAll", query = "SELECT r FROM RolePermission r"),
        @NamedQuery(name = "RolePermission.findById", query = "SELECT r FROM RolePermission r WHERE r.id = :id") })
public class RolePermission implements Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    
    /** The permission id. */
    @JoinColumn(name = "Permission_Id", referencedColumnName = "Permission_Id")
    @ManyToOne
    private Permission permissionId;
    
    /** The role id. */
    @JoinColumn(name = "Role_Id", referencedColumnName = "Role_Id")
    @ManyToOne
    private Role roleId;

    /**
     * Instantiates a new role permission.
     */
    public RolePermission() {
    }

    /**
     * Instantiates a new role permission.
     *
     * @param id the id
     */
    public RolePermission(Integer id) {
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
     * Gets the permission id.
     *
     * @return the permission id
     */
    public Permission getPermissionId() {
        return permissionId;
    }

    /**
     * Sets the permission id.
     *
     * @param permissionId the new permission id
     */
    public void setPermissionId(Permission permissionId) {
        this.permissionId = permissionId;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolePermission)) {
            return false;
        }
        RolePermission other = (RolePermission) object;
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
        return "RolePermission [id=" + id + ", permissionId=" + permissionId + ", roleId=" + roleId + "]";
    }

}
