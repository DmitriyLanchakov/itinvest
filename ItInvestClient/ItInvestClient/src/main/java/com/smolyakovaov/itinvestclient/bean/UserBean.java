/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.itinvestclient.bean;

import com.smolyakovaov.ws.User;
import com.smolyakovaov.ws.UserService_Service;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Honaht
 */
public class UserBean {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ItInvestServer-web/UserService.wsdl")
    private UserService_Service service;

    /**
     * Creates a new instance of UserBean
     */
    
    private User tempUser;

    public User getTempUser() {
        return tempUser;
    }

    public void setTempUser(User tempUser) {
        this.tempUser = tempUser;
    }
    
    public UserBean() {
    }
    
    public void setInfo() {        
        try { // Call Web Service Operation
            com.smolyakovaov.ws.UserService port = service.getUserServicePort();
            // TODO initialize WS operation arguments here
            port.setInfo(tempUser.getId(), tempUser.getFirstname(), tempUser.getLastname(), tempUser.getOrganization(), tempUser.getEmail(), tempUser.getAddress());
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect(context.getRequestContextPath() + "/index.jsf");
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }
    }
    
    public List<User> list() {
        List<User> res = null;
        try { // Call Web Service Operation
            com.smolyakovaov.ws.UserService port = service.getUserServicePort();
            // TODO initialize WS operation arguments here
            res = port.listUserOrderByLogin();
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }
        return res;
    }
    
    public void setGroup(int id, int group) {
        try { // Call Web Service Operation
            com.smolyakovaov.ws.UserService port = service.getUserServicePort();
            // TODO initialize WS operation arguments here
            port.setGroup(id, group);
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }
    }
    
    public void delete(User user) {
        try { // Call Web Service Operation
            com.smolyakovaov.ws.UserService port = service.getUserServicePort();
            // TODO initialize WS operation arguments here
            port.deleteUserFromEntity(user);
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }
    }
}
