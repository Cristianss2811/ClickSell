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
public interface CrudCompras <T, DC, P, PR, U>{
    
    public List<T> Listar(String folio);
    
    public List<DC> ListarDetalle(int idCompra);
    
    public List<P> ListarProductos(String valor);
    
    public List<PR> ListarProvedor(String valor);
    
    public List<U> ListarUusuario(String valor);
    
    public boolean insertar(T obj);
    
    public boolean insertarUsu_Com(int idCompra, int idUsuario);
    
    public boolean insertarProv_Comp(int idCompra, int idProvedor);
    
    public boolean cancelar(int id);
    
    public int total();
    
    public int RegresarIdCompra(String Folio);
    
    public boolean existe(String texto);
    
    public int ActualizarStock(int cant, int id);
    
    public int ObtenerStock(int id);
    
}
