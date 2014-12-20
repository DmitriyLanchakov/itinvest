/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import java.util.List;
import com.smolyakovaov.hibernate.HibernateUtil;
import com.smolyakovaov.hibernate.Project;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author
 */
public abstract class AbstractFacadeForProject<T> extends AbstractFacade<T> {

    public AbstractFacadeForProject(Class<T> entityClass) {
        super(entityClass);
    }

    public T getByProject(Project project) {
        T res = null;
        try {
            this.session.beginTransaction();
            //res = (T)session.get(entityClass, id); 
            res = (T)session.createCriteria(entityClass)
                        .add(Restrictions.eq("project", project))
                        .uniqueResult();
            this.session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
        return res;
    }
}
