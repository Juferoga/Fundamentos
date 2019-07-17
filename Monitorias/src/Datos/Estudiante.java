package Datos;

/**
 *
 * @author jpper
 */
public class Estudiante {

    private long Codigo=0;
    private long Telefono=0;
    private int PromE=0;
    private int PromM=0;
    private String Nombre="";
    private String Apellido="";
    private String Email="";
    //private String ProgAcademico="";

    public Estudiante() {
    }

    public long getCodigo() {
        return Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    /*public String getProgAcademico() {
        return ProgAcademico;
    }*/
    
    public long getTelefono() {
        return Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public int getPromE() {
        return PromE;
    }

    public int getPromM() {
        return PromM;
    }

    /*public void setProgAcademico(String ProgAcademico) {
        this.ProgAcademico = ProgAcademico;
    }*/
    
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public void setCodigo(long Codigo) {
        this.Codigo = Codigo;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setPromE(int PromE) {
        this.PromE = PromE;
    }

    public void setPromM(int PromM) {
        this.PromM = PromM;
    }

    public void setTelefono(long Telefono) {
        this.Telefono = Telefono;
    }
}
