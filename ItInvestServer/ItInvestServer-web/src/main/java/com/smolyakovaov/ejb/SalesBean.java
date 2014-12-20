/*
 * To change this license header, choose License Headers in Sales Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.hibernate.Sales;
import javax.ejb.Stateless;

/**
 *
 * @author Honaht
 */
@Stateless
public class SalesBean extends AbstractFacadeForProject<Sales> implements SalesBeanLocal {

    public SalesBean() {
        super(Sales.class);
    }
}
