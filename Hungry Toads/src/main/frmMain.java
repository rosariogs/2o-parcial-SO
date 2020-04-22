/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;

/**
 *
 * @author Miguel Matul
 */
public class frmMain extends javax.swing.JFrame {
    
    private boolean hayMosca = false;
    private Naturaleza ecosistema = new Naturaleza();

    /**
     * Creates new form frmMain
     */
    public frmMain() {
        initComponents();
        this.setLocationRelativeTo(null); // para centrar el frame
        ecosistema.start(); // El ecosistema generará una mosca cada 10 segundos
        Sapo sapito;
        for (int i=1; i<=3; i++){ // Se crean 3 hilos de la clase sapo
            sapito = new Sapo();
            sapito.numSapo = i;
            if (i==1){
                sapito.estado = lblEstadoSapo1;
                sapito.contador = lblContador1;
            }
            if (i==2){
                sapito.estado = lblEstadoSapo2;
                sapito.contador = lblContador2;
            }
            if (i==3){
                sapito.estado = lblEstadoSapo3;
                sapito.contador = lblContador3;
            }
            sapito.start(); // Los sapos comenzarán a vigilar la hoja en espera de una mosca
        }
    }
    
    public int disminuir(int semaforo) {
        semaforo--;
        return semaforo;
    }
    
    private class Naturaleza extends Thread{
        @Override
        public void run(){
            while(true){
                // Inicio semáforo
                if (!lblEstadoSapo1.getText().equals("Cobrando")) {
                    lblEstadoSapo1.setForeground(new Color(60, 63, 65));
                }
                if (!lblEstadoSapo2.getText().equals("Cobrando")) {
                    lblEstadoSapo2.setForeground(new Color(60, 63, 65));
                }
                if (!lblEstadoSapo3.getText().equals("Cobrando")) {
                    lblEstadoSapo3.setForeground(new Color(60, 63, 65));
                }
                for(int ecosistema=1; ecosistema<=5; ecosistema++){
           
                try {
                    Thread.sleep(10000); // 10 segundos para generar una mosca
                } catch (InterruptedException ex) {
                    Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                }// cambio de imagen en la hoja
                Image img = new ImageIcon(this.getClass().getResource("/imagenes/HojaMosca.png")).getImage();
                img = img.getScaledInstance(63, 69,  java.awt.Image.SCALE_SMOOTH);
                imgLeaf.setIcon(new ImageIcon(img));
                // fin de cambio en imagen
                hayMosca = true; // notifica a los sapos que ya hay mosca en la hoja
                lblEstadoHoja.setText("Hay mosca");
            }}
        }
    }
    
    private class Sapo extends Thread{
        public int numSapo;
        private boolean tengoMosca = false;
        private int moscasDevoradas = 0;
        public JLabel estado, contador;
        
        @Override
        public void run(){
            while(true){
                while (hayMosca==false) // mientras no haya mosca debe esperar
                    estado.setText("Esperando...");
                    estado.setText("Voy a atrapar la mosca");
                try {
                    Thread.sleep(100); // una decima de segundo para arrojar la lengua
                } catch (InterruptedException ex) {
                    Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                tengoMosca = true; // me sirve para poder comer
                hayMosca = false; // ya no hay mosca en la hoja
                // cambio de imagen en la hoja
                Image img = new ImageIcon(this.getClass().getResource("/imagenes/Hoja.png")).getImage();
                img = img.getScaledInstance(63, 69,  java.awt.Image.SCALE_SMOOTH);
                imgLeaf.setIcon(new ImageIcon(img));
                lblEstadoHoja.setText("No hay mosca");
                if (tengoMosca) // Si tengo una mosca, voy a comer
                    this.comer();
            }
        }
    
        private void comer(){
            this.estado.setText("Comiendo");
            try {
                Thread.sleep(5000); // 5 segundos para comerme una mosca
            } catch (InterruptedException ex) {
                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.tengoMosca = false;
            this.moscasDevoradas++; // aumento mi cuenta de moscas devoradas
            this.contador.setText(String.valueOf(this.moscasDevoradas));
        }
    }
    
    public boolean sapoenespera() {
        // Analiza si las sillas de espera están vacías o llenas
        // Regresa false si están ocupadas, o true si hay alguna vacía
        int contador = 5;
        if (lblEstadoSapo1.isVisible()) {
            contador++;
        }
        if (lblEstadoSapo2.isVisible()) {
            contador++;
        }
        if (lblEstadoSapo3.isVisible()) {
            contador++;
        }

        return !(contador == 4);
    }

     public int dormir(int barbero) {
        switch (barbero) {
            case 1:
                lblSapo1.setVisible(false);
                lblSapo1.setText("Durmiendo");
                break;
            case 2:
                lblSapo2.setVisible(false);
                lblSapo2.setText("Durmiendo");
                break;
            default:
                lblSapo3.setVisible(false);
                lblSapo3.setText("Durmiendo");
                break;
        }
        return 1;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        imgLeaf = new javax.swing.JLabel();
        lblEstadoHoja = new javax.swing.JLabel();
        lblSapo1 = new javax.swing.JLabel();
        lblEstadoSapo1 = new javax.swing.JLabel();
        lblContador1 = new javax.swing.JLabel();
        lblSapo2 = new javax.swing.JLabel();
        lblEstadoSapo2 = new javax.swing.JLabel();
        lblContador2 = new javax.swing.JLabel();
        lblSapo3 = new javax.swing.JLabel();
        lblEstadoSapo3 = new javax.swing.JLabel();
        lblContador3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("2a evaluación parcial - Sistemas Operativos");

        imgLeaf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Hoja.png"))); // NOI18N

        lblEstadoHoja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEstadoHoja.setText("No hay mosca");

        lblSapo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Sapo.jpg"))); // NOI18N

        lblEstadoSapo1.setText("Esperando ...");

        lblContador1.setText("0");

        lblSapo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Sapo.jpg"))); // NOI18N

        lblEstadoSapo2.setText("Esperando ...");

        lblContador2.setText("0");

        lblSapo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Sapo.jpg"))); // NOI18N

        lblEstadoSapo3.setText("Esperando ...");

        lblContador3.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSapo1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(lblEstadoSapo1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(82, 82, 82)
                                        .addComponent(lblContador1)))
                                .addGap(73, 73, 73)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(109, 109, 109)
                                        .addComponent(lblEstadoSapo2)
                                        .addGap(175, 175, 175)
                                        .addComponent(lblEstadoSapo3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(135, 135, 135)
                                        .addComponent(lblContador2)
                                        .addGap(232, 232, 232)
                                        .addComponent(lblContador3))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(235, 235, 235)
                                .addComponent(lblSapo2)
                                .addGap(48, 48, 48)
                                .addComponent(lblSapo3))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstadoHoja)
                            .addComponent(imgLeaf))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addComponent(imgLeaf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEstadoHoja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSapo1)
                    .addComponent(lblSapo2)
                    .addComponent(lblSapo3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstadoSapo1)
                    .addComponent(lblEstadoSapo2)
                    .addComponent(lblEstadoSapo3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContador2)
                    .addComponent(lblContador3)
                    .addComponent(lblContador1))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frmMain().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imgLeaf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblContador1;
    private javax.swing.JLabel lblContador2;
    private javax.swing.JLabel lblContador3;
    private javax.swing.JLabel lblEstadoHoja;
    private javax.swing.JLabel lblEstadoSapo1;
    private javax.swing.JLabel lblEstadoSapo2;
    private javax.swing.JLabel lblEstadoSapo3;
    private javax.swing.JLabel lblSapo1;
    private javax.swing.JLabel lblSapo2;
    private javax.swing.JLabel lblSapo3;
    // End of variables declaration//GEN-END:variables
}
