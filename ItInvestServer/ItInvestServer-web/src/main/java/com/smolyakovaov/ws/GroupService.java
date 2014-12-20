/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ws;

import com.smolyakovaov.ejb.GroupBeanLocal;
import com.smolyakovaov.hibernate.Group;
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
@WebService(serviceName = "GroupService")
public class GroupService {
    @EJB
    private GroupBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "createGroup")
    public Group createGroup(@WebParam(name = "u") Group u) {
        return ejbRef.create(u);
    }

    @WebMethod(operationName = "editGroup")
    @Oneway
    public void editGroup(@WebParam(name = "u") Group u) {
        ejbRef.edit(u);
    }

    @WebMethod(operationName = "deleteGroup")
    @Oneway
    public void deleteGroup(@WebParam(name = "u") Group u) {
        ejbRef.delete(u);
    }

    @WebMethod(operationName = "getGroup")
    public Group getGroup(@WebParam(name = "id") int id) {
        return ejbRef.get(id);
    }

    @WebMethod(operationName = "listGroup")
    public List<Group> listGroup() {
        return ejbRef.list();
    }

    @WebMethod(operationName = "countGroup")
    public int countGroup() {
        return ejbRef.count();
    }
    
}
