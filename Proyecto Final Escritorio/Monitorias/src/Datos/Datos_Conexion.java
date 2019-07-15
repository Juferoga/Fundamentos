/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author glud-mint
 */
public class Datos_Conexion {
    public static String Cc() {
            String CadenaSQLcon = "data source=DELL\\SQLEXPRESS;initial catalog=Gaitana;integrated security=true";
            return CadenaSQLcon;
        }
}
