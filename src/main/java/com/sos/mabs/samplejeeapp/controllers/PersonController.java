/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.samplejeeapp.controllers;

import com.sos.mabs.samplejeeapp.entities.Person;
import com.sos.mabs.samplejeeapp.services.PersonFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author abdel
 */
@Named(value = "personController")
@SessionScoped
public class PersonController implements Serializable {

    @Inject
    private PersonFacade personService;
    
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
    
    public List<Person> getAll(){
        return personService.findAll();
    }

    public String doCreate(){
        System.out.println("The person is : " + newPerson.getName() + " " + newPerson.getLastName());
        personService.create(newPerson);
        return this.showList();
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
    
    
}
