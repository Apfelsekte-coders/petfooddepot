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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author msi gs63
 */
public class DialogMascotas extends javax.swing.JDialog {

    /**
     * Creates new form DialogMascotas
     */
    public static final String MOSTRAR_MASCOTAS ="SELECT M.mascota_id, M.mascota_nombre, M.mascota_raza, "
                                                                             + "M.mascota_peso,M.mascota_edad, C.cliente_nombre, M.sesion_id\n" +
                                                                                 "from mascotas as M\n" +
                                                                                 "join clientes as C\n" +
                                                                                 "on M.cliente_id = C.cliente_id ";
    String filtro="";
    String orden=" order by mascota_nombre";
    private DefaultTableModel dtmMascotas;
    DialogCargando dc;
    FramePrincipal frmprincipal;
    String [] datos;
    public DialogMascotas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
          frmprincipal= (FramePrincipal) parent;
          datos= new String[6];
        txtFiltro.setVisible(false);
        btnFiltro.setVisible(false);
        btnFiltro.setVisible(false);
         
    }
    public String[] getDatos(){
    return datos;
    }

     public void desplegarRegistros() {
        Object[] fila = new Object[7];
        ResultSet rs=null;
        dtmMascotas = new DefaultTableModel();
            dtmMascotas.setColumnIdentifiers(new Object[]{"ID","Nombre","Raza","Peso","Edad","Dueño","Sesión"});
        try {
            ConnectionDB.getInstance().connectDB();
             rs=Sentencias.desplegar(MOSTRAR_MASCOTAS+filtro+orden);
            while (rs.next()) {
                
                fila[0] = rs.getInt("mascota_id");
                fila[1] = rs.getString("mascota_nombre");
                fila[2] = rs.getString("mascota_raza");
                fila[3] = rs.getInt("mascota_peso");
                fila[4] = rs.getString("mascota_edad");
                fila[5] = rs.getString("cliente_nombre");
                fila[6] = rs.getInt("sesion_id");
                dtmMascotas.addRow(fila);  
            }
            rs.close();
            jtblMascotas.setModel(dtmMascotas);
        } catch (SQLException ex) {
            System.out.println("Nel " + ex);
        }
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnEditar = new javax.swing.JButton();
        jbtnEditar1 = new javax.swing.JButton();
        jbtnEditar2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblMascotas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        btnFiltro = new javax.swing.JButton();
        cboFiltro = new javax.swing.JComboBox<String>();
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

        jbtnEditar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nueva_mascota.png"))); // NOI18N
        jbtnEditar2.setText(" ");
        jbtnEditar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditar2ActionPerformed(evt);
            }
        });

        jtblMascotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Raza", "Peso", "Edad", "Dueño", "Sesión"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtblMascotas);

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel4.setText("Mascotas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(403, 403, 403)
                .addComponent(jLabel4)
                .addContainerGap(372, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Filtrar por:");

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

        cboFiltro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Seleccione un filtro --", "Nombre", "Raza", "Peso mayor a...", "Peso menor a...", "Edad mayor a...", "Edad menor a...", "Dueño" }));
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
                        .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(txtFiltro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Ordenar por:");

        cboOrden.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboOrden.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Raza", "Mayor Peso", "Menor Peso", "Mayor Edad", "Menor Edad", "Dueño" }));
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRecarga)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnEditar2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnEditar1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                    .addComponent(btnRecarga)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnEditar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditar2ActionPerformed
        // TODO add your handling code here:
        DialogAgregarMascota dam= new DialogAgregarMascota(frmprincipal, this, 1,true);
        dam.setVisible(true);
    }//GEN-LAST:event_jbtnEditar2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        dc= new DialogCargando(this, true,"mascotas");
        dc.setVisible(true);  
        
    }//GEN-LAST:event_formWindowOpened

    private void jbtnEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditar1ActionPerformed
        // TODO add your handling code here:
         int index = jtblMascotas.getSelectedRow();

        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una mascota  a eliminar", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int input = JOptionPane.showConfirmDialog(null,
                "¿Está seguro de que quiere eliminar esta mascota?",
                "Eliminar Mascota",JOptionPane.YES_NO_OPTION);
            if(input==0){
               int id= Integer.parseInt(jtblMascotas.getValueAt(index, 0)+"");
            try {
                 Sentencias.actualizarSesion(frmprincipal.getIdSesion(), Sentencias.getFechaHora());
                Sentencias.eliminarMascota(id);
                dtmMascotas.removeRow(index);
                jtblMascotas.setModel(dtmMascotas);
            } catch (Exception ex) {
                    System.out.println("No eliminó producto");
            }
          }
        }
    }//GEN-LAST:event_jbtnEditar1ActionPerformed

    private void txtFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroActionPerformed

    private void btnFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroActionPerformed
        // TODO add your handling code here:
       switch(cboFiltro.getSelectedIndex()){
            case 0: filtro=""; break;
            case 1: filtro="and mascota_nombre like '%"+txtFiltro.getText().trim()+"%'";
            break;
            case 2: filtro="and mascota_raza like '%"+txtFiltro.getText().trim()+"%'";
            break;
            case 3: filtro="and mascota_peso >= "+txtFiltro.getText().trim();
            break;
            case 4: filtro="and mascota_peso <= "+txtFiltro.getText().trim();
            break;
            case 5: filtro="and mascota_edad like >= "+txtFiltro.getText().trim();
            break;
            case 6: filtro="and mascota_peso <= "+txtFiltro.getText().trim();
            break;
            case 7: filtro="and C.cliente_nombre '%"+txtFiltro.getText().trim()+"%'";
            break;
        }
        dc= new DialogCargando(this, true, "mascotas");
        dc.setVisible(true);
    }//GEN-LAST:event_btnFiltroActionPerformed

    private void cboFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboFiltroItemStateChanged
        // TODO add your handling code here:
        int index=cboFiltro.getSelectedIndex();
        if(index==4){
            txtFiltro.setVisible(false);
          
            btnFiltro.setVisible(true);
          
        }else if(index !=0){
            txtFiltro.setVisible(true);
          
            btnFiltro.setVisible(false);
            btnFiltro.setVisible(true);
        }else{
            
            txtFiltro.setVisible(false);
            btnFiltro.setVisible(false);
            
        }
    }//GEN-LAST:event_cboFiltroItemStateChanged

    private void cboOrdenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboOrdenItemStateChanged
        // TODO add your handling code here:
        switch(cboOrden.getSelectedIndex()){
            case 0: orden=" order by mascota_nombre"; break;
            case 1: orden=" order by mascota_raza"; break;
            case 2: orden=" order by mascota_peso desc "; break;
            case 3: orden=" order by mascota_peso"; break;
            case 4: orden=" order by mascota_edad desc"; break;
            case 5: orden=" order by mascota_edad"; break;
            case 6: orden=" order by C.cliente_nombre"; break;
        }
    }//GEN-LAST:event_cboOrdenItemStateChanged

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        // TODO add your handling code here:
        dc = new DialogCargando(this, true, "mascotas");
        dc.setVisible(true);
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void btnRecargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargaActionPerformed
        // TODO add your handling code here:
        cboFiltro.setSelectedIndex(0);
        filtro="";
        cboOrden.setSelectedIndex(0);
        orden=" order by mascota_nombre";
        btnFiltro.setVisible(false);
        txtFiltro.setVisible(false);
        dc= new DialogCargando(this, true,"mascotas");
        dc.setVisible(true);
    }//GEN-LAST:event_btnRecargaActionPerformed

    private void jbtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditarActionPerformed
        // TODO add your handling code here:
        int index = jtblMascotas.getSelectedRow();

        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una mascota para editar", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            datos[0]= jtblMascotas.getValueAt(index, 0)+"";
            datos[1]= jtblMascotas.getValueAt(index, 1)+"";
            datos[2]= jtblMascotas.getValueAt(index, 2)+"";
            datos[3]= jtblMascotas.getValueAt(index, 3)+"";
            datos[4]= jtblMascotas.getValueAt(index, 4)+"";
            datos[5]= jtblMascotas.getValueAt(index, 5)+"";
           DialogAgregarMascota dam= new DialogAgregarMascota(frmprincipal,this,2 ,true);
           dam.setVisible(true);
        }
    }//GEN-LAST:event_jbtnEditarActionPerformed

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
            java.util.logging.Logger.getLogger(DialogMascotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogMascotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogMascotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogMascotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogMascotas dialog = new DialogMascotas(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable jtblMascotas;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
