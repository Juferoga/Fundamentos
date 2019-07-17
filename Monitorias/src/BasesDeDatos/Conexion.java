package BasesDeDatos;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author jpper
 */
public class Conexion {
    private Connection con; 

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    public Conexion Conectar()
    {
        try{
        Class.forName("oracle.jdbc.OracleDriver");
        String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
        con= DriverManager.getConnection(BaseDeDatos,"Mon","123456");
        if(con!=null)
        {
        System.out.println("Conexion exitosa a esquema HR");
        }
        else{System.out.println("Conexion fallida");}
        }
        catch(Exception e)
        {e.printStackTrace();}
      
    return this;
    }
    
}
