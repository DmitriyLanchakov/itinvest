/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ws;

import com.smolyakovaov.ejb.ProjectgroupBeanLocal;
import com.smolyakovaov.hibernate.Projectgroup;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Honaht
 */
@WebService(serviceName = "ProjectgroupService")
public class ProjectgroupService {
    @EJB
    private ProjectgroupBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "createProjectgroup")
    public Projectgroup createProjectgroup(@WebParam(name = "u") Projectgroup u) {
        return ejbRef.create(u);
    }

    @WebMethod(operationName = "editProjectgroup")
    @Oneway
    public void editProjectgroup(@WebParam(name = "u") Projectgroup u) {
        ejbRef.edit(u);
    }

    @WebMethod(operationName = "deleteProjectgroup")
    @Oneway
    public void deleteProjectgroup(@WebParam(name = "u") Projectgroup u) {
        ejbRef.delete(u);
    }

    @WebMethod(operationName = "getProjectgroup")
    public Projectgroup getProjectgroup(@WebParam(name = "id") int id) {
        return ejbRef.get(id);
    }

    @WebMethod(operationName = "listProjectgroup")
    public List<Projectgroup> listProjectgroup() {
        return ejbRef.list();
    }

    @WebMethod(operationName = "countProjectgroup")
    public int countProjectgroup() {
        return ejbRef.count();
    }
    
}
