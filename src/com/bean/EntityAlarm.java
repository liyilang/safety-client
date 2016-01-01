package com.bean;



/**
 * EntityAlarm entity. @author MyEclipse Persistence Tools
 */

public class EntityAlarm  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Entity entity;
     private AlarmRule alarmRule;


    // Constructors

    /** default constructor */
    public EntityAlarm() {
    }

    
    /** full constructor */
    public EntityAlarm(Entity entity, AlarmRule alarmRule) {
        this.entity = entity;
        this.alarmRule = alarmRule;
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

    public AlarmRule getAlarmRule() {
        return this.alarmRule;
    }
    
    public void setAlarmRule(AlarmRule alarmRule) {
        this.alarmRule = alarmRule;
    }
   








}