/*
 * To change this license header, choose License Headers in Otherdrain Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.hibernate.Otherdrain;
import javax.ejb.Stateless;

/**
 *
 * @author Honaht
 */
@Stateless
public class OtherdrainBean extends AbstractFacadeForProject<Otherdrain> implements OtherdrainBeanLocal {

    public OtherdrainBean() {
        super(Otherdrain.class);
    }
}
