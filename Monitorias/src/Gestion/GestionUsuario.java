package Gestion;
import java.sql.*;


/**
 *
 * @author jpper
 */
public class GestionUsuario{
        
    public void crearUsuario(long c,long t,String n, String a, String x, int pm, int pe) throws SQLException{
        Connection con;
        String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
        con = DriverManager.getConnection(BaseDeDatos,"Mon","123456");
        
        try{
            PreparedStatement crearUser = con.prepareStatement("INSERT INTO estudiante(pk_codigo, n_nombre, "
                    + "n_apellido,o_email,num_telefono,q_promedioM,q_promedioE)"
                    + " values (?,?,?,?,?,?,?)");
            crearUser.setLong(1, c);
            crearUser.setString(2, n);
            crearUser.setString(3, a);
            crearUser.setString(4, x);
            crearUser.setLong(5, t);
            crearUser.setInt(6, pm);
            crearUser.setInt(7, pe);
            crearUser.executeUpdate();
            System.out.println("Los datos se registraron exitosamente");
            
        }catch(SQLException sqle){
            
            System.out.println("a cometido un error por favor ingrese los datos nuevamente");
        }
    }
    
    public void eliminarUsuario(long c) throws SQLException{
        Connection con;
        String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
        con = DriverManager.getConnection(BaseDeDatos,"Mon","123456");
        try {
            PreparedStatement elimUser = con.prepareStatement("DELETE estudiante where pk_codigo = ?");
            elimUser.setLong(1, c);
            elimUser.executeUpdate();
            System.out.println("la tupla fue eliminada exitosamente");
        } catch (SQLException sql) {
            System.out.println("a cometido un error por favor ingrese los datos nuevamente");
        }
    
    }
    
    public void modificarUsuario(long c) throws SQLException{
        Connection con;
        String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
        con = DriverManager.getConnection(BaseDeDatos,"Mon","123456");
    try {
            PreparedStatement modUser = con.prepareStatement("INSERT INTO estudiante(pk_codigo, n_nombre, "
                    + "n_apellido,o_email,num_telefono,q_promedioM,q_promedioE)"
                    + " values (?,?,?,?,?,?,?)");
        } catch (SQLException sql) {
            System.out.println("a cometido un error por favor ingrese los datos nuevamente");
        }
    }
    
    public void consultarDatos(long c) throws SQLException{
        Connection con;
        String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
        con = DriverManager.getConnection(BaseDeDatos,"Mon","123456");
        try {
            PreparedStatement consUser = con.prepareStatement("SELECT * FROM ESTUDIANTE where pk_codigo=?");
            consUser.setLong(1, c);
            consUser.executeUpdate();
            System.out.println("la tupla fue eliminada exitosamente");
            
        } catch (SQLException sql) {
            
            System.out.println("a cometido un error por favor ingrese los datos nuevamente");
        }
    
    } 
    
        
    
}
