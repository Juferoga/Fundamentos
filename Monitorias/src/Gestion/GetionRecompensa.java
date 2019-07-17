/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion;

import java.sql.*;


/**
 *
 * @author jpper
 */
public class GetionRecompensa {
    public void crearRecompensa(int i, String d, String u, int t)throws SQLException{
        Connection con;
        String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
        con = DriverManager.getConnection(BaseDeDatos,"Mon","123456");
        try {
            PreparedStatement darRec = con.prepareStatement("INSERT INTO recompensa (k_recompensa"
                    + ", t_descripcion_recompnsa, u_unidad, k_tipo) values (?,?,?,?) ");
            darRec.setInt(1, i);
            darRec.setString(2, d);
            darRec.setString(3, u);
            darRec.setInt(4, t);
            darRec.execute();
            System.out.println("se ha creado la recompensa");
        } catch (SQLException sql) {
            System.out.println("a cometido un error por favor ingrese los datos nuevamente");
        }
    }
    
}
