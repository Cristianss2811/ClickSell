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
public interface CrudVentas<T, DV, P, U> {
    public List<T> listar(String texto);// Regresa un listado de tipo list de objetos T

    public List<DV> listarDetalle(int idVenta); //Regresar los prodcutos de la venta(tabla hija)

    public List<P> ListarProductos(String valor);

    public List<U> ListarUsuario(String valor);

    public boolean insertar(T obj);//Inserta un objeto del tipo T

    public boolean insertarUsu_Ven(int idVenta, int idEmpleado);

    public int RegresarIdVenta(String Folio);

    public int total(); //Regresa el total de registros de una tabla

    public boolean existe(String texto); //Refresa verdadero si existe un registro o falso sino

    public int ActualizarStock(int cant, int id);

    public int ObtenerStock(int id);
}
