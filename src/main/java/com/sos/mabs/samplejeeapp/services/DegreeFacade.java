/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.samplejeeapp.services;

import com.sos.mabs.samplejeeapp.entities.Degree;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author abdel
 */
@Stateless
public class DegreeFacade extends AbstractFacade<Degree> {
    @PersistenceContext(unitName = "com.sos.mabs_sampleJEEApp_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DegreeFacade() {
        super(Degree.class);
    }
    
}
