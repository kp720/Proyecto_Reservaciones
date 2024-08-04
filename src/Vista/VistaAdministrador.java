/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.InterfazBase;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kp728
 */
public class VistaAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form VistaAfdministrador
     */
    public VistaAdministrador() {
        initComponents();
        
        tblAviones.setModel(InterfazBase.extraerAvionesCompleto());
        tblUsuarios.setModel(InterfazBase.extraerUsuarios());
        tblVuelos.setModel(InterfazBase.extraerViajes());
        pnlVuelos.setVisible(true);
        pnlAviones.setVisible(false);
        pnlUsuarios.setVisible(false);
        pnl1.setOpacity(0.5f);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlVuelos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVuelos = new javax.swing.JTable();
        lblAgregarVuelo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblEliminarVuelo = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        pnlUsuarios = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        lblAgregarUsuario = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblEliminarUsuario = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        pnlAviones = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAviones = new javax.swing.JTable();
        lblAgregarAvion = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblEliminarAvion = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        pnl1 = new elementos.panelOpaco();
        lblVuelos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblAviones = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblUsuarios = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblSalir = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlVuelos.setPreferredSize(new java.awt.Dimension(900, 550));
        pnlVuelos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N

        tblVuelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblVuelos);

        pnlVuelos.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 50, 650, 450));

        lblAgregarVuelo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAgregarVuelo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarVueloMouseClicked(evt);
            }
        });
        pnlVuelos.add(lblAgregarVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, 80, 90));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/schedule_6594834.png"))); // NOI18N
        pnlVuelos.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 80, 70, 70));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Agregar");
        pnlVuelos.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, 90, -1));

        lblEliminarVuelo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEliminarVuelo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEliminarVueloMouseClicked(evt);
            }
        });
        pnlVuelos.add(lblEliminarVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 310, 90, 90));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recycle-bin_8835400.png"))); // NOI18N
        pnlVuelos.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 310, 60, 70));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Eliminar");
        pnlVuelos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, 90, -1));

        getContentPane().add(pnlVuelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 900, 550));

        pnlUsuarios.setPreferredSize(new java.awt.Dimension(900, 550));
        pnlUsuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblUsuarios);

        pnlUsuarios.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 50, 650, 450));

        lblAgregarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAgregarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarUsuarioMouseClicked(evt);
            }
        });
        pnlUsuarios.add(lblAgregarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 80, 90, 90));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/schedule_6594834.png"))); // NOI18N
        pnlUsuarios.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 80, 70, 70));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Agregar");
        pnlUsuarios.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, 90, -1));

        lblEliminarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEliminarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEliminarUsuarioMouseClicked(evt);
            }
        });
        pnlUsuarios.add(lblEliminarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 310, 90, 90));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recycle-bin_8835400.png"))); // NOI18N
        pnlUsuarios.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 310, 60, 70));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Eliminar");
        pnlUsuarios.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, 90, -1));

        getContentPane().add(pnlUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 900, 550));

        pnlAviones.setPreferredSize(new java.awt.Dimension(900, 550));
        pnlAviones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N

        tblAviones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblAviones);

        pnlAviones.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 50, 650, 450));

        lblAgregarAvion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAgregarAvion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarAvionMouseClicked(evt);
            }
        });
        pnlAviones.add(lblAgregarAvion, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 80, 90, 90));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/schedule_6594834.png"))); // NOI18N
        pnlAviones.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 80, 70, 70));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Agregar");
        pnlAviones.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, 90, -1));

        lblEliminarAvion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEliminarAvion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEliminarAvionMouseClicked(evt);
            }
        });
        pnlAviones.add(lblEliminarAvion, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 310, 90, 90));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recycle-bin_8835400.png"))); // NOI18N
        pnlAviones.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 310, 60, 70));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Eliminar");
        pnlAviones.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, 90, -1));

        getContentPane().add(pnlAviones, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 900, 550));

        pnl1.setBackground(new java.awt.Color(0, 0, 0));
        pnl1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblVuelos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVuelos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVuelosMouseClicked(evt);
            }
        });
        pnl1.add(lblVuelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 90, 90));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/task-list_4173325.png"))); // NOI18N
        pnl1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 70));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Adm. Vuelos");
        pnl1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 90, -1));

        lblAviones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAviones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAvionesMouseClicked(evt);
            }
        });
        pnl1.add(lblAviones, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 90, 90));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/airplane_1023319.png"))); // NOI18N
        pnl1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, 70));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Adm. Aviones");
        pnl1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 90, -1));

        lblUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUsuariosMouseClicked(evt);
            }
        });
        pnl1.add(lblUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 90, 90));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/booking_2460877.png"))); // NOI18N
        pnl1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, 70));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Adm. Usuarios");
        pnl1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 90, -1));

        lblSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalirMouseClicked(evt);
            }
        });
        pnl1.add(lblSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 90, 90));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eviction_1464167.png"))); // NOI18N
        pnl1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, -1, 70));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Salir");
        pnl1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 90, -1));

        getContentPane().add(pnl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 140, 720));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/img4.gif"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseClicked
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_lblSalirMouseClicked

    private void lblAvionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAvionesMouseClicked
        pnlVuelos.setVisible(false);
        pnlAviones.setVisible(true);
        pnlUsuarios.setVisible(false);
    }//GEN-LAST:event_lblAvionesMouseClicked

    private void lblVuelosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVuelosMouseClicked
        pnlVuelos.setVisible(true);
        pnlAviones.setVisible(false);
        pnlUsuarios.setVisible(false);
    }//GEN-LAST:event_lblVuelosMouseClicked

    private void lblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUsuariosMouseClicked
        pnlVuelos.setVisible(false);
        pnlAviones.setVisible(false);
        pnlUsuarios.setVisible(true);
    }//GEN-LAST:event_lblUsuariosMouseClicked

    private void lblAgregarVueloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarVueloMouseClicked
        new AgregarVuelo().setVisible(true);
    }//GEN-LAST:event_lblAgregarVueloMouseClicked

    private void lblEliminarVueloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarVueloMouseClicked
        DefaultTableModel modelo = InterfazBase.extraerViajes();
        InterfazBase.eliminarVuelo(tblVuelos.getSelectedRow(), modelo);
        tblVuelos.setModel(InterfazBase.extraerViajes());
    }//GEN-LAST:event_lblEliminarVueloMouseClicked

    private void lblAgregarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarUsuarioMouseClicked
        new AgregarUsuario().setVisible(true);
    }//GEN-LAST:event_lblAgregarUsuarioMouseClicked

    private void lblEliminarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarUsuarioMouseClicked
        DefaultTableModel modelo = InterfazBase.extraerUsuarios();
        InterfazBase.eliminarUsuario(tblUsuarios.getSelectedRow(), modelo);
        tblUsuarios.setModel(InterfazBase.extraerUsuarios());
    }//GEN-LAST:event_lblEliminarUsuarioMouseClicked

    private void lblAgregarAvionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarAvionMouseClicked
        new AgregarAvion().setVisible(true);
    }//GEN-LAST:event_lblAgregarAvionMouseClicked

    private void lblEliminarAvionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarAvionMouseClicked
        DefaultTableModel modelo = InterfazBase.extraerAvionesCompleto();
        InterfazBase.eliminarAvion(tblAviones.getSelectedRow(), modelo);
        tblAviones.setModel(InterfazBase.extraerAvionesCompleto());
    }//GEN-LAST:event_lblEliminarAvionMouseClicked

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
            java.util.logging.Logger.getLogger(VistaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAgregarAvion;
    private javax.swing.JLabel lblAgregarUsuario;
    private javax.swing.JLabel lblAgregarVuelo;
    private javax.swing.JLabel lblAviones;
    private javax.swing.JLabel lblEliminarAvion;
    private javax.swing.JLabel lblEliminarUsuario;
    private javax.swing.JLabel lblEliminarVuelo;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JLabel lblUsuarios;
    private javax.swing.JLabel lblVuelos;
    private elementos.panelOpaco pnl1;
    private javax.swing.JPanel pnlAviones;
    public static javax.swing.JPanel pnlUsuarios;
    private javax.swing.JPanel pnlVuelos;
    public static javax.swing.JTable tblAviones;
    public static javax.swing.JTable tblUsuarios;
    public static javax.swing.JTable tblVuelos;
    // End of variables declaration//GEN-END:variables
}
