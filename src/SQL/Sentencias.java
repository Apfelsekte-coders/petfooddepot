/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import SQL.ConnectionDB;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */

public class Sentencias {
    public static int idSesion;
    
    public static String getFechaHora(){
     Date date = new Date();
     String fecha="";
     DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        fecha+= dateFormat.format(date)+"-";
     DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
     fecha+= hourFormat.format(date);
     return fecha;
    }
    
    public static int iniciarSesion(String log, String pass, String fecha) {
        ResultSet rs;
        try {
            
            
            String sentencia =" SELECT iniciarSesion('"+log+"',"+"'"+pass+"',"+"'"+fecha+"');";
            rs=EjecutorSQL.sqlQuery(sentencia,null);
             if(rs.next()){
             return rs.getInt(1);
             
         }
        } catch (SQLException ex) {
            Logger.getLogger(Sentencias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static void cerrarSesion(int id, String fecha){
        try{
    String sentencia ="call cerrarSesion("+id+", '"+fecha+"');";
    EjecutorSQL.sqlQuery(sentencia);
    }catch(SQLException ex){
        Logger.getLogger(Sentencias.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }
     public static void actualizarSesion(int id, String fecha){
        try{
    String sentencia ="call actualizarUltimaAccion("+id+", '"+fecha+"');";
    EjecutorSQL.sqlQuery(sentencia);
    }catch(SQLException ex){
        Logger.getLogger(Sentencias.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }
     public static int iniciarVenta(int id) {
        ResultSet rs;
        try {
            
            String sentencia =" SELECT iniciarVenta("+id+");";
            rs=EjecutorSQL.sqlQuery(sentencia,null);
             if(rs.next()){
             return rs.getInt(1); 
         }
        } catch (SQLException ex) {
            Logger.getLogger(Sentencias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
     public static void agregarACarrito(String nombre, int cant, int id_venta,int id_ses){
           ResultSet rs;
         try{
             String sentencia= "call agregarACarrito('"+nombre+"',"+cant+","+id_venta+","+id_ses+");";
              EjecutorSQL.sqlQuery(sentencia);
         }catch(SQLException ex){
         
         }
     
     }
     public static void cerrarVenta(int ven_id, int ses_id, int cli_id, String fecha){
         ResultSet rs;
         try{
             String sentencia= "call cerrarVenta("+ven_id+","+ses_id+","+cli_id+","+"'"+fecha+"');";
              EjecutorSQL.sqlQuery(sentencia);
         }catch(SQLException ex){
         
         }
     
     }
     public static void devolverInventario(String nombre, int cant, int ven_id){
         ResultSet rs;
         try{
             String sentencia= "call devolverInventario('"+nombre+"',"+cant+","+ven_id+");";
              EjecutorSQL.sqlQuery(sentencia);
         }catch(SQLException ex){
         
         }
     }
     //----------------------------------------------- Insertar------------------------------------------------------------------//
     public static void nuevoProducto(){
     
     }
    
    
}
