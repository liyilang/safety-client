package com.bean;



/**
 * UserRoleId entity. @author MyEclipse Persistence Tools
 */

public class UserRoleId  implements java.io.Serializable {


    // Fields    

     private Integer userId;
     private Integer roleId;


    // Constructors

    /** default constructor */
    public UserRoleId() {
    }

    
    /** full constructor */
    public UserRoleId(Integer userId, Integer roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

   
    // Property accessors

    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
   








}