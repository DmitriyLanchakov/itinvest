/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.hibernate.Project;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Honaht
 */
@Local
public interface ProjectBeanLocal {
    Project create(Project u);
    void edit(Project u);
    void delete(Project u);
    Project get(int id);
    List<Project> list();
    int count();
}
