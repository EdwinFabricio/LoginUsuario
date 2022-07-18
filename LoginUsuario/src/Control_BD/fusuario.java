/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control_BD;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author richard
 */
public class fusuario {
//incializamos la coneccion    
        Connection cn = null;
 //   private ConexionConBaseDatos mysql = new conexion();
//creamos las variables
    private String sSQL = "";//para la consulta sql
    private String sSQL2 = "";//para otra consulta sql
    public Integer totalregistros;//guarda e total de los registros de una tabla


  //creamos la funcion que nos va evaluar si el usuario existe
    // va ser tipo DefaultTableModel y va recibir dos paramtros
    public DefaultTableModel login(String usuario,String pasword) {
        cn= ConexionConBaseDatos.getConexion();//inicializamos la clase conexion 
        DefaultTableModel modelo;// creamos el modelo con el cual sacaremos los datos de la consulta
//creamos los titulos para las columnas de la tabla
        String[] titulos = {"id", "usuario", "pasword", "tipo", "nombres", "apellidos", "dni", "telefono"};
//creamos un areglo registro con el cual sacaremos los datos de la base de datos
        String[] registro = new String[8];
//inicializamos totalregistros
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);//inicializamos modelo
//escribimos la consulta en nuestro string sql
        sSQL = "select p.id,p.usuario,p.pasword,p.tipo,"
                + "p.nombres,p.apellidos,p.dni,p.telefono from usuario p "
                + " where p.usuario='"
                + usuario + "' and p.pasword='" + pasword + "'";
//CREAMOS EL TRY CACH pra que no nos controlar los errores
        try {
            //creamos una varibale Statement que nos serivra para ejecutar una consulta sql
            Statement st = cn.createStatement();
            //ejecutamos la consulta u la guardamos en un ResultSet
            ResultSet rs = st.executeQuery(sSQL);
//ahora el sacamos los registros del resulset con con while
            while (rs.next()) {
                //guardamos los registros en el areglo registros
                //posicion por posicion cada tabla
                registro[0] = rs.getString("id");
                registro[1] = rs.getString("usuario");
                registro[2] = rs.getString("pasword");
                registro[3] = rs.getString("tipo");
                
                registro[4] = rs.getString("nombres");
                registro[5] = rs.getString("apellidos");
                registro[6] = rs.getString("dni");
                registro[7] = rs.getString("telefono");
                //contamos el total de registros de la consulta
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);//agregamos al modelo para sacar los datos

            }
            return modelo;//devolvemos el modelo

        } //cach controla los errores que puedan suceder
        catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
    
}
