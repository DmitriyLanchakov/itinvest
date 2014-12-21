/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.itinvestclient.bean;

import com.smolyakovaov.ws.StatisticAll;
import com.smolyakovaov.ws.StatisticDay;
import com.smolyakovaov.ws.StatisticService;
import com.smolyakovaov.ws.StatisticService_Service;
import javax.xml.ws.WebServiceRef;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Honaht
 */
public class StatisticBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ItInvestServer-web/StatisticService.wsdl")
    private StatisticService_Service service;

    private StatisticAll tempStatisticAll;

    public StatisticAll getTempStatisticAll() {
        return tempStatisticAll;
    }

    public void setTempStatisticAll(StatisticAll tempStatisticAll) {
        this.tempStatisticAll = tempStatisticAll;
    }

    /**
     * Creates a new instance of StatisticBean
     */
    public StatisticBean() {
    }

    public LineChartModel getAreaModelByProject(int id) {
        LineChartModel res = new LineChartModel();
        try { // Call Web Service Operation
            StatisticService port = service.getStatisticServicePort();
            // TODO initialize WS operation arguments here
            StatisticAll statisticAll = port.getStatisticByProject(id);
            tempStatisticAll = statisticAll;

            LineChartSeries expenses = new LineChartSeries();
            expenses.setFill(false);
            expenses.setLabel("Затраты");

            LineChartSeries incomes = new LineChartSeries();
            incomes.setFill(false);
            incomes.setLabel("Прибыль");

            expenses.set(statisticAll.getDays().get(0).getDay(), statisticAll.getDays().get(0).getExpensesAll());
            incomes.set(statisticAll.getDays().get(0).getDay(), statisticAll.getDays().get(0).getIncomeAll());
            for (int i = 1; i < statisticAll.getDays().size() - 2; i += statisticAll.getDays().size()/10) {
                    expenses.set(statisticAll.getDays().get(i).getDay(), statisticAll.getDays().get(i).getExpensesAll());
                    incomes.set(statisticAll.getDays().get(i).getDay(), statisticAll.getDays().get(i).getIncomeAll());
            }
            expenses.set(statisticAll.getDays().get(statisticAll.getDays().size() - 1).getDay(), statisticAll.getDays().get(statisticAll.getDays().size() - 1).getExpensesAll());
            incomes.set(statisticAll.getDays().get(statisticAll.getDays().size() - 1).getDay(), statisticAll.getDays().get(statisticAll.getDays().size() - 1).getIncomeAll());
            res.addSeries(incomes);
            res.addSeries(expenses);

            res.setTitle("График финансов проекта");
            res.setLegendPosition("ne");

            res.setShowPointLabels(true);

            Axis xAxis = new CategoryAxis("Дни проекта");
            res.getAxes().put(AxisType.X, xAxis);
            Axis yAxis = res.getAxis(AxisType.Y);
            yAxis.setLabel("Деньги, $");
            yAxis.setMin(0);

        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return res;
    }
}
