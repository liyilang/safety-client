package com.bean;



/**
 * RolePermissionId entity. @author MyEclipse Persistence Tools
 */

public class RolePermissionId  implements java.io.Serializable {


    // Fields    

     private Integer roleId;
     private Integer permissionId;


    // Constructors

    /** default constructor */
    public RolePermissionId() {
    }

    
    /** full constructor */
    public RolePermissionId(Integer roleId, Integer permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

   
    // Property accessors

    public Integer getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return this.permissionId;
    }
    
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
   








}