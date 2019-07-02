/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.AddOrderForm;
import View.DeleteOrderForm;
import View.ModifyOrderForm;


import View.OkDialog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

    public void registerConcessioner(Order order) {
        Connection link = connection.getConnection();
        try {
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
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
            OkDialog dialog = new OkDialog(new AddOrderForm(), true);
            dialog.dialogText.setText("Can not register the data.");
            dialog.setVisible(true);
        }
    }

    public void modifyOrder(Order order) {
        try {
            Connection link = connection.getConnection();
            PreparedStatement ps = link.prepareStatement("UPDATE orders SET NameOrder='" + order.getNameOder()+ "',fechaActual='" + order.getFechaActual()
                    + "',fechaEntrega='" + order.getFechaEntrega() + "',idMoto='" + order.getIdMoto() + "',cantidad='"
                    + order.getCantidad() + "' WHERE idOrder='" + order.getIdOrder() + "'");
            ps.executeUpdate();
            OkDialog dialog = new OkDialog(new ModifyOrderForm(), true);
            dialog.dialogText.setText("The data has been updated successfully");
            dialog.setVisible(true);
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
            OkDialog dialog = new OkDialog(new ModifyOrderForm(), true);
            dialog.dialogText.setText("An error occurred when modifying the data.");
            dialog.setVisible(true);
        }
    }

    public void deleteOrder(int id) {

        try {
            String SQL = "delete from orders where idOrder=" + id;
            Connection link = connection.getConnection();
            Statement st = link.createStatement();
            int n = st.executeUpdate(SQL);
            if (n >= 0) {
                OkDialog dialog = new OkDialog(new DeleteOrderForm(), true);
                dialog.dialogText.setText("Data removed successfully.");
                dialog.setVisible(true);
            }

        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            OkDialog dialog = new OkDialog(new DeleteOrderForm(), true);
            dialog.dialogText.setText("An error occurred while deleting the data.");
            dialog.setVisible(true);
        }

    }

    public ArrayList<Order> viewOrder() {
        ArrayList<Order> arr = new ArrayList<Order>();
        Order order;
        try {
            Connection link = connection.getConnection();
            PreparedStatement ps = link.prepareStatement("SELECT * from orders");
            ResultSet rs = ps.executeQuery();  //es una coleccion de los registros
            while (rs.next()) {
                order = new Order();
                order.setIdOrder(rs.getInt(1));
                order.setNameOder(rs.getString(2));
                order.setFechaActual(rs.getString(3));
                order.setFechaEntrega(rs.getString(4));
                order.setIdMoto(rs.getInt(5));
                order.setCantidad(rs.getInt(6));

                arr.add(order);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return arr;
    }

}
