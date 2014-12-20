/*
 * To change this license header, choose License Headers in Workers Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.hibernate.Project;
import com.smolyakovaov.hibernate.Workers;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Honaht
 */
@Local
public interface WorkersBeanLocal {
    Workers create(Workers u);
    void edit(Workers u);
    void delete(Workers u);
    Workers get(int id);
    Workers getByProject(Project project);
    List<Workers> list();
    int count();
}
