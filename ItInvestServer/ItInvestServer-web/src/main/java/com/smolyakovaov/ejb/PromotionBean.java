/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.hibernate.Promotion;
import javax.ejb.Stateless;

/**
 *
 * @author Honaht
 */
@Stateless
public class PromotionBean extends AbstractFacadeForProject<Promotion> implements PromotionBeanLocal {

    public PromotionBean() {
        super(Promotion.class);
    }
}
