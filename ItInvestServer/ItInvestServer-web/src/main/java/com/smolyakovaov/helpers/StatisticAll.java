/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.helpers;

import java.util.List;

/**
 *
 * @author Honaht
 */
public class StatisticAll implements java.io.Serializable {

    private List<StatisticDay> days;
    private int payback_day;
    private double profit;
    private boolean planning_payback;
  
    public List<StatisticDay> getDays() {
        return days;
    }

    public void setDays(List<StatisticDay> days) {
        this.days = days;
    }

    public int getPayback_day() {
        return payback_day;
    }

    public void setPayback_day(int payback_day) {
        this.payback_day = payback_day;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public boolean isPlanning_payback() {
        return planning_payback;
    }

    public void setPlanning_payback(boolean planning_payback) {
        this.planning_payback = planning_payback;
    }    
}
