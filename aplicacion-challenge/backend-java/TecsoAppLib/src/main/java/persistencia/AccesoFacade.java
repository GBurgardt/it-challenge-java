/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Acceso;
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
public class AccesoFacade extends AbstractFacade<Acceso> {

    @PersistenceContext(unitName = "com.burgardt_TecsoAppLib_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccesoFacade() {
        super(Acceso.class);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean setAccesoNuevo(Acceso acceso) {
        boolean transaccion = true;
        try {
            em.persist(acceso);
            em.flush();
            return transaccion;
        } catch (Exception e){
            System.out.println(e);
            transaccion = false;
            return transaccion;
        }
    }
    
    
    /**
     * Busco un Acceso dado un token
     * @param token
     * @return 
     */
    public Acceso findByToken(String token) {
        Acceso ret = null;
        try {
            ret = (Acceso) em.createNamedQuery("Acceso.findByToken")
                .setParameter("token", token)
                .getSingleResult();
            
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
        return ret;
    }
}
