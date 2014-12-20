/*
 * To change this license header, choose License Headers in Wages Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.hibernate.Wages;
import javax.ejb.Stateless;

/**
 *
 * @author Honaht
 */
@Stateless
public class WagesBean extends AbstractFacadeForProject<Wages> implements WagesBeanLocal {

    public WagesBean() {
        super(Wages.class);
    }
}
