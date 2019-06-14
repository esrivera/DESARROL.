/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Randy
 */
public class ConcessionerVO {
    private int idConcessioner;
    private String rucConcessioner;
    private String nameConcessioner;
    private String addressConcessioner;
    private String cityConcessioner;
    private String legalRepresentativeConcessioner;
    private String phoneConcessioner;
    private String cellphoneConcessioner;
    private String emailConcessioner;
    private String faxConcessioner;
    
    public ConcessionerVO(){
        
    }
    public ConcessionerVO(int idConcessioner, String rucConcessioner, String nameConcessioner, String addressConcessioner,
            String cityConcessioner, String legalRepresentativeConcessioner, String phoneConcessioner, String cellphoneConcessioner,
            String emailConcessioner,String faxConcessioner) {
        this.idConcessioner = idConcessioner;
        this.rucConcessioner = rucConcessioner;
        this.nameConcessioner = nameConcessioner;
        this.addressConcessioner = addressConcessioner;
        this.cityConcessioner = cityConcessioner;
        this.legalRepresentativeConcessioner = legalRepresentativeConcessioner;
        this.phoneConcessioner = phoneConcessioner;
        this.cellphoneConcessioner = cellphoneConcessioner;
        this.emailConcessioner= emailConcessioner;
        this.faxConcessioner = faxConcessioner;
    }

    public int getIdConcessioner() {
        return idConcessioner;
    }

    public void setIdConcessioner(int idConcessioner) {
        this.idConcessioner = idConcessioner;
    }

    public String getRucConcessioner() {
        return rucConcessioner;
    }

    public void setRucConcessioner(String rucConcessioner) {
        this.rucConcessioner = rucConcessioner;
    }

    public String getNameConcessioner() {
        return nameConcessioner;
    }

    public void setNameConcessioner(String nameConcessioner) {
        this.nameConcessioner = nameConcessioner;
    }

    public String getAddressConcessioner() {
        return addressConcessioner;
    }

    public void setAddressConcessioner(String addressConcessioner) {
        this.addressConcessioner = addressConcessioner;
    }

    public String getCityConcessioner() {
        return cityConcessioner;
    }

    public void setCityConcessioner(String cityConcessioner) {
        this.cityConcessioner = cityConcessioner;
    }

    public String getLegalRepresentativeConcessioner() {
        return legalRepresentativeConcessioner;
    }

    public void setLegalRepresentativeConcessioner(String legalRepresentativeConcessioner) {
        this.legalRepresentativeConcessioner = legalRepresentativeConcessioner;
    }

    public String getPhoneConcessioner() {
        return phoneConcessioner;
    }

    public void setPhoneConcessioner(String phoneConcessioner) {
        this.phoneConcessioner = phoneConcessioner;
    }

    public String getCellphoneConcessioner() {
        return cellphoneConcessioner;
    }

    public void setCellphoneConcessioner(String cellphoneConcessioner) {
        this.cellphoneConcessioner = cellphoneConcessioner;
    }

    public String getEmailConcessioner() {
        return emailConcessioner;
    }

    public void setEmailConcessioner(String emailConcessioner) {
        this.emailConcessioner = emailConcessioner;
    }

    public String getFaxConcessioner() {
        return faxConcessioner;
    }

    public void setFaxConcessioner(String faxConcessioner) {
        this.faxConcessioner = faxConcessioner;
    }
    
    
}
