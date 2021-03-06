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
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
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
    
    public Degree getDegree(java.lang.Integer id) {
        return degreeService.find(id);
    }
    
     @FacesConverter(forClass = Degree.class)
    public static class DegreeControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DegreeController controller = (DegreeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "degreeController");
            return controller.getDegree(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Degree) {
                Degree o = (Degree) object;
                return getStringKey(o.getIdDegree());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Degree.class.getName());
            }
        }
    
}
    
}
