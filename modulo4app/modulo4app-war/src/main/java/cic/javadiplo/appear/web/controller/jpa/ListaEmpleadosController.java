package cic.javadiplo.appear.web.controller.jpa;

import cic.javadiplo.appear.ejb.modelo.EmpleadoEnt;
import cic.javadiplo.appear.ejb.servicios.EmpleadoServiceLocal;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value="listaEmpleadosController")
@ViewScoped
public class ListaEmpleadosController implements Serializable {
    private static final Logger logger = Logger.getLogger(ListaEmpleadosController.class.getName());

    private List<EmpleadoEnt> empleadoLista;

    @Inject
    private EmpleadoServiceLocal empledoSB;

    @PostConstruct
    public void init(){
        logger.log(Level.INFO,"Inicia Carga de Empleados");
        empleadoLista = empledoSB.listar();
    }

    public List<EmpleadoEnt> getEmpleadoLista() {
        return empleadoLista;
    }
}
