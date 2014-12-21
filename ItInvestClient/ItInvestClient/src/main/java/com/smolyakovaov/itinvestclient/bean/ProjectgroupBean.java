/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.itinvestclient.bean;

import com.smolyakovaov.ws.Projectgroup;
import com.smolyakovaov.ws.ProjectgroupService_Service;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.annotation.*;
import javax.faces.bean.*;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Honaht
 */
public class ProjectgroupBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ItInvestServer-web/ProjectgroupService.wsdl")
    private ProjectgroupService_Service service;

    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBean;
    
    private Projectgroup tempProjectgroup;

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public Projectgroup getTempProjectgroup() {
        return tempProjectgroup;
    }

    public void setTempProjectgroup(Projectgroup tempProjectgroup) {
        this.tempProjectgroup = tempProjectgroup;
    }

    /**
     * Creates a new instance of projectgroupBean
     */
    public ProjectgroupBean() {
    }
    
    @PostConstruct
    public void init() {
        tempProjectgroup = new Projectgroup();
    }

    public List<Projectgroup> listByUser(int id) {
        List<Projectgroup> res = null;
        try { // Call Web Service Operation
            com.smolyakovaov.ws.ProjectgroupService port = service.getProjectgroupServicePort();
            // TODO initialize WS operation arguments here
            res = port.listProjectgroupByUser(id);
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }
        return res;
    }
    
    public void create() {
        try { // Call Web Service Operation
            com.smolyakovaov.ws.ProjectgroupService port = service.getProjectgroupServicePort();
            // TODO initialize WS operation arguments here
            tempProjectgroup.setId(0);
            tempProjectgroup.setUser(loginBean.getCurrentUser());
            port.createProjectgroup(tempProjectgroup);
            tempProjectgroup = new Projectgroup();
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect(context.getRequestContextPath() + "/user_projectgroups.jsf");
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }
    }
    
    public void edit() {
         try { // Call Web Service Operation
            com.smolyakovaov.ws.ProjectgroupService port = service.getProjectgroupServicePort();
            // TODO initialize WS operation arguments here
            port.editProjectgroup(tempProjectgroup);
            tempProjectgroup = new Projectgroup();
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect(context.getRequestContextPath() + "/user_projectgroups.jsf");
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }       
    }
    
    public void delete(Projectgroup projectgroup) {
        try { // Call Web Service Operation
            com.smolyakovaov.ws.ProjectgroupService port = service.getProjectgroupServicePort();
            // TODO initialize WS operation arguments here
            port.deleteProjectgroup(projectgroup);
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        } 
    }

}
