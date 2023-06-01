/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Database.Conexion;
import Datos.Interfaces.CrudProducto;
import Entidades.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author crist
 */
public class ProductoDAO implements CrudProducto<Producto> {
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public ProductoDAO() {
     CON = Conexion.getInstance();
    }

    @Override
    public List<Producto> listar(String texto) {
        List<Producto> registros=new ArrayList();
        try{
            ps=CON.Conectar().prepareStatement("SELECT P.cveProducto, C.cveCategoria, P.nombre, P.descripcion, P.imgProducto, P.precioVenta,\n" +
                                                " P.existencia, P.precioCompra, P.ganancia,P.estado\n" +
                                                " FROM Producto P INNER JOIN Categoria C ON P.cveCategoria = C.cveCategoria\n" +
                                                " WHERE P.nombre like ?;");
            ps.setString(1, '%' + texto + '%');
            rs=ps.executeQuery();
            while(rs.next())
                registros.add(new Producto(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getInt(7),rs.getDouble(8),rs.getDouble(9), rs.getString(10)));
            ps.close();
            rs.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps=null;
            rs=null;
            CON.Desconectar();
        }
        return registros;
    }
    
    @Override
    public Producto obtenerProducto(int id) {
        Producto producto = new Producto();
        try{
            ps=CON.Conectar().prepareStatement("SELECT CVEPRODUCTO, NOMBRE, PRECIOVENTA, EXISTENCIA, PRECIOCOMPRA, GANANCIA FROM PRODUCTO\n" +
                                                "WHERE CVEPRODUCTO = ? AND ESTADO = 'Activo';");
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next())
                producto = new Producto(rs.getInt(1),rs.getString(2),rs.getDouble(3), rs.getInt(4), rs.getDouble(5),rs.getDouble(6));
            ps.close();
            rs.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps=null;
            CON.Desconectar();
        }
        return producto;
    }

    @Override
    public boolean insertar(Producto obj) {
        resp=false;
        String consultaSQL="INSERT INTO Producto(CVECATEGORIA, NOMBRE, DESCRIPCION, IMGPRODUCTO, PRECIOCOMPRA, GANANCIA) \n" +
                            "VALUES(?,?,?,?,?,?);";
        try{
            ps=CON.Conectar().prepareStatement(consultaSQL);
            ps.setInt(1, obj.getCveCategoria());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getDescripcion());
            ps.setString(4, obj.getImgProducto());
            ps.setDouble(5, obj.getPrecioCompra());
            ps.setDouble(6, obj.getGanancia());
            
            if(ps.executeUpdate() > 0)
            {
                resp=true;
            }
            ps.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps=null;
            CON.Desconectar();
        }
        return resp;
    }

    @Override
    public boolean actualizar(Producto obj) {
        resp=false;
        String consultaSQL="UPDATE Producto SET NOMBRE=?, DESCRIPCION=?, IMGPRODUCTO=?, \n" +
                           "PRECIOCOMPRA=?, GANANCIA=? WHERE CVEPRODUCTO=?;";
        try{
            ps=CON.Conectar().prepareStatement(consultaSQL);
            ps=CON.Conectar().prepareStatement(consultaSQL);
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescripcion());
            ps.setString(3, obj.getImgProducto());
            ps.setDouble(4, obj.getPrecioCompra());
            ps.setDouble(5, obj.getGanancia());
            ps.setInt(6, obj.getCveProducto());
            
            if(ps.executeUpdate() > 0)
            {
                resp=true;
            }
            ps.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps=null;
            CON.Desconectar();
        }
        return resp;
    }

    @Override
    public int total() {
         int numeroRegistros=0;
        try{
            ps=CON.Conectar().prepareStatement("SELECT COUNT(*) FROM Producto;");
            rs=ps.executeQuery();
            while(rs.next()){
            numeroRegistros=rs.getInt(1);  // getString(String)
        }
        ps.close();
        rs.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps=null;
            rs=null;
            CON.Desconectar();
        }
        return numeroRegistros;    
    }

    @Override
    public boolean existe(String texto) {
        resp=false;
        try{
            ps=CON.Conectar().prepareStatement("SELECT * FROM Producto WHERE NOMBRE=?;");
            ps.setString(1, texto);
            rs=ps.executeQuery();
            if(rs.next()){
            resp=true;  //getString(String)
            }
            ps.close();
            rs.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps=null;
            rs=null;
            CON.Desconectar();
        }
        return resp;
    }

    @Override
    public boolean eliminar(String texto) {
        resp=false;
        String consultaSQL="DELETE FROM Producto WHERE NOMBRE=?;";
        try{
            ps=CON.Conectar().prepareStatement(consultaSQL);
            ps.setString(1, texto);
            if(ps.executeUpdate() > 0)
            {
                resp=true;
            }
            ps.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps=null;
            CON.Desconectar();
        }
        return resp;    
    }

    @Override
    public boolean desactivar(int id) {
        resp=false;
        String consultaSQL="UPDATE Producto SET ESTADO= 'Inactivo' WHERE CVEPRODUCTO=?";
        try{
            ps=CON.Conectar().prepareStatement(consultaSQL);
            ps.setInt(1, id);
            if(ps.executeUpdate() > 0)
            {
                resp=true;
            }
            ps.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps=null;
            CON.Desconectar();
        }
        return resp;    
    }

    @Override
    public boolean activar(int id) {
        resp=false;
        String consultaSQL="UPDATE PRODUCTO SET ESTADO = 'Activo' WHERE CVEPRODUCTO=?";
        try{
            ps=CON.Conectar().prepareStatement(consultaSQL);
            ps.setInt(1, id);
            if(ps.executeUpdate() > 0)
            {
                resp=true;
            }
            ps.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps=null;
            CON.Desconectar();
        }
        return resp;    
    }
}
