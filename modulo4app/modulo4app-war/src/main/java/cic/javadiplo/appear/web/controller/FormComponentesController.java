package cic.javadiplo.appear.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value="formComponentesController")
@RequestScoped
public class FormComponentesController {
    private static final Logger logger = Logger.getLogger(FormComponentesController.class.getName());

    private String texto;
    private String password;
    private String mensaje;
    private boolean check;
    private String opcionMenu;
    private String opcionMenuDiferente;
    private String oneMap;
    private String opcionRadio;
    private List<String> manyLista;
    private List<String> checkLista;
    private List<String> listaOpciones;
    private Map<String,String> mapaOpciones;

    @PostConstruct
    public void init(){
        listaOpciones = Arrays.asList("uno","dos","tres","cuatro");
        mapaOpciones = new LinkedHashMap<>();
        mapaOpciones.put("A","Opción A");
        mapaOpciones.put("B","Opción B");
        mapaOpciones.put("C","Opción C");
        mapaOpciones.put("D","Opción D");
    }

    public void submit(){
        logger.log(Level.INFO, "Dados enviados por el formulario");
        logger.log(Level.INFO, "texto : {0}",texto);
        logger.log(Level.INFO, "password : {0}",password);
        logger.log(Level.INFO, "mensaje : {0}",mensaje);
        logger.log(Level.INFO, "check : {0}",check);
        logger.log(Level.INFO, "OneMenu : {0}",opcionMenu);
        logger.log(Level.INFO, "OneRadio : {0}",opcionRadio);
        logger.log(Level.INFO, "ManySelect : {0}",manyLista);
        logger.log(Level.INFO, "ManyCheck : {0}",checkLista);
        logger.log(Level.INFO, "OpcionDiferente : {0}",opcionMenuDiferente);
        logger.log(Level.INFO,"oneMapa: {0}",oneMap);
    }

    public String getOneMap() {
        return oneMap;
    }

    public void setOneMap(String oneMap) {
        this.oneMap = oneMap;
    }

    public Map<String, String> getMapaOpciones() {
        return mapaOpciones;
    }

    public String getOpcionMenuDiferente() {
        return opcionMenuDiferente;
    }

    public void setOpcionMenuDiferente(String opcionMenuDiferente) {
        this.opcionMenuDiferente = opcionMenuDiferente;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getOpcionMenu() {
        return opcionMenu;
    }

    public void setOpcionMenu(String opcionMenu) {
        this.opcionMenu = opcionMenu;
    }

    public String getOpcionRadio() {
        return opcionRadio;
    }

    public void setOpcionRadio(String opcionRadio) {
        this.opcionRadio = opcionRadio;
    }

    public List<String> getManyLista() {
        return manyLista;
    }

    public void setManyLista(List<String> manyLista) {
        this.manyLista = manyLista;
    }

    public List<String> getCheckLista() {
        return checkLista;
    }

    public void setCheckLista(List<String> checkLista) {
        this.checkLista = checkLista;
    }

    public List<String> getListaOpciones() {
        return listaOpciones;
    }

}
