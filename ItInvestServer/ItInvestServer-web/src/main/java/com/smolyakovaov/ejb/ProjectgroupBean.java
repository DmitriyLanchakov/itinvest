/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.hibernate.Projectgroup;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Honaht
 */
@Stateless
public class ProjectgroupBean extends AbstractFacade<Projectgroup> implements ProjectgroupBeanLocal {

    public ProjectgroupBean() {
        super(Projectgroup.class);
    }  

    @Override
    public List<Projectgroup> listProjectgroupByUser(int id) {
        List<Projectgroup> res = new ArrayList<>();
        try {
            this.session.beginTransaction();
            //res = (T)session.get(entityClass, id); 
            res = session.createCriteria(entityClass)
                        .add(Restrictions.eq("user.id", id))
                        .list();
            this.session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
        return res;
    }
    
}
