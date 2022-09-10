package cic.javadiplo.appear.web.controller.jpa;

import cic.javadiplo.appear.ejb.exception.SaveEntityException;
import cic.javadiplo.appear.ejb.modelo.DepartamentoEnt;
import cic.javadiplo.appear.ejb.modelo.EmpleadoEnt;
import cic.javadiplo.appear.ejb.servicios.CatalogosServiceLocal;
import cic.javadiplo.appear.ejb.servicios.DepartamentoServiceLocal;
import cic.javadiplo.appear.ejb.servicios.EmpleadoServiceLocal;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value = "altaEmpleadoController")
@ViewScoped
public class AltaEmpleadoController implements Serializable {
    private static final Logger logger = Logger.getLogger(AltaEmpleadoController.class.getName());

    private EmpleadoEnt nuevo;
    private Integer idDepartamento;
    private List<DepartamentoEnt> catDeptos;

    @Inject
    private EmpleadoServiceLocal empledoSB;
    @Inject
    private DepartamentoServiceLocal deptoSB;
    @Inject
    private CatalogosServiceLocal catalogoSB;

    @PostConstruct
    public void inicia(){
        nuevo = new EmpleadoEnt();
        catDeptos = catalogoSB.getCatalogoDepartamentos();
    }

    public void salvar(){
        logger.log(Level.INFO,"valor idDepartamento : {0}",idDepartamento);
        DepartamentoEnt depto = deptoSB.getDepartamento(idDepartamento);
        nuevo.setDepartamento(depto);
        try {
            empledoSB.crear(nuevo);
        }catch (SaveEntityException ex){
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Imposible guardar empleado",
                    ex.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null,mensaje);
            return;
        }
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,
                                        "Empleado guardado",
                                          "Empleado guardado");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null,mensaje);
    }
    public EmpleadoEnt getNuevo() {
        return nuevo;
    }

    public void setNuevo(EmpleadoEnt nuevo) {
        this.nuevo = nuevo;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public List<DepartamentoEnt> getCatDeptos() {
        return catDeptos;
    }
}
