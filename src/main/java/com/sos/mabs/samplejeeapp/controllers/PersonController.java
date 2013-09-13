/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.samplejeeapp.controllers;

import com.sos.mabs.samplejeeapp.entities.Person;
import com.sos.mabs.samplejeeapp.entities.Qualification;
import com.sos.mabs.samplejeeapp.services.PersonFacade;
import com.sos.mabs.samplejeeapp.services.QualificationFacade;
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
 * http://www.ixtendo.com/secure-your-jsf-application-with-jaas/
 */
@Named(value = "personController")
@SessionScoped
public class PersonController implements Serializable {

    @Inject
    private PersonFacade personService;
    @Inject
    private QualificationFacade qualificationService;
    
    private Qualification newQualification;
    private Qualification lastQualification;
    private List<Qualification> qualifications;
    
    private Person person;
    private Person newPerson;
    private List<Person> persons;
    /**
     * Creates a new instance of PersonController
     */
    public PersonController() {
    }
    
    public String showList(){
        return "list?faces-redirect=true";
    }
    public String showCreate(){
        newPerson = new Person();
        return "new?faces-redirect=true";
    }
    public String showView(Person item){
        this.person = item;
        return "view?faces-redirect=true";
    }
    
    public String showAddQualification(){
        newQualification = new Qualification();
        return "addQualification?faces-redirect=true";
    }
    
    public String showCertificate(){
        lastQualification = personService.getLatetstFormation(person);
        return "certificate?faces-redirect=true";
    }
    
    
    public List<Person> getAll(){
        return personService.findAll();
    }

    public String doCreate(){
        System.out.println("The person is : " + newPerson.getName() + " " + newPerson.getLastName());
        personService.create(newPerson);
        return this.showList();
    }
    
    public String doAddQualification(){
        newQualification.setPerson(person);
        qualificationService.create(newQualification);
        person.getQualificationList().add(newQualification);
        return "view?faces-redirect=true";
    }
    
    
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getNewPerson() {
        return newPerson;
    }

    public void setNewPerson(Person newPerson) {
        this.newPerson = newPerson;
    }

    public Qualification getNewQualification() {
        return newQualification;
    }

    public void setNewQualification(Qualification newQualification) {
        this.newQualification = newQualification;
    }

    public Qualification getLastQualification() {
        return lastQualification;
    }

    public void setLastQualification(Qualification lastQualification) {
        this.lastQualification = lastQualification;
    }
    
    public Person getPerson(java.lang.Integer id) {
        return personService.find(id);
    }
    
     @FacesConverter(forClass = Person.class)
    public static class PersonControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PersonController controller = (PersonController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "personController");
            return controller.getPerson(getKey(value));
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
            if (object instanceof Person) {
                Person o = (Person) object;
                return getStringKey(o.getIdPerson());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Person.class.getName());
            }
        }
    
}
    
}
