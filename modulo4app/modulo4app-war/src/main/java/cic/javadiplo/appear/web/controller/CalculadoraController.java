package cic.javadiplo.appear.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value = "calculadoraController")
@SessionScoped
public class CalculadoraController implements Serializable {
    private static final Logger logger = Logger.getLogger(CalculadoraController.class.getName());
    private static final String SUMA = "Suma";
    private static final String RESTA = "Resta";
    private static final String MULTIPLICA = "Multiplica";
    private static final String DIVIDE = "Divide";

    private int numero1;
    private int numero2;
    private int resultado;

    private String tipoOperacion;

    private List<SelectItem> listaOperaciones;

    @PostConstruct
    public void init(){
        numero1=0;
        numero2=0;
        resultado=0;
        tipoOperacion=null;
        llenarLista();
        logger.log(Level.INFO,"Inicio de atributos concluido");
    }

    private void llenarLista(){
        listaOperaciones = new ArrayList<>();
        listaOperaciones.add(new SelectItem(SUMA));
        listaOperaciones.add(new SelectItem(RESTA));
        listaOperaciones.add(new SelectItem(MULTIPLICA));
        listaOperaciones.add(new SelectItem(DIVIDE));
    }

    public void realizarOperacion(){
        switch (tipoOperacion){
            case SUMA : setResultado(numero1 + numero2);
                        break;
            case RESTA : setResultado(numero1 - numero2);
                        break;
            case MULTIPLICA:  setResultado(numero1 * numero2);
                            break;
            case DIVIDE : {
              try{
                  setResultado(numero1 / numero2);
              }catch (Exception ex){
                  // imprimir un mensaje
                  logger.log(Level.INFO,"No se puede dividir : {0}",ex.getMessage());
                  FacesMessage fsms = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                            "Imposible obtener resultado",
                                            "Se intenta dividir por 0");
                  FacesContext.getCurrentInstance().addMessage(null,fsms);
              }
            }
        }
        FacesMessage msExito = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Imposible obtener resultado",
                "Se intenta dividir por 0");
        FacesContext.getCurrentInstance().addMessage(null,msExito);
    }


    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public List<SelectItem> getListaOperaciones() {
        return listaOperaciones;
    }

}
