/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;
import Database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Entidades.Proveedor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Datos.Interfaces.CrudProveedor;
/**
 *
 * @author juanp
 */
public class ProveedorDAO implements CrudProveedor<Proveedor>{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public ProveedorDAO() {
        this.CON = Conexion.getInstance();
    }

    @Override
    public List<Proveedor> listar(String texto) {
        List<Proveedor> registros=new ArrayList();
        try {
            ps = CON.Conectar().prepareStatement("SELECT * FROM PROVEEDORES where NOMBREP like ?");
            ps.setString(1, "%" + texto + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new Proveedor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.Desconectar();
        }

        return registros;
    }

    @Override
    public boolean insertar(Proveedor obj) {
       resp = false;
        String consultaSQL = "insert into PROVEEDORES(NOMBREP, TELP, LOCALIDADP, ESTADOP, EMPRESAP,ESTADO )\n"
                + "values(?,?,?,?,?,?) ;";
        try {
            ps = CON.Conectar().prepareStatement(consultaSQL);
           ps.setString(1, obj.getNombrep());
           ps.setString(2, obj.getTelp());
           ps.setString(3, obj.getLocalidadp());
           ps.setString(4, obj.getEstadop());
           ps.setString(5, obj.getEmpresap());
           ps.setString(6, obj.getEstado());

            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.Desconectar();
        }
        return resp;  
    }

    @Override
    public boolean actualizar(Proveedor obj) {
        resp = false;
        String consultaSQL = "update PROVEEDORES set NOMBREP=?,TELP=?,LOCALIDADP=?,ESTADOP=?,EMPRESAP=? where CVEPROVEEDORES=?;";
        try {
            ps = CON.Conectar().prepareStatement(consultaSQL);
            ps.setString(1, obj.getNombrep());
           ps.setString(2, obj.getTelp());
           ps.setString(3, obj.getLocalidadp());
           ps.setString(4, obj.getEstadop());
           ps.setString(5, obj.getEmpresap());
           ps.setInt(6, obj.getCVEPROVEEDORES());
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.Desconectar();
        }
        return resp; 
    }

    @Override
    public boolean desactivar(int id) {
       resp = false;
        String consultaSQL = "delete from PROVEEDORES where CVEPROVEEDORES=?";
        try {
            ps = CON.Conectar().prepareStatement(consultaSQL);
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.Desconectar();
        }
        return resp;    
    }

    @Override
    public int total() {
        int numeroderegistros = 0;
        try {
            ps = CON.Conectar().prepareStatement("select count(CVEPROVEEDORES) from PROVEEDORES;");
            rs = ps.executeQuery();
            while (rs.next()) {
                numeroderegistros = rs.getInt(1); //getString(String) 
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.Desconectar();
        }

        return numeroderegistros; 
    }

    @Override
    public boolean existe(String texto) {
        resp = false;
        try {
            ps = CON.Conectar().prepareStatement("select * from PROVEEDORES where CVEPROVEEDORES=?;");
            ps.setString(1, texto);
            rs = ps.executeQuery();
            if (rs.next()) {
                resp = true;
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.Desconectar();
        }

        return resp;      
    }
    
    
}
