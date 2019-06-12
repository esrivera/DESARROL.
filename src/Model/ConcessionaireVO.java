/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Melissa
 */
public class ConcessionaireVO {
    int idConcesionario;
    String rucConcesionario;
    String nombreConcesionario;
    String direccionConcesionario;
    String ciudadConcesionario;
    String representanteConcesionario;
    String telefonoConcesionario;
    String celularConcesionario;
    String emailConcesionario;
    String faxConcesionario;
    public ConcessionaireVO(){
        
    }
    public ConcessionaireVO(int idConcesionario, String rucConcesionario, String nombreConcesionario, String direccionConcesionario, String ciudadConcesionario, String representanteConcesionario, String telefonoConcesionario, String celularConcesionario, String emailConcesionario,String faxConcesionario) {
        this.idConcesionario = idConcesionario;
        this.rucConcesionario = rucConcesionario;
        this.nombreConcesionario = nombreConcesionario;
        this.direccionConcesionario = direccionConcesionario;
        this.ciudadConcesionario = ciudadConcesionario;
        this.representanteConcesionario = representanteConcesionario;
        this.telefonoConcesionario = telefonoConcesionario;
        this.celularConcesionario = celularConcesionario;
        this.emailConcesionario=emailConcesionario;
        this.faxConcesionario = faxConcesionario;
    }

    public String getEmailConcesionario() {
        return emailConcesionario;
    }

    public void setEmailConcesionario(String emailConcesionario) {
        this.emailConcesionario = emailConcesionario;
    }

    public int getIdConcesionario() {
        return idConcesionario;
    }

    public void setIdConcesionario(int idConcesionario) {
        this.idConcesionario = idConcesionario;
    }

    public String getRucConcesionario() {
        return rucConcesionario;
    }

    public void setRucConcesionario(String rucConcesionario) {
        this.rucConcesionario = rucConcesionario;
    }

    public String getNombreConcesionario() {
        return nombreConcesionario;
    }

    public void setNombreConcesionario(String nombreConcesionario) {
        this.nombreConcesionario = nombreConcesionario;
    }

    public String getDireccionConcesionario() {
        return direccionConcesionario;
    }

    public void setDireccionConcesionario(String direccionConcesionario) {
        this.direccionConcesionario = direccionConcesionario;
    }

    public String getCiudadConcesionario() {
        return ciudadConcesionario;
    }

    public void setCiudadConcesionario(String ciudadConcesionario) {
        this.ciudadConcesionario = ciudadConcesionario;
    }

    public String getRepresentanteConcesionario() {
        return representanteConcesionario;
    }

    public void setRepresentanteConcesionario(String representanteConcesionario) {
        this.representanteConcesionario = representanteConcesionario;
    }

    public String getTelefonoConcesionario() {
        return telefonoConcesionario;
    }

    public void setTelefonoConcesionario(String telefonoConcesionario) {
        this.telefonoConcesionario = telefonoConcesionario;
    }

    public String getCelularConcesionario() {
        return celularConcesionario;
    }

    public void setCelularConcesionario(String celularConcesionario) {
        this.celularConcesionario = celularConcesionario;
    }

    public String getFaxConcesionario() {
        return faxConcesionario;
    }

    public void setFaxConcesionario(String faxConcesionario) {
        this.faxConcesionario = faxConcesionario;
    }
            
    
         
    
    
}
