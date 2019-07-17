package Gestion;

import java.sql.*;


/**
 *
 * @author jpper
 */
public class GestionAsignatura {
    public void insertarAsignatura(int x, String n, String d) throws SQLException{
        Connection con;
        String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
        con = DriverManager.getConnection(BaseDeDatos,"Mon","123456");
        
        try{
            PreparedStatement insAsig = con.prepareStatement("INSERT INTO asignatura(k_asignatura,"
                    + " n_nombre, t_descripcion"
                    + " values (?,?,?)");
            insAsig.setInt(1, x);
            insAsig.setString(2, n);
            insAsig.setString(3, d);
            insAsig.execute();
            System.out.println("Los datos se registraron exitosamente");
            
        }catch(SQLException sqle){
            System.out.println("a cometido un error por favor ingrese los datos nuevamente");
        }
}
    
    public void consultarAsignatura() throws SQLException {
        Connection con;
        String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
        con = DriverManager.getConnection(BaseDeDatos,"Mon","123456");
        try {
            PreparedStatement consAsig = con.prepareStatement("SELECT n_nombre FROM asignatura");
            consAsig.execute();
            
        } catch (SQLException sql) {
            System.out.println("a cometido un error por favor ingrese los datos nuevamente");
        }
           
    
    }
}
