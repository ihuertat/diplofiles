package cic.javadiplo.appear.ejb.servicios;

import cic.javadiplo.appear.ejb.modelo.EmpleadoEnt;
import cic.javadiplo.appear.ejb.modelo.ProyectoEnt;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ProyectoServiceImp extends AbstractServiceFacade<ProyectoEnt>
                                         implements ProyectoServiceLocal {
    @PersistenceContext(name = "diplojavaDS")
    private EntityManager em;

    public ProyectoServiceImp() {
        super(ProyectoEnt.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<ProyectoEnt> listar() {
        return em.createQuery("from ProyectoEnt ORDER BY id", ProyectoEnt.class).getResultList();
    }

    @Override
    public ProyectoEnt getProyecto(Integer id) {
        return em.find(ProyectoEnt.class, id);
    }

    @Override
    public ProyectoEnt getProyectoCompleto(Integer id){
        ProyectoEnt proyecto = getProyecto(id);
        for(EmpleadoEnt e : proyecto.getEmpleados()){
            e.getId();
            e.getNombre();
        }
        return proyecto;
    }
}
