package cic.javadiplo.appear.ejb.servicios;

import cic.javadiplo.appear.ejb.modelo.EmpleadoEnt;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class EmpleadoServiceImp extends AbstractServiceFacade<EmpleadoEnt>
                                implements EmpleadoServiceLocal{
    @PersistenceContext(name="diplojavaDS")
    private EntityManager em;

    public EmpleadoServiceImp(){
        super(EmpleadoEnt.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<EmpleadoEnt> listar() {
        return em.createQuery("from EmpleadoEnt",EmpleadoEnt.class).getResultList();
    }
}
