package com.bean;

import java.util.HashSet;
import java.util.Set;


/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String salt;
     private String password;
     private Integer age;
     private Integer sex;
     private String phone;
     private String email;
     private Integer uuid;
     private Integer cuid;
     private Long utime;
     private Long ctime;
     private Set alarmRules = new HashSet(0);
     private Set fences = new HashSet(0);
     private Set entities = new HashSet(0);
     private Set alarmLogs = new HashSet(0);


    // Constructors

    /** default constructor */
    public User() {
    }

    
    /** full constructor */
    public User(String name, String salt, String password, Integer age, Integer sex, String phone, String email, Integer uuid, Integer cuid, Long utime, Long ctime, Set alarmRules, Set fences, Set entities, Set alarmLogs) {
        this.name = name;
        this.salt = salt;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.uuid = uuid;
        this.cuid = cuid;
        this.utime = utime;
        this.ctime = ctime;
        this.alarmRules = alarmRules;
        this.fences = fences;
        this.entities = entities;
        this.alarmLogs = alarmLogs;
    }
    
    public User(String name,String password, String phone) {
        this.name = name;
        this.password = password;
        this.phone = phone;
      
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getSalt() {
        return this.salt;
    }
    
    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return this.sex;
    }
    
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUuid() {
        return this.uuid;
    }
    
    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public Integer getCuid() {
        return this.cuid;
    }
    
    public void setCuid(Integer cuid) {
        this.cuid = cuid;
    }

    public Long getUtime() {
        return this.utime;
    }
    
    public void setUtime(Long utime) {
        this.utime = utime;
    }

    public Long getCtime() {
        return this.ctime;
    }
    
    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public Set getAlarmRules() {
        return this.alarmRules;
    }
    
    public void setAlarmRules(Set alarmRules) {
        this.alarmRules = alarmRules;
    }

    public Set getFences() {
        return this.fences;
    }
    
    public void setFences(Set fences) {
        this.fences = fences;
    }

    public Set getEntities() {
        return this.entities;
    }
    
    public void setEntities(Set entities) {
        this.entities = entities;
    }

    public Set getAlarmLogs() {
        return this.alarmLogs;
    }
    
    public void setAlarmLogs(Set alarmLogs) {
        this.alarmLogs = alarmLogs;
    }
   








}