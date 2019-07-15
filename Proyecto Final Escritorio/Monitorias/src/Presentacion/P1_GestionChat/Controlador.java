

package Presentacion.P1_GestionChat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;



class Controlador implements ActionListener{

    private final Inicio ventana;

    public Controlador(Inicio aThis) {
        ventana = aThis;
    }
    
    private void mostrarError(String msg) {
        JOptionPane.showMessageDialog(ventana, msg, "Error de datos", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton;
        boton = (JButton)e.getSource();
        
        String PuertoE=ventana.getTxtPuerto().getText();
        String HostE=ventana.getTxtHost().getText();
        String AliasE=ventana.getTxtAlias().getText();
        if(PuertoE.isEmpty() || HostE.isEmpty() || AliasE.isEmpty()){
            mostrarError("Hay algun requisito vacio");
            return;
        }else
            if(ventana.getEleccion()== 0 )
                ventana.getModelo().iniciarServidor(Integer.parseInt(PuertoE),HostE);
            else
                ventana.getModelo().iniciarCliente(Integer.parseInt(PuertoE),HostE,AliasE);
    }    
}