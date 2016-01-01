package com.bean;



/**
 * Permission entity. @author MyEclipse Persistence Tools
 */

public class Permission  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String permission;
     private String description;


    // Constructors

    /** default constructor */
    public Permission() {
    }

    
    /** full constructor */
    public Permission(String permission, String description) {
        this.permission = permission;
        this.description = description;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermission() {
        return this.permission;
    }
    
    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
   








}