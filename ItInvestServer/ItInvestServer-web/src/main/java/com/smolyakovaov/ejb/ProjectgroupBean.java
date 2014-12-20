/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.hibernate.Projectgroup;
import javax.ejb.Stateless;

/**
 *
 * @author Honaht
 */
@Stateless
public class ProjectgroupBean extends AbstractFacade<Projectgroup> implements ProjectgroupBeanLocal {

    public ProjectgroupBean() {
        super(Projectgroup.class);
    }  
    
}
