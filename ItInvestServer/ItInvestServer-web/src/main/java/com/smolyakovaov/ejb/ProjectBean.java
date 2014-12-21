/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.hibernate.Project;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Honaht
 */
@Stateless
public class ProjectBean extends AbstractFacade<Project> implements ProjectBeanLocal {

    public ProjectBean() {
        super(Project.class);
    }

    @Override
    public List<Project> listProjectsByProjectgroup(int id) {
        List<Project> res = new ArrayList<Project>();
        try {
            this.session.beginTransaction();
            //res = (T)session.get(entityClass, id); 
            res = session.createCriteria(entityClass)
                        .add(Restrictions.eq("projectgroup.id", id))
                        .list();
            this.session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
        return res;
    }
    
}
