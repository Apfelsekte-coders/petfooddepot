/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import SQL.ConnectionDB;
import SQL.Sentencias;
import java.awt.Cursor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static principal.DialogAgregarMascota.MOSTRAR_DUEGNOS;

/**
 *
 * @author ACER
 */
public class DialogAgregarAgenda extends javax.swing.JDialog {

    /**
     * Creates new form DialogAgregarAgenda
     */
    FramePrincipal frmprincipal;
    DialogAgenda da;
    DialogCargando dc;
    String [] datos;
    int modo;
    public static final String MOSTRAR_CLIENTES="SELECT cliente_nombre FROM clientes WHERE cliente_estado='1'"
             + "ORDER BY cliente_nombre";
    public DialogAgregarAgenda(java.awt.Frame parent,java.awt.Dialog dialog ,int modo,boolean modal) {
        super(parent, modal);
        initComponents();
        frmprincipal= (FramePrincipal)parent;
        da=(DialogAgenda)dialog;
        choFecha.setDateFormatString("yyyy/MM/dd");
        this.modo=modo;
    }

    public void cargar(){
        try{
     Sentencias.actualizarSesion(frmprincipal.getIdSesion(), Sentencias.getFechaHora());
     String fecha="";
         DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        fecha+= dateFormat.format(choFecha.getDate());
        Sentencias.nuevaAgenda(Sentencias.idDuegno(cboCliente.getSelectedItem()+""), fecha, frmprincipal.getIdSesion());
                da.desplegarRegistros();
        dispose();
       }catch  (Exception e){
           JOptionPane.showMessageDialog(this,"Datos incorrectos: "+e);
       }
    }
    public void actualizar(){
        try{
        Sentencias.actualizarSesion(frmprincipal.getIdSesion(), Sentencias.getFechaHora());
        String fecha="";
         DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        fecha+= dateFormat.format(choFecha.getDate());
        Sentencias.actualizarFechaContacto(Integer.parseInt(datos[0]), fecha);
                da.desplegarRegistros();
       dispose();
       }catch  (Exception e){
           JOptionPane.showMessageDialog(this,"Datos incorrectos: "+e);
       }
    
    }
    
     public void llenarClientes(){
        ResultSet rs;
        try {
            ConnectionDB.getInstance().connectDB();
             rs=Sentencias.desplegar(MOSTRAR_CLIENTES);
            while (rs.next()) {
               cboCliente.addItem(rs.getString("cliente_nombre"));
            }
            rs.close();
           cboCliente.removeItem("Invitado");

        } catch (SQLException ex) {
            System.out.println("Nel");
            
        }
    
    }
  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        choFecha = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cboCliente = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Agendar Contacto");

        jLabel1.setText("Cliente:");

        jLabel2.setText("Fecha de contacto:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        cboCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione el dueño de la mascota" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(58, 58, 58))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(choFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(28, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(choFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        if(modo==2){
            datos=da.getDatos();
            System.out.println(datos[0]);
            System.out.println(datos[1]);
            System.out.println(datos[2]);
        cboCliente.addItem(datos[1]);
        cboCliente.setSelectedIndex(1);
        cboCliente.setEnabled(false);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date contacto;
            try {
                contacto= sdf.parse(datos[2]);
                choFecha.setDate(contacto);
            } catch (ParseException ex) {
                Logger.getLogger(DialogAgregarAgenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        llenarClientes();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if(modo==1){
        dc = new DialogCargando(this, true, "agregarAgenda");
        }else{
        dc = new DialogCargando(this, true, "editarAgenda");
        }
        dc.setVisible(true);
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(DialogAgregarAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogAgregarAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogAgregarAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogAgregarAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogAgregarAgenda dialog = new DialogAgregarAgenda(new javax.swing.JFrame(),new javax.swing.JDialog(),1, true);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cboCliente;
    private com.toedter.calendar.JDateChooser choFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
