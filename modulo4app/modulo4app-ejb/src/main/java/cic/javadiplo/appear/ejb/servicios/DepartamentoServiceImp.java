package cic.javadiplo.appear.ejb.servicios;

import cic.javadiplo.appear.ejb.modelo.DepartamentoEnt;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
public class DepartamentoServiceImp extends AbstractServiceFacade<DepartamentoEnt>
                                    implements DepartamentoServiceLocal{
    @PersistenceContext(name="diplojavaDS")
    private EntityManager em;

    public DepartamentoServiceImp(){
        super(DepartamentoEnt.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<DepartamentoEnt> listar() {
        Query qry = em.createQuery("from DepartamentoEnt",DepartamentoEnt.class);
        return qry.getResultList();
    }

    @Override
    public DepartamentoEnt getDepartamento(Integer id) {
        return em.find(DepartamentoEnt.class,id);
    }
}
