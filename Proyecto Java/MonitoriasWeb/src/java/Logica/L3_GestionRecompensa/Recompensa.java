/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.L3_GestionRecompensa;
import Logica.L1_GestionEstudiante.*;
import Datos.D1_GestionEstudiante.CreacionEstudiante;
import Datos.D1_GestionEstudiante.ActualizacionEstudiante;
import Datos.D1_GestionEstudiante.ConsultaEstudiante;
import Datos.D1_GestionEstudiante.EliminacionEstudiante;

/**
 *
 * @author glud-mint
 */

public class Recompensa {
    
int codigo;
String nombre;
int telefono;
String programaAcademico;
String email;
boolean Estado;

public Recompensa (int codigo, String nombre, int telefono, String programaAcademico, String email, boolean Estado){
    
    this.codigo = codigo;
    this.nombre = nombre;
    this.telefono = telefono;
    this.programaAcademico = programaAcademico;
    this.email = email;
    this.Estado = Estado;
    
}
    
int CrearUsuario(){
    return 1;
}

int ModificarUsuario(){
    return 1;
}


int EliminarUsuario(){
    return 1;
}

int ConsultaIngreso(){
    return 1;
}

int ConsultarGeneralUsuario(){
    return 1;
}

int ConsultarEspecificaNombre(){
    return 1;
}

int ConsultarEspecificaIdentificacion(){
    return 1;
}

int ConsultarEspecificaProgramaAca(){
    return 1;
}

int ConsultarEspecificaEstado(){
    return 1;
}

}
