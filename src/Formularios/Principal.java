
package Formularios;

import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import javax.swing.ImageIcon;

public class Principal extends javax.swing.JFrame {

    private final Connection Conexion;
    
    public Principal(Connection Conexion) {
        initComponents();
        this.Conexion = Conexion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon Icono = new ImageIcon(getClass().getResource("/Imagenes/Fondo.jpg"));
        Image Imagen = Icono.getImage();
        Contenedor = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics Grafico){

                Grafico.drawImage(Imagen,0,0,getWidth(),getHeight(),this);

            }

        };
        BarraMenu = new javax.swing.JMenuBar();
        Menu1 = new javax.swing.JMenu();
        ItemCerrarSesion = new javax.swing.JMenuItem();
        ItemSalir = new javax.swing.JMenuItem();
        Menu2 = new javax.swing.JMenu();
        ItemAgregarProducto = new javax.swing.JMenuItem();
        ItemModificarProducto = new javax.swing.JMenuItem();
        ItemEliminarProducto = new javax.swing.JMenuItem();
        Menu3 = new javax.swing.JMenu();
        ItemAgregarCliente = new javax.swing.JMenuItem();
        ItemModificarCliente = new javax.swing.JMenuItem();
        ItemEliminarCliente = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");

        javax.swing.GroupLayout ContenedorLayout = new javax.swing.GroupLayout(Contenedor);
        Contenedor.setLayout(ContenedorLayout);
        ContenedorLayout.setHorizontalGroup(
            ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 788, Short.MAX_VALUE)
        );
        ContenedorLayout.setVerticalGroup(
            ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        Menu1.setText("Usuario");

        ItemCerrarSesion.setText("Cerrar sesión");
        ItemCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemCerrarSesionActionPerformed(evt);
            }
        });
        Menu1.add(ItemCerrarSesion);

        ItemSalir.setText("Salir");
        ItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemSalirActionPerformed(evt);
            }
        });
        Menu1.add(ItemSalir);

        BarraMenu.add(Menu1);

        Menu2.setText("Productos");

        ItemAgregarProducto.setText("Agregar");
        ItemAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemAgregarProductoActionPerformed(evt);
            }
        });
        Menu2.add(ItemAgregarProducto);

        ItemModificarProducto.setText("Modificar");
        ItemModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemModificarProductoActionPerformed(evt);
            }
        });
        Menu2.add(ItemModificarProducto);

        ItemEliminarProducto.setText("Eliminar");
        ItemEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemEliminarProductoActionPerformed(evt);
            }
        });
        Menu2.add(ItemEliminarProducto);

        BarraMenu.add(Menu2);

        Menu3.setText("Clientes");

        ItemAgregarCliente.setText("Agregar");
        Menu3.add(ItemAgregarCliente);

        ItemModificarCliente.setText("Modificar");
        Menu3.add(ItemModificarCliente);

        ItemEliminarCliente.setText("Eliminar");
        Menu3.add(ItemEliminarCliente);

        BarraMenu.add(Menu3);

        setJMenuBar(BarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Contenedor)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Contenedor)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ItemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemCerrarSesionActionPerformed
        
        Login VerLogin = new Login();
        VerLogin.setLocationRelativeTo(null);
        VerLogin.show();
        this.dispose();
        
    }//GEN-LAST:event_ItemCerrarSesionActionPerformed

    private void ItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemSalirActionPerformed
        
        System.exit(0);
        
    }//GEN-LAST:event_ItemSalirActionPerformed

    private void ItemModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemModificarProductoActionPerformed
        
        ModificarProducto VerModificarProducto = new ModificarProducto(Conexion);
        Contenedor.add(VerModificarProducto);
        VerModificarProducto.show();
        
    }//GEN-LAST:event_ItemModificarProductoActionPerformed

    private void ItemEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemEliminarProductoActionPerformed
        
        EliminarProducto VerEliminarProducto = new EliminarProducto(Conexion);
        Contenedor.add(VerEliminarProducto);
        VerEliminarProducto.show();
        
    }//GEN-LAST:event_ItemEliminarProductoActionPerformed

    private void ItemAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemAgregarProductoActionPerformed

        AgregarProducto VerAgregarProducto = new AgregarProducto(Conexion);
        Contenedor.add(VerAgregarProducto);
        VerAgregarProducto.show();

    }//GEN-LAST:event_ItemAgregarProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarraMenu;
    private javax.swing.JDesktopPane Contenedor;
    private javax.swing.JMenuItem ItemAgregarCliente;
    private javax.swing.JMenuItem ItemAgregarProducto;
    private javax.swing.JMenuItem ItemCerrarSesion;
    private javax.swing.JMenuItem ItemEliminarCliente;
    private javax.swing.JMenuItem ItemEliminarProducto;
    private javax.swing.JMenuItem ItemModificarCliente;
    private javax.swing.JMenuItem ItemModificarProducto;
    private javax.swing.JMenuItem ItemSalir;
    private javax.swing.JMenu Menu1;
    private javax.swing.JMenu Menu2;
    private javax.swing.JMenu Menu3;
    // End of variables declaration//GEN-END:variables
}
