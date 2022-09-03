package cic.javadiplo.appear.ejb.servicios;

import cic.javadiplo.appear.ejb.modelo.DepartamentoEnt;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface DepartamentoServiceLocal {
    List<DepartamentoEnt> listar();
    public DepartamentoEnt crear(DepartamentoEnt entity);
    public DepartamentoEnt actualiza(DepartamentoEnt entity);
    public  void borrar(DepartamentoEnt entity);
}
