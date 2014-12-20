/*
 * To change this license header, choose License Headers in Otherdrain Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.hibernate.Otherdrain;
import com.smolyakovaov.hibernate.Project;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Honaht
 */
@Local
public interface OtherdrainBeanLocal {
    Otherdrain create(Otherdrain u);
    void edit(Otherdrain u);
    void delete(Otherdrain u);
    Otherdrain get(int id);
    Otherdrain getByProject(Project project);
    List<Otherdrain> list();
    int count();
}
