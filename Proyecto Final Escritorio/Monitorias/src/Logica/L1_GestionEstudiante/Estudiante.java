/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.L1_GestionEstudiante;

import Datos.D1_GestionEstudiante;


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
private double promedio_m;
private double promedio_e;
private boolean Estado;

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
    
public int CrearUsuario(int codigo, String nombre,String apellido, String email, 
        int telefono, String programaAcademico,double promedio_e, double promedio_m
        ,boolean Estado){
    
    D1_GestionEstudiante d= new D1_GestionEstudiante();
    
    return d.CreacionEstudiante(codigo, nombre, apellido, email, telefono, 
            programaAcademico, promedio_e, promedio_m, Estado);
}

public int ModificarUsuario(int codigo,String email,int telefono, String programaAcademico,
        double promedio_e, double promedio_m,boolean Estado){
    
    D1_GestionEstudiante d= new D1_GestionEstudiante();
    

    return d.ActualizacionEstudiante(codigo,email, telefono, programaAcademico,
            promedio_e, promedio_m, Estado);
}


public int EliminarUsuario(int codigo){
    
    D1_GestionEstudiante d= new D1_GestionEstudiante();
    
    return d.EliminacionEstudiante(codigo);
}

public int ConsultaIngreso(int codigo,String contrasena){
    
    D1_GestionEstudiante d= new D1_GestionEstudiante();
    
    return d.ConsultaLogin(codigo,contrasena);
}

public int ConsultarGeneralUsuario(){
    
    D1_GestionEstudiante d= new D1_GestionEstudiante();
    return d.ConsultaEstudiante();
}

public int ConsultarEspecificaNombre(String nombre){
    
    D1_GestionEstudiante d= new D1_GestionEstudiante();
    
    return d.ConsultaEspecificaNom(nombre);
}

public int ConsultarEspecificaIdentificacion(int codigo){
    
    D1_GestionEstudiante d= new D1_GestionEstudiante();
    return d.ConsultaEspecificaID(codigo);
}

public int ConsultarEspecificaProgramaAca(String programaAcademico){
    D1_GestionEstudiante d= new D1_GestionEstudiante();
    return d.ConsultaEspecificaPA(programaAcademico);
}

public int ConsultarEspecificaEstado(boolean estado){
    D1_GestionEstudiante d= new D1_GestionEstudiante();
    return d.ConsultaEspecificaEstado(estado);
}

}
