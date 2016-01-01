package com.bean;



/**
 * EntityFence entity. @author MyEclipse Persistence Tools
 */

public class EntityFence  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Fence fence;
     private Entity entity;


    // Constructors

    /** default constructor */
    public EntityFence() {
    }

    
    /** full constructor */
    public EntityFence(Fence fence, Entity entity) {
        this.fence = fence;
        this.entity = entity;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Fence getFence() {
        return this.fence;
    }
    
    public void setFence(Fence fence) {
        this.fence = fence;
    }

    public Entity getEntity() {
        return this.entity;
    }
    
    public void setEntity(Entity entity) {
        this.entity = entity;
    }
   








}