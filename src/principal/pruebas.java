/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import SQL.ConnectionDB;
import SQL.Sentencias;

/**
 *
 * @author ACER
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         ConnectionDB.getInstance().connectDB();
         System.out.println(Sentencias.iniciarSesion("geragui", "Lentes69",Sentencias.getFechaHora()));
    }
    
}
