/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ws;

import com.smolyakovaov.ejb.StatisticBeanLocal;
import com.smolyakovaov.helpers.StatisticAll;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Honaht
 */
@WebService(serviceName = "StatisticService")
public class StatisticService {
    @EJB
    private StatisticBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "getStatisticByProject")
    public StatisticAll getStatisticByProject(@WebParam(name = "id") int id) {
        return ejbRef.getStatisticByProject(id);
    }
    
}
