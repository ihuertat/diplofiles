package cic.javadiplo.appear.web.controller.proyecto;

import cic.javadiplo.appear.ejb.modelo.ProyectoEnt;
import cic.javadiplo.appear.ejb.servicios.CatalogosServiceLocal;
import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;

import java.io.Serializable;
import java.security.Principal;
import java.util.List;
import java.util.logging.Logger;

@Named(value="proyectoController")
@ViewScoped
public class ProyectoController implements Serializable {
    private static final Logger logger = Logger.getLogger(ProyectoController.class.getName());

    @Inject
    private CatalogosServiceLocal catalogosService;
    private List<ProyectoEnt> listaProyectos;
    private String usuario;

    @PostConstruct
    public void init(){
        listaProyectos = catalogosService.getCatalogoProyectos();
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        Principal principal = request.getUserPrincipal();
        usuario = principal.getName();
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
