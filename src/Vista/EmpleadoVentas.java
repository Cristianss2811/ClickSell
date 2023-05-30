package Vista;

import Entidades.Proveedor;
import Negocio.VentasControl;
import Negocio.ProductoControl;
import java.awt.event.KeyEvent;
import Vista.Usuario_Venta;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class EmpleadoVentas extends javax.swing.JPanel {
    private final ProductoControl PRCONTROL;
    private final VentasControl COMCONTROL;
    private DefaultTableModel modeloTabla;
    private Usuario_Venta u = new Usuario_Venta();
    
    private String verde="#71BD44", naranja="#F39121";
    private int i;
    private double total, subtotal, iva;
    
    public EmpleadoVentas() {
        initComponents();
        PRCONTROL = new ProductoControl();
        COMCONTROL = new VentasControl();
        inicializarTabla();
        listarVentas("");
        EmpleadoVentas.setVisible(false);
        MostrarCompras.setVisible(true);
    }
    
    private void inicializarTabla(){
        String titulos[]={"Clave producto", "Nombre", "Precio Venta", "Existencias", "Cantidad"};
        modeloTabla=new DefaultTableModel(null,titulos);
        modeloTabla.addTableModelListener(new TableModelListener(){
             @Override
            public void tableChanged(TableModelEvent evento) {
                calcularTotal();
            }
        });
        tablaProductos.setModel(modeloTabla);
    }
    
    private boolean encuentraProducto(String id){
        for(i=0; i < tablaProductos.getRowCount(); i++)
            if(id.equals(tablaProductos.getValueAt(i, 0)))
            {
                tablaProductos.setValueAt(""+(Integer.parseInt(""+tablaProductos.getValueAt(i, 4))+1), i, 4);
                this.calcularTotal();
                return true;
            }
        return false;
    }
    
    private void calcularTotal(){
        total=0;
        for(i = 0; i < tablaProductos.getRowCount(); i++){
            if(Integer.parseInt(""+tablaProductos.getValueAt(i, 4)) <= Integer.parseInt(""+tablaProductos.getValueAt(i, 3)))
                if(Integer.parseInt(""+tablaProductos.getValueAt(i, 4))>0)
                        total += (Double.parseDouble(""+tablaProductos.getValueAt(i, 2)) * Integer.parseInt(""+tablaProductos.getValueAt(i, 4)));
                else{
                    JOptionPane.showMessageDialog(null, "No es posible vender " + tablaProductos.getValueAt(i, 4) + " " + ""+tablaProductos.getValueAt(i, 1));
                    tablaProductos.setValueAt(1,i,4);
                }
            else{
                JOptionPane.showMessageDialog(null, "Sólo tienes " + Integer.parseInt(""+tablaProductos.getValueAt(i, 3)) + " productos en existencia.");
                tablaProductos.setValueAt(Integer.parseInt(""+tablaProductos.getValueAt(i, 3)),i,4);
            }
                 
        }
        txtTotal.setText("$"+(Math.round(total*100.00)/100.00));
        txtSubtotal.setText("$"+(Math.round((total/1.16)*100.00)/100.00));
        txtIVA.setText("$"+(Math.round((total*0.16/1.16)*100.00)/100.00));
    }
    
    private void vaciarVentas(){
        inicializarTabla();
        txtProducto.setText("");
        calcularTotal();
    }
    
    private void listarVentas(String msj){
        tabla.setModel(COMCONTROL.listar(msj));
        TableRowSorter modeloOrdenado = new TableRowSorter(tabla.getModel());
        tabla.setRowSorter(modeloOrdenado);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MostrarCompras = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        btnAgregar1 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        EmpleadoVentas = new javax.swing.JPanel();
        txtProducto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtIVA = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1030, 690));

        MostrarCompras.setPreferredSize(new java.awt.Dimension(1030, 690));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Producto", "Cantidad", "Precio", "Iva", "Precio Final"
            }
        ));
        jScrollPane2.setViewportView(tabla);

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(113, 189, 68));
        btnBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarMouseExited(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel28.setText("Buscar");
        jLabel28.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout btnBuscarLayout = new javax.swing.GroupLayout(btnBuscar);
        btnBuscar.setLayout(btnBuscarLayout);
        btnBuscarLayout.setHorizontalGroup(
            btnBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBuscarLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addGap(30, 30, 30))
        );
        btnBuscarLayout.setVerticalGroup(
            btnBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        btnAgregar1.setBackground(new java.awt.Color(113, 189, 68));
        btnAgregar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btnAgregar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregar1MouseExited(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel29.setText("Agregar");
        jLabel29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout btnAgregar1Layout = new javax.swing.GroupLayout(btnAgregar1);
        btnAgregar1.setLayout(btnAgregar1Layout);
        btnAgregar1Layout.setHorizontalGroup(
            btnAgregar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAgregar1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addGap(30, 30, 30))
        );
        btnAgregar1Layout.setVerticalGroup(
            btnAgregar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout MostrarComprasLayout = new javax.swing.GroupLayout(MostrarCompras);
        MostrarCompras.setLayout(MostrarComprasLayout);
        MostrarComprasLayout.setHorizontalGroup(
            MostrarComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MostrarComprasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MostrarComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE)
                    .addGroup(MostrarComprasLayout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        MostrarComprasLayout.setVerticalGroup(
            MostrarComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MostrarComprasLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MostrarComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        EmpleadoVentas.setPreferredSize(new java.awt.Dimension(1030, 690));

        txtProducto.setName(""); // NOI18N
        txtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProductoKeyReleased(evt);
            }
        });

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Producto", "Cantidad", "Precio", "Ganancia"
            }
        ));
        jScrollPane1.setViewportView(tablaProductos);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Total de la venta");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Subtotal de la venta");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTotal.setText("$0.00");
        txtTotal.setEnabled(false);

        btnEliminar.setBackground(new java.awt.Color(113, 189, 68));
        btnEliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMouseExited(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setText("Eliminar producto");
        jLabel26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout btnEliminarLayout = new javax.swing.GroupLayout(btnEliminar);
        btnEliminar.setLayout(btnEliminarLayout);
        btnEliminarLayout.setHorizontalGroup(
            btnEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEliminarLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(30, 30, 30))
        );
        btnEliminarLayout.setVerticalGroup(
            btnEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        btnAgregar.setBackground(new java.awt.Color(113, 189, 68));
        btnAgregar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarMouseExited(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel27.setText("Realizar venta");
        jLabel27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout btnAgregarLayout = new javax.swing.GroupLayout(btnAgregar);
        btnAgregar.setLayout(btnAgregarLayout);
        btnAgregarLayout.setHorizontalGroup(
            btnAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAgregarLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel27)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        btnAgregarLayout.setVerticalGroup(
            btnAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        btnRegresar.setBackground(new java.awt.Color(113, 189, 68));
        btnRegresar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegresarMouseExited(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel33.setText("Regresar");
        jLabel33.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout btnRegresarLayout = new javax.swing.GroupLayout(btnRegresar);
        btnRegresar.setLayout(btnRegresarLayout);
        btnRegresarLayout.setHorizontalGroup(
            btnRegresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRegresarLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel33)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        btnRegresarLayout.setVerticalGroup(
            btnRegresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        txtSubtotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSubtotal.setText("$0.00");
        txtSubtotal.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("IVA");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtIVA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtIVA.setText("$0.00");
        txtIVA.setEnabled(false);

        javax.swing.GroupLayout EmpleadoVentasLayout = new javax.swing.GroupLayout(EmpleadoVentas);
        EmpleadoVentas.setLayout(EmpleadoVentasLayout);
        EmpleadoVentasLayout.setHorizontalGroup(
            EmpleadoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmpleadoVentasLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(EmpleadoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(EmpleadoVentasLayout.createSequentialGroup()
                        .addComponent(txtProducto)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EmpleadoVentasLayout.createSequentialGroup()
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addGroup(EmpleadoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(EmpleadoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(EmpleadoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(126, Short.MAX_VALUE))
            .addGroup(EmpleadoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EmpleadoVentasLayout.createSequentialGroup()
                    .addContainerGap(25, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(35, Short.MAX_VALUE)))
        );
        EmpleadoVentasLayout.setVerticalGroup(
            EmpleadoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EmpleadoVentasLayout.createSequentialGroup()
                .addGroup(EmpleadoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EmpleadoVentasLayout.createSequentialGroup()
                        .addGap(490, 490, 490)
                        .addGroup(EmpleadoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EmpleadoVentasLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(EmpleadoVentasLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(14, 14, 14)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(EmpleadoVentasLayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EmpleadoVentasLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(EmpleadoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(EmpleadoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
            .addGroup(EmpleadoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EmpleadoVentasLayout.createSequentialGroup()
                    .addContainerGap(38, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(225, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EmpleadoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(MostrarCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EmpleadoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(MostrarCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(!encuentraProducto(txtProducto.getText()))
                if(!txtProducto.getText().equals(""))
                {
                    String producto[] = PRCONTROL.obtenerProductoVenta(Integer.parseInt(txtProducto.getText()));
                    if(producto[1] != null){
                        if(Integer.parseInt(producto[3]) > 0){
                            System.out.println(producto.length);
                            modeloTabla.addRow(producto);
                            calcularTotal();
                        }
                        else
                            JOptionPane.showMessageDialog(null, "El producto no cuenta con existencias.");
                    }
                    else
                        JOptionPane.showMessageDialog(null, "El producto no se encontró en la BD.");
                }
                else
                        JOptionPane.showMessageDialog(null, "Por favor, inserte la clave de un producto.");
            txtProducto.setText("");
        }
    }//GEN-LAST:event_txtProductoKeyReleased

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        if(tablaProductos.getSelectedRow() != -1){
            modeloTabla.removeRow(tablaProductos.getSelectedRow());
            tablaProductos.setModel(modeloTabla);
        }
        else
            JOptionPane.showMessageDialog(null, "Por favor, seleccione el producto a eliminar.");
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        btnEliminar.setBackground(Color.decode(naranja));
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        btnEliminar.setBackground(Color.decode(verde));
    }//GEN-LAST:event_btnEliminarMouseExited

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        if(tablaProductos.getRowCount() > 0)
        {
            COMCONTROL.insertar(Integer.parseInt(u.nombre));
            for(i = 0; i < tablaProductos.getRowCount(); i++)
            {
                COMCONTROL.insertarDetalle(Integer.parseInt(""+tablaProductos.getValueAt(i, 0)),
                                             Integer.parseInt(""+tablaProductos.getValueAt(i, 4)));
            }
            JOptionPane.showMessageDialog(null, "Venta realizada con éxito.");
            vaciarVentas();
            listarVentas("");
            EmpleadoVentas.setVisible(false);
            MostrarCompras.setVisible(true);
        }
        else
            JOptionPane.showMessageDialog(null, "Por favor, inserte al menos un producto.");
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseEntered
        btnAgregar.setBackground(Color.decode(naranja));
    }//GEN-LAST:event_btnAgregarMouseEntered

    private void btnAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseExited
        btnAgregar.setBackground(Color.decode(verde));
    }//GEN-LAST:event_btnAgregarMouseExited

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        listarVentas(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        listarVentas(txtBuscar.getText());
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseEntered
        btnBuscar.setBackground(Color.decode(naranja));
    }//GEN-LAST:event_btnBuscarMouseEntered

    private void btnBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseExited
        btnBuscar.setBackground(Color.decode(verde));
    }//GEN-LAST:event_btnBuscarMouseExited

    private void btnAgregar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregar1MouseClicked
        EmpleadoVentas.setVisible(true);
        MostrarCompras.setVisible(false);
    }//GEN-LAST:event_btnAgregar1MouseClicked

    private void btnAgregar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregar1MouseEntered
        btnAgregar1.setBackground(Color.decode(naranja));
    }//GEN-LAST:event_btnAgregar1MouseEntered

    private void btnAgregar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregar1MouseExited
        btnAgregar1.setBackground(Color.decode(verde));
    }//GEN-LAST:event_btnAgregar1MouseExited

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        EmpleadoVentas.setVisible(false);
        MostrarCompras.setVisible(true);
    }//GEN-LAST:event_btnRegresarMouseClicked

    private void btnRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseEntered
        btnRegresar.setBackground(Color.decode(naranja));
    }//GEN-LAST:event_btnRegresarMouseEntered

    private void btnRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseExited
        btnRegresar.setBackground(Color.decode(verde));
    }//GEN-LAST:event_btnRegresarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EmpleadoVentas;
    private javax.swing.JPanel MostrarCompras;
    private javax.swing.JPanel btnAgregar;
    private javax.swing.JPanel btnAgregar1;
    private javax.swing.JPanel btnBuscar;
    private javax.swing.JPanel btnEliminar;
    private javax.swing.JPanel btnRegresar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtIVA;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
