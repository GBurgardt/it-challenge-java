/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Alumno;
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
public class AlumnoFacade extends AbstractFacade<Alumno> {

    @PersistenceContext(unitName = "com.burgardt_TecsoAppLib_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlumnoFacade() {
        super(Alumno.class);
    }
    
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean setAlumnoNuevo(Alumno alumno) {
        boolean transaccion = true;
        try {
            em.persist(alumno);
            em.flush();
            return transaccion;
        } catch (Exception e){
            System.out.println(e);
            transaccion = false;
            return transaccion;
        }
    }
       
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean editAlumno(Alumno alumno) {
        boolean transaccion = true;
        try {
            em.merge(alumno);
            em.flush();
            return transaccion;
        } catch (Exception e){
            transaccion = false;
            return transaccion;
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean deleteAlumno(Alumno alumno) {
        boolean transaccion = true;
        try {
            em.remove(alumno);
            em.flush();
            return transaccion;
        } catch (Exception e){
            transaccion = false;
            return transaccion;
        }
    }
    
    /**
     * Busca un alumno por su legajo (TODO: Estoy suponiendo que todos tienen legajo único, para simplificar
     * @param legajo
     * @return 
     */
    public Alumno findByLegajo(Integer legajo) {
        Alumno ret = null;
        try {
            ret = (Alumno) em.createNamedQuery("Alumno.findByLegajo")
                .setParameter("legajo", legajo)
                .getSingleResult();
            
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
        return ret;
    }
    
    /**
     * Limpia cache y retorna un alumno dado su id
     * @param idAlumno
     * @return 
     */
    public Alumno findById(Integer idAlumno) {
        em.getEntityManagerFactory().getCache().evictAll();
//        em.getEntityManagerFactory().getCache().evict(Curso.class, "identificador");
        
        return this.find(idAlumno);
    }
}
