/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import SQL.Sentencias;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author msi gs63
 */
public class FramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FramePrincipal2
     */
    private int id_sesion;
    public FramePrincipal( int id_sesion) {
        initComponents();
        this.id_sesion= id_sesion;
        //setIconImage(new ImageIcon(getClass().getResource("../imagenes/pet_ico.png")).getImage());
        
    }
    //Para poder cambiar el icono de la aplicación
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/pet_ico.png"));


        return retValue;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnVenta = new javax.swing.JButton();
        jbtnClientes = new javax.swing.JButton();
        jbtnMascotas = new javax.swing.JButton();
        jbtnUsuarios = new javax.swing.JButton();
        jbtnProducto = new javax.swing.JButton();
        jbtnAgenda = new javax.swing.JButton();
        jbtnAgenda1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblNumeroSesion = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblventas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconImage(getIconImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jbtnVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Venta_icon.png"))); // NOI18N
        jbtnVenta.setText(" ");
        jbtnVenta.setMaximumSize(new java.awt.Dimension(85, 60));
        jbtnVenta.setPreferredSize(new java.awt.Dimension(85, 60));
        jbtnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVentaActionPerformed(evt);
            }
        });

        jbtnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cliente_icon.png"))); // NOI18N
        jbtnClientes.setText(" ");
        jbtnClientes.setMaximumSize(new java.awt.Dimension(85, 60));
        jbtnClientes.setPreferredSize(new java.awt.Dimension(85, 60));
        jbtnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnClientesActionPerformed(evt);
            }
        });

        jbtnMascotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/huella_icon.png"))); // NOI18N
        jbtnMascotas.setText(" ");
        jbtnMascotas.setMaximumSize(new java.awt.Dimension(85, 60));
        jbtnMascotas.setPreferredSize(new java.awt.Dimension(85, 60));
        jbtnMascotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMascotasActionPerformed(evt);
            }
        });

        jbtnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Usuarios_icon.png"))); // NOI18N
        jbtnUsuarios.setText(" ");
        jbtnUsuarios.setMaximumSize(new java.awt.Dimension(85, 60));
        jbtnUsuarios.setPreferredSize(new java.awt.Dimension(85, 60));
        jbtnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUsuariosActionPerformed(evt);
            }
        });

        jbtnProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/orden_icon.png"))); // NOI18N
        jbtnProducto.setText(" ");
        jbtnProducto.setMaximumSize(new java.awt.Dimension(85, 60));
        jbtnProducto.setPreferredSize(new java.awt.Dimension(85, 60));
        jbtnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnProductoActionPerformed(evt);
            }
        });

        jbtnAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Agenda.png"))); // NOI18N
        jbtnAgenda.setText(" ");
        jbtnAgenda.setMaximumSize(new java.awt.Dimension(85, 60));
        jbtnAgenda.setPreferredSize(new java.awt.Dimension(85, 60));
        jbtnAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgendaActionPerformed(evt);
            }
        });

        jbtnAgenda1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar-sesion.png"))); // NOI18N
        jbtnAgenda1.setText(" ");
        jbtnAgenda1.setMaximumSize(new java.awt.Dimension(85, 60));
        jbtnAgenda1.setPreferredSize(new java.awt.Dimension(85, 60));
        jbtnAgenda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgenda1ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Historial_Venta.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_panel.png"))); // NOI18N

        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuario.setText("Usuario");

        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("Nombre usuario");

        lblNumeroSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumeroSesion.setText("Número de sesión:");

        jLabel5.setText("Ventas realizadas en esta sesión");

        lblventas.setText("##");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNumeroSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblventas)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNumeroSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblventas))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtnMascotas, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnAgenda1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtnVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnMascotas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbtnAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(jbtnUsuarios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnAgenda1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVentaActionPerformed
        DialogVentas dialogVentas = new DialogVentas( this, false);
        dialogVentas.setVisible( true );
    }//GEN-LAST:event_jbtnVentaActionPerformed

    private void jbtnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnProductoActionPerformed
        DialogProducto dialogProducto = new DialogProducto( this, false );
        dialogProducto.setVisible( true );
    }//GEN-LAST:event_jbtnProductoActionPerformed

    private void jbtnAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgendaActionPerformed
        DialogAgenda dialogAgenda = new DialogAgenda( this, false );
        dialogAgenda.setVisible( true );
        
    }//GEN-LAST:event_jbtnAgendaActionPerformed

    private void jbtnAgenda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgenda1ActionPerformed
        // TODO add your handling code here:
        DialogSalir dgSalir= new DialogSalir(this,true);
        dgSalir.setVisible(true);
    }//GEN-LAST:event_jbtnAgenda1ActionPerformed

    private void jbtnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnClientesActionPerformed
        DialogClientes dialogClientes = new DialogClientes( this, false );
        dialogClientes.setVisible( true );
    }//GEN-LAST:event_jbtnClientesActionPerformed

    private void jbtnMascotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMascotasActionPerformed
        DialogMascotas dialogMascotas = new DialogMascotas( this, false);
        dialogMascotas.setVisible( true );
    }//GEN-LAST:event_jbtnMascotasActionPerformed

    private void jbtnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUsuariosActionPerformed
        DialogUsuarios dialogUsuarios = new DialogUsuarios( this, true );
        dialogUsuarios.setVisible( true );
    }//GEN-LAST:event_jbtnUsuariosActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowClosed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DialogHistorialVentas dhv= new DialogHistorialVentas(this, false);
        dhv.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public int getIdSesion(){
    return id_sesion;
    }
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnAgenda;
    private javax.swing.JButton jbtnAgenda1;
    private javax.swing.JButton jbtnClientes;
    private javax.swing.JButton jbtnMascotas;
    private javax.swing.JButton jbtnProducto;
    private javax.swing.JButton jbtnUsuarios;
    private javax.swing.JButton jbtnVenta;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumeroSesion;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblventas;
    // End of variables declaration//GEN-END:variables
}
