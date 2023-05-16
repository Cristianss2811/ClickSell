package Datos;

import Database.Conexion;
import Datos.Interfaces.CrudCompras;
import Entidades.Compras;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ComprasDAO implements CrudCompras<Compras>{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public ComprasDAO(){
        CON = Conexion.getInstance();
    }
    
    public List<Compras> listar(String texto){
        List<Compras> registros=new ArrayList();
        try{
            ps=CON.Conectar().prepareStatement("SELECT CVECOMPRAS, TOTALC, FECHAC FROM Compras WHERE FECHAC LIKE ?");
            ps.setString(1, '%' + texto + '%');
            rs=ps.executeQuery();
            while(rs.next())
                registros.add(new Compras(rs.getInt(1), rs.getDouble(2),rs.getString(3)));
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
    public boolean insertar(Compras obj){
      resp = false;
      String consultaSQL="CALL INSERTARCOMPRA(?,?);";
      try{
          ps=CON.Conectar().prepareStatement(consultaSQL);
          ps.setInt(1, obj.getCveProveedores());
          ps.setInt(2, obj.getCveUsuario());
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
    public List<Compras> Listar(String folio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Compras> ListarDetalle(int idCompra) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Compras> ListarProductos(String valor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Compras> ListarProvedor(String valor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Compras> ListarUsuario(String valor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insertarDetalle(Compras obj, double precioCompra, double ganancia) {
        resp = false;
        String consultaSQL="CALL INSERTARPRO_COMP(?,?,?,?);";
        try{
            ps=CON.Conectar().prepareStatement(consultaSQL);
            ps.setInt(1, obj.getCveProducto());
            ps.setInt(2, obj.getCanProCom());
            ps.setDouble(3, precioCompra);
            ps.setDouble(4, ganancia);
            
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
    public boolean cancelar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int total() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existe(String texto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int ActualizarStock(int cant, int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int ObtenerStock(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
