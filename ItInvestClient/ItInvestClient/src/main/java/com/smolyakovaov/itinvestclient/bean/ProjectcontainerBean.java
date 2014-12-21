/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.itinvestclient.bean;

import com.smolyakovaov.ws.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Honaht
 */
public class ProjectcontainerBean {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ItInvestServer-web/TimeschedulerService.wsdl")
    private TimeschedulerService_Service service_timescheduler;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ItInvestServer-web/WorkersService.wsdl")
    private WorkersService_Service service_workers;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ItInvestServer-web/WagesService.wsdl")
    private WagesService_Service service_wages;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ItInvestServer-web/PromotionService.wsdl")
    private PromotionService_Service service_promotion;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ItInvestServer-web/OtherdrainService.wsdl")
    private OtherdrainService_Service service_otherdrain;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ItInvestServer-web/QualityService.wsdl")
    private QualityService_Service service_quality;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ItInvestServer-web/SalesService.wsdl")
    private SalesService_Service service_sales;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ItInvestServer-web/ProjectcontainerService.wsdl")
    private ProjectcontainerService_Service service;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ItInvestServer-web/ProjectService.wsdl")
    private ProjectService_Service service_project;

    private Projectcontainer tempProjectcontainer;

    public Projectcontainer getTempProjectcontainer() {
        return tempProjectcontainer;
    }

    public void setTempProjectcontainer(Projectcontainer tempProjectcontainer) {
        this.tempProjectcontainer = tempProjectcontainer;
    }
    
    /**
     * Creates a new instance of ProjectcontainerBean
     */
    public ProjectcontainerBean() {
    }
    
    public Projectcontainer getProjectcontainerByProject(int id) {
        Projectcontainer res = null;        
        try { // Call Web Service Operation
            ProjectcontainerService port = service.getProjectcontainerServicePort();
            Project project = service_project.getProjectServicePort().getProject(id);
            // TODO initialize WS operation arguments here
            res = port.getProjectcontainerByProject(id);
            if (res.getTimescheduler()==null) {res.setTimescheduler(new Timescheduler()); res.getTimescheduler().setId(0);res.getTimescheduler().setProject(project);}
            if (res.getWorkers()==null) {res.setWorkers(new Workers()); res.getWorkers().setId(0);res.getWorkers().setProject(project);}
            if (res.getWages()==null) {res.setWages(new Wages()); res.getWages().setId(0);res.getWages().setProject(project);}
            if (res.getPromotion()==null) {res.setPromotion(new Promotion()); res.getPromotion().setId(0);res.getPromotion().setProject(project);}
            if (res.getOtherdrain()==null) {res.setOtherdrain(new Otherdrain()); res.getOtherdrain().setId(0);res.getOtherdrain().setProject(project);}
            if (res.getQuality()==null) {res.setQuality(new Quality()); res.getQuality().setId(0);res.getQuality().setProject(project);}
            if (res.getSales()==null) {res.setSales(new Sales()); res.getSales().setId(0);res.getSales().setProject(project);}
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }
        return res;
    }
    
    public void createTimescheduler() {
        try { // Call Web Service Operation
            TimeschedulerService port = service_timescheduler.getTimeschedulerServicePort();
            // TODO initialize WS operation arguments here
            tempProjectcontainer.setTimescheduler(port.createTimescheduler(tempProjectcontainer.getTimescheduler()));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }

    }
    
    public void editTimescheduler() {
        try { // Call Web Service Operation
            TimeschedulerService port = service_timescheduler.getTimeschedulerServicePort();
            // TODO initialize WS operation arguments here
            port.editTimescheduler(tempProjectcontainer.getTimescheduler());
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }
    }
    
    public void createWorkers() {
        try { // Call Web Service Operation
            WorkersService port = service_workers.getWorkersServicePort();
            // TODO initialize WS operation arguments here
            tempProjectcontainer.setWorkers(port.createWorkers(tempProjectcontainer.getWorkers()));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }

    }
    
    public void editWorkers() {
        try { // Call Web Service Operation
            WorkersService port = service_workers.getWorkersServicePort();
            // TODO initialize WS operation arguments here
            port.editWorkers(tempProjectcontainer.getWorkers());
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }
    }
    
    public void createWages() {
        try { // Call Web Service Operation
            WagesService port = service_wages.getWagesServicePort();
            // TODO initialize WS operation arguments here
            tempProjectcontainer.setWages(port.createWages(tempProjectcontainer.getWages()));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }

    }
    
    public void editWages() {
        try { // Call Web Service Operation
            WagesService port = service_wages.getWagesServicePort();
            // TODO initialize WS operation arguments here
            port.editWages(tempProjectcontainer.getWages());
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }
    }
    
    public void createPromotion() {
        try { // Call Web Service Operation
            PromotionService port = service_promotion.getPromotionServicePort();
            // TODO initialize WS operation arguments here
            tempProjectcontainer.setPromotion(port.createPromotion(tempProjectcontainer.getPromotion()));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }

    }
    
    public void editPromotion() {
        try { // Call Web Service Operation
            PromotionService port = service_promotion.getPromotionServicePort();
            // TODO initialize WS operation arguments here
            port.editPromotion(tempProjectcontainer.getPromotion());
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }
    }
    
    public void createQuality() {
        try { // Call Web Service Operation
            QualityService port = service_quality.getQualityServicePort();
            // TODO initialize WS operation arguments here
            tempProjectcontainer.setQuality(port.createQuality(tempProjectcontainer.getQuality()));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }

    }
    
    public void editQuality() {
        try { // Call Web Service Operation
            QualityService port = service_quality.getQualityServicePort();
            // TODO initialize WS operation arguments here
            port.editQuality(tempProjectcontainer.getQuality());
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }
    }
    
    public void createOtherdrain() {
        try { // Call Web Service Operation
            OtherdrainService port = service_otherdrain.getOtherdrainServicePort();
            // TODO initialize WS operation arguments here
            tempProjectcontainer.setOtherdrain(port.createOtherdrain(tempProjectcontainer.getOtherdrain()));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }

    }
    
    public void editOtherdrain() {
        try { // Call Web Service Operation
            OtherdrainService port = service_otherdrain.getOtherdrainServicePort();
            // TODO initialize WS operation arguments here
            port.editOtherdrain(tempProjectcontainer.getOtherdrain());
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }
    }
    
    public void createSales() {
        try { // Call Web Service Operation
            SalesService port = service_sales.getSalesServicePort();
            // TODO initialize WS operation arguments here
            tempProjectcontainer.setSales(port.createSales(tempProjectcontainer.getSales()));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }

    }
    
    public void editSales() {
        try { // Call Web Service Operation
            SalesService port = service_sales.getSalesServicePort();
            // TODO initialize WS operation arguments here
            port.editSales(tempProjectcontainer.getSales());
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
        }
    }
}
