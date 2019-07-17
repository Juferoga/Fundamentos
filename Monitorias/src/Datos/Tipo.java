package Datos;

/**
 *
 * @author jpper
 */
public class Tipo {
    private int tipo;
    private String nombre;
    private String Descripcion;

    public Tipo(int tipo, String nombre, String Descripcion) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.Descripcion = Descripcion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
}
