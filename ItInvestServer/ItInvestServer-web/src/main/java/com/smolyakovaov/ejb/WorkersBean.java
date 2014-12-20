/*
 * To change this license header, choose License Headers in Workers Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.hibernate.Workers;
import javax.ejb.Stateless;

/**
 *
 * @author Honaht
 */
@Stateless
public class WorkersBean extends AbstractFacadeForProject<Workers> implements WorkersBeanLocal {

    public WorkersBean() {
        super(Workers.class);
    }
}
