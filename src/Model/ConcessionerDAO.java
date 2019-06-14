/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.AddConcessionerForm;
import View.DeleteConcessionerForm;
import View.ModifyConcessionerForm;
import View.OkDialog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Randy
 */
public class ConcessionerDAO {
    Link connection;
    
    public ConcessionerDAO(){
        connection = new Link();
    }
    
    
    public void registerConcessioner(ConcessionerVO concessioner)
    {
        Connection link = connection.getConnection();
        try
        {
            PreparedStatement statement = link.prepareStatement("INSERT INTO concessioners(idConcessioner, rucConcessioner,nameConcessioner,"
                    + "addressConcessioner, cityConcessioner, legalRepresentativeConcessioner, phoneConcessioner, cellphoneConcessioner, "
                    + "emailConcessioner, faxConcessioner) VALUES(?, ?, ?, ?, ?, ? , ? , ? , ? , ?)");
           
            statement.setInt(1, concessioner.getIdConcessioner());
            statement.setString(2, concessioner.getRucConcessioner());
            statement.setString(3, concessioner.getNameConcessioner());
            statement.setString(4, concessioner.getAddressConcessioner());
            statement.setString(5, concessioner.getCityConcessioner());
            statement.setString(6, concessioner.getLegalRepresentativeConcessioner());
            statement.setString(7, concessioner.getPhoneConcessioner());
            statement.setString(8, concessioner.getCellphoneConcessioner());
            statement.setString(9, concessioner.getEmailConcessioner());
            statement.setString(10, concessioner.getFaxConcessioner());
            statement.executeUpdate();
            OkDialog dialog = new OkDialog(new AddConcessionerForm(), true);
            dialog.dialogText.setText("Successful data registration.");
            dialog.setVisible(true);
        }
        catch(SQLException e)
        {
            System.out.println("" + e.getMessage());
            OkDialog dialog = new OkDialog(new AddConcessionerForm(), true);
            dialog.dialogText.setText("Can not register the data.");
            dialog.setVisible(true);
        }
    }
    
    public void modifyConcessioner(ConcessionerVO concessioner){
        try{
            Connection link = connection.getConnection();
            PreparedStatement ps=link.prepareStatement("UPDATE concessioner SET rucConcessioner='"+concessioner.getRucConcessioner()+"',nameConcessioner='"+concessioner.getNameConcessioner() 
                    + "',addressConcessioner='"+concessioner.getAddressConcessioner()+"',cityConcessioner='"+concessioner.getCityConcessioner()+"',legalRepresentativeConcessioner='" 
                    +concessioner.getLegalRepresentativeConcessioner()+"',phoneConcessioner='"+concessioner.getPhoneConcessioner()+"',cellphoneConcessioner='"+concessioner.getCellphoneConcessioner()
                    + "',emailConcessioner='"+concessioner.getEmailConcessioner()+"',faxConcessioner='"+concessioner.getFaxConcessioner()+"'WHERE idConcessioner='"+concessioner.getIdConcessioner()+"'");
            ps.executeUpdate();
            OkDialog dialog = new OkDialog(new ModifyConcessionerForm(), true);
            dialog.dialogText.setText("The data has been updated successfully");
            dialog.setVisible(true);
        }catch(SQLException e){
            System.out.println("" + e.getMessage());
            OkDialog dialog = new OkDialog(new ModifyConcessionerForm(), true);
            dialog.dialogText.setText("An error occurred when modifying the data.");
            dialog.setVisible(true);
        }
         }
    public void deleteConcessioner(int id){
       
        try{
            String SQL="delete from concessioner where idConcessioner="+id;
            Connection link = connection.getConnection();
            Statement st=link.createStatement();
            int n=st.executeUpdate(SQL);
            if(n>=0){
                OkDialog dialog = new OkDialog(new DeleteConcessionerForm(), true);
                dialog.dialogText.setText("Data removed successfully.");
                dialog.setVisible(true);
            }
            
        }catch(Exception e){
            System.out.println("" + e.getMessage());
            OkDialog dialog = new OkDialog(new DeleteConcessionerForm(), true);
            dialog.dialogText.setText("An error occurred while deleting the data.");
            dialog.setVisible(true);
        }
        
    }
    
     public ArrayList<ConcessionerVO> viewConcessioner(){
        ArrayList<ConcessionerVO> arr=new ArrayList<ConcessionerVO>();
        ConcessionerVO concessioner;
        try {
            Connection link = connection.getConnection();
            PreparedStatement ps=link.prepareStatement("SELECT * from concessioners");
            ResultSet rs = ps.executeQuery();  //es una coleccion de los registros
            while(rs.next()){
                concessioner=new ConcessionerVO();
                concessioner.setIdConcessioner(rs.getInt(1));
                concessioner.setRucConcessioner(rs.getString(2));
                concessioner.setNameConcessioner(rs.getString(3));
                concessioner.setAddressConcessioner(rs.getString(4));
                concessioner.setCityConcessioner(rs.getString(5));
                concessioner.setLegalRepresentativeConcessioner(rs.getString(6));
                concessioner.setPhoneConcessioner(rs.getString(7));
                concessioner.setCellphoneConcessioner(rs.getString(8));
                concessioner.setEmailConcessioner(rs.getString(9));
                concessioner.setFaxConcessioner(rs.getString(10));
                arr.add(concessioner);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return arr;
    }
    
}
