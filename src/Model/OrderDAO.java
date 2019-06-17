/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.AddOrderForm;
import View.OkDialog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Galito
 */
public class OrderDAO {
    Link connection;

    public OrderDAO() {
    }

    
    public OrderDAO(Link connection) {
       connection = new Link();
    }
    
     public void registerConcessioner(Order order)
    {
        Connection link = connection.getConnection();
        try
        {
            PreparedStatement statement = link.prepareStatement("INSERT INTO orders(idOrder,NameOrder,fechaActual,"
                    + "fechaEntrega,idMoto,cantidad) VALUES(?,?,?,?,?,?)");
           
            statement.setInt(1, order.getIdOrder());
            statement.setString(2, order.getNameOder());
            statement.setString(3, order.getFechaActual());
            statement.setString(4, order.getFechaEntrega());
            statement.setInt(5, order.getIdMoto());
            statement.setInt(6, order.getCantidad());
           
            statement.executeUpdate();
            OkDialog dialog = new OkDialog(new AddOrderForm(), true);
            dialog.dialogText.setText("Successful data registration.");
            dialog.setVisible(true);
        }
        catch(SQLException e)
        {
            System.out.println("" + e.getMessage());
            OkDialog dialog = new OkDialog(new AddOrderForm(), true);
            dialog.dialogText.setText("Can not register the data.");
            dialog.setVisible(true);
        }
    }
    
    
}
