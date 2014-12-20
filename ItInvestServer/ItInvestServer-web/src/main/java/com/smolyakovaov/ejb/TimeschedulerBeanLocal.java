/*
 * To change this license header, choose License Headers in Timescheduler Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.hibernate.Project;
import com.smolyakovaov.hibernate.Timescheduler;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Honaht
 */
@Local
public interface TimeschedulerBeanLocal {
    Timescheduler create(Timescheduler u);
    void edit(Timescheduler u);
    void delete(Timescheduler u);
    Timescheduler get(int id);
    Timescheduler getByProject(Project project);
    List<Timescheduler> list();
    int count();
}
