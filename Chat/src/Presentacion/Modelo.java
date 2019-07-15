package Presentacion;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Logica.*;

public class Modelo implements Runnable{
    private SistemaServer miSistemaServer;
    private Sistema miSistema;
            
    private VentanaPrincipal vistaPrincipal;
    private Inicio VistaInicial;
    
    private int puerto;
    private String estado;
    private String host;
    private String alias;
    private Thread mensajes;
    
    private boolean conectado;
    
    public Modelo(){
        mensajes = new Thread(this);
    }
    
    public Sistema getMiCliente() {
        if(miSistema == null){
            miSistema = new Sistema(alias);
        }
        return miSistema;
    }
    
    public SistemaServer getMiServer() {
        if(miSistemaServer == null){
            miSistemaServer = new SistemaServer(this);
        }
        return miSistemaServer;
    }

    public VentanaPrincipal getVentanaPrincipal() {
        if(vistaPrincipal == null){
            vistaPrincipal = new VentanaPrincipal(this);
        }
        return vistaPrincipal;
    }
    
    public Inicio getVentanaInicio() {
        if(VistaInicial == null){
            VistaInicial = new Inicio(this);
        }
        return VistaInicial;
    }
    //************representacion de cU
    public void iniciar() {
        getVentanaInicio().setSize(480, 360);
        getVentanaInicio().setVisible(true);
        estado ="No tiene";
    }
    
    public void iniciarServidor(int PuertoEntra, String HostEntra){
        getVentanaPrincipal().setSize(660,530);
        getVentanaPrincipal().setVisible(true);
        getVentanaInicio().setVisible(false);
        getVentanaPrincipal().getLblEnunciado().setText("Esperando alguna conexion");
        getVentanaPrincipal().getTxaMensajes().setEnabled(false);
        getVentanaPrincipal().getTxtMensaje().setEnabled(false);
        getVentanaPrincipal().getBtnEnviar().setEnabled(false);
        getVentanaPrincipal().getTxaMensajes().setEditable(false);
        conectado = false;
        puerto = PuertoEntra;
        host = HostEntra;
        estado = "Servidor";
        esperarConexion();       
    }
    
    public void iniciarCliente(int PuertoE, String HostE, String aliasE) {
        getVentanaPrincipal().setSize(660,530);
        getVentanaPrincipal().setVisible(true);        
        getVentanaInicio().setVisible(false);
        conectado = false;
        getVentanaPrincipal().getLblEnunciado().setBounds(40, 55, 20, 20);
        getVentanaPrincipal().getLblEnunciado().setText(" ");
        getVentanaPrincipal().getLblEnunciado().setBackground(new java.awt.Color(255, 0, 0));
        getVentanaPrincipal().getTxaMensajes().setEnabled(false);
        getVentanaPrincipal().getTxtMensaje().setEnabled(false);
        getVentanaPrincipal().getBtnEnviar().setEnabled(false);
        getVentanaPrincipal().getTxaMensajes().setEditable(false);
        puerto = PuertoE;
        host = HostE;
        alias= aliasE;
        
        estado = "Cliente";
        try { 
            conectar();
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void esperarConexion(){
        try {
            getMiServer().setPuerto(puerto);
            getMiServer().activarEsperaConexiones();
            getVentanaPrincipal().getTxaMensajes().setEnabled(true);
            getVentanaPrincipal().getTxtMensaje().setEnabled(true);
            getVentanaPrincipal().getBtnEnviar().setEnabled(true);
            getVentanaPrincipal().getTxaMensajes().setEditable(true);            
            mensajes.start();
        }catch (IOException ex) {
            System.out.println("el error es, en esperando conexion:"+ex.getMessage());
            mostrarError(ex.getMessage());
        }  
        //getVentanaPrincipal().getLblEnunciado().setText("Conectado...");
    }
    
    void terminarConexion() {
        try {
            getMiServer().setEsperandoConexiones(false);
            getMiServer().detenerConexiones();           
            //getVentanaPrincipal().getTxtPuerto().setEnabled(true);
        } catch (IOException ex) {
        }
    }
 
    public void conectar() throws IOException{
        try {
            getMiCliente().conectar(host, puerto);
            conectado = true;
            getVentanaPrincipal().getTxaMensajes().setEnabled(true);
            getVentanaPrincipal().getTxtMensaje().setEnabled(true);
            getVentanaPrincipal().getBtnEnviar().setEnabled(true);
            mensajes.start();
        } catch (IOException ex) {
            System.out.println("el error es en conectar:"+ex.getMessage());
            mostrarError(ex.getMessage());
        }   
        getVentanaPrincipal().getLblEnunciado().setBackground(new java.awt.Color(52, 204, 0));
    }
    
    public void desconectar(){
        try {
            getMiCliente().desconectar();
            conectado = false;
            mensajes = null;
        } catch (IOException ex) {
            mostrarError(ex.getMessage());            
        }
        getVentanaPrincipal().getTxaMensajes().setEnabled(false);
        getVentanaPrincipal().getTxtMensaje().setEnabled(false);
        getVentanaPrincipal().getBtnEnviar().setEnabled(false);
        getVentanaPrincipal().getTxaMensajes().setEditable(false);
    }
 
    private void mostrarError(String msg) {
        JOptionPane.showMessageDialog(vistaPrincipal, msg, "Error de datos", JOptionPane.ERROR_MESSAGE);
    }
    
   public void enviarMensaje(){
        String mensaje;
        mensaje = getVentanaPrincipal().getTxtMensaje().getText();
        if (mensaje.isEmpty()) {
            mostrarError("Mensaje vacio");
            return;
        }
        try {
            if(estado.equals("Cliente"))
                getMiCliente().enviarMensaje(getMiCliente().getNombreHost()+": "+mensaje);
            else
                getMiServer().enviarMensaje("El servidor envía: " + mensaje);
        }catch (IOException ex){
            mostrarError(ex.getMessage());
        }
    }
    
    public void mostrarMensajes(){
        getVentanaPrincipal().getTxaMensajes().setText(getMiCliente().getMensajes().toString());
    }
    public void recibirMensajes(){
        getVentanaPrincipal().getTxaMensajes().setText(getMiServer().getSbMensajes().toString());
    }    
    @Override    
    public void run(){  
        Thread ct = Thread.currentThread();
        while(true){
            try{
                Thread.sleep(30);
                if(estado == "Cliente")
                    mostrarMensajes();
                else
                    recibirMensajes();
            }catch(InterruptedException ex){}
        }
    }
}