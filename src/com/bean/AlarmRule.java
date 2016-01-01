package com.bean;

import java.util.HashSet;
import java.util.Set;


/**
 * AlarmRule entity. @author MyEclipse Persistence Tools
 */

public class AlarmRule  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private User user;
     private byte[] name;
     private Integer type;
     private Integer notifyType;
     private Integer status;
     private Set entityAlarms = new HashSet(0);


    // Constructors

    /** default constructor */
    public AlarmRule() {
    }

    
    /** full constructor */
    public AlarmRule(User user, byte[] name, Integer type, Integer notifyType, Integer status, Set entityAlarms) {
        this.user = user;
        this.name = name;
        this.type = type;
        this.notifyType = notifyType;
        this.status = status;
        this.entityAlarms = entityAlarms;
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

    public byte[] getName() {
        return this.name;
    }
    
    public void setName(byte[] name) {
        this.name = name;
    }

    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNotifyType() {
        return this.notifyType;
    }
    
    public void setNotifyType(Integer notifyType) {
        this.notifyType = notifyType;
    }

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set getEntityAlarms() {
        return this.entityAlarms;
    }
    
    public void setEntityAlarms(Set entityAlarms) {
        this.entityAlarms = entityAlarms;
    }
   








}