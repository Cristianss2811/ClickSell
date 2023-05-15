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
public interface CrudProducto<T> {
    public List<T> listar(String texto); //Regresa un listado de tipo List de objetos T
    
    public T obtenerProducto(int id);
    
    public boolean insertar(T obj); // Inserta un objeto del tipo T
    
    public boolean actualizar(T obj); //Actualiza un registro de acuerdo a un objeto del tipo T
    
    public int total();
    
    public boolean existe(String texto); //Regresa verdadero o falso si existe un registro.
    
    public boolean eliminar(String texto); //Elimina un objeto
    
}
