/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ws;

import com.smolyakovaov.ejb.PromotionBeanLocal;
import com.smolyakovaov.hibernate.Project;
import com.smolyakovaov.hibernate.Promotion;
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
@WebService(serviceName = "PromotionService")
public class PromotionService {
    @EJB
    private PromotionBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "createPromotion")
    public Promotion createPromotion(@WebParam(name = "u") Promotion u) {
        return ejbRef.create(u);
    }

    @WebMethod(operationName = "editPromotion")
    @Oneway
    public void editPromotion(@WebParam(name = "u") Promotion u) {
        ejbRef.edit(u);
    }

    @WebMethod(operationName = "deletePromotion")
    @Oneway
    public void deletePromotion(@WebParam(name = "u") Promotion u) {
        ejbRef.delete(u);
    }

    @WebMethod(operationName = "getPromotion")
    public Promotion getPromotion(@WebParam(name = "id") int id) {
        return ejbRef.get(id);
    }

    @WebMethod(operationName = "getPromotionByProject")
    public Promotion getPromotionByProject(@WebParam(name = "project") Project project) {
        return ejbRef.getByProject(project);
    }

    @WebMethod(operationName = "listPromotion")
    public List<Promotion> listPromotion() {
        return ejbRef.list();
    }

    @WebMethod(operationName = "countPromotion")
    public int countPromotion() {
        return ejbRef.count();
    }
    
}
