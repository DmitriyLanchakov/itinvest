/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ws;

import com.smolyakovaov.ejb.QualityBeanLocal;
import com.smolyakovaov.hibernate.Project;
import com.smolyakovaov.hibernate.Quality;
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
@WebService(serviceName = "QualityService")
public class QualityService {
    @EJB
    private QualityBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "createQuality")
    public Quality createQuality(@WebParam(name = "u") Quality u) {
        return ejbRef.create(u);
    }

    @WebMethod(operationName = "editQuality")
    @Oneway
    public void editQuality(@WebParam(name = "u") Quality u) {
        ejbRef.edit(u);
    }

    @WebMethod(operationName = "deleteQuality")
    @Oneway
    public void deleteQuality(@WebParam(name = "u") Quality u) {
        ejbRef.delete(u);
    }

    @WebMethod(operationName = "getQuality")
    public Quality getQuality(@WebParam(name = "id") int id) {
        return ejbRef.get(id);
    }

    @WebMethod(operationName = "getQualityByProject")
    public Quality getQualityByProject(@WebParam(name = "project") Project project) {
        return ejbRef.getByProject(project);
    }

    @WebMethod(operationName = "listQuality")
    public List<Quality> listQuality() {
        return ejbRef.list();
    }

    @WebMethod(operationName = "countQuality")
    public int countQuality() {
        return ejbRef.count();
    }
    
}
