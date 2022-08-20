package cic.javadiplo.appear.web.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named(value="mensajesController")
@RequestScoped
public class MensajesController {
    private String email;
    private String password;

    public String enviar(){
        try{
            if(password.equals("321")){
//                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                        "Contraseña incorrecta","Contraseña incorrecta");
//                FacesContext fc= FacesContext.getCurrentInstance();
//                fc.addMessage("formEtiquetasMensajes:pass",mensaje);
//                return null;
                return "EXITO";
            }else{
                return "ERROR";
            }
            //throw new Exception("Excepción Simulada");
        }catch (Exception e){
            FacesMessage mensaje = new FacesMessage(e.getMessage());
            FacesContext fc= FacesContext.getCurrentInstance();
            fc.addMessage("formEtiquetasMensajes:enviarBtn",mensaje);
            return null;
        }

    }
     public String enviar2(){
        return "EXITO";
     }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
