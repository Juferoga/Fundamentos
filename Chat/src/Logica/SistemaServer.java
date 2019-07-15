package Logica;

import Presentacion.Modelo;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SistemaServer implements Runnable{
    private ServerSocket server;
    private Socket cliente;
    private Modelo miModelo;
    private int puerto;
    private Thread hiloConexiones;
    private boolean esperandoConexiones;
    
    private StringBuffer sbMensajes;
    private ArrayList <Cliente> listaClientes;

    public SistemaServer(Modelo miModelo) {
        this.miModelo=miModelo;
        listaClientes = new ArrayList<Cliente>();        
        sbMensajes = new StringBuffer();  
        esperandoConexiones = true;
    }    
    
    public void activarEsperaConexiones() throws IOException{
            server = new ServerSocket(puerto);
            hiloConexiones = new Thread(this);        
            hiloConexiones.start();
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public StringBuffer getSbMensajes(){
        return sbMensajes;
    }  

    public void enviarMensaje(String msg) throws IOException {        
        // Enviar este mensaje a todos los clientes
        Cliente host;
        sbMensajes.append(msg+"\n");//"\n"
        for(int c = 0; c < listaClientes.size(); c++){
            host = listaClientes.get(c);
            host.enviarMensaje(msg);
        }
    }

    @Override
    public void run() {
        while(esperandoConexiones){
            try {
                cliente = server.accept(); //espera a que alguien se conecte   
                miModelo.getVentanaPrincipal().getLblEnunciado().setText("conectado");
                Cliente nuevoCliente = new Cliente(this, cliente);
                listaClientes.add(nuevoCliente);
                nuevoCliente.start();
                //enviarMensaje("Se ha conectado " + nuevoCliente.getClienteConectado()+"\n");
                sbMensajes.append("Se ha conectado " + nuevoCliente.getClienteConectado()+"\n");
            } catch (IOException ex) {
            }            
        }
    }

    public boolean isEsperandoConexiones() {
        return esperandoConexiones;
    }

    public void setEsperandoConexiones(boolean esperandoConexiones) {
        this.esperandoConexiones = esperandoConexiones;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void detenerConexiones() throws IOException {
        Cliente host;
        
        for(int c = 0; c < listaClientes.size(); c++){
            host = listaClientes.get(c);
            host.terminarConexiones();
        }
    }   
}