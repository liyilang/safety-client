package com.bean;

import java.util.HashSet;
import java.util.Set;


/**
 * Fence entity. @author MyEclipse Persistence Tools
 */

public class Fence  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private User user;
     private String name;
     private String geometry;
     private Integer status;
     private Integer type;
     private Set entityFences = new HashSet(0);


    // Constructors

    /** default constructor */
    public Fence() {
    }

    
    /** full constructor */
    public Fence(User user, String name, String geometry, Integer status, Integer type, Set entityFences) {
        this.user = user;
        this.name = name;
        this.geometry = geometry;
        this.status = status;
        this.type = type;
        this.entityFences = entityFences;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getGeometry() {
        return this.geometry;
    }
    
    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }

    public Set getEntityFences() {
        return this.entityFences;
    }
    
    public void setEntityFences(Set entityFences) {
        this.entityFences = entityFences;
    }
   








}