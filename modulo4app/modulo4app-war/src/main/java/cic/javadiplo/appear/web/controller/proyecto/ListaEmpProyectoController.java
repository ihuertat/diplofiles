package cic.javadiplo.appear.web.controller.proyecto;

import cic.javadiplo.appear.ejb.modelo.EmpleadoEnt;
import cic.javadiplo.appear.ejb.modelo.ProyectoEnt;
import cic.javadiplo.appear.ejb.servicios.ProyectoServiceLocal;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Named(value="listaEmpProyectoController")
@ViewScoped
public class ListaEmpProyectoController implements Serializable {
    private static final Logger logger= Logger.getLogger(ListaEmpProyectoController.class.getName());

    @Inject
    private ProyectoServiceLocal proyectoService;

    private String idProyecto;
    private ProyectoEnt proyActual;
    private List<EmpleadoEnt> empleadosLista;
    private EmpleadoEnt empleadoSelec;

    public String getIdProyecto() {
        return idProyecto;
    }

    public void cargaDatosProyecto(){
        logger.log(Level.INFO, "Id que vamos a buscar : {0}",idProyecto);
        Integer id = Integer.valueOf(idProyecto);
        proyActual = proyectoService.getProyectoCompleto(id);
        logger.log(Level.INFO, "Id  : {0}",proyActual.getId());
        logger.log(Level.INFO, "Nombre : {0}",proyActual.getNombre());
        logger.log(Level.INFO, "Empleados : {0}",proyActual.getEmpleados().size());
        for(EmpleadoEnt e : proyActual.getEmpleados()){
            logger.log(Level.INFO, "Id  : {0}",e.getId());
            logger.log(Level.INFO, "Nombre : {0}",e.getNombre());
            logger.log(Level.INFO, "Salario : {0}",e.getSalario());
        }
        empleadosLista = proyActual.getEmpleados().stream().collect(Collectors.toList());

    }


    public void removerEmpleado(){
        logger.log(Level.INFO,"Empleado a remover $$$$$$$$$: {0}",empleadoSelec.getNombre());
        proyActual.getEmpleados().remove(empleadoSelec);
        proyectoService.actualiza(proyActual);
        cargaDatosProyecto();
    }

    public EmpleadoEnt getEmpleadoSelec() {
        return empleadoSelec;
    }

    public void setEmpleadoSelec(EmpleadoEnt empleadoSelec) {
        this.empleadoSelec = empleadoSelec;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    public List<EmpleadoEnt> getEmpleadosLista() {
        return empleadosLista;
    }

    public ProyectoEnt getProyActual() {
        return proyActual;
    }
}
