/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.hibernate.Projectgroup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Honaht
 */
@Local
public interface ProjectgroupBeanLocal {
    Projectgroup create(Projectgroup u);
    void edit(Projectgroup u);
    void delete(Projectgroup u);
    Projectgroup get(int id);
    List<Projectgroup> list();
    List<Projectgroup> listProjectgroupByUser(int id);
    int count();
}
