/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.helpers.StatisticAll;
import com.smolyakovaov.helpers.StatisticDay;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Honaht
 */
@Local
public interface StatisticBeanLocal {
    StatisticAll getStatisticByProject(int id);
}
