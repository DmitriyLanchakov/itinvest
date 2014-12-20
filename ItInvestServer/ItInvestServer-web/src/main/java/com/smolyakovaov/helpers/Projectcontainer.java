/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.helpers;

import com.smolyakovaov.hibernate.Otherdrain;
import com.smolyakovaov.hibernate.Promotion;
import com.smolyakovaov.hibernate.Quality;
import com.smolyakovaov.hibernate.Sales;
import com.smolyakovaov.hibernate.Timescheduler;
import com.smolyakovaov.hibernate.Wages;
import com.smolyakovaov.hibernate.Workers;

/**
 *
 * @author Honaht
 */
public class Projectcontainer implements java.io.Serializable {
        private Otherdrain otherdrain;
        private Promotion promotion;
        private Quality quality;
        private Sales sales;
        private Timescheduler timescheduler;
        private Wages wages;
        private Workers workers;

    public Otherdrain getOtherdrain() {
        return otherdrain;
    }

    public void setOtherdrain(Otherdrain otherdrain) {
        this.otherdrain = otherdrain;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public Timescheduler getTimescheduler() {
        return timescheduler;
    }

    public void setTimescheduler(Timescheduler timescheduler) {
        this.timescheduler = timescheduler;
    }

    public Wages getWages() {
        return wages;
    }

    public void setWages(Wages wages) {
        this.wages = wages;
    }

    public Workers getWorkers() {
        return workers;
    }

    public void setWorkers(Workers workers) {
        this.workers = workers;
    }
        
        
}
