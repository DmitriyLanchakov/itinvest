/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ws;

import com.smolyakovaov.ejb.WagesBeanLocal;
import com.smolyakovaov.hibernate.Project;
import com.smolyakovaov.hibernate.Wages;
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
@WebService(serviceName = "WagesService")
public class WagesService {
    @EJB
    private WagesBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "createWages")
    public Wages createWages(@WebParam(name = "u") Wages u) {
        return ejbRef.create(u);
    }

    @WebMethod(operationName = "editWages")
    @Oneway
    public void editWages(@WebParam(name = "u") Wages u) {
        ejbRef.edit(u);
    }

    @WebMethod(operationName = "deleteWages")
    @Oneway
    public void deleteWages(@WebParam(name = "u") Wages u) {
        ejbRef.delete(u);
    }

    @WebMethod(operationName = "getWages")
    public Wages getWages(@WebParam(name = "id") int id) {
        return ejbRef.get(id);
    }

    @WebMethod(operationName = "getWagesByProject")
    public Wages getWagesByProject(@WebParam(name = "project") Project project) {
        return ejbRef.getByProject(project);
    }

    @WebMethod(operationName = "listWages")
    public List<Wages> listWages() {
        return ejbRef.list();
    }

    @WebMethod(operationName = "countWages")
    public int countWages() {
        return ejbRef.count();
    }
    
}
