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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author msi gs63
 */
public class DialogProducto extends javax.swing.JDialog {

    /**
     * Creates new form DialogProducto
     */
    public static final String MOSTRAR_PRODUCTOS ="SELECT * FROM productos where producto_estado='1' ";
    private DefaultTableModel dtmProductos;
    String filtro="";
    String orden=" order by producto_nombre";
    DialogCargando dc;
    FramePrincipal frmprincipal;
    String [] datos;
    public DialogProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        frmprincipal= (FramePrincipal) parent;
       datos= new String[4];
       txtFiltro.setVisible(false);
        btnFiltro.setVisible(false);
        btnFiltro2.setVisible(false);
        choFecha.setVisible(false);
        choFecha.setDateFormatString("yyyy/MM/dd");
    }
      public String[] getDatos(){
    return datos;
}
    
    public void desplegarRegistros() {
        
        Object[] fila = new Object[6];
        ResultSet rs=null;
        dtmProductos = new DefaultTableModel();
            dtmProductos.setColumnIdentifiers(new Object[]{"Nombre", "Precio", "Inventario", "Duración (días)","Fecha","Sesión"});
        try {
            ConnectionDB.getInstance().connectDB();
             rs=Sentencias.desplegar(MOSTRAR_PRODUCTOS+filtro+orden);
            while (rs.next()) {
                
                fila[0] = rs.getString("producto_nombre");
                fila[1] = rs.getFloat("producto_precio");
                fila[2] = rs.getInt("producto_inventario");
                fila[3] = rs.getInt("producto_duracion");
                fila[4] = rs.getString("producto_fecha");
                fila[5] = rs.getInt("sesion_id");
                dtmProductos.addRow(fila);  
            }
            rs.close();
            jtblProductos.setModel(dtmProductos);
        } catch (SQLException ex) {
            System.out.println("Nel");
            
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
        jbtnEliminar = new javax.swing.JButton();
        jbtnEditar2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblProductos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnRecarga = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        choFecha = new com.toedter.calendar.JDateChooser();
        btnFiltro = new javax.swing.JButton();
        txtFiltro = new javax.swing.JTextField();
        btnFiltro2 = new javax.swing.JButton();
        cboFiltro = new javax.swing.JComboBox<String>();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cboOrden = new javax.swing.JComboBox<String>();
        btnOrdenar = new javax.swing.JButton();

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

        jbtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eliminar.png"))); // NOI18N
        jbtnEliminar.setText(" ");
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });

        jbtnEditar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mascotas.png"))); // NOI18N
        jbtnEditar2.setText(" ");
        jbtnEditar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditar2ActionPerformed(evt);
            }
        });

        jtblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio", "Inventario", "Duración (días)", "Fecha", "Sesión "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtblProductos);

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel4.setText("Producto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(403, 403, 403)
                .addComponent(jLabel4)
                .addContainerGap(362, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRecarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar.png"))); // NOI18N
        btnRecarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Filtrar por:");

        btnFiltro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/filtrar.png"))); // NOI18N
        btnFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroActionPerformed(evt);
            }
        });

        txtFiltro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroActionPerformed(evt);
            }
        });

        btnFiltro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/filtrar.png"))); // NOI18N
        btnFiltro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltro2ActionPerformed(evt);
            }
        });

        cboFiltro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Seleccione un filtro --", "Nombre", "Inventario menor a...", "Inventario mayor a...", "Fecha" }));
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
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboFiltro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(choFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFiltro2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2)
                    .addContainerGap(304, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltro2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2)
                    .addContainerGap(93, Short.MAX_VALUE)))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Ordenar por:");

        cboOrden.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboOrden.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Mayor Precio", "Menor Precio", "Mayor Duración", "Menor Duración", "Mayor Inventario", "Menor Inventario" }));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnRecarga)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnEditar2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnEliminar))
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRecarga, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jbtnEditar)
                                .addComponent(jbtnEliminar)
                                .addComponent(jbtnEditar2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnEditar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditar2ActionPerformed
        // TODO add your handling code here:
        DialogAgregarProducto dap= new DialogAgregarProducto(frmprincipal,this,1 ,true);
        dap.setVisible(true);
    }//GEN-LAST:event_jbtnEditar2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
         dc= new DialogCargando(this, true,"productos");
        dc.setVisible(true);  
    }//GEN-LAST:event_formWindowOpened

    private void btnRecargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargaActionPerformed
        // TODO add your handling code here:
        filtro="";
        orden=" order by producto_nombre";
        btnFiltro.setVisible(false);
        btnFiltro2.setVisible(false);
        txtFiltro.setVisible(false);
        cboFiltro.setSelectedIndex(0);
        cboOrden.setSelectedIndex(0);
        dc= new DialogCargando(this, true,"productos");
        dc.setVisible(true);  
    }//GEN-LAST:event_btnRecargaActionPerformed

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
        // TODO add your handling code here:
        int index = jtblProductos.getSelectedRow();

        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto a eliminar", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int input = JOptionPane.showConfirmDialog(null,
                "¿Está seguro de que quiere eliminar esta mascota?", "Eliminar Producto",JOptionPane.YES_NO_OPTION);
            if(input==0){
                String nombre= jtblProductos.getValueAt(index, 0)+"";
            try {
                Sentencias.actualizarSesion(frmprincipal.getIdSesion(), Sentencias.getFechaHora());
                Sentencias.eliminarProducto(nombre);
                dtmProductos.removeRow(index);
                jtblProductos.setModel(dtmProductos);
            } catch (Exception ex) {
                    System.out.println("No eliminó producto");
            }
          }
        }
    }//GEN-LAST:event_jbtnEliminarActionPerformed

    private void jbtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditarActionPerformed
        // TODO add your handling code here:
         int index = jtblProductos.getSelectedRow();

        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto a editar", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            datos[0]= jtblProductos.getValueAt(index, 0)+"";
            datos[1]= jtblProductos.getValueAt(index, 1)+"";
            datos[2]= jtblProductos.getValueAt(index, 2)+"";
            datos[3]= jtblProductos.getValueAt(index, 3)+"";
           DialogAgregarProducto dap= new DialogAgregarProducto(frmprincipal,this,2 ,true);
           dap.setVisible(true);
        }
    }//GEN-LAST:event_jbtnEditarActionPerformed

    private void btnFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroActionPerformed
        // TODO add your handling code here:
        switch(cboFiltro.getSelectedIndex()){
            case 0: filtro="";break;
            case 1: filtro="and producto_nombre like '%"+txtFiltro.getText().trim()+"%'";
            break;
            case 2: filtro="and producto_inventario <= "+txtFiltro.getText().trim();
            break;  
            case 3: filtro="and producto_inventario >= "+txtFiltro.getText().trim();
            break;  
            case 4:
            System.out.println(choFecha.getToolTipText());
            Date date = choFecha.getDate();
            String fecha="";
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            fecha+= dateFormat.format(date);
            filtro="and venta_fecha like '%"+fecha+"%'";
            break;
            
        }
        dc= new DialogCargando(this, true, "productos");
        dc.setVisible(true);
    }//GEN-LAST:event_btnFiltroActionPerformed

    private void txtFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroActionPerformed

    private void btnFiltro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltro2ActionPerformed
        // TODO add your handling code here:
        btnFiltro.doClick();
    }//GEN-LAST:event_btnFiltro2ActionPerformed

    private void cboOrdenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboOrdenItemStateChanged
        // TODO add your handling code here:
        switch(cboOrden.getSelectedIndex()){
            case 0: orden=" order by producto_nombre"; break;
            case 1: orden=" order by producto_precio desc"; break;
            case 2: orden=" order by producto_precio "; break;
            case 3: orden=" order by producto_duracion desc"; break;
            case 4: orden=" order by producto_duracion"; break;
            case 5: orden=" order by producto_inventario desc"; break;
            case 6: orden=" order by producto_inventario "; break;
        }
    }//GEN-LAST:event_cboOrdenItemStateChanged

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        // TODO add your handling code here:
        dc = new DialogCargando(this, true, "productos");
        dc.setVisible(true);
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void cboFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboFiltroItemStateChanged
        // TODO add your handling code here:
         int index=cboFiltro.getSelectedIndex();
        if(index==4){
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
            java.util.logging.Logger.getLogger(DialogProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogProducto dialog = new DialogProducto(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnEditar;
    private javax.swing.JButton jbtnEditar2;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JTable jtblProductos;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
