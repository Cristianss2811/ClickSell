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
            ps=(combo==1)?CON.Conectar().prepareStatement("SELECT * FROM CATEGORIA WHERE NOMBREC LIKE ? ;"):
                    CON.Conectar().prepareStatement("SELECT * FROM CATEGORIA WHERE NOMBREC LIKE ? ORDER BY NOMBREC;");
            ps.setString(1, '%' + texto + '%');
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Categoria(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
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
         resp=false;
        String consultaSQL="INSERT INTO Categoria (NOMBREC, DESCRIPCIONC, IMAGENC)\n" +
        "VALUES(?,?,?);";
        try{
            ps=CON.Conectar().prepareStatement(consultaSQL);
            ps.setString(1, obj.getNombrec());
            ps.setString(2, obj.getDescripcionc());
            ps.setString(3, obj.getImagenc());
            
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
    public boolean actualizar(Categoria obj) {
        resp=false;
        String consultaSQL="UPDATE Categoria SET NOMBREC=?, DESCRIPCIONC=?, IMAGENC=?"
                + "WHERE CVECATEGORIA = ?;";
        try{
            ps=CON.Conectar().prepareStatement(consultaSQL);
            ps.setString(1, obj.getNombrec());
            ps.setString(2, obj.getDescripcionc());
            ps.setString(3, obj.getImagenc());
            ps.setInt(4, obj.getCvecategoria());
            
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
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean desactivar(int id) {
        resp=false;
        String consultaSQL="UPDATE Categoria SET ESTADO = 'Inactivo' WHERE CVECATEGORIA=?";
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
        String consultaSQL="UPDATE Categoria SET ESTADO = 'Activo' WHERE CVECATEGORIA=?";
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
            ps=CON.Conectar().prepareStatement("SELECT COUNT(*) FROM Categoria;");
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
            ps=CON.Conectar().prepareStatement("SELECT * FROM Categoria WHERE NOMBREC=?;");
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

    
    
}
