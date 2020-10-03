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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author msi gs63
 */
public class DialogAgenda extends javax.swing.JDialog {

    /**
     * Creates new form DialogAgenda
     */
     public static final String MOSTRAR_AGENDA="Select A.agenda_id,A.venta_id,C.cliente_nombre,A.fecha_compra,"+
                                                                            "A.fecha_contacto,A.sesion_id \n" +
                                                                            "from agenda as A\n" +
                                                                            "join clientes as C\n" +
                                                                            "on A.cliente_id= C.cliente_id ";
    private DefaultTableModel dtmAgenda;
    FramePrincipal frmprincipal;
    DialogCargando dc;
    String filtro="";
    String[] datos;
    String orden=" order by A.fecha_contacto";
    public DialogAgenda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        frmprincipal= (FramePrincipal) parent;
        datos= new String[3];
        
    }
    
        public String[] getDatos(){
        return datos;
        }
        public void desplegarRegistros() {
        
        Object[] fila = new Object[7];
        ResultSet rs=null;
        dtmAgenda = new DefaultTableModel();
            dtmAgenda.setColumnIdentifiers(new Object[]{"ID", "Número venta", "Cliente", "Fecha compra","Fecha contacto","Días restantes","Sesión"});
            String fechaActual= Sentencias.getFecha();
            String fechaContacto;
                Date dContacto;
                Date dActual;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
      
        try {
            ConnectionDB.getInstance().connectDB();
             rs=Sentencias.desplegar(MOSTRAR_AGENDA+filtro+orden);
            while (rs.next()) {
                
                fila[0] =rs.getInt("agenda_id");
                int venta=rs.getInt("venta_id");
                if(venta==0)
                fila[1] ="";
                else
                    fila[1] =venta;
                fila[2] = rs.getString("cliente_nombre");
                fila[3] = rs.getString("fecha_compra");
                fechaContacto=rs.getString("fecha_contacto");
                dContacto= sdf.parse(fechaContacto);
                dActual=sdf.parse(fechaActual);
               long diasRestantes= dContacto.getTime()-dActual.getTime();
                fila[4] = fechaContacto;
                fila[5] = diasRestantes/1000/60/60/24;
                fila[6] = rs.getInt("sesion_id");
                dtmAgenda.addRow(fila);  
            }
            rs.close();
            jtblAgenda.setModel(dtmAgenda);
        } catch (SQLException ex) {
            System.out.println("Nel " + ex);
            
        } catch (ParseException ex) {
             Logger.getLogger(DialogAgenda.class.getName()).log(Level.SEVERE, null, ex);
         }
            
    
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jbtnEditar = new javax.swing.JButton();
        jbtnEditar1 = new javax.swing.JButton();
        jbtnEditar2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblAgenda = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnFiltro = new javax.swing.JButton();
        cboFiltro = new javax.swing.JComboBox<String>();
        choFecha = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cboOrden = new javax.swing.JComboBox<String>();
        btnOrdenar = new javax.swing.JButton();
        btnRecarga = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel4.setText("Agenda");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(403, 403, 403)
                .addComponent(jLabel4)
                .addContainerGap(494, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Editar.png"))); // NOI18N
        jbtnEditar.setText(" ");
        jbtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditarActionPerformed(evt);
            }
        });

        jbtnEditar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eliminar.png"))); // NOI18N
        jbtnEditar1.setText(" ");
        jbtnEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditar1ActionPerformed(evt);
            }
        });

        jbtnEditar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calendario.png"))); // NOI18N
        jbtnEditar2.setText(" ");
        jbtnEditar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditar2ActionPerformed(evt);
            }
        });

        jtblAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Número venta", "Cliente", "Fecha Compra", "Fecha contacto", "Días restantes", "Sesión"
            }
        ));
        jScrollPane1.setViewportView(jtblAgenda);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Filtrar por:");

        btnFiltro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/filtrar.png"))); // NOI18N
        btnFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroActionPerformed(evt);
            }
        });

        cboFiltro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Seleccione un filtro --", "Hoy", "Fecha Contacto\t", "Fecha Compra" }));
        cboFiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboFiltroItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(choFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(cboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Ordenar por:");

        cboOrden.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboOrden.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fecha De Contacto", "Fecha De Compra", "Cliente" }));
        cboOrden.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboOrdenItemStateChanged(evt);
            }
        });

        btnOrdenar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lista.png"))); // NOI18N
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(cboOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cboOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(9, Short.MAX_VALUE)))
        );

        btnRecarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar.png"))); // NOI18N
        btnRecarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRecarga)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnEditar2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnEditar1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtnEditar)
                        .addComponent(jbtnEditar1)
                        .addComponent(jbtnEditar2))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRecarga))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        choFecha.setDateFormatString("yyyy/MM/dd");
        choFecha.setVisible(false);
        btnFiltro.setVisible(false);
        Date date= new Date();
        choFecha.setDate(date);
        dc= new DialogCargando(this, true, "agenda");
        dc.setVisible(true);
    }//GEN-LAST:event_formWindowOpened

    private void btnFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroActionPerformed
        // TODO add your handling code here:
        String fecha="";
         DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        fecha+= dateFormat.format(choFecha.getDate());
        switch(cboFiltro.getSelectedIndex()){
            case 0: filtro=""; break;
            case 1:filtro=" where fecha_contacto like '"+fecha+"'";break;
            case 2:filtro=" where fecha_contacto like '"+fecha+"'";break;
            case 3:filtro=" where fecha_compra like '"+fecha+"'";break;
        }
        dc= new DialogCargando(this, true, "agenda");
        dc.setVisible(true);
    }//GEN-LAST:event_btnFiltroActionPerformed

    private void cboFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboFiltroItemStateChanged
        // TODO add your handling code here:
        int index=cboFiltro.getSelectedIndex();
        if(index==1){
            choFecha.setVisible(true);
            btnFiltro.setVisible(true);
           Date date= new Date();
          choFecha.setDate(date);
          choFecha.setEnabled(false);
        }else if(index!=0){
        choFecha.setVisible(true);
        choFecha.setEnabled(true);
        btnFiltro.setVisible(true);
        }else{
        choFecha.setVisible(false);
        btnFiltro.setVisible(false);
        }
    }//GEN-LAST:event_cboFiltroItemStateChanged

    private void cboOrdenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboOrdenItemStateChanged
        // TODO add your handling code here:
        switch(cboOrden.getSelectedIndex()){
            case 0: orden=" order by fecha_contacto desc"; break;
            case 1: orden=" order by fecha_compra desc"; break;
            case 2: orden=" order by C.cliente_nombre "; break;
            
        }
    }//GEN-LAST:event_cboOrdenItemStateChanged

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        // TODO add your handling code here:
        dc = new DialogCargando(this, true, "agenda");
        dc.setVisible(true);
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void jbtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditarActionPerformed
        // TODO add your handling code here:
         int index = jtblAgenda.getSelectedRow();

        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un renglón para editar", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            datos[0]= jtblAgenda.getValueAt(index, 0)+"";
            datos[1]= jtblAgenda.getValueAt(index, 2)+"";
            datos[2]= jtblAgenda.getValueAt(index, 4)+"";
           DialogAgregarAgenda da= new DialogAgregarAgenda(frmprincipal,this, 2, true);
           da.setVisible(true);
        }
    }//GEN-LAST:event_jbtnEditarActionPerformed

    private void jbtnEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditar1ActionPerformed
        // TODO add your handling code here:
         int index = jtblAgenda.getSelectedRow();

        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un renglón para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int input = JOptionPane.showConfirmDialog(null,
                "¿Está seguro de que quiere eliminar esta agenda?",
                "Eliminar Agenda",JOptionPane.YES_NO_OPTION);
            if(input==0){
               int id= Integer.parseInt(jtblAgenda.getValueAt(index, 0)+"");
            try {
                 Sentencias.actualizarSesion(frmprincipal.getIdSesion(), Sentencias.getFechaHora());
                Sentencias.eliminarAgenda(id);
                dtmAgenda.removeRow(index);
                jtblAgenda.setModel(dtmAgenda);
            } catch (Exception ex) {
                    System.out.println("No eliminó producto");
            }
          }
        }
    }//GEN-LAST:event_jbtnEditar1ActionPerformed

    private void jbtnEditar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditar2ActionPerformed
        // TODO add your handling code here:
        DialogAgregarAgenda da= new DialogAgregarAgenda(frmprincipal, this, 1, true);
        da.setVisible(true);  
        
    }//GEN-LAST:event_jbtnEditar2ActionPerformed

    private void btnRecargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargaActionPerformed
        // TODO add your handling code here:
        cboFiltro.setSelectedIndex(0);
        filtro="";
        cboOrden.setSelectedIndex(0);
        orden=" order by A.fecha_contacto";
        btnFiltro.setVisible(false);
        choFecha.setVisible(false);
        dc= new DialogCargando(this, true, "agenda");
        dc.setVisible(true);
    }//GEN-LAST:event_btnRecargaActionPerformed

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
            java.util.logging.Logger.getLogger(DialogAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogAgenda dialog = new DialogAgenda(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JButton btnRecarga;
    private javax.swing.JComboBox<String> cboFiltro;
    private javax.swing.JComboBox<String> cboOrden;
    private com.toedter.calendar.JDateChooser choFecha;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnEditar;
    private javax.swing.JButton jbtnEditar1;
    private javax.swing.JButton jbtnEditar2;
    private javax.swing.JTable jtblAgenda;
    // End of variables declaration//GEN-END:variables
}
