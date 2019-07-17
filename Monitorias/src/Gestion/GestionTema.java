package Gestion;
import java.sql.*;

/**
 *
 * @author jpper
 */
public class GestionTema {
    public void insertarTema (int t, String n, int a) throws SQLException{
        Connection con;
        String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
        con = DriverManager.getConnection(BaseDeDatos,"Mon","123456");
        try {
            PreparedStatement insTema = con.prepareStatement("INSERT INTO tema (k_tema ,"
                    + "n_nombre, k_asignatura) values (?,?,?)");
            insTema.setInt(1, t);
            insTema.setString(2, n);
            insTema.setInt(3, a);
            insTema.execute();
            System.out.println("se a agregado el tema");
        } catch (SQLException sql) {
            System.out.println("a cometido un error por favor ingrese los datos nuevamente");
        }
    }
    
}
