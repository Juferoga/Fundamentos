package Datos;
import java.util.Date;

public class Solicitud {
    private int idSolicitud;
    private int numEstudiantes;
    private boolean estado;
    private Date f_solicitud;
    private int numDuarcion;
    
    
    public Solicitud(int idSolicitud, int numEstudiantes, boolean estado, Date f_solicitud, int numDuarcion) {
        this.idSolicitud = idSolicitud;
        this.numEstudiantes = numEstudiantes;
        this.estado = estado;
        this.f_solicitud = f_solicitud;
        this.numDuarcion = numDuarcion;
    }

    public Date getF_solicitud() {
        return f_solicitud;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public int getNumEstudiantes() {
        return numEstudiantes;
    }

    public int getNumDuarcion() {
        return numDuarcion;
    }

    public boolean isEstado() {
        return estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setF_solicitud(Date f_solicitud) {
        this.f_solicitud = f_solicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public void setNumDuarcion(int numDuarcion) {
        this.numDuarcion = numDuarcion;
    }

    public void setNumEstudiantes(int numEstudiantes) {
        this.numEstudiantes = numEstudiantes;
    }
    
    
    
    
}
