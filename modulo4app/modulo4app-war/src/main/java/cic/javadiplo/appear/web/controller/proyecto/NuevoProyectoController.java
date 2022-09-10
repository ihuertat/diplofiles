package cic.javadiplo.appear.web.controller.proyecto;

import cic.javadiplo.appear.ejb.modelo.ProyectoEnt;
import cic.javadiplo.appear.ejb.servicios.ProyectoServiceLocal;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value ="nuevoProyectoController")
@ViewScoped
public class NuevoProyectoController implements Serializable {
    private static final Logger logger= Logger.getLogger(NuevoProyectoController.class.getName());
    @Inject
    private ProyectoServiceLocal proyectoService;

    private ProyectoEnt nuevo;

    @PostConstruct
    public void init(){
        nuevo = new ProyectoEnt();
    }

    public String guardaProyecto(){
        logger.log(Level.INFO,"Id Antes de guardar : {0}",nuevo.getId());
        try {
            nuevo = proyectoService.crear(nuevo);
        }catch (Exception e){}
        logger.log(Level.INFO,"Id proyecto nuevo asignado : {0}",nuevo.getId());

        return "/prime/listaProyectos?faces-redirect=true";
    }

    public ProyectoEnt getNuevo() {
        return nuevo;
    }

    public void setNuevo(ProyectoEnt nuevo) {
        this.nuevo = nuevo;
    }
}
