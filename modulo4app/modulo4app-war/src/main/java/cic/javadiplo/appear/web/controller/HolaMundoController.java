package cic.javadiplo.appear.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.Map;

@Named(value="holaMundoController")
@RequestScoped
public class HolaMundoController {
    private String mensaje;
    private String nombreParam;

    @PostConstruct
    public void init(){
        mensaje = "Hola mundo desde un Managebean";
    }

    public void construyeMensaje(){
//        Map<String,String> mapParametros = FacesContext.getCurrentInstance()
//                                                        .getExternalContext()
//                                                        .getRequestParameterMap();
//        String nombre = mapParametros.get("nombreCompleto");
        mensaje = "Bienvenido al nuevo mundo "+ nombreParam;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getNombreParam() {
        return nombreParam;
    }

    public void setNombreParam(String nombreParam) {
        this.nombreParam = nombreParam;
    }
}
