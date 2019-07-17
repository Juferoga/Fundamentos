package Gestion;
import java.sql.*;
/**
 *
 * @author jpper
 */
public class GestionTipo {
    public void nuevoTipo(int c, String n, String d) throws SQLException{
        Connection con;
        String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
        con = DriverManager.getConnection(BaseDeDatos,"Mon","123456");
        try {
            PreparedStatement nueTipo = con.prepareStatement("INSERT INTO tipo (k_tipo, "
                    + "n_nombre, t_descripcion)");
            nueTipo.setInt(1, c);
            nueTipo.setString(2, n);
            nueTipo.setString(3, d);
            nueTipo.execute();
            System.out.println("tipo creado exitosamente");
        } catch (SQLException sql) {
            System.out.println("a cometido un error por favor ingrese los datos nuevamente");
        }
    }
    
}
