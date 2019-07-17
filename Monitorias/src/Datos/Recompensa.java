package Datos;

/**
 *
 * @author jpper
 */
public class Recompensa {
    private int recompensa;
    private String descripcion;
    private String unidad;
    

    public Recompensa(int recompensa, String descripcion, String unidad) {
        this.recompensa = recompensa;
        this.descripcion = descripcion;
        this.unidad = unidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getRecompensa() {
        return recompensa;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setRecompensa(int recompensa) {
        this.recompensa = recompensa;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
    
}
