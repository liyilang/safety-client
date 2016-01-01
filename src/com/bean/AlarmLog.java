package com.bean;



/**
 * AlarmLog entity. @author MyEclipse Persistence Tools
 */

public class AlarmLog  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private User user;
     private Integer alarmType;
     private Long ctime;
     private Integer notifyType;
     private String alarmContent;


    // Constructors

    /** default constructor */
    public AlarmLog() {
    }

    
    /** full constructor */
    public AlarmLog(User user, Integer alarmType, Long ctime, Integer notifyType, String alarmContent) {
        this.user = user;
        this.alarmType = alarmType;
        this.ctime = ctime;
        this.notifyType = notifyType;
        this.alarmContent = alarmContent;
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

    public Integer getAlarmType() {
        return this.alarmType;
    }
    
    public void setAlarmType(Integer alarmType) {
        this.alarmType = alarmType;
    }

    public Long getCtime() {
        return this.ctime;
    }
    
    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public Integer getNotifyType() {
        return this.notifyType;
    }
    
    public void setNotifyType(Integer notifyType) {
        this.notifyType = notifyType;
    }

    public String getAlarmContent() {
        return this.alarmContent;
    }
    
    public void setAlarmContent(String alarmContent) {
        this.alarmContent = alarmContent;
    }
   








}