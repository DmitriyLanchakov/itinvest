/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.hibernate.Group;
import javax.ejb.EJBException;
import javax.ejb.EJBLocalHome;
import javax.ejb.EJBLocalObject;
import javax.ejb.RemoveException;
import javax.ejb.Stateless;

/**
 *
 * @author Honaht
 */
@Stateless
public class GroupBean extends AbstractFacade<Group> implements GroupBeanLocal {

    public GroupBean() {
        super(Group.class);
    }  

}
