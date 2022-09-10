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
        String consulta = "select e from EmpleadoEnt e left join fetch e.departamento";
        return em.createQuery(consulta,EmpleadoEnt.class).getResultList();
    }
}
