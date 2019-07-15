/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.L4_GestionChat;

/**
 *
 * @author estudiantes
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Sistema implements Runnable{
    
    private String alias;
    private int puerto;
    private Socket servidor;
    private StringBuffer mensajes;
    
    private boolean conectado;
    
    private DataInputStream datosEntrada;
    private DataOutputStream datosSalida;
    
    private boolean recibeMensaje;
    private Thread hiloLectura;
    
    public Sistema(String alias) {
        this.alias=alias;
        conectado = false;
        mensajes = new StringBuffer();        
    }

    public String getNombreHost(){
        return alias;
    }

    public int getPuerto() {
        return puerto;
    }

    public StringBuffer getMensajes() {
        return mensajes;
    }

    public boolean isConectado() {
        return conectado;
    }
    
    
    public void conectar(String host, int puerto) throws IOException{
        // 1. Establecer contacto
        servidor = new Socket(host, puerto);
        
        //2. Capturar flujos(stream)
        datosEntrada = new DataInputStream(servidor.getInputStream());
        datosSalida = new DataOutputStream(servidor.getOutputStream());
        
        conectado = true;
        hiloLectura = new Thread(this);
        hiloLectura.start(); 
    }
    
    public void enviarMensaje(String msg) throws IOException{
        if(alias!=null)
            datosSalida.write(msg.getBytes());
        //mensajes.append(">:" + msg  +"\n");//
    }

    @Override
    public void run() {
        byte buffer[] = new byte[256];
        String msg;
        
        while(conectado){
            try {
                datosEntrada.read(buffer);
                // si llego aqui, es porque algo llego
                msg = new String(buffer);
                mensajes.append( msg + "\n");//"<: " + msg + "\n"
                recibeMensaje = true;
            } catch(IOException ex){}            
        }
    }

    public void desconectar() throws IOException {
        conectado = false;
        datosEntrada.close();
        datosSalida.close();
        servidor.close();        
    }

    public boolean isRecibeMensaje() {
        return recibeMensaje;
    }

    public void setRecibeMensaje(boolean recibeMensaje) {
        this.recibeMensaje = recibeMensaje;
    }   
}
