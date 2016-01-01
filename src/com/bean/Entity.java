package com.bean;

import java.util.HashSet;
import java.util.Set;


/**
 * Entity entity. @author MyEclipse Persistence Tools
 */

public class Entity  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private User user;
     private String name;
     private Integer rate;
     private Integer cuid;
     private Integer uuid;
     private Long ctime;
     private Long utime;
     private Set gpsPoints = new HashSet(0);
     private Set entityAlarms = new HashSet(0);
     private Set entityStatuses = new HashSet(0);
     private Set entityFences = new HashSet(0);


    // Constructors

    /** default constructor */
    public Entity() {
    }

    
    /** full constructor */
    public Entity(User user, String name, Integer rate, Integer cuid, Integer uuid, Long ctime, Long utime, Set gpsPoints, Set entityAlarms, Set entityStatuses, Set entityFences) {
        this.user = user;
        this.name = name;
        this.rate = rate;
        this.cuid = cuid;
        this.uuid = uuid;
        this.ctime = ctime;
        this.utime = utime;
        this.gpsPoints = gpsPoints;
        this.entityAlarms = entityAlarms;
        this.entityStatuses = entityStatuses;
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

    public Integer getRate() {
        return this.rate;
    }
    
    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getCuid() {
        return this.cuid;
    }
    
    public void setCuid(Integer cuid) {
        this.cuid = cuid;
    }

    public Integer getUuid() {
        return this.uuid;
    }
    
    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public Long getCtime() {
        return this.ctime;
    }
    
    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public Long getUtime() {
        return this.utime;
    }
    
    public void setUtime(Long utime) {
        this.utime = utime;
    }

    public Set getGpsPoints() {
        return this.gpsPoints;
    }
    
    public void setGpsPoints(Set gpsPoints) {
        this.gpsPoints = gpsPoints;
    }

    public Set getEntityAlarms() {
        return this.entityAlarms;
    }
    
    public void setEntityAlarms(Set entityAlarms) {
        this.entityAlarms = entityAlarms;
    }

    public Set getEntityStatuses() {
        return this.entityStatuses;
    }
    
    public void setEntityStatuses(Set entityStatuses) {
        this.entityStatuses = entityStatuses;
    }

    public Set getEntityFences() {
        return this.entityFences;
    }
    
    public void setEntityFences(Set entityFences) {
        this.entityFences = entityFences;
    }
   








}