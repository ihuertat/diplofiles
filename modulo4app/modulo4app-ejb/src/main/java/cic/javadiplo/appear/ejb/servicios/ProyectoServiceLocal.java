package cic.javadiplo.appear.ejb.servicios;

import cic.javadiplo.appear.ejb.exception.SaveEntityException;
import cic.javadiplo.appear.ejb.modelo.EmpleadoEnt;
import cic.javadiplo.appear.ejb.modelo.ProyectoEnt;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface ProyectoServiceLocal {
    List<ProyectoEnt> listar();
    public ProyectoEnt crear(ProyectoEnt entity) throws SaveEntityException;
    public ProyectoEnt actualiza(ProyectoEnt entity);
    public  void borrar(ProyectoEnt entity);

    public ProyectoEnt getProyecto(Integer id);
    public ProyectoEnt getProyectoCompleto(Integer id);
}
