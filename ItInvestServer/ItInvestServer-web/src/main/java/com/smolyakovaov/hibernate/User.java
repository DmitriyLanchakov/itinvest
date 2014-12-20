package com.smolyakovaov.hibernate;
// Generated 18.12.2014 2:18:48 by Hibernate Tools 4.3.1


/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private Integer id;
     private Group group;
     private String login;
     private String password;
     private String firstname;
     private String lastname;
     private String organization;
     private String email;
     private String address;

    public User() {
    }

	
    public User(Group group, String login, String password) {
        this.group = group;
        this.login = login;
        this.password = password;
    }
    public User(Group group, String login, String password, String firstname, String lastname, String organization, String email, String address) {
       this.group = group;
       this.login = login;
       this.password = password;
       this.firstname = firstname;
       this.lastname = lastname;
       this.organization = organization;
       this.email = email;
       this.address = address;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Group getGroup() {
        return this.group;
    }
    
    public void setGroup(Group group) {
        this.group = group;
    }
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstname() {
        return this.firstname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return this.lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getOrganization() {
        return this.organization;
    }
    
    public void setOrganization(String organization) {
        this.organization = organization;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
}


