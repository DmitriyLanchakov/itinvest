/*
 * To change this license header, choose License Headers in Quality Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.hibernate.Project;
import com.smolyakovaov.hibernate.Quality;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Honaht
 */
@Local
public interface QualityBeanLocal {
    Quality create(Quality u);
    void edit(Quality u);
    void delete(Quality u);
    Quality get(int id);
    Quality getByProject(Project project);
    List<Quality> list();
    int count();
}
