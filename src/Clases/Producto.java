
package Clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Producto {
    
    private String IdProducto;
    private String DescripcionProducto;
    private int StockProducto;
    private double PrecioProducto;
    
    //Para los métodos
    private CallableStatement Consulta;
    private ResultSet Datos;

    public Producto(String DescripcionProducto, int StockProducto, double PrecioProducto) {
        this.DescripcionProducto = DescripcionProducto;
        this.StockProducto = StockProducto;
        this.PrecioProducto = PrecioProducto;
    }

    public Producto(String IdProducto, String DescripcionProducto, int StockProducto, double PrecioProducto) {
        this.IdProducto = IdProducto;
        this.DescripcionProducto = DescripcionProducto;
        this.StockProducto = StockProducto;
        this.PrecioProducto = PrecioProducto;
    }

    public Producto() {
    }
    
    public String getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(String IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getDescripcionProducto() {
        return DescripcionProducto;
    }

    public void setDescripcionProducto(String DescripcionProducto) {
        this.DescripcionProducto = DescripcionProducto;
    }

    public int getStockProducto() {
        return StockProducto;
    }

    public void setStockProducto(int StockProducto) {
        this.StockProducto = StockProducto;
    }

    public double getPrecioProducto() {
        return PrecioProducto;
    }

    public void setPrecioProducto(double PrecioProducto) {
        this.PrecioProducto = PrecioProducto;
    }
    
    //Métodos
    
    public ArrayList<Producto> ListarProductos(Connection Conexion, String Texto) {

        ArrayList<Producto> ListaProductos = new ArrayList<>();
        String Operacion = "CALL ListarProductos(?)";

        try {
            Consulta = Conexion.prepareCall(Operacion);
            Consulta.setString(1, Texto);
            Datos = Consulta.executeQuery();

            while (Datos.next()) {
                ListaProductos.add(new Producto(Datos.getString(1),
                        Datos.getString(2),
                        Datos.getInt(3),
                        Datos.getDouble(4))); // 1,2,3,4 Columnas en la tabla de la BD
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return ListaProductos;

    }

    public int AgregarProducto(Connection Conexion, Producto Producto) { //Devuelve 1 cuando agrega 0 cuando no

        String Operacion = "CALL AgregarProducto(?,?,?)";

        try {
            Consulta = Conexion.prepareCall(Operacion);
            Consulta.setString(1, Producto.getDescripcionProducto());
            Consulta.setInt(2, Producto.getStockProducto());
            Consulta.setDouble(3, Producto.getPrecioProducto());
            Consulta.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }

    }

    public int ModificarProducto(Connection Conexion, Producto Producto) {

        String Operacion = "CALL ModificarProducto(?,?,?,?)";

        try {
            Consulta = Conexion.prepareCall(Operacion);
            Consulta.setString(1, Producto.getIdProducto().substring(2));
            Consulta.setString(2, Producto.getDescripcionProducto());
            Consulta.setInt(3, Producto.getStockProducto());
            Consulta.setDouble(4, Producto.getPrecioProducto());
            Consulta.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }

    }

    public void EliminarProducto(Connection Conexion, String Codigo) {

        String Operacion = "CALL EliminarProducto(?)";
        Codigo = Codigo.substring(2);

        try {
            Consulta = Conexion.prepareCall(Operacion);
            Consulta.setString(1, Codigo);
            Consulta.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public Producto ObtenerProducto(Connection Conexion, String Codigo) {

        String Operacion = "CALL ObtenerProducto(?)";
        Producto Producto = null;
        Codigo = Codigo.substring(2);

        try {
            Consulta = Conexion.prepareCall(Operacion);
            Consulta.setString(1, Codigo);
            Datos = Consulta.executeQuery();
            if (Datos.next()) {
                Producto = new Producto(Datos.getString(1),
                        Datos.getString(2),
                        Datos.getInt(3),
                        Datos.getDouble(4)); // 1,2,3,4 Columnas en la tabla de la BD
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return Producto;
        
    }
    
}
