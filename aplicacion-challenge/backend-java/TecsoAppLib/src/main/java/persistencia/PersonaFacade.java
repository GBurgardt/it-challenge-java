/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Persona;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author germanburgardt
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> {

    @PersistenceContext(unitName = "com.burgardt_TecsoAppLib_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
    
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean setPersonaNueva(Persona persona) {
        boolean transaccion = true;
        try {
            em.persist(persona);
            em.flush();
            return transaccion;
        } catch (Exception e){
            System.out.println(e);
            transaccion = false;
            return transaccion;
        }
    }
       
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean editPersona(Persona persona) {
        boolean transaccion = true;
        try {
            em.merge(persona);
            em.flush();
            return transaccion;
        } catch (Exception e){
            transaccion = false;
            return transaccion;
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean deletePersona(Persona persona) {
        boolean transaccion = true;
        try {
            em.remove(persona);
            em.flush();
            return transaccion;
        } catch (Exception e){
            transaccion = false;
            return transaccion;
        }
    }
    
}
