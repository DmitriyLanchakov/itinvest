/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ws;

import com.smolyakovaov.ejb.ProjectcontainerBeanLocal;
import com.smolyakovaov.helpers.Projectcontainer;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Honaht
 */
@WebService(serviceName = "ProjectcontainerService")
public class ProjectcontainerService {
    @EJB
    private ProjectcontainerBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "getProjectcontainerByProject")
    public Projectcontainer getProjectcontainerByProject(@WebParam(name = "id") int id) {
        return ejbRef.getByProject(id);
    }
    
}
