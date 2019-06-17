package Model;

/**
 *
 * @author Randy
 */

import java.sql.*;

public class Link {
    private static final String DATABASE ="motos";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "galito.97";
    private static final String URL = "jdbc:mysql://localhost/" + DATABASE + "?autoReconnect=true&useSSL=false";

    public static Connection getConnection()
    {
        Connection connection = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection succesful!");
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Connection failed!");
        }
        return connection;
    }

    public void Unlink()
    {
        Connection connection = null;
    }
}
