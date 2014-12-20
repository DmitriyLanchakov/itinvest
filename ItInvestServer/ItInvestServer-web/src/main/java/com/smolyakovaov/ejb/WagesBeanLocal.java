/*
 * To change this license header, choose License Headers in Wages Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.hibernate.Project;
import com.smolyakovaov.hibernate.Wages;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Honaht
 */
@Local
public interface WagesBeanLocal {
    Wages create(Wages u);
    void edit(Wages u);
    void delete(Wages u);
    Wages get(int id);
    Wages getByProject(Project project);
    List<Wages> list();
    int count();
}
