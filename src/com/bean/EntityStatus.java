package com.bean;



/**
 * EntityStatus entity. @author MyEclipse Persistence Tools
 */

public class EntityStatus  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Entity entity;
     private Double battery;
     private Integer rate;
     private Integer status;
     private Long utime;


    // Constructors

    /** default constructor */
    public EntityStatus() {
    }

    
    /** full constructor */
    public EntityStatus(Entity entity, Double battery, Integer rate, Integer status, Long utime) {
        this.entity = entity;
        this.battery = battery;
        this.rate = rate;
        this.status = status;
        this.utime = utime;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Entity getEntity() {
        return this.entity;
    }
    
    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Double getBattery() {
        return this.battery;
    }
    
    public void setBattery(Double battery) {
        this.battery = battery;
    }

    public Integer getRate() {
        return this.rate;
    }
    
    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getUtime() {
        return this.utime;
    }
    
    public void setUtime(Long utime) {
        this.utime = utime;
    }
   








}