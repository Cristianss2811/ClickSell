/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;
import Database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Entidades.Usuarios;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Datos.Interfaces.CrudUsuario;
/**
 *
 * @author juanp
 */
public class UsuariosDAO implements CrudUsuario<Usuarios>{
private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public UsuariosDAO() {
        this.CON = Conexion.getInstance();
    }

    @Override
    public List<Usuarios> listar(String texto) {
        List<Usuarios> registros=new ArrayList();
          try{
            ps=CON.Conectar().prepareStatement("SELECT * FROM USUARIO WHERE NOMBREU LIKE ?");
            ps.setString(1, '%' + texto + '%');
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Usuarios(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
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
    public boolean insertar(Usuarios obj) {
       resp=false;
        String consultaSQL="INSERT INTO USUARIO(NOMBREU, CORREOU, CONTRASEÑAU, ROL, ESTADO)\n" +
                           " values(?,?,?,?,?);";
        try{
            ps=CON.Conectar().prepareStatement(consultaSQL);
            ps.setString(1, obj.getNombreu());
            ps.setString(2, obj.getCorreou() );
            ps.setString(3, obj.getContraseñau());
            ps.setString(4, obj.getRol());
            ps.setString(5, "Activo");
           
            
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
    public boolean actualizar(Usuarios obj) {
        resp=false;
        String consultaSQL = "UPDATE USUARIO SET NOMBREU=?, CORREOU=?, CONTRASEÑAU=?, ROL=?" +
"WHERE CVEUSUARIO = ?;";
         try
        {
            ps=CON.Conectar().prepareStatement(consultaSQL);
            ps.setString(1, obj.getNombreu());
            ps.setString(2, obj.getCorreou());
            ps.setString(3, obj.getContraseñau());
            ps.setString(4, obj.getRol());
            ps.setInt(5, obj.getCVEUSUARIO());
            
            if(ps.executeUpdate() > 0)
                resp=true;
            ps.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            ps=null;
            CON.Desconectar();
        }
        return resp;
    }

    @Override
    public boolean eliminar(int id) {
        resp=false;
        String consultaSQL="DELETE FROM USUARIO WHERE CVEUSUARIO=?";
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
    public boolean desactivar(int id) {
       resp=false;
        String consultaSQL="UPDATE USUARIO SET ESTADO = 'Inactivo' WHERE CVEUSUARIO=?";
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
        String consultaSQL="UPDATE USUARIO SET ESTADO = 'Activo' WHERE CVEUSUARIO=?";
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
    public int total() {
        int numeroRegistros=0;
        try{
            ps=CON.Conectar().prepareStatement("SELECT COUNT(*) FROM USUARIO;");
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
            ps=CON.Conectar().prepareStatement("SELECT * FROM USUARIO WHERE CVEUSUARIO =?;");
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
    public List<Usuarios> Logear(String texto, String texto2) {
        
        List<Usuarios> registros=new ArrayList();
        try {
//            System.out.println(texto2);
            CON.Conectar();
            ps = CON.cadena.prepareStatement("SELECT CVEUSUARIO, ROL  FROM USUARIO WHERE NOMBREU=? and CONTRASEÑAU = ?;");
            ps.setString(1, texto);
            ps.setString(2, texto2);
            rs = ps.executeQuery();
            if (rs.next()) {
                while(rs.next()){
                registros.add(new Usuarios(rs.getInt(1), rs.getString(2)));
            }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un usuario valido");
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
             CON.Desconectar();
            rs = null;
        }
return registros;
    }
    
}
