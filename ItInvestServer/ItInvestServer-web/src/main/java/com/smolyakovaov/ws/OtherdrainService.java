/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ws;

import com.smolyakovaov.ejb.OtherdrainBeanLocal;
import com.smolyakovaov.hibernate.Otherdrain;
import com.smolyakovaov.hibernate.Project;
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
@WebService(serviceName = "OtherdrainService")
public class OtherdrainService {
    @EJB
    private OtherdrainBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "createOtherdrain")
    public Otherdrain createOtherdrain(@WebParam(name = "u") Otherdrain u) {
        return ejbRef.create(u);
    }

    @WebMethod(operationName = "editOtherdrain")
    @Oneway
    public void editOtherdrain(@WebParam(name = "u") Otherdrain u) {
        ejbRef.edit(u);
    }

    @WebMethod(operationName = "deleteOtherdrain")
    @Oneway
    public void deleteOtherdrain(@WebParam(name = "u") Otherdrain u) {
        ejbRef.delete(u);
    }

    @WebMethod(operationName = "getOtherdrain")
    public Otherdrain getOtherdrain(@WebParam(name = "id") int id) {
        return ejbRef.get(id);
    }

    @WebMethod(operationName = "getOtherdrainByProject")
    public Otherdrain getOtherdrainByProject(@WebParam(name = "project") Project project) {
        return ejbRef.getByProject(project);
    }

    @WebMethod(operationName = "listOtherdrain")
    public List<Otherdrain> listOtherdrain() {
        return ejbRef.list();
    }

    @WebMethod(operationName = "countOtherdrain")
    public int countOtherdrain() {
        return ejbRef.count();
    }
    
}
