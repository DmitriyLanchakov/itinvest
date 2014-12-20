/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.helpers;

public class StatisticDay implements java.io.Serializable {
    
    private Integer day;
    private Integer period;
    
    private double expenses_otherdrains;
    private double expenses_promotions;
    private double expenses_wages;
    private double expenses_day;
    private double expenses_all;
    
    private double income_sales;
    private double income_all;

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public double getExpenses_otherdrains() {
        return expenses_otherdrains;
    }

    public void setExpenses_otherdrains(double expenses_otherdrains) {
        this.expenses_otherdrains = expenses_otherdrains;
    }

    public double getExpenses_promotions() {
        return expenses_promotions;
    }

    public void setExpenses_promotions(double expenses_promotions) {
        this.expenses_promotions = expenses_promotions;
    }

    public double getExpenses_wages() {
        return expenses_wages;
    }

    public void setExpenses_wages(double expenses_wages) {
        this.expenses_wages = expenses_wages;
    }

    public double getExpenses_day() {
        return expenses_day;
    }

    public void setExpenses_day(double expenses_day) {
        this.expenses_day = expenses_day;
    }

    public double getExpenses_all() {
        return expenses_all;
    }

    public void setExpenses_all(double expenses_all) {
        this.expenses_all = expenses_all;
    }

    public double getIncome_sales() {
        return income_sales;
    }

    public void setIncome_sales(double income_sales) {
        this.income_sales = income_sales;
    }

    public double getIncome_all() {
        return income_all;
    }

    public void setIncome_all(double income_all) {
        this.income_all = income_all;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    @Override
    public String toString() {
        String res="";
        res+="День: "+this.day+", период "+this.period+"\r\n";
        res+="Накладные расходы: "+this.expenses_otherdrains+"\r\n";
        res+="Расходы на зарплату: "+this.expenses_wages+"\r\n";
        res+="Расходы на рекламу: "+this.expenses_promotions+"\r\n";
        res+="Суммарные расходы за день: "+this.expenses_day+"\r\n";
        res+="Общие расходы: "+this.expenses_all+"\r\n";
        res+="/++++";
        res+="Доходы за день: "+this.income_sales+"\r\n";
        res+="Общие доходы: "+this.income_all+"\r\n";
        res+="/------------------------------------";
        return res;
    }
}
