/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import SQL.ConnectionDB;
import SQL.Sentencias;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
         String infecha=Sentencias.getFecha();
         Date fecha=null;
        try {
            fecha = sdf.parse(infecha);
        } catch (ParseException ex) {
            Logger.getLogger(pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
         int dias=30;
         Calendar calendar = Calendar.getInstance();
      calendar.setTime(fecha); // Configuramos la fecha que se recibe
      calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
        System.out.println("Fecha actual: "+infecha);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println("Fecha contacto: "+dateFormat.format(calendar.getTime()));
    }
    
}
