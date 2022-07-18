
package Control_BD;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * En esta clase se expone sólo un metodo el cual
 * sirve para cerrar la conexion (connection)
 * a la base de datos, cerrar los resultados(resulset),
 * cerrar las sentencias (preparedStatement y Statement)
 * 
 * @author Sergio
 */
public class CerrarConexiones {
    
    
    //clase cerra coneccion
    //es ncesario cerrar conecciones para ahorrrar la memoria
    
    public static void metodoCerrarConexiones(Connection conexion, Statement sentencia, ResultSet resultado, PreparedStatement ps ){
        // cpm esta condicion cerramos la conecccion
        if(ps != null){
            try{
                ps.close();
            }
            catch(SQLException e1){
                JOptionPane.showMessageDialog(null,"No se pudo cerrar el PreparedStatement(ps)\n Error: "+e1);
                
            }
            resultado = null;
        }
        //- - - - - - - - - - - - - - - - - - - - - -
        // aca controlamos el error si no se cierra la coneccion
        if(resultado != null){
            try{
                resultado.close();
            }
            catch(SQLException e1){
                JOptionPane.showMessageDialog(null,"No se pudo cerrar el ResultSet (resultado)\n Error: "+e1);
            }
            resultado = null;
        }
        
        //- - - - - - - - - - - - - - - - - - - - - -
        
        if(sentencia != null){
            try{
                sentencia.close();
            }
            catch(SQLException e1){
                JOptionPane.showMessageDialog(null,"No se pudo cerrar el Statement (sentencia)\n Error "+e1);
            }
            sentencia = null;
        }
        //- - - - - - - - - - - - - - - - - - - - - -
        if(conexion != null){
            try{
                conexion.close();
            }
            catch(SQLException e1){
                JOptionPane.showMessageDialog(null,"No se pudo cerrar Connection (conexion)\n Error "+e1);
            }
            conexion = null;
        }
        
    }//cierra metodo
    
    
    
}//cierra class
