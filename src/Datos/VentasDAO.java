package Datos;

import Database.Conexion;
import Datos.Interfaces.CrudVentas;
import Entidades.Ventas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VentasDAO  implements CrudVentas<Ventas>{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public VentasDAO(){
        CON = Conexion.getInstance();
    }
    
    @Override
    public List<Ventas> Listar(String texto) {
        List<Ventas> registros=new ArrayList();
        try{
            ps=CON.Conectar().prepareStatement("SELECT CVEVENTAS, SUBTOTALV, IVAV, FECHAV FROM VENTAS WHERE FECHAV LIKE ?");
            ps.setString(1, '%' + texto + '%');
            rs=ps.executeQuery();
            while(rs.next())
                registros.add(new Ventas(rs.getInt(1), rs.getDouble(2), rs.getDouble(3),rs.getString(4)));
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
    
    public List<String[]> ticket(int venta) {
        List<String[]> registros=new ArrayList();
        try{
            ps=CON.Conectar().prepareStatement("SELECT NOMBRE, PRECIOVENTA, CANPROVEN \n" +
                                                "FROM PRODUCTO INNER JOIN PRO_VEN ON PRO_VEN.CVEPRODUCTO = PRODUCTO.CVEPRODUCTO\n" +
                                                "WHERE CVEVENTAS = ?;");
            ps.setInt(1, venta);
            rs=ps.executeQuery();
            while(rs.next()){
                String objetos[] = new String[3];
                objetos[0] = rs.getString(1);
                objetos[2] = ""+rs.getDouble(2);
                objetos[1] = ""+rs.getInt(3);
                registros.add(objetos);
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
        return registros;
    }

    @Override
    public List<Ventas> ListarDetalle(int idVenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Ventas> ListarProductos(String valor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Ventas> ListarProvedor(String valor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Ventas> ListarUsuario(String valor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insertar(Ventas obj) {
        resp = false;
      String consultaSQL="CALL INSERTARVENTA(?);";
      try{
          ps=CON.Conectar().prepareStatement(consultaSQL);
          ps.setInt(1, obj.getCveUsuario());
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
    public boolean insertarDetalle(Ventas obj) {
        resp = false;
        String consultaSQL="CALL INSERTARPRO_VEN(?,?);";
        try{
            ps=CON.Conectar().prepareStatement(consultaSQL);
            ps.setInt(1, obj.getCveProducto());
            ps.setInt(2, obj.getCanProVen());
            
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
