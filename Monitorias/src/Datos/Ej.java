package Datos;
import BasesDeDatos.Conexion;
import Gestion.GestionUsuario;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author jpper
 */
public class Ej {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) throws SQLException {
        Conexion conex= new Conexion();
        conex.Conectar();
        Scanner sc = new Scanner(System.in);
        String cadcod=sc.nextLine();
        Estudiante p = new Estudiante();
        Long cod=Long.parseLong(cadcod);
        p.setCodigo(cod);
        GestionUsuario gu = new GestionUsuario();
        gu.eliminarUsuario(p.getCodigo());
        
    }
    
}
