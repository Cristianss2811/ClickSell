/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Entidades.Categoria;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Datos.Interfaces.CrudCategoria;

/**
 *
 * @author crist
 */
public class CategoriaDAO implements CrudCategoria<Categoria> {
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public CategoriaDAO() {
        this.CON = Conexion.getInstance();
    }

    @Override
    public List<Categoria> listar(String texto, int combo) {
         List<Categoria> registros=new ArrayList();
        try{
            ps=(combo==1)?CON.Conectar().prepareStatement("SELECT * FROM Categorias WHERE nombreCategoria LIKE ? AND ActivoCategoria=true ORDER BY nombreCategoria;"):
                    CON.Conectar().prepareStatement("SELECT * FROM Categorias WHERE nombreCategoria LIKE ? ORDER BY nombreCategoria;");
            ps.setString(1, '%' + texto + '%');
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Categoria(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getBoolean(5)));
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
    public boolean insertar(Categoria obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(Categoria obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean desactivar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean activar(int id) {
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

    
    
}
