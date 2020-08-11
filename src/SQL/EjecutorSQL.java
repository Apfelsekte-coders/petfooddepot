
package SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import SQL.ConnectionDB;

public class EjecutorSQL {
    public static final String INT= "int";
    public static final String FLOAT="float";
    public static final String STRING ="string";
    
    
    
//------------------------------------------------------------------------------   
    public static ResultSet sqlQuery(String sql) throws SQLException{
        return sqlQuery(sql, null);
    }
//------------------------------------------------------------------------------
    public static ResultSet sqlQuery(String sql, Object [][] args) throws SQLException{
        PreparedStatement ps= ConnectionDB.getInstance().getConnection().prepareStatement(sql);
        prepararArgumentos(ps, args);
    return ps.executeQuery();
    
    }
//------------------------------------------------------------------------------
    public static int sqlEjecutar(String sql,Object[][] args) throws SQLException{
    PreparedStatement ps= ConnectionDB.getInstance().getConnection().prepareStatement(sql);
    prepararArgumentos(ps, args);
    return ps.executeUpdate(); 
    }
//------------------------------------------------------------------------------
    public static void prepararArgumentos(PreparedStatement ps, Object [][] args) throws SQLException{
        final int TIPO=0;
    final int VALOR=1;
        
        if (args!=null){
        int numArg=1;
        for(Object[]arg:args){
            switch(arg[TIPO].toString()){
                case INT: ps.setInt(numArg, 
                        Integer.parseInt(arg[VALOR].toString())
                );
                break;
                case FLOAT: ps.setFloat(numArg,
                        Float.parseFloat(arg[VALOR].toString())
                );
                break;
                case STRING: ps.setString(numArg,
                        arg[VALOR].toString()
                );
                break;
                }
             numArg++;
             }
       
        }
     
    }
//------------------------------------------------------------------------------
    
}
