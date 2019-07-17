package Gestion;
import java.sql.*;

/**
 *
 * @author jpper
 */
public class GestionSolicitud {
    public void CrearSolicitud(int nS, Date fS, boolean i, int nE,int nD , long cE, int cR, int t) throws SQLException{
        Connection con;
        String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
        con = DriverManager.getConnection(BaseDeDatos,"Mon","123456");
        try {
            PreparedStatement crearSol = con.prepareStatement("INSERT INTO solicitud(k_num_solicitud ,i_estado ,"
                    + "d_fecha_solicitud ,num_estudiantes ,num_duracion ,k_codigo_estudiante ,k_cod_recompensa)"
                    + "values (?,?,?,?,?,?,?)");
            crearSol.setInt(1, nS);
            crearSol.setBoolean(2, i);
            crearSol.setDate(5, fS);
            crearSol.setInt(4, nE);
            crearSol.setInt(5, nD);
            crearSol.setLong(6, cE);
            crearSol.setInt(7, cR);
            crearSol.execute();
            System.out.println("se creo la solicitud");
            PreparedStatement crearSol_tema = con.prepareStatement("INSERT INTO solicitud_tema(k_solicitud, k_tema)"
                    + "values (?,?)");
            crearSol_tema.setInt(1, nS);
            crearSol_tema.setInt(2, t);
            crearSol_tema.execute();
            System.out.println("se relaciono solicitud con tema");
            
        }catch (SQLException sql) {
            System.out.println("a cometido un error por favor ingrese los datos nuevamente");
        }
    
    }
    
    public void eliminarSolicitud(int x, int t) throws SQLException{
        Connection con;
        String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
        con = DriverManager.getConnection(BaseDeDatos,"Mon","123456");
        try {
            PreparedStatement elimSol = con.prepareStatement("DELETE solicitud where k_num_solicitud = ?");
            elimSol.setInt(1, x);
            elimSol.execute();
            System.out.println("se elimino la solicitud ");
            PreparedStatement elimSol_tema = con.prepareStatement("DELETE solicitud_tema where k_solicitud = ?");
            elimSol_tema.setInt(1 ,t );
            elimSol_tema.execute();
            System.out.println("se elimino la relacion solicitud tema");
            
        }catch (SQLException sql) {
            System.out.println("a cometido un error por favor ingrese los datos nuevamente");
        }
    
    }
    
    public void revisarSolicitud(int x) throws SQLException{
        Connection con;
        String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
        con = DriverManager.getConnection(BaseDeDatos,"Mon","123456");
        try {
            PreparedStatement revSol = con.prepareStatement("SELECT * FROM solicitud where pk_codigo=?");
            revSol.setInt(1, x);
            revSol.execute();
            System.out.println("yeah");
            
        }catch (SQLException sql) {
            System.out.println("a cometido un error por favor ingrese los datos nuevamente");
        }
    }
        
    public void aceptarSolicitud(long cE, int s) throws SQLException{
        Connection con;
        String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
        con = DriverManager.getConnection(BaseDeDatos,"Mon","123456");
        try {
            PreparedStatement acepSol = con.prepareStatement("");
            acepSol.setLong(1, cE);
            acepSol.setInt(2, s);
            acepSol.execute();
            System.out.println("se ha relacionado la solicitud a un estudiante");
        } catch (SQLException e) {
            System.out.println("a cometido un error por favor ingrese los datos nuevamente");
        }
        
            
    }
    
}
