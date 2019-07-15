
package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;



class ControladorMensaje implements ActionListener{

    private final VentanaPrincipal ventana;

    public ControladorMensaje(VentanaPrincipal aThis) {
        ventana = aThis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton;
        boton = (JButton)e.getSource();
        
        if(boton == ventana.getBtnEnviar())
            ventana.getModelo().enviarMensaje();
    }    
}