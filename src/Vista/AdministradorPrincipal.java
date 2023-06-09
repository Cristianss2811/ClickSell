/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.awt.Color;

/**
 *
 * @author crist
 */
public class AdministradorPrincipal extends javax.swing.JFrame {
int xmouse,ymouse;
String verde="#71BD44", naranja="#F39121", blanco="#FFFFFF", negro="#000000";
    /**
     * Creates new form AdministradorInventario
     */
    public AdministradorPrincipal() {
        initComponents();
        this.setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnContenedorInventario = new javax.swing.JPanel();
        btnInventario = new javax.swing.JButton();
        btnContenedorUsuario = new javax.swing.JPanel();
        btnUsuario = new javax.swing.JButton();
        btnContenedorProveedor = new javax.swing.JPanel();
        btnProveedor = new javax.swing.JButton();
        btnContenedorSalir = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PanelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(380, 1120));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/administrador256px.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Administrador");

        btnContenedorInventario.setBackground(new java.awt.Color(255, 255, 255));
        btnContenedorInventario.setMaximumSize(new java.awt.Dimension(83, 25));
        btnContenedorInventario.setMinimumSize(new java.awt.Dimension(83, 25));
        btnContenedorInventario.setPreferredSize(new java.awt.Dimension(83, 25));
        btnContenedorInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnContenedorInventarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnContenedorInventarioMouseExited(evt);
            }
        });
        btnContenedorInventario.setLayout(new java.awt.BorderLayout());

        btnInventario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnInventario.setForeground(new java.awt.Color(113, 189, 68));
        btnInventario.setText("Inventario");
        btnInventario.setBorder(null);
        btnInventario.setBorderPainted(false);
        btnInventario.setContentAreaFilled(false);
        btnInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInventarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInventarioMouseExited(evt);
            }
        });
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });
        btnContenedorInventario.add(btnInventario, java.awt.BorderLayout.CENTER);

        btnContenedorUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnContenedorUsuario.setMaximumSize(new java.awt.Dimension(83, 25));
        btnContenedorUsuario.setMinimumSize(new java.awt.Dimension(83, 25));
        btnContenedorUsuario.setPreferredSize(new java.awt.Dimension(83, 25));
        btnContenedorUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnContenedorUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnContenedorUsuarioMouseExited(evt);
            }
        });
        btnContenedorUsuario.setLayout(new java.awt.BorderLayout());

        btnUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnUsuario.setForeground(new java.awt.Color(113, 189, 68));
        btnUsuario.setText("Usuario");
        btnUsuario.setBorder(null);
        btnUsuario.setBorderPainted(false);
        btnUsuario.setContentAreaFilled(false);
        btnUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUsuarioMouseExited(evt);
            }
        });
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });
        btnContenedorUsuario.add(btnUsuario, java.awt.BorderLayout.CENTER);

        btnContenedorProveedor.setBackground(new java.awt.Color(255, 255, 255));
        btnContenedorProveedor.setMaximumSize(new java.awt.Dimension(83, 25));
        btnContenedorProveedor.setMinimumSize(new java.awt.Dimension(83, 25));
        btnContenedorProveedor.setPreferredSize(new java.awt.Dimension(83, 25));
        btnContenedorProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnContenedorProveedorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnContenedorProveedorMouseExited(evt);
            }
        });
        btnContenedorProveedor.setLayout(new java.awt.BorderLayout());

        btnProveedor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnProveedor.setForeground(new java.awt.Color(113, 189, 68));
        btnProveedor.setText("Proveedor");
        btnProveedor.setBorder(null);
        btnProveedor.setBorderPainted(false);
        btnProveedor.setContentAreaFilled(false);
        btnProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProveedorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProveedorMouseExited(evt);
            }
        });
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });
        btnContenedorProveedor.add(btnProveedor, java.awt.BorderLayout.CENTER);

        btnContenedorSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnContenedorSalir.setMaximumSize(new java.awt.Dimension(83, 25));
        btnContenedorSalir.setMinimumSize(new java.awt.Dimension(83, 25));
        btnContenedorSalir.setPreferredSize(new java.awt.Dimension(83, 25));
        btnContenedorSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnContenedorSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnContenedorSalirMouseExited(evt);
            }
        });
        btnContenedorSalir.setLayout(new java.awt.BorderLayout());

        btnSalir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(113, 189, 68));
        btnSalir.setText("Salir");
        btnSalir.setBorder(null);
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        btnContenedorSalir.add(btnSalir, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(62, 62, 62))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnContenedorInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnContenedorUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(btnContenedorProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(btnContenedorSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnContenedorInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnContenedorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnContenedorProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnContenedorSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 250, 690));

        jPanel2.setBackground(new java.awt.Color(243, 145, 33));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo 256px.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, 260, 280));

        PanelPrincipal.setLayout(new javax.swing.BoxLayout(PanelPrincipal, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(PanelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 1030, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        // TODO add your handling code here:
         new CambiaPanel(PanelPrincipal,new AdminUsuario());
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void btnInventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventarioMouseEntered
        btnContenedorInventario.setBackground(Color.decode(verde));
        btnInventario.setForeground(Color.decode(negro));
    }//GEN-LAST:event_btnInventarioMouseEntered

    private void btnInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventarioMouseExited
        btnContenedorInventario.setBackground(Color.decode(blanco));
        btnInventario.setForeground(Color.decode(verde));
    }//GEN-LAST:event_btnInventarioMouseExited

    private void btnUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuarioMouseEntered
        btnContenedorUsuario.setBackground(Color.decode(verde));
        btnUsuario.setForeground(Color.decode(negro));
    }//GEN-LAST:event_btnUsuarioMouseEntered

    private void btnUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuarioMouseExited
        btnContenedorUsuario.setBackground(Color.decode(blanco));
        btnUsuario.setForeground(Color.decode(verde));
    }//GEN-LAST:event_btnUsuarioMouseExited

    private void btnProveedorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProveedorMouseEntered
         btnContenedorProveedor.setBackground(Color.decode(verde));
        btnProveedor.setForeground(Color.decode(negro));
    }//GEN-LAST:event_btnProveedorMouseEntered

    private void btnProveedorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProveedorMouseExited
        btnContenedorProveedor.setBackground(Color.decode(blanco));
        btnProveedor.setForeground(Color.decode(verde));
    }//GEN-LAST:event_btnProveedorMouseExited

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        btnContenedorSalir.setBackground(Color.decode(verde));
        btnSalir.setForeground(Color.decode(negro));
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        btnContenedorSalir.setBackground(Color.decode(blanco));
        btnSalir.setForeground(Color.decode(verde));
    }//GEN-LAST:event_btnSalirMouseExited

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        Logout log=new Logout();
        log.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
         xmouse=evt.getX();
        ymouse=evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
                this.setLocation(x-xmouse,y-ymouse);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        // TODO add your handling code here:
        new CambiaPanel(PanelPrincipal,new AdminInventario());
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        // TODO add your handling code here:
        new CambiaPanel(PanelPrincipal,new AdminProveedor());
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnContenedorInventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContenedorInventarioMouseEntered
        
    }//GEN-LAST:event_btnContenedorInventarioMouseEntered

    private void btnContenedorInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContenedorInventarioMouseExited
       
    }//GEN-LAST:event_btnContenedorInventarioMouseExited

    private void btnContenedorUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContenedorUsuarioMouseEntered
        
    }//GEN-LAST:event_btnContenedorUsuarioMouseEntered

    private void btnContenedorUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContenedorUsuarioMouseExited
        
    }//GEN-LAST:event_btnContenedorUsuarioMouseExited

    private void btnContenedorProveedorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContenedorProveedorMouseEntered
       
    }//GEN-LAST:event_btnContenedorProveedorMouseEntered

    private void btnContenedorProveedorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContenedorProveedorMouseExited
        
    }//GEN-LAST:event_btnContenedorProveedorMouseExited

    private void btnContenedorSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContenedorSalirMouseEntered
        
    }//GEN-LAST:event_btnContenedorSalirMouseEntered

    private void btnContenedorSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContenedorSalirMouseExited
         
    }//GEN-LAST:event_btnContenedorSalirMouseExited

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
            java.util.logging.Logger.getLogger(AdministradorPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministradorPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministradorPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministradorPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministradorPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel btnContenedorInventario;
    private javax.swing.JPanel btnContenedorProveedor;
    private javax.swing.JPanel btnContenedorSalir;
    private javax.swing.JPanel btnContenedorUsuario;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
