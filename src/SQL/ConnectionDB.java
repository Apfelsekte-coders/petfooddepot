/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class ConnectionDB {
    private static ConnectionDB instancia = null;
    private Connection connect;
    private static String url="jdbc:mysql://www.petfooddepotmx.com:3306/u760520066_petfooddepot";
    private static String user="u760520066_petAdmin";
    private static  String pass="4guileraAdmin";
    
     public static ConnectionDB getInstance() {
        if (instancia == null) {
            instancia = new ConnectionDB();
        }
        return instancia;
    }
     public void connectDB(){
         connect = null;
        try {
            connect= DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
      public Connection getConnection() {
        return connect;
    }
    public void disconnect() {
        if (connect != null) {
            try {
                connect.close();

            } catch (SQLException ex) {
                System.out.println("Error de SQL [" + ex + "]");
            }
        }
    }
    public boolean isConnected(){
        if(connect != null)
            return true;
        return false;
    }
}
