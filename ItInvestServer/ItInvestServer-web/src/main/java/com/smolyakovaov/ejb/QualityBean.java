/*
 * To change this license header, choose License Headers in Quality Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.hibernate.Quality;
import javax.ejb.Stateless;

/**
 *
 * @author Honaht
 */
@Stateless
public class QualityBean extends AbstractFacadeForProject<Quality> implements QualityBeanLocal {

    public QualityBean() {
        super(Quality.class);
    }
}
