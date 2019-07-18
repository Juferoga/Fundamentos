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
//Se importa clases para las fechas y el tiempo
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Modelo implements Runnable{
    private SistemaServer miSistemaServer;//El servidor al cual se conectara
    private Sistema miSistema;//La aplicacion del cliente
            
    private VentanaPrincipal vistaPrincipal;//Vista del chat
    private Inicio VistaInicial;//Vista para elegir si ser servidor o cliente
    
    private int puerto;//Puerto al cual se conecta
 
    private Calendar calendario;//variable para fechas y horas
            
    private String estado;//Si es servidor o cliente
    private String host;//El host del pc por el que se hace la conexion
    private String alias;//Nombre que sale en el mensaje
 
    private Thread mensajes;//Hilo que se encarga de recibir mensajes
    
    public Modelo(){
        mensajes = new Thread(this);//Se instancia el hilo
        host="localhost";//Se inicia el host como el localhost
    }
    
    public Sistema getMiCliente(){//Encontrar el sistema del cliente
        if(miSistema == null){
            miSistema = new Sistema(alias);//Se instancia el sitema del cliente pasandole como parametro
        }                                  //como se llama en la aplicacion
        return miSistema;
    }
    
    public SistemaServer getMiServer(){//Encontrar el sistema del servidor
        if(miSistemaServer == null){
            miSistemaServer = new SistemaServer(this);
        }
        return miSistemaServer;
    }

    public VentanaPrincipal getVentanaPrincipal() {//Encontrar la ventana del chat
        if(vistaPrincipal == null){
            vistaPrincipal = new VentanaPrincipal(this);
        }
        return vistaPrincipal;
    }
    
    public Inicio getVentanaInicio(){//Encontrar la ventana de eleccion cliente o servidor
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
    
    public void iniciarServidor(int PuertoEntra){
        getVentanaPrincipal().setSize(660,530);
        getVentanaPrincipal().setVisible(true);
        getVentanaInicio().setVisible(false);
        getVentanaPrincipal().getLblEnunciado().setText("Esperando alguna conexion");
        getVentanaPrincipal().getLblEnunciado().setBounds(40, 30, 280, 50);
        getVentanaPrincipal().getTxaMensajes().setEnabled(false);
        getVentanaPrincipal().getTxtMensaje().setEnabled(false);
        getVentanaPrincipal().getBtnEnviar().setEnabled(false);
        getVentanaPrincipal().getTxaMensajes().setEditable(false);
        
        puerto = PuertoEntra;
        estado = "Servidor";//Se escoje rol de servidor
        esperarConexion();//Despues de crear la ventana inicial se procede a esperar conexion de algun        
    }
    
    public void iniciarCliente(int PuertoE, String aliasE) {
        getVentanaPrincipal().setSize(660,530);
        getVentanaPrincipal().setVisible(true);        
        getVentanaInicio().setVisible(false);
        
        getVentanaPrincipal().getLblEnunciado().setBounds(40, 55, 20, 20);
        getVentanaPrincipal().getLblEnunciado().setText(" ");
        getVentanaPrincipal().getLblEnunciado().setBackground(new java.awt.Color(255, 0, 0));//color rojo sin conexion
        getVentanaPrincipal().getTxaMensajes().setEnabled(false);
        getVentanaPrincipal().getTxtMensaje().setEnabled(false);
        getVentanaPrincipal().getBtnEnviar().setEnabled(false);
        getVentanaPrincipal().getTxaMensajes().setEditable(false);
        puerto = PuertoE;
        alias= aliasE;
        
        estado = "Cliente";//Se escoje rol de cliente
        try { 
            conectar();
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void esperarConexion(){
        try {
            getMiServer().setPuerto(puerto);//Se configura el puerto por el cual se conectara el servidor
            getMiServer().activarEsperaConexiones();//Se espera la conexionde algun alumno
            getVentanaPrincipal().getTxaMensajes().setEnabled(true);
            getVentanaPrincipal().getTxtMensaje().setEnabled(true);
            getVentanaPrincipal().getBtnEnviar().setEnabled(true);
            getVentanaPrincipal().getTxaMensajes().setEditable(true);            
            mensajes.start();//Se inicia para recibir los mensajes 
        }catch (IOException ex) {
            mostrarError(ex.getMessage());
        } 
    }
    
    void terminarConexion(){//Para desconectar el servidor
        try {
            getMiServer().setEsperandoConexiones(false);//se deja de esperar conexiones
            getMiServer().detenerConexiones();// se desconectan los clientes
        } catch (IOException ex) {
        }
    }
 
    public void conectar() throws IOException{
        try {
            getMiCliente().conectar(host, puerto);//Se conecta a un determinado puerto
                                                  //con el localhost            
            getVentanaPrincipal().getTxaMensajes().setEnabled(true);
            getVentanaPrincipal().getTxtMensaje().setEnabled(true);
            getVentanaPrincipal().getBtnEnviar().setEnabled(true);
            mensajes.start();//Se inicia para recibir los mensajes
        } catch (IOException ex) {
            mostrarError(ex.getMessage());
        } 
        getVentanaPrincipal().getLblEnunciado().setBackground(new java.awt.Color(52, 204, 0));//color verde despues de conectar
    }
    
    public void desconectar(){//Para desconectar el cliente
        try {
            getMiCliente().desconectar();//se desconecta del servidor
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
    
    private String esqueleto(){//Retorna el "esqueleto del mensaje" (fecha + hora)
        calendario=new GregorianCalendar();
        return("* " + calendario.get(Calendar.DATE) + "/" + (calendario.get(Calendar.MONTH)+1) +
                "/" + calendario.get(Calendar.YEAR) + "  ["+calendario.get(Calendar.HOUR_OF_DAY)+":"+
                calendario.get(Calendar.MINUTE)+"] ->  ");
    }
    
    public void enviarMensaje(){//enviar determinado mensaje dependiendo del rol
        String mensaje;
        mensaje = getVentanaPrincipal().getTxtMensaje().getText();
        if (mensaje.isEmpty()) {
            mostrarError("Mensaje vacio");
            return;
        }
        
        try {
            if(estado.equals("Cliente"))
                getMiCliente().enviarMensaje(esqueleto()+getMiCliente().getNombreHost()+": "+mensaje);//Se añade el esqueleto y el alias al mensaje
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