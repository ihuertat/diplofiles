package cic.javadiplo.appear.web.controller.proyecto;

import cic.javadiplo.appear.ejb.modelo.ProyectoEnt;
import cic.javadiplo.appear.ejb.servicios.CatalogosServiceLocal;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Named(value="proyectoController")
@ViewScoped
public class ProyectoController implements Serializable {
    private static final Logger logger = Logger.getLogger(ProyectoController.class.getName());

    @Inject
    private CatalogosServiceLocal catalogosService;
    private List<ProyectoEnt> listaProyectos;

    @PostConstruct
    public void init(){
        listaProyectos = catalogosService.getCatalogoProyectos();
    }

    public String nuevoProyecto(){
        return "/prime/nuevoProyecto?faces-redirect=true";
    }

    public List<ProyectoEnt> getListaProyectos() {
        return listaProyectos;
    }

    public void setListaProyectos(List<ProyectoEnt> listaProyectos) {
        this.listaProyectos = listaProyectos;
    }
}
