package com.bean;



/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String roleName;
     private String description;
     private Integer cuid;
     private Integer uuid;
     private Long ctime;
     private Long utime;


    // Constructors

    /** default constructor */
    public Role() {
    }

    
    /** full constructor */
    public Role(String roleName, String description, Integer cuid, Integer uuid, Long ctime, Long utime) {
        this.roleName = roleName;
        this.description = description;
        this.cuid = cuid;
        this.uuid = uuid;
        this.ctime = ctime;
        this.utime = utime;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
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
   








}