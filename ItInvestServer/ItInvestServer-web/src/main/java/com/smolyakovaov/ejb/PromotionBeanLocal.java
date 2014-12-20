/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.hibernate.Project;
import com.smolyakovaov.hibernate.Promotion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Honaht
 */
@Local
public interface PromotionBeanLocal {
    Promotion create(Promotion u);
    void edit(Promotion u);
    void delete(Promotion u);
    Promotion get(int id);
    Promotion getByProject(Project project);
    List<Promotion> list();
    int count();
}
