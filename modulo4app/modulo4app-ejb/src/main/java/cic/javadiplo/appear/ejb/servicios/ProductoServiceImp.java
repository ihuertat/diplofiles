package cic.javadiplo.appear.ejb.servicios;

import cic.javadiplo.appear.ejb.modelo.ProductoEnt;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
public class ProductoServiceImp extends AbstractServiceFacade<ProductoEnt>
                                implements ProductoServiceLocal{
    @PersistenceContext(name="diplojavaDS")
    private EntityManager em;

    public ProductoServiceImp(){
        super(ProductoEnt.class);
    }

    @Override
    public List<ProductoEnt> listar() {
        Query consulta = em.createQuery("from ProductoEnt", ProductoEnt.class);
        return consulta.getResultList();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
