/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

import java.util.Date;

/**
 *
 * @author Juan Felipe (Local)
 */


public class D2_GestionMonitoria {
    
    private int id_monitoria;
    private Date fecha;
    private String lugar;
    private Date H_Inicial;
    private boolean estado;
    private String descripcion_M;
    private String descripcion_E;
    private int calificacion_M;
    private int calificacion_E;
    
    
    
    public D2_GestionMonitoria(){
      id_monitoria=0;
      fecha=new Date();
      lugar= "";
      H_Inicial= new Date();
      
    }
    
    public int CreacionMonitoria(){
        return 1;
    }
    
    public int ActualizacionMonitoria(){
        return 1;
    }
    
    public int ConsultaMonitoria(){
        return 1;
    }
    
    public int EliminacionMonitoria(){
        return 1;
    }
}

    
