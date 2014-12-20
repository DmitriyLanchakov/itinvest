/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.helpers.Projectcontainer;
import javax.ejb.Local;

/**
 *
 * @author Honaht
 */
@Local
public interface ProjectcontainerBeanLocal {
    public Projectcontainer getByProject(int id);
}
