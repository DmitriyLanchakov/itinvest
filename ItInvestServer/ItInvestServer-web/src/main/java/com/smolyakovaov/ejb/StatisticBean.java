/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.helpers.Projectcontainer;
import com.smolyakovaov.helpers.StatisticAll;
import com.smolyakovaov.helpers.StatisticDay;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Honaht
 */
@Stateless
public class StatisticBean implements StatisticBeanLocal {
    @EJB
    ProjectcontainerBeanLocal projectcontainerBean;    
    
    @Override
    public StatisticAll getStatisticByProject(int id) {        
        Projectcontainer pc = projectcontainerBean.getByProject(id);
        List<StatisticDay> days = new ArrayList<>();
        StatisticAll res = new StatisticAll();
        boolean payback = false;
        res.setPayback_day(0);
        res.setPlanning_payback(false);
        int period[] = new int[5];
        period[0]=pc.getTimescheduler().getArchitecture();
        period[1]=period[0]+pc.getTimescheduler().getDeveloping();
        period[2]=period[1]+pc.getTimescheduler().getTesting();
        period[3]=period[2]+pc.getTimescheduler().getRelease();
        period[4]=period[3]+pc.getTimescheduler().getSupport();
        
                    double quality_koeff = 
                        (pc.getQuality().getActuality()+
                        pc.getQuality().getFunctional()+
                        pc.getQuality().getGui()+
                        pc.getQuality().getHardware()+
                        pc.getQuality().getHardware()+
                        pc.getQuality().getSpeed()+
                        pc.getQuality().getSupport())/7.0/100.0;
            double release_pay_inday = pc.getPromotion().getReleaseAll()/pc.getTimescheduler().getRelease();
            int promotion_company_day_start = period[2];
            int promotion_company_day_end = promotion_company_day_start+pc.getPromotion().getCompanyDays();
        
        StatisticDay thisDay=null, prevDay = null;
        for (int day=1; day<=period[4]; day++) {
            thisDay = new StatisticDay();
            thisDay.setDay(day);
            
            //Одинаковые расчеты во все периоды
            thisDay.setExpenses_otherdrains(pc.getOtherdrain().getArend()+pc.getOtherdrain().getService());
            thisDay.setExpenses_wages(pc.getWorkers().getSeos()*pc.getWages().getSeos());
            thisDay.setExpenses_promotions(0);
            thisDay.setIncome_sales(0);
            
            //Разные рассчеты в периоды
            if          (day>period[3] && day<=period[4]) {
                thisDay.setPeriod(5); //Поддержка
                
                thisDay.setExpenses_wages(thisDay.getExpenses_wages()
                        +(pc.getWorkers().getSupports()*pc.getWages().getSupports()));
                if (day<=promotion_company_day_end) {
                    thisDay.setExpenses_promotions(pc.getPromotion().getSupportIndayStart()*Math.pow(pc.getPromotion().getMultiplierInday(), day-period[3]));
                    if (thisDay.getExpenses_promotions()<1) {
                        thisDay.setExpenses_promotions(0);
                    }
                }
                
                double possible = thisDay.getExpenses_promotions()/((pc.getSales().getPlanningAuditory()*0.65)/pc.getTimescheduler().getSupport());
                possible *= quality_koeff;
                possible /= pc.getSales().getCostForoneOther();
                possible /=0.60;
                if (possible>1) {possible=1.0;}
                thisDay.setIncome_sales(possible*pc.getSales().getCostForoneOther()*((pc.getSales().getPlanningAuditory()*0.65)/pc.getTimescheduler().getSupport()));
                if (day>1) {
                    thisDay.setIncome_sales(thisDay.getIncome_sales()+(prevDay.getIncome_sales()*0.9));
                }
            } else if   (day>period[2] && day<=period[3]) {
                thisDay.setPeriod(4); //Релиз
                
                thisDay.setExpenses_wages(thisDay.getExpenses_wages()
                        +(pc.getWorkers().getDevelopers()*pc.getWages().getDevelopers())
                        +(pc.getWorkers().getTesters()*pc.getWages().getTesters())
                        +(pc.getWorkers().getSupports()*pc.getWages().getSupports()));
                
                if (day<=promotion_company_day_end) {
                    thisDay.setExpenses_promotions(release_pay_inday);
                }
                
                double possible = thisDay.getExpenses_promotions()/((pc.getSales().getPlanningAuditory()*0.35)/pc.getTimescheduler().getRelease());
                possible *= quality_koeff;
                possible /= pc.getSales().getCostForoneRelease();
                possible /=0.60;
                if (possible>1) {possible=1.0;}
                thisDay.setIncome_sales(possible*pc.getSales().getCostForoneRelease()*((pc.getSales().getPlanningAuditory()*0.35)/pc.getTimescheduler().getRelease()));
                if (day>1) {
                    thisDay.setIncome_sales(thisDay.getIncome_sales()+(prevDay.getIncome_sales()*0.6));
                }
            } else if   (day>period[1] && day<=period[2]) {
                thisDay.setPeriod(3); //Тестирование
                
                thisDay.setExpenses_wages(thisDay.getExpenses_wages()
                        +(pc.getWorkers().getTesters()*pc.getWages().getTesters()));
            } else if   (day>period[0] && day<=period[1]) {
                thisDay.setPeriod(2); //Разработка
                
                thisDay.setExpenses_wages(thisDay.getExpenses_wages()
                        +(pc.getWorkers().getDevelopers()*pc.getWages().getDevelopers()));
            } else if   (day>0 && day<=period[0]) {
                thisDay.setPeriod(1); //Проектирование
                
                thisDay.setExpenses_wages(thisDay.getExpenses_wages()
                        +(pc.getWorkers().getArchitects()*pc.getWages().getArchitects())
                        +(pc.getWorkers().getDesigners()*pc.getWages().getDesigners()));
                
            }
            
            if (thisDay.getIncome_sales()>0 && thisDay.getIncome_sales()<1) {
                thisDay.setIncome_sales(0);
            }
            
            thisDay.setExpenses_day(thisDay.getExpenses_otherdrains()+thisDay.getExpenses_promotions()+thisDay.getExpenses_wages());
            if (day>1) {
                thisDay.setExpenses_all(prevDay.getExpenses_all()+thisDay.getExpenses_day());
                thisDay.setIncome_all(prevDay.getIncome_all()+thisDay.getIncome_sales());
            } else {
                thisDay.setExpenses_all(thisDay.getExpenses_day());
                thisDay.setIncome_all(thisDay.getIncome_sales());
            }
            
            if (res.isPlanning_payback()==false && thisDay.getIncome_all()>=pc.getSales().getPlanningPayback() && day<=pc.getSales().getPlanningPaybackIndays()) {
                res.setPlanning_payback(true);
            }
            
            if (!payback && thisDay.getIncome_all()>=pc.getSales().getPlanningPayback()) {
                payback=true;
                res.setPayback_day(day);
            }
            
            //System.out.println(thisDay);
            days.add(thisDay);
            prevDay = thisDay;
        }
        res.setProfit(thisDay.getIncome_all()-pc.getSales().getPlanningPayback());
        res.setDays(days);
        return res;
    }

    
}
