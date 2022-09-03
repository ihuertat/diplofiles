package cic.javadiplo.appear.ejb.servicios;

import cic.javadiplo.appear.ejb.modelo.DepartamentoEnt;
import cic.javadiplo.appear.ejb.modelo.ProyectoEnt;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface CatalogosServiceLocal {
    List<DepartamentoEnt> getCatalogoDepartamentos();
    List<ProyectoEnt> getCatalogoProyectos();
}
