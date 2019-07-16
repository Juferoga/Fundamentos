package Datos;

import java.sql.*;
import Logica.L3_GestionRecompensa.Recompensa;

import oracle.jdbc.driver.OracleConnection;

import util.CaException;
import util.ServiceLocator;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in estudiantethe editor.
 */


/**
 *
 * @author Juan Felipe (Local)
 */

public class D3_GestionRecompensa {
 
    private Recompensa recompensa;

    public Recompensa getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(Recompensa recompensa) {
        this.recompensa = recompensa;
    }
    
    public D3_GestionRecompensa(){
        
        recompensa = new Recompensa();
    }
    
    /*D1_GestionRecompensa(int codeEST,String nameEST,String lastnameEST,
    String e_mail,int phoneNumber,double PROM_monitor,double PROM_recompensa){
    
        codeEST=codigoRecompensa;
        nameEST=nombreRecompensa;
        lastnameEST=apellidoRecompensa;
        e_mail=email;
        phoneNumber=numeroTelefono;
        PROM_monitor=promedioMonitor;
        PROM_recompensa=promedioRecompensa;
        
        
    }*/
    
    public void CreacionRecompensa(int codigo, String nombre,String apellido, String email, 
        int telefono, String programaAcademico,double promedio_e, double promedio_m
            ,char Estado) throws CaException{
        
        try{
            
        String strSQL = "INSERT INTO Recompensa (n_nombre,n_apellido,o_email,num_telefono"
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
            
            throw new CaException("D1_GestionRecompensa","No se logro crear el recompensa"+ e.getMessage());
            
        }
        finally{
            ServiceLocator.getInstance().liberarConexion();
        }
        
    }
    
    public void ActualizacionRecompensa(int codeEST, String e_mail,int phoneNumber,
            String programaAcademico,double PROM_recompensa,double PROM_monitor,
            boolean Estado) throws CaException{
        
        try{
            
        String strSQL = "UPDATE Recompensa SET num_telefono = ?"
                + "o_clave = ? t_programaAcademico = ? where  pk_codigo = ? ";
        
        
        Connection conexion=ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        
        prepStmt.setInt(1, phoneNumber);
        prepStmt.setInt(2, codeEST);
        prepStmt.setString(3, programaAcademico);
        prepStmt.setInt(4, codeEST);
        
        }catch(SQLException e){
            
            throw new CaException("D1_GestionRecompensa","No se logro ACTUALIZAR al recompensa"+ e.getMessage());
            
        }
        finally{
            ServiceLocator.getInstance().liberarConexion();
        }
        
    }
    
    public void EliminacionRecompensa(int codigo) throws CaException{
        
        try{
            
        String strSQL = "DELETE * FROM Recompensa"
                + "where  pk_codigo = ? ";
        
        
        Connection conexion=ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        
        prepStmt.setInt(1, codigo);
        
        }catch(SQLException e){
            
            throw new CaException("D1_GestionRecompensa","No se logro crear el recompensa"+ e.getMessage());
            
        }
        finally{
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    public void ConsultaRecompensa() throws CaException{
        
        try{
            
        String strSQL = "SELECT n_nombre, n_apellido, o_email, num_telefono, t_programaAcademico," +
"q_promedioM, q_promedioE WHERE i_estado='A'";
        
        
        Connection conexion=ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        
        ResultSet rs= prepStmt.executeQuery();
        
        while(rs.next()){
    
            recompensa.setNombre(rs.getString(1));
            recompensa.setApellido(rs.getString(2));
            recompensa.setEmail(rs.getString(3));
            recompensa.setTelefono(rs.getInt(4));
            recompensa.setProgramaAcademico(rs.getString(5));
            recompensa.setPromedio_m(rs.getDouble(6));
            recompensa.setPromedio_e(rs.getDouble(7));
            
        }
        
        }catch(SQLException e){
            
            throw new CaException("D1_GestionRecompensa","No se logro realizar la CONSULTA"+ e.getMessage());
            
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
          prepStmt.setLong(1,recompensa.getCodigo());
          
          ResultSet rs = prepStmt.executeQuery();
          while (rs.next()){
            
            recompensa.setNombre(rs.getString(1));
            recompensa.setApellido(rs.getString(2));
            recompensa.setEmail(rs.getString(3));
            recompensa.setTelefono(rs.getInt(4));
            recompensa.setProgramaAcademico(rs.getString(5));
            recompensa.setPromedio_m(rs.getDouble(6));
            recompensa.setPromedio_e(rs.getDouble(7));
            
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
          
          prepStmt.setLong(1,recompensa.getCodigo());
          prepStmt.setString(2,recompensa.getContrasena());
          
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
          prepStmt.setString(1,"%"+recompensa.getNombre()+"%");
          
          ResultSet rs = prepStmt.executeQuery();
          while (rs.next()){
            
            recompensa.setNombre(rs.getString(1));
            recompensa.setApellido(rs.getString(2));
            recompensa.setEmail(rs.getString(3));
            recompensa.setTelefono(rs.getInt(4));
            recompensa.setProgramaAcademico(rs.getString(5));
            recompensa.setPromedio_m(rs.getDouble(6));
            recompensa.setPromedio_e(rs.getDouble(7));
            
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
          prepStmt.setString(1,"%"+recompensa.getProgramaAcademico()+"%");
          
          ResultSet rs = prepStmt.executeQuery();
          while (rs.next()){
            
            recompensa.setNombre(rs.getString(1));
            recompensa.setApellido(rs.getString(2));
            recompensa.setEmail(rs.getString(3));
            recompensa.setTelefono(rs.getInt(4));
            recompensa.setProgramaAcademico(rs.getString(5));
            recompensa.setPromedio_m(rs.getDouble(6));
            recompensa.setPromedio_e(rs.getDouble(7));
            
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
          prepStmt.setString(1,"%"+recompensa.isEstado()+"%");
          
          ResultSet rs = prepStmt.executeQuery();
          while (rs.next()){
            
            recompensa.setNombre(rs.getString(1));
            recompensa.setApellido(rs.getString(2));
            recompensa.setEmail(rs.getString(3));
            recompensa.setTelefono(rs.getInt(4));
            recompensa.setProgramaAcademico(rs.getString(5));
            recompensa.setPromedio_m(rs.getDouble(6));
            recompensa.setPromedio_e(rs.getDouble(7));
            
          }
      }
      catch(SQLException e){
        throw new CaException("MunicipioDAO", "No pudo recuperar el Municipio "+ e.getMessage());
      }
    }
    
}
