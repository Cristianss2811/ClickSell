/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Datos.Interfaces;

import java.util.List;

/**
 *
 * @author crist
 */
public interface CrudCompras <T>{
    
    public List<T> Listar(String folio);
    
    public List<T> ListarDetalle(int idCompra);
    
    public List<T> ListarProductos(String valor);
    
    public List<T> ListarProvedor(String valor);
    
    public List<T> ListarUsuario(String valor);
    
    public boolean insertar(T obj);
    
    public boolean insertarDetalle(T obj, double precioCompra, double ganancia);
    
    public boolean cancelar(int id);
    
    public int total();
        
    public boolean existe(String texto);
    
    public int ActualizarStock(int cant, int id);
    
    public int ObtenerStock(int id);
}
