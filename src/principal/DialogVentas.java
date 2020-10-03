/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import SQL.ConnectionDB;
import SQL.Sentencias;
import java.awt.Color;
import java.awt.Cursor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import  org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author msi gs63
 */
public class DialogVentas extends javax.swing.JDialog {

    /**
     * Creates new form DialogVentas
     */
    FramePrincipal frmprincipal;
    DialogCargando dc;
    ArrayList<Float> precios;
    ArrayList<Integer> inventario;
    ArrayList<Integer> ids;
    ArrayList<Integer> puntos;
    DefaultTableModel dtmProductos;
    float descuento=0;
    float totalAPagar=0;
     public static final String MOSTRAR_PRODUCTOS="Select producto_nombre, producto_precio, producto_inventario  "
                                                                          + "from productos where producto_estado='1' ORDER BY producto_nombre";
     public static final String MOSTRAR_CLIENTES="SELECT cliente_id, cliente_nombre,cliente_puntos FROM clientes where cliente_estado='1'";
    public DialogVentas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        frmprincipal=(FramePrincipal) parent;
        AutoCompleteDecorator.decorate(cboProductos);
        AutoCompleteDecorator.decorate(cboClientes);
        inicializar();
       
    }
    
     public void llenarProductos(){
        ResultSet rs=null;
        try {
            ConnectionDB.getInstance().connectDB();
             rs=Sentencias.desplegar(MOSTRAR_PRODUCTOS);
            while (rs.next()) {
               cboProductos.addItem(rs.getString("producto_nombre"));
               precios.add(rs.getFloat("producto_precio"));
               inventario.add(rs.getInt("producto_inventario"));
                
            }
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Nel : "+ex);
            
        }
    
    }
      public void llenarClientes(){
        ResultSet rs=null;
        try {
            ConnectionDB.getInstance().connectDB();
           
             rs=Sentencias.desplegar(MOSTRAR_CLIENTES);
            while (rs.next()) {
               ids.add(rs.getInt("cliente_id"));
               cboClientes.addItem(rs.getString("cliente_nombre"));
               puntos.add(rs.getInt("cliente_puntos"));
                
            }
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Nel : "+ex);
            
        }
    
    }
      public void calcularContacto(){
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
         String infecha=Sentencias.getFecha();
         Date fecha=null;
        try {
            fecha = sdf.parse(infecha);
        } catch (ParseException ex) {
            Logger.getLogger(pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
         int dias=30;
         Calendar calendar = Calendar.getInstance();
      calendar.setTime(fecha); // Configuramos la fecha que se recibe
      calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
        try {
            dchoFecha.setDate(sdf.parse(sdf.format(calendar.getTime())));
        } catch (ParseException ex) {
            Logger.getLogger(DialogVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      public void calcularTotal(){
          float total=0;
      for(int i=0;i<dtmProductos.getRowCount();i++){
                total+=Float.parseFloat(dtmProductos.getValueAt(i, 4)+"");
                }
                total-=descuento;
                totalAPagar= total;
                lblTotal.setText("$ "+total);
      }
      public void inicializar(){
       precios= new ArrayList<>();
        inventario= new ArrayList<>();
        ids=new ArrayList<>();
        puntos=new ArrayList<>();
        dtmProductos = new DefaultTableModel();
         dtmProductos.setColumnIdentifiers(new Object[]{"Nombre", "Precio", "Cantidad", "Descuento","Subtotal"});
         dchoFecha.setDateFormatString("yyyy/MM/dd");
         ftxtDescuento.setVisible(false);
      //  btnCalcularDescuento.setVisible(false);
        ftxtDescuento.setVisible(false);
        lblPuntosAUsar.setVisible(false);
        spnPuntos.setVisible(false);
        rdbtnDescontarPuntos.setVisible(false);
        rdbtnUsarTodos.setVisible(false);
        dchoFecha.setVisible(false); 
        rdbtnTotal.setVisible(false);
        rdbtnPorUnidad.setVisible(false);
        btnAplicarDescuento.setVisible(false);
      }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLocaleChooser1 = new com.toedter.components.JLocaleChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCanasta = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        cboProductos = new javax.swing.JComboBox<String>();
        jLabel3 = new javax.swing.JLabel();
        spnCantidad = new javax.swing.JSpinner();
        cboClientes = new javax.swing.JComboBox();
        dchoFecha = new com.toedter.calendar.JDateChooser();
        chboAgenda = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblInventario = new javax.swing.JLabel();
        lblPuntos = new javax.swing.JLabel();
        lblPuntosD = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        ftxtDescuento = new javax.swing.JFormattedTextField();
        rdbtnDescontarPuntos = new javax.swing.JRadioButton();
        rdbtnUsarTodos = new javax.swing.JRadioButton();
        lblPuntosAUsar = new javax.swing.JLabel();
        spnPuntos = new javax.swing.JSpinner();
        chboDescuento = new javax.swing.JCheckBox();
        rdbtnTotal = new javax.swing.JRadioButton();
        rdbtnPorUnidad = new javax.swing.JRadioButton();
        rdbtnPuntosClasicos = new javax.swing.JRadioButton();
        rdbtnPuntosDobles = new javax.swing.JRadioButton();
        btnAplicarDescuento = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblCanasta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio", "Cantidad", "Descuento", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCanasta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCanastaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCanasta);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar todo");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnFinalizar.setText("Finalizar venta");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        cboProductos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        cboProductos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- SELECCIONE UN PRODUCTO --" }));
        cboProductos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboProductosItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("Cantidad");

        spnCantidad.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        spnCantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spnCantidadMouseClicked(evt);
            }
        });

        cboClientes.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cboClientes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Seleccione el cliente --" }));
        cboClientes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboClientesItemStateChanged(evt);
            }
        });

        chboAgenda.setText("Agenda automática");
        chboAgenda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chboAgendaItemStateChanged(evt);
            }
        });

        jLabel2.setText("Precio:");

        lblPrecio.setText("$");
        lblPrecio.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Inventario:");

        lblInventario.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblPuntos.setText("Puntos disponibles:");

        lblPuntosD.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jCheckBox1.setText("Descuento especial");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        ftxtDescuento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ftxtDescuento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        ftxtDescuento.setText("0");
        ftxtDescuento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ftxtDescuentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ftxtDescuentoFocusLost(evt);
            }
        });
        ftxtDescuento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ftxtDescuentoMouseClicked(evt);
            }
        });
        ftxtDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftxtDescuentoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbtnDescontarPuntos);
        rdbtnDescontarPuntos.setText("Descontar puntos");
        rdbtnDescontarPuntos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdbtnDescontarPuntosItemStateChanged(evt);
            }
        });

        buttonGroup1.add(rdbtnUsarTodos);
        rdbtnUsarTodos.setText("Usar todos los puntos");

        lblPuntosAUsar.setText("Puntos a usar:");

        chboDescuento.setText("Descuento con puntos");
        chboDescuento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chboDescuentoItemStateChanged(evt);
            }
        });
        chboDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chboDescuentoActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdbtnTotal);
        rdbtnTotal.setSelected(true);
        rdbtnTotal.setText("Total");
        rdbtnTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnTotalActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdbtnPorUnidad);
        rdbtnPorUnidad.setText("Por unidad");

        buttonGroup3.add(rdbtnPuntosClasicos);
        rdbtnPuntosClasicos.setText("Puntos clásicos");

        buttonGroup3.add(rdbtnPuntosDobles);
        rdbtnPuntosDobles.setText("Puntos dobles");

        btnAplicarDescuento.setText("Aplicar descuento");
        btnAplicarDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarDescuentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cboProductos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(12, 12, 12)
                                        .addComponent(lblInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(31, 31, 31)
                                        .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(ftxtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(rdbtnTotal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdbtnPorUnidad)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFinalizar))
                            .addComponent(cboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(rdbtnDescontarPuntos)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblPuntosAUsar)
                                        .addGap(18, 18, 18)
                                        .addComponent(spnPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(rdbtnUsarTodos)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAplicarDescuento))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblPuntos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblPuntosD, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(chboDescuento))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(chboAgenda)
                                .addGap(18, 18, 18)
                                .addComponent(dchoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdbtnPuntosClasicos)
                                .addGap(18, 18, 18)
                                .addComponent(rdbtnPuntosDobles)))))
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(chboAgenda)
                            .addComponent(dchoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdbtnPuntosClasicos)
                            .addComponent(rdbtnPuntosDobles))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblPuntosD, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPuntos, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(chboDescuento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdbtnDescontarPuntos)
                            .addComponent(lblPuntosAUsar)
                            .addComponent(spnPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdbtnUsarTodos)
                            .addComponent(btnAplicarDescuento)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(lblInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdbtnTotal)
                            .addComponent(rdbtnPorUnidad))
                        .addGap(0, 0, 0)
                        .addComponent(ftxtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel4.setText("Ventas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(403, 403, 403)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Total:");

        lblTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTotal.setText("$ 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
       // inicializar();
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
         calcularContacto();
         llenarProductos();
         llenarClientes();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         
    }//GEN-LAST:event_formWindowOpened

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if(cboProductos.getSelectedIndex()!=0){
            String producto= cboProductos.getSelectedItem()+"";
            float precio= precios.get(cboProductos.getSelectedIndex()-1);
            int cantidad=Integer.parseInt(spnCantidad.getValue()+"");
            int stock =inventario.get(cboProductos.getSelectedIndex()-1);
            float desc=Float.parseFloat(ftxtDescuento.getText());
            if(cantidad<stock){
                Object[] fila = new Object[5];
                fila[0]=producto;
                fila[1]=precio;
                fila[2]=cantidad;
                fila[3]=desc;
                if(rdbtnTotal.isSelected()){
                fila[4]= precio*cantidad-desc;
                }else{
                fila[4]= precio*cantidad-(desc*cantidad);
                }
                dtmProductos.addRow(fila);
                tblCanasta.setModel(dtmProductos);
                calcularTotal();
                inventario.set(cboProductos.getSelectedIndex()-1, inventario.get(cboProductos.getSelectedIndex()-1)-cantidad);
                cboProductos.setSelectedIndex(0);
                spnCantidad.setValue(1);
            }else{
                JOptionPane.showMessageDialog(this, "No hay inventario suficiente");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Elija un producto");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int r= tblCanasta.getSelectedRow();
        if(r>=0){
        inventario.set(cboProductos.getSelectedIndex()-1, inventario.get(cboProductos.getSelectedIndex()-1)+Integer.parseInt(dtmProductos.getValueAt(r, 2)+""));
        dtmProductos.removeRow(r);
        tblCanasta.setModel(dtmProductos);
        cboProductos.setSelectedIndex(0);
        }
        else{
        JOptionPane.showMessageDialog(this, "Seleccione un producto para eliminar");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        if(dtmProductos.getRowCount()>0){
        dtmProductos = new DefaultTableModel();
         dtmProductos.setColumnIdentifiers(new Object[]{"Nombre", "Precio", "Cantidad", "Descuento","Subtotal"});
         tblCanasta.setModel(dtmProductos);
         lblTotal.setText("$ 0");
         llenarProductos();
        }else{
        JOptionPane.showMessageDialog(this, "No hay nada  para eliminar");
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        // TODO add your handling code here:
        if(cboClientes.getSelectedIndex()>=1&&(rdbtnPuntosClasicos.isSelected()||rdbtnPuntosDobles.isSelected()||cboClientes.getSelectedIndex()==1)){
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
         Sentencias.actualizarSesion(frmprincipal.getIdSesion(), Sentencias.getFechaHora());
         int id_venta= Sentencias.iniciarVenta(frmprincipal.getIdSesion());
        int r= tblCanasta.getRowCount();
        if(chboAgenda.isSelected()&&dchoFecha.getDate()!=null){
         String fecha="";
         DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        fecha+= dateFormat.format(dchoFecha.getDate());
        Sentencias.agendarContacto(
                id_venta, 
                Sentencias.idDuegno(cboClientes.getSelectedItem()+""), 
                Sentencias.getFecha(), 
                fecha, 
                frmprincipal.getIdSesion()
                 );
        
        }
        for(int i=0;i<r;i++){
            String nombre= tblCanasta.getValueAt(i, 0)+"";
            float precio= Float.parseFloat(tblCanasta.getValueAt(i, 1)+"");
            int cantidad= Integer.parseInt(tblCanasta.getValueAt(i, 2)+"");
            float desc= Float.parseFloat(tblCanasta.getValueAt(i, 3)+"");
            float subtotal= Float.parseFloat(tblCanasta.getValueAt(i, 4)+"");
            Sentencias.agregarACarrito(id_venta, nombre, precio, cantidad, desc, subtotal);
        
        }
        
        Sentencias.cerrarVenta(descuento,id_venta, frmprincipal.getIdSesion(), Sentencias.idDuegno(cboClientes.getSelectedItem()+""), Sentencias.getFechaHora());
        if(cboClientes.getSelectedIndex()>1){
             int puntos=0;
            if(rdbtnPuntosClasicos.isSelected()){
            puntos= (int) (totalAPagar/100);
           
            }else if(rdbtnPuntosDobles.isSelected()){
             puntos = (int) (totalAPagar/50);
            }
            if(chboDescuento.isSelected()){
            Sentencias.descontarPuntos(Sentencias.idDuegno(cboClientes.getSelectedItem()+""), (int) descuento);
            }
             Sentencias.sumarPuntos(Sentencias.idDuegno(cboClientes.getSelectedItem()+""),puntos);
        }
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        int input = JOptionPane.showConfirmDialog(null,
                "Venta realizada\n¿Desea realizar otra venta?",
                "Venta concluida",JOptionPane.YES_NO_OPTION);
            if(input==0){
             DialogVentas dialogVentas = new DialogVentas( frmprincipal, false);
            dialogVentas.setVisible( true );
            this.dispose();
            }else{
            this.dispose();
            }
        }else{
            if(rdbtnPuntosClasicos.isSelected()==false&&rdbtnPuntosDobles.isSelected()==false){
            rdbtnPuntosClasicos.setForeground(Color.red);
            rdbtnPuntosDobles.setForeground(Color.red);
            }
        JOptionPane.showMessageDialog(this, "Complete bien los datos para realizar la venta");
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void ftxtDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftxtDescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftxtDescuentoActionPerformed

    private void cboProductosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboProductosItemStateChanged
        // TODO add your handling code here:
        if(cboProductos.getSelectedIndex()!=0){
            lblPrecio.setText(precios.get(cboProductos.getSelectedIndex()-1)+"");
            lblInventario.setText(inventario.get(cboProductos.getSelectedIndex()-1)+"");
        }else{
        lblInventario.setText("");
        lblPrecio.setText("");
        }
    }//GEN-LAST:event_cboProductosItemStateChanged

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        if(jCheckBox1.isSelected()){
        ftxtDescuento.setVisible(true);
        rdbtnTotal.setVisible(true);
        rdbtnPorUnidad.setVisible(true);
        //btnCalcularDescuento.setVisible(true);
        }else{
         ftxtDescuento.setText("0.00");
         ftxtDescuento.setVisible(false);
         rdbtnTotal.setVisible(false);
        rdbtnPorUnidad.setVisible(false);
        //btnCalcularDescuento.setVisible(false);
        
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void cboClientesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboClientesItemStateChanged
        // TODO add your handling code here:
        if(cboClientes.getSelectedIndex()!=0){
        lblPuntosD.setText(puntos.get(cboClientes.getSelectedIndex()-1)+"");
        }else{
        lblPuntosD.setText("");
        }
    }//GEN-LAST:event_cboClientesItemStateChanged

    private void chboDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chboDescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chboDescuentoActionPerformed

    private void chboDescuentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chboDescuentoItemStateChanged
        // TODO add your handling code here:
         if(chboDescuento.isSelected() && cboClientes.getSelectedIndex()>1){
        rdbtnDescontarPuntos.setVisible(true);
        rdbtnUsarTodos.setVisible(true);
        btnAplicarDescuento.setVisible(true);
        }else{
         rdbtnDescontarPuntos.setSelected(false);
         rdbtnUsarTodos.setSelected(false);
         rdbtnDescontarPuntos.setVisible(false);
        rdbtnUsarTodos.setVisible(false);
         btnAplicarDescuento.setVisible(false);
         
        }
    }//GEN-LAST:event_chboDescuentoItemStateChanged

    private void rdbtnDescontarPuntosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdbtnDescontarPuntosItemStateChanged
        // TODO add your handling code here:
        if(rdbtnDescontarPuntos.isSelected()){
        lblPuntosAUsar.setVisible(true);
        spnPuntos.setVisible(true);
        }else{
        lblPuntosAUsar.setVisible(false);
        spnPuntos.setVisible(false);
        }
    }//GEN-LAST:event_rdbtnDescontarPuntosItemStateChanged

    private void chboAgendaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chboAgendaItemStateChanged
        // TODO add your handling code here:
     if(chboAgenda.isSelected() && cboClientes.getSelectedIndex()>1){
        dchoFecha.setVisible(true);
        }else{
          dchoFecha.setVisible(false); 
        }
    }//GEN-LAST:event_chboAgendaItemStateChanged

    private void tblCanastaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCanastaMouseClicked
        // TODO add your handling code here:
        int r = tblCanasta.getSelectedRow();
        cboProductos.setSelectedItem(tblCanasta.getValueAt(r, 0));
        
    }//GEN-LAST:event_tblCanastaMouseClicked

    private void rdbtnTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbtnTotalActionPerformed

    private void ftxtDescuentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftxtDescuentoFocusGained
        // TODO add your handling code here:
        ftxtDescuento.selectAll();
    }//GEN-LAST:event_ftxtDescuentoFocusGained

    private void ftxtDescuentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ftxtDescuentoMouseClicked
        // TODO add your handling code here:
        ftxtDescuento.selectAll();
    }//GEN-LAST:event_ftxtDescuentoMouseClicked

    private void ftxtDescuentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftxtDescuentoFocusLost
        // TODO add your handling code here:
        btnAgregar.setFocusable(true);
    }//GEN-LAST:event_ftxtDescuentoFocusLost

    private void btnAplicarDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarDescuentoActionPerformed
        // TODO add your handling code here:
        if(chboDescuento.isSelected()){
            if(rdbtnDescontarPuntos.isSelected()){
            descuento= Float.parseFloat(spnPuntos.getValue()+"");
            calcularTotal();
            }else if(rdbtnUsarTodos.isSelected()){
            descuento= Float.parseFloat(lblPuntosD.getText());
            calcularTotal();
            }else{
            JOptionPane.showMessageDialog(this, "Sleccione una opción para el descuento");
            }
        }
        
    }//GEN-LAST:event_btnAplicarDescuentoActionPerformed

    private void spnCantidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spnCantidadMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_spnCantidadMouseClicked

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
            java.util.logging.Logger.getLogger(DialogVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogVentas dialog = new DialogVentas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAplicarDescuento;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox cboClientes;
    private javax.swing.JComboBox<String> cboProductos;
    private javax.swing.JCheckBox chboAgenda;
    private javax.swing.JCheckBox chboDescuento;
    private com.toedter.calendar.JDateChooser dchoFecha;
    private javax.swing.JFormattedTextField ftxtDescuento;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private com.toedter.components.JLocaleChooser jLocaleChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblInventario;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblPuntos;
    private javax.swing.JLabel lblPuntosAUsar;
    private javax.swing.JLabel lblPuntosD;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JRadioButton rdbtnDescontarPuntos;
    private javax.swing.JRadioButton rdbtnPorUnidad;
    private javax.swing.JRadioButton rdbtnPuntosClasicos;
    private javax.swing.JRadioButton rdbtnPuntosDobles;
    private javax.swing.JRadioButton rdbtnTotal;
    private javax.swing.JRadioButton rdbtnUsarTodos;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JSpinner spnPuntos;
    private javax.swing.JTable tblCanasta;
    // End of variables declaration//GEN-END:variables
}
