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
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */

public class Sentencias {
    public static int idSesion;
    public static int intento=1;
    
    public static String getFechaHora(){
     Date date = new Date();
     String fecha="";
     DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        fecha+= dateFormat.format(date)+"-";
     DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
     fecha+= hourFormat.format(date);
     return fecha;
    }
    public static String getFecha(){
    Date date = new Date();
    String fecha="";
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        fecha+= dateFormat.format(date);
        return fecha;
    
    }
    
    public static int iniciarSesion(String log, String pass, String fecha) {
        
        try {
             ConnectionDB.getInstance().connectDB();
             ResultSet rs;
             Statement st;
            String sentencia =" SELECT iniciarSesion('"+log+"',"+"'"+pass+"',"+"'"+fecha+"');";
             st= ConnectionDB.getInstance().getConnection().createStatement();
                rs= st.executeQuery(sentencia);
             if(rs.next()){
             return rs.getInt(1);
             
         }
        } catch (SQLException ex) {
            System.out.println("Error "+ex);
        }
        return 0;
    }
    
    public static void cerrarSesion(int id, String fecha){
        try{
    String sentencia ="call cerrarSesion("+id+", '"+fecha+"');";
    PreparedStatement ps;
                ps =  ConnectionDB.getInstance().getConnection().prepareStatement(sentencia);
                ps.executeUpdate();
    }catch(SQLException ex){
           // System.out.println("Error "+ex);
            ConnectionDB.getInstance().connectDB();
            cerrarSesion(id, fecha);
    }
    
    }
     public static void actualizarSesion(int id, String fecha){
        try{
    String sentencia ="call actualizarUltimaAccion("+id+", '"+fecha+"');";
    PreparedStatement ps;
                ps =  ConnectionDB.getInstance().getConnection().prepareStatement(sentencia);
                ps.executeUpdate();
    }catch(SQLException ex){
        ConnectionDB.getInstance().connectDB();
        actualizarSesion(id,fecha);
    }
    
    }
     public static int iniciarVenta(int id) {
        ResultSet rs;
        Statement st;
        try {
            
            String sentencia =" SELECT iniciarVenta("+id+");";
                st= ConnectionDB.getInstance().getConnection().createStatement();
                rs= st.executeQuery(sentencia);
             if(rs.next()){
             return rs.getInt(1); 
         }
        } catch (SQLException ex) {
           ConnectionDB.getInstance().connectDB();
           iniciarVenta(id); 
        }
        return 0;
    }
     public static int idDuegno(String nombre){
         ResultSet rs;
        Statement st;
        try {
            
            String sentencia =" SELECT cliente_id from clientes where cliente_nombre = '"+ nombre+"'";
                st= ConnectionDB.getInstance().getConnection().createStatement();
                rs= st.executeQuery(sentencia);
             if(rs.next()){
            int id= rs.getInt(1); 
            return id;
         }
             
        } catch (SQLException ex) {
            System.out.println("Error "+ ex);
           ConnectionDB.getInstance().connectDB();
            idDuegno(nombre);
        }
        return 0;
     
     }
     
   
     public static void cerrarVenta(float descuento,int ven_id, int ses_id, int cli_id, String fecha){
         try{
             String sentencia= "call cerrarVenta("+descuento+","+ven_id+","+ses_id+","+cli_id+","+"'"+fecha+"');";
               PreparedStatement ps;
                ps =  ConnectionDB.getInstance().getConnection().prepareStatement(sentencia);
                ps.executeUpdate();
         }catch(SQLException ex){
             System.out.println("Error "+ex);
         }
     
     }
     public static void devolverInventario(String nombre, int cant, int ven_id){
         try{
             String sentencia= "call devolverInventario('"+nombre+"',"+cant+","+ven_id+");";
              PreparedStatement ps;
                ps =  ConnectionDB.getInstance().getConnection().prepareStatement(sentencia);
                ps.executeUpdate();
         }catch(SQLException ex){
         System.out.println("Error "+ ex);
         }
     }
     public static void sumarPuntos(int id, int puntos){
         try{
             String sentencia= "call sumarPuntos("+id+","+puntos+");";
              PreparedStatement ps;
                ps =  ConnectionDB.getInstance().getConnection().prepareStatement(sentencia);
                ps.executeUpdate();
         }catch(SQLException ex){
             ConnectionDB.getInstance().connectDB();
             sumarPuntos(id, puntos);
         }
     
     }
     public static void descontarPuntos(int id, int puntos){
         try{
             String sentencia= "call descontarPuntos("+id+","+puntos+");";
              PreparedStatement ps;
                ps =  ConnectionDB.getInstance().getConnection().prepareStatement(sentencia);
                ps.executeUpdate();
         }catch(SQLException ex){
             ConnectionDB.getInstance().connectDB();
             descontarPuntos(id, puntos);
         }
     
     }
     //----------------------------------------------- Insertar------------------------------------------------------------------//
     public static void nuevoProducto(String nombre, float precio, int inventario, int duracion,String fecha, int ses_id){
         
         try{
             String sentencia= "call nuevoProducto('"+nombre+"',"+precio+","+inventario+","+duracion+",'"+fecha+"',"+ses_id+");";
              PreparedStatement ps;
                ps =  ConnectionDB.getInstance().getConnection().prepareStatement(sentencia);
                ps.executeUpdate();
         }catch(SQLException ex){
             System.out.println(ConnectionDB.getInstance().isConnected());
             System.out.println("Error "+ ex);
           // ConnectionDB.getInstance().connectDB();
            // nuevoProducto(nombre,precio,inventario,duracion,fecha,ses_id);
         
         }
     }
     public static void nuevoUsuario(String login, String nombre, String contrasegna, String rol, int id){
          try{
             String sentencia = "call nuevoUsuario('"+login+"','"+nombre+"','"+contrasegna+"','"+rol+"',"+id+");";
              PreparedStatement ps;
                ps =  ConnectionDB.getInstance().getConnection().prepareStatement(sentencia);
                ps.executeUpdate();
         }catch(SQLException ex){
             //System.out.println("Error "+ ex);
             //ConnectionDB.getInstance().connectDB();
             //nuevoUsuario(login,nombre,contrasegna,rol,id);
         
         }
     
     }
     public static void nuevoCliente(String nombre, String telefono, String correo, String colonia, int id){
                  try{
             String sentencia = "call nuevoCliente('"+nombre+"','"+telefono+"','"+correo+"','"+colonia+"',"+0+","+id+");";
              PreparedStatement ps;
                ps =  ConnectionDB.getInstance().getConnection().prepareStatement(sentencia);
                ps.executeUpdate();
         }catch(SQLException ex){
             //System.out.println("Error "+ ex);
             //ConnectionDB.getInstance().connectDB();
             //nuevoCliente(nombre, telefono, correo, colonia, id);
         
         }
     }
     public static void nuevaMascota(String nombre, String raza, int peso, String edad, int cliente, int sesion){
         try{
             String sentencia = "call nuevaMascota('"+nombre+"','"+raza+"',"+peso+",'"+edad+"',"+cliente+","+sesion+");";
              PreparedStatement ps;
                ps =  ConnectionDB.getInstance().getConnection().prepareStatement(sentencia);
                ps.executeUpdate();
         }catch(SQLException ex){
             System.out.println("Error "+ ex);
             //ConnectionDB.getInstance().connectDB();
             //nuevaMascota(nombre, raza, peso, edad, cliente, sesion);
         }
     }
     
     public static void agregarACarrito(int id_venta, String nombre, float precio, int cantidad, float descuento, float subtotal){
         try{
             String sentencia = "call agregarACarrito("+id_venta+",'"+nombre+"',"+precio+","+cantidad+","+descuento+","+subtotal+");";
              PreparedStatement ps;
                ps =  ConnectionDB.getInstance().getConnection().prepareStatement(sentencia);
                ps.executeUpdate();
         }catch(SQLException ex){
             System.out.println("Error "+ ex);
             ConnectionDB.getInstance().connectDB();
             agregarACarrito(id_venta,nombre,precio,cantidad,descuento, subtotal);
             //nuevaMascota(nombre, raza, peso, edad, cliente, sesion);
         }
     
     }
     public static void agendarContacto(int venta_id, int cliente_id, String fecha_compra, String fecha_contacto, int sesion_id){
     try{
             String sentencia = "call agendarContacto("+venta_id+","+cliente_id+",'"+fecha_compra+"','"+fecha_contacto+"',"+sesion_id+");";
              PreparedStatement ps;
                ps =  ConnectionDB.getInstance().getConnection().prepareStatement(sentencia);
                ps.executeUpdate();
         }catch(SQLException ex){
             System.out.println("Error "+ ex);
             ConnectionDB.getInstance().connectDB();
             agendarContacto(venta_id, cliente_id, fecha_compra, fecha_contacto, sesion_id);
             //nuevaMascota(nombre, raza, peso, edad, cliente, sesion);
         }
     }
     public static void nuevaAgenda(int cliente_id, String fecha_contacto, int sesion_id){
     try{
             String sentencia = "call nuevaAgenda("+cliente_id+",'"+fecha_contacto+ "',"+sesion_id+");";
              PreparedStatement ps;
                ps =  ConnectionDB.getInstance().getConnection().prepareStatement(sentencia);
                ps.executeUpdate();
         }catch(SQLException ex){
             System.out.println("Error "+ ex);
             ConnectionDB.getInstance().connectDB();
             nuevaAgenda(cliente_id, fecha_contacto, sesion_id);
             //nuevaMascota(nombre, raza, peso, edad, cliente, sesion);
         }
     }
     //----------------------------------------------- Desplegar------------------------------------------------------------------//
     public static ResultSet desplegar(String sentencia){
         ResultSet rs;
             Statement st;
        try {
            st= ConnectionDB.getInstance().getConnection().createStatement();
            rs= st.executeQuery(sentencia);
            return rs;
        } catch (SQLException ex) {
            System.out.println("Error: "+ex);
            if(intento==1){
                intento++;
            ConnectionDB.getInstance().connectDB();
            desplegar(sentencia);
            }else{
            intento=1;
                JOptionPane.showMessageDialog(null, "Error: verifique datos o conexión");
            }
        }
                return null;
     }
    //-------------------------------------------Eliminar-------------------------------------------------------------------------//
     public static void eliminarProducto(String nombre){
     try{
             String sentencia = "call eliminarProducto('"+nombre+"');";
              PreparedStatement ps;
                ps =  ConnectionDB.getInstance().getConnection().prepareStatement(sentencia);
                ps.executeUpdate();
         }catch(SQLException ex){
             System.out.println("Error "+ ex);
             //ConnectionDB.getInstance().connectDB();
             //nuevaMascota(nombre, raza, peso, edad, cliente, sesion);
         }
     }
     public static void eliminarCliente(int id){
         try{
             String sentencia = "call eliminarCliente("+id+");";
              PreparedStatement ps;
                ps =  ConnectionDB.getInstance().getConnection().prepareStatement(sentencia);
                ps.executeUpdate();
         }catch(SQLException ex){
             System.out.println("Error "+ ex);
             //ConnectionDB.getInstance().connectDB();
             //nuevaMascota(nombre, raza, peso, edad, cliente, sesion);
         }
     }
     public static void eliminarUsuario(String login){
           try{
             String sentencia = "call eliminarUsuario('"+login+"');";
              PreparedStatement ps;
                ps =  ConnectionDB.getInstance().getConnection().prepareStatement(sentencia);
                ps.executeUpdate();
         }catch(SQLException ex){
             System.out.println("Error "+ ex);
             //ConnectionDB.getInstance().connectDB();
             //nuevaMascota(nombre, raza, peso, edad, cliente, sesion);
         }
     }
     public static void eliminarMascota(int id){
          try{
             String sentencia = "call eliminarMascota("+id+");";
              PreparedStatement ps;
                ps =  ConnectionDB.getInstance().getConnection().prepareStatement(sentencia);
                ps.executeUpdate();
         }catch(SQLException ex){
             System.out.println("Error "+ ex);
             //ConnectionDB.getInstance().connectDB();
             //nuevaMascota(nombre, raza, peso, edad, cliente, sesion);
         }
     }
     public static void eliminarAgenda(int id){
          try{
             String sentencia = "call eliminarAgenda("+id+");";
              PreparedStatement ps;
                ps =  ConnectionDB.getInstance().getConnection().prepareStatement(sentencia);
                ps.executeUpdate();
         }catch(SQLException ex){
             System.out.println("Error "+ ex);
             //ConnectionDB.getInstance().connectDB();
             //nuevaMascota(nombre, raza, peso, edad, cliente, sesion);
         }
     }
//------------------------------------Actualizar--------------------------------------------------------------------------------------
     public static void actualizarProducto(String nombre, float precio, int inventario, int duracion){
          try{
             String sentencia = "call actualizarProducto('"+nombre+"',"+precio+","+inventario+","+duracion+");";
              PreparedStatement ps;
                ps =  ConnectionDB.getInstance().getConnection().prepareStatement(sentencia);
                ps.executeUpdate();
         }catch(SQLException ex){
             System.out.println("Error "+ ex);
         }
     }
     
      public static void actualizarCliente(int id, String nombre,String tel, String email, String colonia){
          try{
             String sentencia = "call actualizarCliente("+id+",'"+nombre+"','"+tel+"','"+email+"','"+colonia+"');";
              PreparedStatement ps;
                ps =  ConnectionDB.getInstance().getConnection().prepareStatement(sentencia);
                ps.executeUpdate();
         }catch(SQLException ex){
             System.out.println("Error "+ ex);
         }
     }
     public static void actualizarMascota(int id, String nombre,String raza, int peso, String edad){
          try{
             String sentencia = "call actualizarMascota("+id+",'"+nombre+"','"+raza+"',"+peso+",'"+edad+"');";
              PreparedStatement ps;
                ps =  ConnectionDB.getInstance().getConnection().prepareStatement(sentencia);
                ps.executeUpdate();
         }catch(SQLException ex){
             System.out.println("Error "+ ex);
         }
     }
     public static void actualizarUsuario(String login, String nombre,String pass, String rol){
          try{
             String sentencia = "call actualizarUsuario('"+login+"','"+nombre+"','"+pass+"','"+rol+"');";
              PreparedStatement ps;
                ps =  ConnectionDB.getInstance().getConnection().prepareStatement(sentencia);
                ps.executeUpdate();
         }catch(SQLException ex){
             System.out.println("Error "+ ex);
         }
     }
     public static void actualizarFechaContacto(int id, String fecha){
          try{
              String sentencia = "call actualizarFechaContacto("+id+",'"+fecha+"');";
            
              PreparedStatement ps;
                ps =  ConnectionDB.getInstance().getConnection().prepareStatement(sentencia);
                ps.executeUpdate();
         }catch(SQLException ex){
             System.out.println("Error "+ ex);
         }
     }
     
}
