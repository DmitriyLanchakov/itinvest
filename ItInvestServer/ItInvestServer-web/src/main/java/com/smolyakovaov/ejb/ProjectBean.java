/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.hibernate.Project;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Honaht
 */
@Stateless
public class ProjectBean extends AbstractFacade<Project> implements ProjectBeanLocal {

    public ProjectBean() {
        super(Project.class);
    }
    
}
