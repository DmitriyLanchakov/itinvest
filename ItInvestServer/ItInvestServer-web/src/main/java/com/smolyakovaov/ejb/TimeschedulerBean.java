/*
 * To change this license header, choose License Headers in Timescheduler Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.hibernate.Timescheduler;
import javax.ejb.Stateless;

/**
 *
 * @author Honaht
 */
@Stateless
public class TimeschedulerBean extends AbstractFacadeForProject<Timescheduler> implements TimeschedulerBeanLocal {

    public TimeschedulerBean() {
        super(Timescheduler.class);
    }
}
