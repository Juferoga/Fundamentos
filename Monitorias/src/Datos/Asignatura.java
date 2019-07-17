package Datos;

public class Asignatura {
    private int asignatura;
    private String nombre;
    private String descripcion;

    public Asignatura(int asignatura, String nombre, String descripcion) {
        this.asignatura = asignatura;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getAsignatura() {
        return asignatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setAsignatura(int asignatura) {
        this.asignatura = asignatura;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
