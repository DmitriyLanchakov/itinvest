/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.helpers.Projectcontainer;
import com.smolyakovaov.hibernate.Project;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Honaht
 */
@Stateless
public class ProjectcontainerBean implements ProjectcontainerBeanLocal {
    @EJB
    OtherdrainBeanLocal otherdrainBean;
    @EJB
    PromotionBeanLocal promotionBean;
    @EJB
    QualityBeanLocal qualityBean;
    @EJB
    SalesBeanLocal salesBean;
    @EJB
    TimeschedulerBeanLocal timeschedulerBean;
    @EJB
    WagesBeanLocal wagesBean;    
    @EJB
    WorkersBeanLocal workersBean;    
    @EJB
    ProjectBeanLocal projectBean;
    
    @Override
    public Projectcontainer getByProject(int id) {
        Projectcontainer res= new Projectcontainer();
        Project project = projectBean.get(id);
        res.setOtherdrain(otherdrainBean.getByProject(project));
        res.setPromotion(promotionBean.getByProject(project));
        res.setQuality(qualityBean.getByProject(project));
        res.setSales(salesBean.getByProject(project));
        res.setTimescheduler(timeschedulerBean.getByProject(project));
        res.setWages(wagesBean.getByProject(project));
        res.setWorkers(workersBean.getByProject(project));
        return res;
    }
}
