/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import SQL.ConnectionDB;
import SQL.Sentencias;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class DialogHistorialVentas extends javax.swing.JDialog {

    /**
     * Creates new form DialogHistorialVentas
     */
    String orden=" order by venta_id desc";
    String filtro="";
    public static final String MOSTRAR_HISTORIAL ="Select V.venta_id, C.cliente_nombre, V.venta_fecha, V.venta_descuento, V.venta_total, U.usuario_nombre,V.sesion_id\n" +
"from ventas as V\n" +
"join clientes as C\n" +
"join usuarios as U\n" +
"join sesiones as S\n" +
"on V.cliente_id= C.cliente_id and V.sesion_id=S.sesion_id and S.usuario_login= U.usuario_login ";
    private DefaultTableModel dtmHistorial;
    DialogCargando dc;
    FramePrincipal frmprincipal;
    public DialogHistorialVentas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        frmprincipal= (FramePrincipal) parent;
        txtFiltro.setVisible(false);
        btnFiltro.setVisible(false);
        btnFiltro2.setVisible(false);
        choFecha.setVisible(false);
        choFecha.setDateFormatString("yyyy/MM/dd");
        
    }

    public void desplegarRegistros() {
        
        Object[] fila = new Object[7];
        ResultSet rs=null;
        dtmHistorial = new DefaultTableModel();
            dtmHistorial.setColumnIdentifiers(new Object[]{"Número de venta", "Cliente", "Fecha", "Descuento","Total","Vendedor","Sesión"});
        try {
            ConnectionDB.getInstance().connectDB();
             rs=Sentencias.desplegar(MOSTRAR_HISTORIAL+filtro+orden);
            while (rs.next()) {
                
                fila[0] = rs.getInt("venta_id");
                fila[1] = rs.getString("cliente_nombre");
                fila[2] = rs.getString("venta_fecha");
                fila[3] = rs.getFloat("venta_descuento");
                fila[4] = rs.getFloat("venta_total");
                fila[5] = rs.getString("usuario_nombre");
                fila[6] = rs.getInt("sesion_id");
                dtmHistorial.addRow(fila);  
            }
            rs.close();
            tblHistorial.setModel(dtmHistorial);
        } catch (SQLException ex) {
            System.out.println("Nel " + ex);
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnEditar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistorial = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnOrdenar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cboOrden = new javax.swing.JComboBox<String>();
        jLabel2 = new javax.swing.JLabel();
        cboFiltro = new javax.swing.JComboBox<String>();
        txtFiltro = new javax.swing.JTextField();
        btnFiltro = new javax.swing.JButton();
        btnRecarga = new javax.swing.JButton();
        choFecha = new com.toedter.calendar.JDateChooser();
        btnFiltro2 = new javax.swing.JButton();

        jbtnEditar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eliminar.png"))); // NOI18N
        jbtnEditar1.setText(" ");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número venta", "Cliente", "Fecha", "Descuento", "Total", "Vendedor", "Sesión"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblHistorial);

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Historial de ventas");

        btnOrdenar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lista.png"))); // NOI18N
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Ordenar por:");

        cboOrden.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboOrden.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Número de venta", "Fecha", "Venta total" }));
        cboOrden.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboOrdenItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Filtrar por:");

        cboFiltro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Seleccione un filtro --", "Fecha", "Vendedor", "Cliente" }));
        cboFiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboFiltroItemStateChanged(evt);
            }
        });

        txtFiltro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroActionPerformed(evt);
            }
        });

        btnFiltro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/filtrar.png"))); // NOI18N
        btnFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroActionPerformed(evt);
            }
        });

        btnRecarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar.png"))); // NOI18N
        btnRecarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargaActionPerformed(evt);
            }
        });

        btnFiltro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/filtrar.png"))); // NOI18N
        btnFiltro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltro2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRecarga))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(choFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFiltro2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(btnRecarga))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(btnOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cboOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltro2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
       dc = new DialogCargando(this, true, "historial");
        dc.setVisible(true);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
         String infecha=Sentencias.getFecha();
         Date fecha;
        try {
            fecha = sdf.parse(infecha);
            choFecha.setDate(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        // TODO add your handling code here:
        dc = new DialogCargando(this, true, "historial");
        dc.setVisible(true);
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void cboOrdenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboOrdenItemStateChanged
        // TODO add your handling code here:
        switch(cboOrden.getSelectedIndex()){
            case 0: orden=" order by venta_id desc"; break;
            case 1: orden=" order by venta_fecha desc"; break;
            case 2: orden=" order by venta_total desc"; break;
        }
    }//GEN-LAST:event_cboOrdenItemStateChanged

    private void cboFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboFiltroItemStateChanged
        // TODO add your handling code here:
        int index=cboFiltro.getSelectedIndex();
        if(index==1){
            txtFiltro.setVisible(false);
            choFecha.setVisible(true);
            btnFiltro.setVisible(true);
            btnFiltro2.setVisible(false);
        }else if(index !=0){
            txtFiltro.setVisible(true);
            choFecha.setVisible(false);
            btnFiltro.setVisible(false);
            btnFiltro2.setVisible(true);
             }else{
            choFecha.setVisible(false);
            txtFiltro.setVisible(false);
            btnFiltro.setVisible(false);
            btnFiltro2.setVisible(false);
        }
    }//GEN-LAST:event_cboFiltroItemStateChanged

    private void txtFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroActionPerformed

    private void btnFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroActionPerformed
        // TODO add your handling code here:
        switch(cboFiltro.getSelectedIndex()){
            case 0: filtro=""; break;
            case 1: 
                System.out.println(choFecha.getToolTipText());
                Date date = choFecha.getDate();
                String fecha="";
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                fecha+= dateFormat.format(date);
                filtro="and venta_fecha like '%"+fecha+"%'";
            break;
            case 2: filtro="and usuario_nombre like '%"+txtFiltro.getText().trim()+"%'";
            break;
            case 3: filtro="and cliente_nombre like '%"+txtFiltro.getText().trim()+"%'";
            break;
        }
        dc= new DialogCargando(this, true, "historial");
        dc.setVisible(true);
    }//GEN-LAST:event_btnFiltroActionPerformed

    private void btnRecargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargaActionPerformed
        // TODO add your handling code here:
        txtFiltro.setText("");
        txtFiltro.setVisible(false);
        btnFiltro.setVisible(false);
        btnFiltro2.setVisible(false);
        choFecha.setVisible(false);
        cboFiltro.setSelectedIndex(0);
        cboOrden.setSelectedIndex(0);
        filtro="";
        orden=" order by venta_id desc";
        dc = new DialogCargando(this, true, "historial");
        dc.setVisible(true);
    }//GEN-LAST:event_btnRecargaActionPerformed

    private void btnFiltro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltro2ActionPerformed
        // TODO add your handling code here:
        btnFiltro.doClick();
    }//GEN-LAST:event_btnFiltro2ActionPerformed

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
            java.util.logging.Logger.getLogger(DialogHistorialVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogHistorialVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogHistorialVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogHistorialVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogHistorialVentas dialog = new DialogHistorialVentas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltro;
    private javax.swing.JButton btnFiltro2;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JButton btnRecarga;
    private javax.swing.JComboBox<String> cboFiltro;
    private javax.swing.JComboBox<String> cboOrden;
    private com.toedter.calendar.JDateChooser choFecha;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnEditar1;
    private javax.swing.JTable tblHistorial;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
