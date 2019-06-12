/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.AddPiecesForm;
import View.OkDialog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Melissa
 */
public class ConcessionaireDAO {
    Link connection;
    
    public ConcessionaireDAO(){
        connection = new Link();
    }
    
    public void registerConcessionaire(ConcessionaireVO cli)
    {
        Connection link = connection.getConnection();
        try
        {
            PreparedStatement statement = link.prepareStatement("INSERT INTO concesionario(id_concesionario, ruc_concesionario,nombre_concesionario, direccion_concesionario, ciudad_concesionario, representante_concesionario, telefono_concesionario, celular_concesionario,email_concesionario,fax_concesionario) VALUES(?, ?, ?, ?, ?, ? , ? , ? , ? , ?)");
           
            statement.setInt(1, cli.idConcesionario);
            statement.setString(2, cli.rucConcesionario);
            statement.setString(3, cli.nombreConcesionario);
            statement.setString(4, cli.direccionConcesionario);
            statement.setString(5, cli.ciudadConcesionario);
            statement.setString(6, cli.representanteConcesionario);
            statement.setString(7, cli.telefonoConcesionario);
            statement.setString(8, cli.celularConcesionario);
            statement.setString(9, cli.emailConcesionario);
            statement.setString(10, cli.faxConcesionario);
            statement.executeUpdate();
            OkDialog dialog = new OkDialog(new AddPiecesForm(), true);
            dialog.dialogText.setText("Successful data registration.");
            dialog.setVisible(true);
        }
        catch(SQLException e)
        {
            System.out.println("" + e.getMessage());
            OkDialog dialog = new OkDialog(new AddPiecesForm(), true);
            dialog.dialogText.setText("Can not register the data.");
            dialog.setVisible(true);
        }
    }
    
    public void modificarConcesionario(ConcessionaireVO cli){
        try{
            Connection link = connection.getConnection();
            PreparedStatement ps=link.prepareStatement("UPDATE concesionario SET ruc_concesionario='"+cli.getRucConcesionario()+"',nombre_concesionario='"+cli.getNombreConcesionario()+"',direccion_concesionario='"+cli.getDireccionConcesionario()+"',ciudad_concesionario='"+cli.getCiudadConcesionario()+"',representante_concesionario='"+cli.getRepresentanteConcesionario()+"',telefono_concesionario='"+cli.getTelefonoConcesionario()+"',celular_concesionario='"+cli.getCelularConcesionario()+"',email_concesionario='"+cli.getEmailConcesionario()+"',fax_concesionario='"+cli.getFaxConcesionario()+"'WHERE id_concesionario='"+cli.getIdConcesionario()+"'");
            ps.executeUpdate();
            System.out.println("exito cambio");
        }catch(SQLException e){
            System.out.println(e);
        }
         }
    public void eliminarCliente(int id){
       
        try{
            String SQL="delete from concesionario where id_concesionario="+id;
            Connection link = connection.getConnection();
            Statement st=link.createStatement();
            int n=st.executeUpdate(SQL);
            if(n>=0){
                JOptionPane.showMessageDialog(null, "Registro eliminado");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error a eliminar"+e.getMessage());
        }
        
    }
    
     public ArrayList<ConcessionaireVO> mostrarConcesionario(){
        ArrayList<ConcessionaireVO> arr=new ArrayList<ConcessionaireVO>();
        ConcessionaireVO cli;
        try {
            Connection link = connection.getConnection();
            PreparedStatement ps=link.prepareStatement("SELECT * from concesionario");
            ResultSet rs = ps.executeQuery();  //es una coleccion de los registros
            while(rs.next()){
                cli=new ConcessionaireVO();
                cli.setIdConcesionario(rs.getInt(1));
                cli.setRucConcesionario(rs.getString(2));
                cli.setNombreConcesionario(rs.getString(3));
                cli.setDireccionConcesionario(rs.getString(4));
                cli.setCiudadConcesionario(rs.getString(5));
                cli.setRepresentanteConcesionario(rs.getString(6));
                cli.setTelefonoConcesionario(rs.getString(7));
                cli.setCelularConcesionario(rs.getString(8));
                cli.setEmailConcesionario(rs.getString(9));
                cli.setFaxConcesionario(rs.getString(10));
                arr.add(cli);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return arr;
    }
    
}
