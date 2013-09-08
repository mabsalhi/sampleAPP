/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.samplejeeapp.controllers;

import com.sos.mabs.samplejeeapp.entities.Degree;
import com.sos.mabs.samplejeeapp.services.DegreeFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author abdel
 */
@Named(value = "degreeController")
@SessionScoped
public class DegreeController implements Serializable {

    @Inject
    private DegreeFacade degreeService;
    
    private Degree degree;
    private Degree newDegree;
    private List<Degree> degrees;
    /**
     * Creates a new instance of DegreeController
     */
    
    public String showList(){
        return "list?faces-redirect=true";
    }
    public String showCreate(){
        newDegree = new Degree();
        return "new?faces-redirect=true";
    }
    public String showView(Degree item){
        this.degree = item;
        return "view?faces-redirect=true";
    }
    
    public List<Degree> getAll(){
        return degreeService.findAll();
    }

    public String doCreate(){
        System.out.println("The person is : " + newDegree.getEntitled());
        degreeService.create(newDegree);
        return this.showList();
    }
    
    public DegreeController() {
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Degree getNewDegree() {
        return newDegree;
    }

    public void setNewDegree(Degree newDegree) {
        this.newDegree = newDegree;
    }
    
    
}
