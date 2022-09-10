package cic.javadiplo.appear.ejb.servicios;

import cic.javadiplo.appear.ejb.exception.SaveEntityException;
import cic.javadiplo.appear.ejb.modelo.DepartamentoEnt;
import cic.javadiplo.appear.ejb.modelo.EmpleadoEnt;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface EmpleadoServiceLocal {
    List<EmpleadoEnt> listar();
    public EmpleadoEnt crear(EmpleadoEnt entity) throws SaveEntityException;
    public EmpleadoEnt actualiza(EmpleadoEnt entity);
    public  void borrar(EmpleadoEnt entity);
}
