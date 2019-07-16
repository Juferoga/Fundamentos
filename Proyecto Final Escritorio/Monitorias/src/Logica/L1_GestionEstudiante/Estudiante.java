/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.L1_GestionEstudiante;

import Datos.D1_GestionEstudiante;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.CaException;


/**
 *
 * @author glud-mint
 */

public class Estudiante {
    
private int codigo;
private String nombre;
private String apellido;
private String email;
private int telefono;
private String programaAcademico;
private String contrasena;
private double promedio_m;
private double promedio_e;
private boolean Estado;

public Estudiante (){

}

public Estudiante (int codigo, String nombre,String apellido, String email, 
        int telefono, String programaAcademico,double promedio_e, double promedio_m,boolean Estado){
    
    this.codigo = codigo;
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.telefono = telefono;
    this.programaAcademico = programaAcademico;
    this.promedio_e = promedio_e;
    this.promedio_m = promedio_m;    
    this.Estado = Estado;
    
}

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getProgramaAcademico() {
        return programaAcademico;
    }

    public void setProgramaAcademico(String programaAcademico) {
        this.programaAcademico = programaAcademico;
    }

    public double getPromedio_m() {
        return promedio_m;
    }

    public void setPromedio_m(double promedio_m) {
        this.promedio_m = promedio_m;
    }

    public double getPromedio_e() {
        return promedio_e;
    }

    public void setPromedio_e(double promedio_e) {
        this.promedio_e = promedio_e;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }
    
public int CrearUsuario(int codigo, String nombre,String apellido, String email, 
        int telefono, String programaAcademico,double promedio_e, double promedio_m
        ,boolean Estado){
    
    D1_GestionEstudiante d= new D1_GestionEstudiante();
    
    return 1;
//    return d.CreacionEstudiante(codigo, nombre, apellido, email, telefono, 
  //          programaAcademico, promedio_e, promedio_m, Estado);
}

public int ModificarUsuario(int codigo,String email,int telefono, String programaAcademico,
        double promedio_e, double promedio_m,boolean Estado){
    
    D1_GestionEstudiante d= new D1_GestionEstudiante();
    
    try {
        d.ActualizacionEstudiante(codigo,email, telefono, programaAcademico,
                promedio_e, promedio_m, Estado);
    } catch (CaException ex) {
        Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return 1;
}


public int EliminarUsuario(int codigo){
    
    D1_GestionEstudiante d= new D1_GestionEstudiante();
    try {
        d.EliminacionEstudiante(codigo);
    } catch (CaException ex) {
        Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return 1;
}

public int ConsultaIngreso(int codigo,String contrasena){
    
    D1_GestionEstudiante d= new D1_GestionEstudiante();
    
    try {
        d.ConsultaLogin(codigo,contrasena);
        
    } catch (CaException ex) {
        Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return 1;
}

public int ConsultarGeneralUsuario(){
    
    D1_GestionEstudiante d= new D1_GestionEstudiante();
    try {
        d.ConsultaEstudiante();
    } catch (CaException ex) {
        Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return 1;
}

public int ConsultarEspecificaNombre(String nombre){
    
    D1_GestionEstudiante d= new D1_GestionEstudiante();
    try {
        d.ConsultaEspecificaNom(nombre);
    } catch (CaException ex) {
        Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return 1;
}

public int ConsultarEspecificaIdentificacion(int codigo){
    
    D1_GestionEstudiante d= new D1_GestionEstudiante();
    try {
        d.ConsultaEspecificaID(codigo);
    } catch (CaException ex) {
        Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return 1;
}

public int ConsultarEspecificaProgramaAca(String programaAcademico){
    D1_GestionEstudiante d= new D1_GestionEstudiante();
    try {
        d.ConsultaEspecificaPA(programaAcademico);
    } catch (CaException ex) {
        Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return 1;
}

public int ConsultarEspecificaEstado(boolean estado){
    D1_GestionEstudiante d= new D1_GestionEstudiante();
    try {
        d.ConsultaEspecificaEstado(estado);
    } catch (CaException ex) {
        Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return 1;
}

}
