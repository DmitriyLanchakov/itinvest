/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ws;

import com.smolyakovaov.ejb.WorkersBeanLocal;
import com.smolyakovaov.hibernate.Project;
import com.smolyakovaov.hibernate.Workers;
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
@WebService(serviceName = "WorkersService")
public class WorkersService {
    @EJB
    private WorkersBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "createWorkers")
    public Workers createWorkers(@WebParam(name = "u") Workers u) {
        return ejbRef.create(u);
    }

    @WebMethod(operationName = "editWorkers")
    @Oneway
    public void editWorkers(@WebParam(name = "u") Workers u) {
        ejbRef.edit(u);
    }

    @WebMethod(operationName = "deleteWorkers")
    @Oneway
    public void deleteWorkers(@WebParam(name = "u") Workers u) {
        ejbRef.delete(u);
    }

    @WebMethod(operationName = "getWorkers")
    public Workers getWorkers(@WebParam(name = "id") int id) {
        return ejbRef.get(id);
    }

    @WebMethod(operationName = "getWorkersByProject")
    public Workers getWorkersByProject(@WebParam(name = "project") Project project) {
        return ejbRef.getByProject(project);
    }

    @WebMethod(operationName = "listWorkers")
    public List<Workers> listWorkers() {
        return ejbRef.list();
    }

    @WebMethod(operationName = "countWorkers")
    public int countWorkers() {
        return ejbRef.count();
    }
    
}
