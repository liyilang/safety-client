package com.bean;



/**
 * GpsPoint entity. @author MyEclipse Persistence Tools
 */

public class GpsPoint  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Entity entity;
     private Double lat;
     private Double lng;
     private Long utime;
     private String geohash;


    // Constructors

    /** default constructor */
    public GpsPoint() {
    }

    
    /** full constructor */
    public GpsPoint(Entity entity, Double lat, Double lng, Long utime, String geohash) {
        this.entity = entity;
        this.lat = lat;
        this.lng = lng;
        this.utime = utime;
        this.geohash = geohash;
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

    public Double getLat() {
        return this.lat;
    }
    
    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return this.lng;
    }
    
    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Long getUtime() {
        return this.utime;
    }
    
    public void setUtime(Long utime) {
        this.utime = utime;
    }

    public String getGeohash() {
        return this.geohash;
    }
    
    public void setGeohash(String geohash) {
        this.geohash = geohash;
    }
   








}