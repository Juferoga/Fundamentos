package Datos;

import java.sql.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Juan Felipe (Local)
 */

public class D1_GestionEstudiante {
 
    private int codigoEstudiante;
    private String nombreEstudiante;
    private String apellidoEstudiante;
    private String email;
    private int numeroTelefono;
    private double promedioMonitor;
    private double promedioEstudiante;
    
    public D1_GestionEstudiante(){
        
        codigoEstudiante=0;
        nombreEstudiante="NN";
        apellidoEstudiante="NN";
        email="NN";
        numeroTelefono=123;
        promedioMonitor=5;
        promedioEstudiante=5;
    }
    
    /*D1_GestionEstudiante(int codeEST,String nameEST,String lastnameEST,
    String e_mail,int phoneNumber,double PROM_monitor,double PROM_estudiante){
    
        codeEST=codigoEstudiante;
        nameEST=nombreEstudiante;
        lastnameEST=apellidoEstudiante;
        e_mail=email;
        phoneNumber=numeroTelefono;
        PROM_monitor=promedioMonitor;
        PROM_estudiante=promedioEstudiante;
        
        
    }*/
    
    public int CreacionEstudiante(int codigo, String nombre,String apellido, String email, 
        int telefono, String programaAcademico,double promedio_e, double promedio_m
            ,boolean Estado){
        
        
        
        
        return 1;
    }
    
    public int ActualizacionEstudiante(int codeEST, String e_mail,int phoneNumber,
            String ProgramaAcademico,double PROM_estudiante,double PROM_monitor,
            boolean Estado){
        
        
        return 1;
    }
    
    public int EliminacionEstudiante(int codigo){
        
        
        return 1;
    }
    
    public int ConsultaEstudiante(){
        
        return 1;
    }
    
    public int ConsultaEspecificaID(int codigo){
        
        return 1;
    }

    public int ConsultaLogin(int codigo, String contrasena) {

        return 1;
    }

    public int ConsultaEspecificaNom(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int ConsultaEspecificaPA(String programaAcademico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int ConsultaEspecificaEstado(boolean estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
