package cic.javadiplo.appear.ejb.servicios;

import cic.javadiplo.appear.ejb.modelo.DepartamentoEnt;
import cic.javadiplo.appear.ejb.modelo.ProyectoEnt;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class CatalogosServiceImp implements CatalogosServiceLocal {

    @Inject
    private DepartamentoServiceLocal departamentoService;
    @Inject
    private ProyectoServiceLocal proyectoService;

    @Override
    public List<DepartamentoEnt> getCatalogoDepartamentos() {
        return departamentoService.listar();
    }

    @Override
    public List<ProyectoEnt> getCatalogoProyectos() {
        return proyectoService.listar();
    }
}
