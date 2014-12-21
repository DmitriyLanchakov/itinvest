/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.itinvestclient.bean;

import com.smolyakovaov.ws.Project;
import com.smolyakovaov.ws.ProjectService_Service;
import com.smolyakovaov.ws.Projectgroup;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Honaht
 */
public class ProjectBean {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ItInvestServer-web/ProjectService.wsdl")
    private ProjectService_Service service;

   
    private Project tempProject;

    public Project getTempProject() {
        return tempProject;
    }

    public void setTempProject(Project tempProject) {
        this.tempProject = tempProject;
    }
    /**
     * Creates a new instance of ProjectBean
     */
    public ProjectBean() {
    }
    
    @PostConstruct
    public void init() {
        tempProject = new Project();
    }
    
    public List<Project> listByProjectgroup(int id) {
        List<Project> res = null;
        try { // Call Web Service Operation
            com.smolyakovaov.ws.ProjectService port = service.getProjectServicePort();
            // TODO initialize WS operation arguments here
            res = port.listProjectsByProjectgroup(id);
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }
        return res;
    }
    
    public List<Project> list() {
        List<Project> res = null;
        try { // Call Web Service Operation
            com.smolyakovaov.ws.ProjectService port = service.getProjectServicePort();
            // TODO initialize WS operation arguments here
            res = port.listProject();
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }
        return res;
    }
    
    public void create() {
        try { // Call Web Service Operation
            com.smolyakovaov.ws.ProjectService port = service.getProjectServicePort();
            // TODO initialize WS operation arguments here
            tempProject.setId(0);
            port.createProject(tempProject);
            tempProject = new Project();
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect(context.getRequestContextPath() + "/user_projectgroups.jsf");
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }
    }
    
    public void edit() {
         try { // Call Web Service Operation
            com.smolyakovaov.ws.ProjectService port = service.getProjectServicePort();
            // TODO initialize WS operation arguments here
            port.editProject(tempProject);
            tempProject = new Project();
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect(context.getRequestContextPath() + "/user_projectgroups.jsf");
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }       
    }
    
    public void delete(Project project) {
        try { // Call Web Service Operation
            com.smolyakovaov.ws.ProjectService port = service.getProjectServicePort();
            // TODO initialize WS operation arguments here
            port.deleteProject(project);
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        } 
    }
}
