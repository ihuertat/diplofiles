package cic.javadiplo.appear.ejb.servicios;

import jakarta.persistence.EntityManager;

public abstract class AbstractServiceFacade<T> {

    private Class<T> claseEntidad;

    public AbstractServiceFacade(Class<T> claseEntidad){
        this.claseEntidad=claseEntidad;
    }

    public T crear(T entidad){
        EntityManager em = getEntityManager();
        em.persist(entidad);
        return entidad;
    }

    public T actualiza(T entidad){
        T entcopia;
        if(entidad!=null){
            entcopia = getEntityManager().merge(entidad);
            return entcopia;
        }
        return null;
    }

    public void borrar(T entidad){
        getEntityManager().remove(getEntityManager().merge(entidad));
    }

    abstract protected EntityManager getEntityManager();
}
