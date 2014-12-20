/*
 * To change this license header, choose License Headers in Sales Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.hibernate.Project;
import com.smolyakovaov.hibernate.Sales;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Honaht
 */
@Local
public interface SalesBeanLocal {
    Sales create(Sales u);
    void edit(Sales u);
    void delete(Sales u);
    Sales get(int id);
    Sales getByProject(Project project);
    List<Sales> list();
    int count();
}
