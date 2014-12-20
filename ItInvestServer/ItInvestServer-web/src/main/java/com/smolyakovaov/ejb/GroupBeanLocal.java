/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.hibernate.Group;
import java.util.List;
import javax.ejb.EJBLocalObject;

/**
 *
 * @author Honaht
 */
public interface GroupBeanLocal {
    Group create(Group u);
    void edit(Group u);
    void delete(Group u);
    Group get(int id);
    List<Group> list();
    int count();
}
