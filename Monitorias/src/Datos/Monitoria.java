package Datos;
import java.util.Date;


/**
 *
 * @author jpper
 */
public class Monitoria {
    private String lugar;
    private int id;
    private boolean estado;
    private Date fecha;
    private Date Hora;
    //private String califM;
    //private String califE;
    private String desM;
    private String desE;

    public Monitoria(String lugar, int id, boolean estado, Date fecha, Date Hora, String desM, String desE) {
        this.lugar = lugar;
        this.id = id;
        this.estado = estado;
        this.fecha = fecha;
        this.Hora = Hora;
        //this.califM = califM;
        //this.califE = califE;
        this.desM = desM;
        this.desE = desE;
    }

    

    /*public String getCalifE() {
        return califE;
    }

    public String getCalifM() {
        return califM;
    }*/

    public String getDesE() {
        return desE;
    }

    public String getDesM() {
        return desM;
    }

    public Date getFecha() {
        return fecha;
    }

    public Date getHora() {
        return Hora;
    }

    public int getId() {
        return id;
    }

    public String getLugar() {
        return lugar;
    }

    public boolean isEstado() {
        return estado;
    }

    /*public void setCalifE(String califE) {
        this.califE = califE;
    }

    public void setCalifM(String califM) {
        this.califM = califM;
    }*/

    public void setDesE(String desE) {
        this.desE = desE;
    }

    public void setDesM(String desM) {
        this.desM = desM;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHora(Date Hora) {
        this.Hora = Hora;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    
    
}
