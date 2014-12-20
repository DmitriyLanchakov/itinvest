/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ws;

import com.smolyakovaov.ejb.SalesBeanLocal;
import com.smolyakovaov.hibernate.Project;
import com.smolyakovaov.hibernate.Sales;
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
@WebService(serviceName = "SalesService")
public class SalesService {
    @EJB
    private SalesBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "createSales")
    public Sales createSales(@WebParam(name = "u") Sales u) {
        return ejbRef.create(u);
    }

    @WebMethod(operationName = "editSales")
    @Oneway
    public void editSales(@WebParam(name = "u") Sales u) {
        ejbRef.edit(u);
    }

    @WebMethod(operationName = "deleteSales")
    @Oneway
    public void deleteSales(@WebParam(name = "u") Sales u) {
        ejbRef.delete(u);
    }

    @WebMethod(operationName = "getSales")
    public Sales getSales(@WebParam(name = "id") int id) {
        return ejbRef.get(id);
    }

    @WebMethod(operationName = "getSalesByProject")
    public Sales getSalesByProject(@WebParam(name = "project") Project project) {
        return ejbRef.getByProject(project);
    }

    @WebMethod(operationName = "listSales")
    public List<Sales> listSales() {
        return ejbRef.list();
    }

    @WebMethod(operationName = "countSales")
    public int countSales() {
        return ejbRef.count();
    }
    
}
