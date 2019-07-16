package Datos;

import java.sql.*;
import Logica.L2_GestionMonitoria.Monitoria;

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

public class D2_GestionMonitoria {
 
    private Monitoria monitoria;

    public Monitoria getMonitoria() {
        return monitoria;
    }

    public void setMonitoria(Monitoria monitoria) {
        this.monitoria = monitoria;
    }
    
    public D2_GestionMonitoria(){
        
        monitoria = new Monitoria();
    }
    
    /*D1_GestionMonitoria(int codeEST,String nameEST,String lastnameEST,
    String e_mail,int phoneNumber,double PROM_monitor,double PROM_monitoria){
    
        codeEST=codigoMonitoria;
        nameEST=nombreMonitoria;
        lastnameEST=apellidoMonitoria;
        e_mail=email;
        phoneNumber=numeroTelefono;
        PROM_monitor=promedioMonitor;
        PROM_monitoria=promedioMonitoria;
        
        
    }*/
    
    public void CreacionMonitoria(int codigo, String nombre,String apellido, String email, 
        int telefono, String programaAcademico,double promedio_e, double promedio_m
            ,char Estado) throws CaException{
        
        try{
            
        String strSQL = "INSERT INTO Monitoria (n_nombre,n_apellido,o_email,num_telefono"
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
            
            throw new CaException("D1_GestionMonitoria","No se logro crear el monitoria"+ e.getMessage());
            
        }
        finally{
            ServiceLocator.getInstance().liberarConexion();
        }
        
    }
    
    public void ActualizacionMonitoria(int codeEST, String e_mail,int phoneNumber,
            String programaAcademico,double PROM_monitoria,double PROM_monitor,
            boolean Estado) throws CaException{
        
        try{
            
        String strSQL = "UPDATE Monitoria SET num_telefono = ?"
                + "o_clave = ? t_programaAcademico = ? where  pk_codigo = ? ";
        
        
        Connection conexion=ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        
        prepStmt.setInt(1, phoneNumber);
        prepStmt.setInt(2, codeEST);
        prepStmt.setString(3, programaAcademico);
        prepStmt.setInt(4, codeEST);
        
        }catch(SQLException e){
            
            throw new CaException("D1_GestionMonitoria","No se logro ACTUALIZAR al monitoria"+ e.getMessage());
            
        }
        finally{
            ServiceLocator.getInstance().liberarConexion();
        }
        
    }
    
    public void EliminacionMonitoria(int codigo) throws CaException{
        
        try{
            
        String strSQL = "DELETE * FROM Monitoria"
                + "where  pk_codigo = ? ";
        
        
        Connection conexion=ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        
        prepStmt.setInt(1, codigo);
        
        }catch(SQLException e){
            
            throw new CaException("D1_GestionMonitoria","No se logro crear el monitoria"+ e.getMessage());
            
        }
        finally{
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    public void ConsultaMonitoria() throws CaException{
        
        try{
            
        String strSQL = "SELECT n_nombre, n_apellido, o_email, num_telefono, t_programaAcademico," +
"q_promedioM, q_promedioE WHERE i_estado='A'";
        
        
        Connection conexion=ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        
        ResultSet rs= prepStmt.executeQuery();
        
        while(rs.next()){
    
            monitoria.setNombre(rs.getString(1));
            monitoria.setApellido(rs.getString(2));
            monitoria.setEmail(rs.getString(3));
            monitoria.setTelefono(rs.getInt(4));
            monitoria.setProgramaAcademico(rs.getString(5));
            monitoria.setPromedio_m(rs.getDouble(6));
            monitoria.setPromedio_e(rs.getDouble(7));
            
        }
        
        }catch(SQLException e){
            
            throw new CaException("D1_GestionMonitoria","No se logro realizar la CONSULTA"+ e.getMessage());
            
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
          prepStmt.setLong(1,monitoria.getCodigo());
          
          ResultSet rs = prepStmt.executeQuery();
          while (rs.next()){
            
            monitoria.setNombre(rs.getString(1));
            monitoria.setApellido(rs.getString(2));
            monitoria.setEmail(rs.getString(3));
            monitoria.setTelefono(rs.getInt(4));
            monitoria.setProgramaAcademico(rs.getString(5));
            monitoria.setPromedio_m(rs.getDouble(6));
            monitoria.setPromedio_e(rs.getDouble(7));
            
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
          
          prepStmt.setLong(1,monitoria.getCodigo());
          prepStmt.setString(2,monitoria.getContrasena());
          
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
          prepStmt.setString(1,"%"+monitoria.getNombre()+"%");
          
          ResultSet rs = prepStmt.executeQuery();
          while (rs.next()){
            
            monitoria.setNombre(rs.getString(1));
            monitoria.setApellido(rs.getString(2));
            monitoria.setEmail(rs.getString(3));
            monitoria.setTelefono(rs.getInt(4));
            monitoria.setProgramaAcademico(rs.getString(5));
            monitoria.setPromedio_m(rs.getDouble(6));
            monitoria.setPromedio_e(rs.getDouble(7));
            
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
          prepStmt.setString(1,"%"+monitoria.getProgramaAcademico()+"%");
          
          ResultSet rs = prepStmt.executeQuery();
          while (rs.next()){
            
            monitoria.setNombre(rs.getString(1));
            monitoria.setApellido(rs.getString(2));
            monitoria.setEmail(rs.getString(3));
            monitoria.setTelefono(rs.getInt(4));
            monitoria.setProgramaAcademico(rs.getString(5));
            monitoria.setPromedio_m(rs.getDouble(6));
            monitoria.setPromedio_e(rs.getDouble(7));
            
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
          prepStmt.setString(1,"%"+monitoria.isEstado()+"%");
          
          ResultSet rs = prepStmt.executeQuery();
          while (rs.next()){
            
            monitoria.setNombre(rs.getString(1));
            monitoria.setApellido(rs.getString(2));
            monitoria.setEmail(rs.getString(3));
            monitoria.setTelefono(rs.getInt(4));
            monitoria.setProgramaAcademico(rs.getString(5));
            monitoria.setPromedio_m(rs.getDouble(6));
            monitoria.setPromedio_e(rs.getDouble(7));
            
          }
      }
      catch(SQLException e){
        throw new CaException("MunicipioDAO", "No pudo recuperar el Municipio "+ e.getMessage());
      }
    }
    
}
