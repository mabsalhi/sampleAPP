/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.samplejeeapp.services;

import com.sos.mabs.samplejeeapp.entities.Person;
import com.sos.mabs.samplejeeapp.entities.Qualification;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author abdel
 */
@Stateless
public class PersonFacade extends AbstractFacade<Person> {
    @PersistenceContext(unitName = "com.sos.mabs_sampleJEEApp_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonFacade() {
        super(Person.class);
    }
    
    public Qualification getLatetstFormation(Person person){
        return (Qualification) em.createQuery("SELECT q FROM Qualification q WHERE q.graduateDate = (SELECT MAX(q.graduateDate) FROM Qualification q WHERE q.person = :person)")
                .setParameter("person", person)
                .getSingleResult();
         
    }
    
}
