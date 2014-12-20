/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ws;

import com.smolyakovaov.ejb.ProjectBeanLocal;
import com.smolyakovaov.hibernate.Project;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Honaht
 */
@WebService(serviceName = "ProjectService")
public class ProjectService {
    @EJB
    private ProjectBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "createProject")
    public Project createProject(@WebParam(name = "u") Project u) {
        return ejbRef.create(u);
    }

    @WebMethod(operationName = "editProject")
    @Oneway
    public void editProject(@WebParam(name = "u") Project u) {
        ejbRef.edit(u);
    }

    @WebMethod(operationName = "deleteProject")
    @Oneway
    public void deleteProject(@WebParam(name = "u") Project u) {
        ejbRef.delete(u);
    }

    @WebMethod(operationName = "getProject")
    public Project getProject(@WebParam(name = "id") int id) {
        return ejbRef.get(id);
    }

    @WebMethod(operationName = "listProject")
    public List<Project> listProject() {
        return ejbRef.list();
    }

    @WebMethod(operationName = "countProject")
    public int countProject() {
        return ejbRef.count();
    }
    
}
