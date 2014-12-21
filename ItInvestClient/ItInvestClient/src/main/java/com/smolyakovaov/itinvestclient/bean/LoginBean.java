/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.itinvestclient.bean;

import com.smolyakovaov.ws.User;
import com.smolyakovaov.ws.UserService;
import com.smolyakovaov.ws.UserService_Service;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Honaht
 */
public class LoginBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ItInvestServer-web/UserService.wsdl")
    private UserService_Service service;

    private User currentUser;
    private String login;
    private String password;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Creates a new instance of LoginWS
     */
    public LoginBean() {
    }

    /*public void setSessionValue(String name, Object value) {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        session.setAttribute(name, value);
    }*/

    public void auth() throws IOException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        System.err.println("--> Auth begin!");
        if (login != null && password != null) {
            try { // Call Web Service Operation
                UserService port = service.getUserServicePort();
                // TODO process result here
                User result = port.loginUser(login, password);
                System.err.println("--> User, getting from base: " + result);
                if (result != null) {
                    //setSessionValue("user", result);
                    currentUser=result;
                    password = "";
                    context.redirect(context.getRequestContextPath() + "/index.jsf");
                } else {
                    //setSessionValue("user", null);
                    currentUser=null;
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", "Неверный логин или пароль."));
                }
            } catch (Exception ex) {
                System.err.println("--> Auth exception: " + ex.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
            }
        }
    }

    public void logout() throws IOException {
        //setSessionValue("user", null);
        currentUser=null;
        System.err.println("--> User " + login + " logout.");        
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect(context.getRequestContextPath() + "/login.jsf");
    }
    
    public boolean isAuth() {
        return (currentUser != null && currentUser.getId()>0);
    }
    
    public boolean isAdmin() {
        return (this.isAuth() && currentUser.getGroup().getId()==1);
    }
    
    public boolean isModerator() {
        return (this.isAuth() && currentUser.getGroup().getId()==2);
    }
    
    public boolean isUser() {
        return (this.isAuth() && currentUser.getGroup().getId()==3);
    }
    
    public boolean isAdminRights() {
        return (this.isAuth() && currentUser.getGroup().getId()==1);
    }
    
    public boolean isModeratorRights() {
        return (this.isAuth() && currentUser.getGroup().getId()<=2);
    }
    
    public boolean isUserRights() {
        return (this.isAuth() && currentUser.getGroup().getId()<=3);
    }
}
