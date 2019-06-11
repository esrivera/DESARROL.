package Model;

import View.AddPiecesForm;
import View.OkDialog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Randy
 */
public class PieceDAO {
    Link connection;
    
    public PieceDAO()
    {
        connection = new Link();
    }
    
    public void registerProduct(String namePiece, String categoryPiece, String descriptionPiece, int quantityPiece, float pricePiece)
    {
        Connection link = connection.getConnection();
        try
        {
            PreparedStatement statement = link.prepareStatement("INSERT INTO pieces (idPiece, namePiece, categoryPiece, descriptionPiece,"
                    + " quantityPiece, pricePiece) VALUES(?, ?, ?, ?, ?, ?)");
            statement.setInt(1, 0);
            statement.setString(2, namePiece);
            statement.setString(3, categoryPiece);
            statement.setString(4, descriptionPiece);
            statement.setInt(5, quantityPiece);
            statement.setFloat(6, pricePiece);
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
    
    public void deleteProduct(int idPiece)
    {
        Connection link = connection.getConnection();
        try
        {
            Statement result = link.createStatement();
            result.execute("DELETE FROM pieces WHERE idPiece = '" + idPiece + "'");
            result.close();
            OkDialog dialog = new OkDialog(new AddPiecesForm(), true);
            dialog.dialogText.setText("Data removed successfully.");
            dialog.setVisible(true);
        }
        catch(SQLException e)
        {
            System.out.println("" + e.getMessage());
            OkDialog dialog = new OkDialog(new AddPiecesForm(), true);
            dialog.dialogText.setText("An error occurred while deleting the data.");
            dialog.setVisible(true);
        }
    }
    
    public void modifyPiece(int idPiece, String namePiece, String categoryPiece, String descriptionPiece, int quantityPiece, float pricePiece)
    {
        Connection link = connection.getConnection();
        try
        {
            PreparedStatement statement = link.prepareStatement("UPDATE pieces SET namePiece=?, categoryPiece=?, descriptionPiece=?,"
                    + " quantityPiece=?, pricePiece=? WHERE idPieces=?");
            statement.setInt(6, idPiece);
            statement.setString(1, namePiece);
            statement.setString(2, categoryPiece);
            statement.setString(3, descriptionPiece);
            statement.setInt(4, quantityPiece);
            statement.setFloat(5, pricePiece);
            statement.executeUpdate();
            OkDialog dialog = new OkDialog(new AddPiecesForm(), true);
            dialog.dialogText.setText("The data has been updated successfully");
            dialog.setVisible(true);
        }
        catch(SQLException e)
        {
            System.out.println("" + e.getMessage());
            OkDialog dialog = new OkDialog(new AddPiecesForm(), true);
            dialog.dialogText.setText("An error occurred when modifying the data.");
            dialog.setVisible(true);
        }
    }
    
    public void viewPiece(JTable tblPieces)
    {
        Connection link = connection.getConnection();
        Piece piece = new Piece();
        try
        {
            String[]data = new String[6];
            DefaultTableModel table = new DefaultTableModel();
            table.addColumn("Id");
            table.addColumn("Name");
            table.addColumn("Description");
            table.addColumn("Category");
            table.addColumn("Quantity");
            table.addColumn("Providers");
            tblPieces.setModel(table);
            Statement result = link.createStatement();
            ResultSet resultSet = result.executeQuery("SELECT * FROM pieces");
            while(resultSet.next())
            {
                piece.setIdPiece(resultSet.getInt("idPiece"));
                piece.setNamePiece(resultSet.getString("namePiece"));
                piece.setCategoryPiece(resultSet.getString("categoryPiece"));
                piece.setDescriptionPiece(resultSet.getString("descriptionPiece"));
                piece.setQuantityPiece(resultSet.getInt("pricePiece"));
                data[0] = resultSet.getString(1);
                data[1] = resultSet.getString(2);
                data[2] = resultSet.getString(3);
                data[3] = resultSet.getString(4);
                data[4] = resultSet.getString(5);
                
                table.addRow(data);
            }
            tblPieces.setModel(table);
            connection.Unlink();
        }
        catch(SQLException e)
        {
            Logger.getLogger(PieceDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
