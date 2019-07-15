
package Presentacion;

import Logica.Cliente.*;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Canvas;
import javax.swing.JComboBox;

public class Inicio extends javax.swing.JFrame {

    private final Modelo modelo;
    private Controlador control;
        
    private javax.swing.JComboBox ComBoxPartida;
    
    public Inicio(Modelo aThis) {
        modelo = aThis;
        initComponents();
        capturarEventos();
        String[] opcs={"Crear partida", "Unirse a una partida"};
        ComBoxPartida = new JComboBox(opcs);
        getContentPane().add(ComBoxPartida);
        ComBoxPartida.setBounds(180, 170, 100, 30);
        pack();
    }

    @SuppressWarnings("unchecked")
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Bienvenido = new javax.swing.JLabel();
        Imagen = new javax.swing.JLabel();
        lblHost = new javax.swing.JLabel();
        txtHost = new javax.swing.JTextField();
        lblPuerto = new javax.swing.JLabel();
        txtPuerto = new javax.swing.JTextField();
        btnJugar = new javax.swing.JButton();
        lblAlias = new javax.swing.JLabel();
        txtAlias = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(400, 220, 0, 0));
        getContentPane().setLayout(null);

        Bienvenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Bienvenido.setText("Bienvenido");
        getContentPane().add(Bienvenido);
        Bienvenido.setBounds(120, 10, 220, 30);

        Imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Imagen.setText("Imagen");
        getContentPane().add(Imagen);
        Imagen.setBounds(120, 30, 220, 50);

        lblHost.setText("Host");
        getContentPane().add(lblHost);
        lblHost.setBounds(62, 80, 50, 20);
        getContentPane().add(txtHost);
        txtHost.setBounds(140, 80, 210, 20);

        lblPuerto.setText("Puerto");
        getContentPane().add(lblPuerto);
        lblPuerto.setBounds(60, 110, 60, 15);
        getContentPane().add(txtPuerto);
        txtPuerto.setBounds(140, 110, 210, 19);

        btnJugar.setText("Jugar");
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });
        getContentPane().add(btnJugar);
        btnJugar.setBounds(180, 230, 100, 30);

        lblAlias.setText("alias");
        getContentPane().add(lblAlias);
        lblAlias.setBounds(60, 140, 34, 15);
        getContentPane().add(txtAlias);
        txtAlias.setBounds(140, 140, 210, 19);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void ComBoxPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComBoxPartidaActionPerformed
        // TODO add your handling code here:        
    }//GEN-LAST:event_ComBoxPartidaActionPerformed
    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnJugarActionPerformed

    private void capturarEventos(){
        btnJugar.addActionListener(getControl());
    }

    public Modelo getModelo() {
        return modelo;
    }

    public Controlador getControl() {
        if(control == null){
            control = new Controlador(this);
        }
        return control;
    }
    
    public int getEleccion(){
        int opcion = ComBoxPartida.getSelectedIndex();
        return opcion;
    }

    public JButton getBtnJugar() {
        return btnJugar;
    }    

    public JTextField getTxtPuerto() {
        return txtPuerto;
    }

    public JTextField getTxtHost() {
        return txtHost;
    }
    
    public JTextField getTxtAlias() {
        return txtAlias;
    }    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bienvenido;
    private javax.swing.JLabel Imagen;
    private javax.swing.JButton btnJugar;
    private javax.swing.JLabel lblAlias;
    private javax.swing.JLabel lblHost;
    private javax.swing.JLabel lblPuerto;
    private javax.swing.JTextField txtAlias;
    private javax.swing.JTextField txtHost;
    private javax.swing.JTextField txtPuerto;
    // End of variables declaration//GEN-END:variables
}
