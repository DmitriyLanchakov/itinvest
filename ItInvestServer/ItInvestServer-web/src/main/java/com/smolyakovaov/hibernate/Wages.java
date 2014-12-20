package com.smolyakovaov.hibernate;
// Generated 18.12.2014 2:18:48 by Hibernate Tools 4.3.1



/**
 * Wages generated by hbm2java
 */
public class Wages  implements java.io.Serializable {


     private Integer id;
     private Project project;
     private double seos;
     private double architects;
     private double designers;
     private double developers;
     private double testers;
     private double supports;

    public Wages() {
    }

    public Wages(Project project, double seos, double architects, double designers, double developers, double testers, double supports) {
       this.project = project;
       this.seos = seos;
       this.architects = architects;
       this.designers = designers;
       this.developers = developers;
       this.testers = testers;
       this.supports = supports;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Project getProject() {
        return this.project;
    }
    
    public void setProject(Project project) {
        this.project = project;
    }
    public double getSeos() {
        return this.seos;
    }
    
    public void setSeos(double seos) {
        this.seos = seos;
    }
    public double getArchitects() {
        return this.architects;
    }
    
    public void setArchitects(double architects) {
        this.architects = architects;
    }
    public double getDesigners() {
        return this.designers;
    }
    
    public void setDesigners(double designers) {
        this.designers = designers;
    }
    public double getDevelopers() {
        return this.developers;
    }
    
    public void setDevelopers(double developers) {
        this.developers = developers;
    }
    public double getTesters() {
        return this.testers;
    }
    
    public void setTesters(double testers) {
        this.testers = testers;
    }
    public double getSupports() {
        return this.supports;
    }
    
    public void setSupports(double supports) {
        this.supports = supports;
    }




}

