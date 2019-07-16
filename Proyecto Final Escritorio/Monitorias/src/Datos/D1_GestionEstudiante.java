package Datos;

import java.sql.*;
import Logica.L1_GestionEstudiante.Estudiante;

import oracle.jdbc.driver.OracleConnection;

import util.CaException;
import util.ServiceLocator;
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
 
    private Estudiante estudiante;

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    public D1_GestionEstudiante(){
        
        estudiante = new Estudiante();
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
    
    public void CreacionEstudiante(int codigo, String nombre,String apellido, String email, 
        int telefono, String programaAcademico,double promedio_e, double promedio_m
            ,char Estado) throws CaException{
        
        try{
            
        String strSQL = "INSERT INTO Estudiante (n_nombre,n_apellido,o_email,num_telefono"
                + ",o_clave,t_programaAcademico,q_promedioM,q_promedioE,i_estado) VALUES "
                + "(?,?,?,?,?,?,?,?)";
        
        Connection conexion=ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        
        prepStmt.setInt(1, codigo);
        prepStmt.setString(2, nombre);
        prepStmt.setString(3, apellido);
        prepStmt.setString(4, email);
        prepStmt.setInt(5, telefono);
        prepStmt.setInt(6, codigo);
        prepStmt.setString(7, programaAcademico);
        prepStmt.setDouble(8, promedio_m);
        prepStmt.setDouble(9, promedio_e);
        prepStmt.setDouble(10, Estado);
        
        
        }catch(SQLException e){
            
            throw new CaException("D1_GestionEstudiante","No se logro crear el estudiante"+ e.getMessage());
            
        }
        finally{
            ServiceLocator.getInstance().liberarConexion();
        }
        
    }
    
    public void ActualizacionEstudiante(int codeEST, String e_mail,int phoneNumber,
            String programaAcademico,double PROM_estudiante,double PROM_monitor,
            boolean Estado) throws CaException{
        
        try{
            
        String strSQL = "UPDATE Estudiante SET num_telefono = ?"
                + "o_clave = ? t_programaAcademico = ? where  pk_codigo = ? ";
        
        
        Connection conexion=ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        
        prepStmt.setInt(1, phoneNumber);
        prepStmt.setInt(2, codeEST);
        prepStmt.setString(3, programaAcademico);
        prepStmt.setInt(4, codeEST);
        
        }catch(SQLException e){
            
            throw new CaException("D1_GestionEstudiante","No se logro ACTUALIZAR al estudiante"+ e.getMessage());
            
        }
        finally{
            ServiceLocator.getInstance().liberarConexion();
        }
        
    }
    
    public void EliminacionEstudiante(int codigo) throws CaException{
        
        try{
            
        String strSQL = "DELETE * FROM Estudiante"
                + "where  pk_codigo = ? ";
        
        
        Connection conexion=ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        
        prepStmt.setInt(1, codigo);
        
        }catch(SQLException e){
            
            throw new CaException("D1_GestionEstudiante","No se logro crear el estudiante"+ e.getMessage());
            
        }
        finally{
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    public void ConsultaEstudiante() throws CaException{
        
        try{
            
        String strSQL = "SELECT n_nombre, n_apellido, o_email, num_telefono, t_programaAcademico," +
"q_promedioM, q_promedioE WHERE i_estado='A'";
        
        
        Connection conexion=ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        
        ResultSet rs= prepStmt.executeQuery();
        
        while(rs.next()){
    
            estudiante.setNombre(rs.getString(1));
            estudiante.setApellido(rs.getString(2));
            estudiante.setEmail(rs.getString(3));
            estudiante.setTelefono(rs.getInt(4));
            estudiante.setProgramaAcademico(rs.getString(5));
            estudiante.setPromedio_m(rs.getDouble(6));
            estudiante.setPromedio_e(rs.getDouble(7));
            
        }
        
        }catch(SQLException e){
            
            throw new CaException("D1_GestionEstudiante","No se logro realizar la CONSULTA"+ e.getMessage());
            
        }
        finally{
            ServiceLocator.getInstance().liberarConexion();
        }
        
    }
    
    public void ConsultaEspecificaID(int codigo) throws CaException{
        
        try{
         String strSQL = "SELECT n_nombre, n_apellido, o_email, num_telefono, t_programaAcademico," +
"q_promedioM, q_promedioE WHERE i_estado='A' and pk_codigo=?";
         Connection conexion = ServiceLocator.getInstance().tomarConexion();
          PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
          prepStmt.setLong(1,estudiante.getCodigo());
          
          ResultSet rs = prepStmt.executeQuery();
          while (rs.next()){
            
            estudiante.setNombre(rs.getString(1));
            estudiante.setApellido(rs.getString(2));
            estudiante.setEmail(rs.getString(3));
            estudiante.setTelefono(rs.getInt(4));
            estudiante.setProgramaAcademico(rs.getString(5));
            estudiante.setPromedio_m(rs.getDouble(6));
            estudiante.setPromedio_e(rs.getDouble(7));
            
          }
      }
      catch(SQLException e){
        throw new CaException("MunicipioDAO", "No pudo recuperar el Municipio "+ e.getMessage());
      }
        
        
    }

    public int ConsultaLogin(int codigo, String contrasena) 
            throws CaException{

        try{
         String strSQL = "SELECT n_nombre, n_apellido, o_email, num_telefono, t_programaAcademico," +
"q_promedioM, q_promedioE WHERE i_estado='A' and pk_codigo=? and o_clave=?";
         
         Connection conexion = ServiceLocator.getInstance().tomarConexion();
          PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
          
          prepStmt.setLong(1,estudiante.getCodigo());
          prepStmt.setString(2,estudiante.getContrasena());
          
          ResultSet rs = prepStmt.executeQuery();
          
            if ( rs.getRow() == 0 )
            {
               return 0;
            }
            else
            {
              return 1;
            }
      }
      catch(SQLException e){
        throw new CaException("MunicipioDAO", "No pudo recuperar el Municipio "+ e.getMessage());
      }
        
    }

    public void ConsultaEspecificaNom(String nombre) throws CaException{
       
        try{
         String strSQL = "SELECT n_nombre, n_apellido, o_email, num_telefono, t_programaAcademico," +
"q_promedioM, q_promedioE WHERE i_estado='A' and n_nombre LIKE ?";
         Connection conexion = ServiceLocator.getInstance().tomarConexion();
          PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
          prepStmt.setString(1,"%"+estudiante.getNombre()+"%");
          
          ResultSet rs = prepStmt.executeQuery();
          while (rs.next()){
            
            estudiante.setNombre(rs.getString(1));
            estudiante.setApellido(rs.getString(2));
            estudiante.setEmail(rs.getString(3));
            estudiante.setTelefono(rs.getInt(4));
            estudiante.setProgramaAcademico(rs.getString(5));
            estudiante.setPromedio_m(rs.getDouble(6));
            estudiante.setPromedio_e(rs.getDouble(7));
            
          }
      }
      catch(SQLException e){
        throw new CaException("MunicipioDAO", "No pudo recuperar el Municipio "+ e.getMessage());
      }
    }

    public void ConsultaEspecificaPA(String programaAcademico) throws CaException{
        
        try{
         String strSQL = "SELECT n_nombre, n_apellido, o_email, num_telefono, t_programaAcademico," +
"q_promedioM, q_promedioE WHERE i_estado='A' and n_nombre LIKE ?";
         Connection conexion = ServiceLocator.getInstance().tomarConexion();
          PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
          prepStmt.setString(1,"%"+estudiante.getProgramaAcademico()+"%");
          
          ResultSet rs = prepStmt.executeQuery();
          while (rs.next()){
            
            estudiante.setNombre(rs.getString(1));
            estudiante.setApellido(rs.getString(2));
            estudiante.setEmail(rs.getString(3));
            estudiante.setTelefono(rs.getInt(4));
            estudiante.setProgramaAcademico(rs.getString(5));
            estudiante.setPromedio_m(rs.getDouble(6));
            estudiante.setPromedio_e(rs.getDouble(7));
            
          }
      }
      catch(SQLException e){
        throw new CaException("MunicipioDAO", "No pudo recuperar el Municipio "+ e.getMessage());
      }
    }

    public void ConsultaEspecificaEstado(boolean estado) throws CaException{
        
        try{
         String strSQL = "SELECT n_nombre, n_apellido, o_email, num_telefono, t_programaAcademico," +
"q_promedioM, q_promedioE WHERE i_estado='A' and n_nombre LIKE ?";
         Connection conexion = ServiceLocator.getInstance().tomarConexion();
          PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
          prepStmt.setString(1,"%"+estudiante.isEstado()+"%");
          
          ResultSet rs = prepStmt.executeQuery();
          while (rs.next()){
            
            estudiante.setNombre(rs.getString(1));
            estudiante.setApellido(rs.getString(2));
            estudiante.setEmail(rs.getString(3));
            estudiante.setTelefono(rs.getInt(4));
            estudiante.setProgramaAcademico(rs.getString(5));
            estudiante.setPromedio_m(rs.getDouble(6));
            estudiante.setPromedio_e(rs.getDouble(7));
            
          }
      }
      catch(SQLException e){
        throw new CaException("MunicipioDAO", "No pudo recuperar el Municipio "+ e.getMessage());
      }
    }
    
}
