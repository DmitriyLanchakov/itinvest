/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ws;

import com.smolyakovaov.ejb.TimeschedulerBeanLocal;
import com.smolyakovaov.hibernate.Project;
import com.smolyakovaov.hibernate.Timescheduler;
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
@WebService(serviceName = "TimeschedulerService")
public class TimeschedulerService {
    @EJB
    private TimeschedulerBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "createTimescheduler")
    public Timescheduler createTimescheduler(@WebParam(name = "u") Timescheduler u) {
        return ejbRef.create(u);
    }

    @WebMethod(operationName = "editTimescheduler")
    @Oneway
    public void editTimescheduler(@WebParam(name = "u") Timescheduler u) {
        ejbRef.edit(u);
    }

    @WebMethod(operationName = "deleteTimescheduler")
    @Oneway
    public void deleteTimescheduler(@WebParam(name = "u") Timescheduler u) {
        ejbRef.delete(u);
    }

    @WebMethod(operationName = "getTimescheduler")
    public Timescheduler getTimescheduler(@WebParam(name = "id") int id) {
        return ejbRef.get(id);
    }

    @WebMethod(operationName = "getTimeschedulerByProject")
    public Timescheduler getTimeschedulerByProject(@WebParam(name = "project") Project project) {
        return ejbRef.getByProject(project);
    }

    @WebMethod(operationName = "listTimescheduler")
    public List<Timescheduler> listTimescheduler() {
        return ejbRef.list();
    }

    @WebMethod(operationName = "countTimescheduler")
    public int countTimescheduler() {
        return ejbRef.count();
    }
    
}
