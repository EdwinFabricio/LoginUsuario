
package Control_BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionConBaseDatos {
     
    
    
    public static Connection conexion = null;
    public static Connection getConexion() {
        try {
           conexion = null;
           //cargar nuestro driver de conecccion java mysql
           Class.forName("com.mysql.jdbc.Driver");
           //creamos la conecccion
           //mandamos como parametro el hot, el nombre de la base de datos, el usuario, la contraseña 
           conexion =DriverManager.getConnection("jdbc:mysql://localhost/login_roles","root","");
           
           //mensaje de coneccion correcta
           System.out.println("conexion establecida");
       } catch (ClassNotFoundException | SQLException e) {
           //mensaje coneccion fallida
           System.out.println("error de conexion");
           JOptionPane.showMessageDialog(null, "error de conexion "+e);
       }

        return conexion;
    }//cierra metodo obtenerConexion
    
}//fin class
