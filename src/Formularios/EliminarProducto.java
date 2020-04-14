package Formularios;

import Clases.Producto;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EliminarProducto extends javax.swing.JInternalFrame {

    private final Producto ObjProducto;
    private final Connection Conexion;

    public EliminarProducto(Connection Conexion) {

        initComponents();
        this.Conexion = Conexion;
        ObjProducto = new Producto();
        MostrarProductos("");

    }

    private void LimpiarCajas() {

        txtBuscar.setText("");
        txtBuscar.requestFocus();
        MostrarProductos("");

    }

    private void MostrarProductos(String Texto) {

        DefaultTableModel ModeloTabla = new DefaultTableModel();
        ModeloTabla.addColumn("Id");
        ModeloTabla.addColumn("Descripción");
        ModeloTabla.addColumn("Stock");
        ModeloTabla.addColumn("Precio");

        Object Fila[] = new Object[4];
        ArrayList<Producto> ListaProductos = ObjProducto.ListarProductos(Conexion, Texto);
        NumberFormat FormatoNumero = new DecimalFormat("0.00");

        if (ListaProductos != null) {
            for (int i = 0; i < ListaProductos.size(); i++) {
                Fila[0] = ListaProductos.get(i).getIdProducto();
                Fila[1] = ListaProductos.get(i).getDescripcionProducto();
                Fila[2] = ListaProductos.get(i).getStockProducto();
                Fila[3] = FormatoNumero.format(ListaProductos.get(i).getPrecioProducto());
                ModeloTabla.addRow(Fila);
            }
        }

        tblProductos.setModel(ModeloTabla);
        tblProductos.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblProductos.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblProductos.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblProductos.getColumnModel().getColumn(3).setPreferredWidth(50);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Eliminar producto");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));

        jScrollPane1.setViewportView(tblProductos);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnCancelar))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int filas[] = tblProductos.getSelectedRows();

        if (filas.length > 0) {
            String Cod;

            for (int i = 0; i < filas.length; i++) {
                Cod = tblProductos.getValueAt(filas[i], 0).toString();
                ObjProducto.EliminarProducto(Conexion, Cod);
            }

            LimpiarCajas();

            try {
                ModificarProducto.btnCancelar.doClick();
                AgregarProducto.btnCancelar.doClick();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe elegir elementos", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        MostrarProductos(txtBuscar.getText());

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        LimpiarCajas();

    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    public static javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
