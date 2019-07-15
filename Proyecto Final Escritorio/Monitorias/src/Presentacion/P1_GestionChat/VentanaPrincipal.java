package Presentacion.P1_GestionChat;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Canvas;
import javax.swing.JLabel;

public class VentanaPrincipal extends javax.swing.JFrame {

    private final Modelo modelo;
    private ControladorMensaje control;
    
    public VentanaPrincipal(Modelo aThis) {
        modelo = aThis;
        initComponents();
        capturarEventos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txaMensajes = new javax.swing.JTextArea();
        txtMensaje = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        lblConectado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Titulo");
        getContentPane().setLayout(null);

        txaMensajes.setColumns(20);
        txaMensajes.setRows(5);
        jScrollPane1.setViewportView(txaMensajes);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 90, 610, 290);

        txtMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMensajeActionPerformed(evt);
            }
        });
        getContentPane().add(txtMensaje);
        txtMensaje.setBounds(40, 390, 490, 30);

        btnEnviar.setText("Enviar");
        getContentPane().add(btnEnviar);
        btnEnviar.setBounds(540, 390, 100, 30);

        lblConectado.setBackground(new java.awt.Color(51, 204, 0));
        lblConectado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblConectado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConectado.setText("Esperando conectarse");
        lblConectado.setOpaque(true);
        getContentPane().add(lblConectado);
        lblConectado.setBounds(40, 30, 220, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMensajeActionPerformed

    }//GEN-LAST:event_txtMensajeActionPerformed

    private void capturarEventos(){
        //TableroDibujo.addMouseListener(getControl2());//eventos del click en el canvas
        btnEnviar.addActionListener(getControl());
    }

    public Modelo getModelo() {
        return modelo;
    }

    public ControladorMensaje getControl() {
        if(control == null){
            control = new ControladorMensaje(this);
        }
        return control;
    } 
    
    public JButton getBtnEnviar() {
        return btnEnviar;
    }

    public JTextArea getTxaMensajes() {
        return txaMensajes;
    }

    public JTextField getTxtMensaje() {
        return txtMensaje;
    }
    
    public JLabel getLblEnunciado(){
        return lblConectado;
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblConectado;
    private javax.swing.JTextArea txaMensajes;
    private javax.swing.JTextField txtMensaje;
    // End of variables declaration//GEN-END:variables
}