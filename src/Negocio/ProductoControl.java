/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Datos.CategoriaDAO;
import Datos.ProductoDAO;
import Entidades.Producto;
import Entidades.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crist
 */
public class ProductoControl {
    private final ProductoDAO DATOS;
    private final CategoriaDAO DATOSCAT;
    private Producto obj;
    private DefaultTableModel modeloTabla;
    private int registrosMostrados;

    public ProductoControl() {
        DATOS = new ProductoDAO();
        DATOSCAT = new CategoriaDAO();
        obj = new Producto();
        registrosMostrados=0;
    }
    
    public DefaultTableModel listar(String texto){
        List <Producto> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));
        
        //Crear el modelo y establecer los títulos del modelo
        String titulos[]={"IDProducto","IDCategoria","Nombre Producto",  "Descripcion", "ImagenProducto","Precio de venta", "Existencia", "Precio de compra", 
        "Ganancia", "Estado" };
        modeloTabla=new DefaultTableModel(null,titulos);
        
        // Recorrer los elementos de la lista con for each
        String registro []= new String[10];
        registrosMostrados=0;
        for(Producto item: lista){
            registro[0] = ""+item.getCveProducto();
            registro[1] = ""+item.getCveCategoria();
            registro[2] = item.getNombre();
            registro[3] = item.getDescripcion();
            registro[4] = ""+item.getImgProducto();
            registro[5] = ""+item.getPrecioVenta();
            registro[6] = ""+item.getExistencia();
            registro[7] = ""+item.getPrecioCompra();
            registro[8] = ""+item.getGanancia();
            registro[9] = ""+item.getEstado();
                        
            //Insertar el registro en el modelo
            modeloTabla.addRow(registro);
            registrosMostrados+=1;
        }
        return modeloTabla;
    }
    
    public String[] obtenerProducto(int id){
        String registro []= new String[6];
        Producto producto = DATOS.obtenerProducto(id);
        registro[0] = ""+producto.getCveProducto();
        registro[1] = producto.getNombre();
        registro[2] = ""+producto.getPrecioVenta();
        registro[3] = ""+producto.getPrecioCompra();
        registro[4] = ""+producto.getGanancia();
        registro[5] = "1";

        return registro;
    }
    
    public String[] obtenerProductoVenta(int id){
        String registro []= new String[5];
        Producto producto = DATOS.obtenerProducto(id);
        registro[0] = ""+producto.getCveProducto();
        registro[1] = producto.getNombre();
        registro[2] = ""+producto.getPrecioVenta();
        registro[3] = ""+producto.getExistencia();
        registro[4] = "1";

        return registro;
    }
    
    public DefaultTableModel seleccionarCategorias(String texto){
        List <Categoria> lista = new ArrayList();
        lista.addAll(DATOSCAT.listar(texto,1));
        
        //Crear el modelo y establecer los títulos del modelo
        String titulos[]={"ID Categoría", "Nombre"};
        modeloTabla=new DefaultTableModel(null,titulos);
        
        // Recorrer los elementos de la lista con for each
        String registro []= new String[2];
        registrosMostrados=0;
        for(Categoria item: lista){
            registro[0] = ""+item.getCvecategoria();
            registro[1] = item.getNombrec();
                        
            //Insertar el registro en el modelo
            modeloTabla.addRow(registro);
            registrosMostrados+=1;
        }
        return modeloTabla;
    }
    
    public String insertar(int cveCategoria, String nombreProducto, String descripcionCategoria, String imagenProducto, double precioCompra,  double ganancia){
    // Verificar si existe la categoria
        if(DATOS.existe(nombreProducto))
            return "El registro ya existe.";
        else
        {
            // Llenar el objeto
            obj.setCveCategoria(cveCategoria);
            obj.setNombre(nombreProducto);
            obj.setDescripcion(descripcionCategoria);
            obj.setImgProducto(imagenProducto);
            obj.setPrecioCompra(precioCompra);
            obj.setGanancia(ganancia);
            
            //Insertar el objeto en la base de datos
            return (DATOS.insertar(obj))?"OK":"Error al insertar el registro";
        }
    }
    
    public String eliminar(String nombreProducto){
        // Verificar si existe la categoria
        if(!DATOS.existe(nombreProducto))
            return "El registro no existe.";
        else
        {
            return (DATOS.eliminar(nombreProducto))?"OK":"Error al insertar el registro";
        }
    }
    
    public String actualizar(int cveProducto, int cveCategoria,   String nombreProducto, String nombreAnterior, String descripcion, String imagenProducto, double precioCompra, double ganancia){
        //Verificar si el usuario cambia el nombre de la categoría
        if(nombreProducto.equals(nombreAnterior)){
            // Llenar el objeto
            obj.setCveProducto(cveProducto);
            obj.setCveCategoria(cveCategoria);
            obj.setNombre(nombreProducto);
            obj.setDescripcion(descripcion);
            obj.setImgProducto(imagenProducto);
            obj.setPrecioCompra(precioCompra);
            obj.setGanancia(ganancia);

                //Actualizar el objeto en la base de datos
                return(DATOS.actualizar(obj))?"OK":"Error al actualizar el registro";
        }
        else{
        // Verificar si existe la categoria
            if(DATOS.existe(nombreProducto))
                return "El nombre del producto ya existe.";
            else
            {
                // Llenar el objeto
                obj.setCveProducto(cveProducto);
                obj.setNombre(nombreProducto);
                obj.setDescripcion(descripcion);
                obj.setImgProducto(imagenProducto);
                obj.setPrecioCompra(precioCompra);
                obj.setGanancia(ganancia);

                //Actualizar el objeto en la base de datos
                return(DATOS.actualizar(obj))?"OK":"Error al actualizar el registro";
            }
        }
    }
    
    public String desactivar(int id){
        return(DATOS.desactivar(id))?"OK":"No se pudo desactivar el registro";
    }
    
    public String activar(int id){
        return(DATOS.activar(id))?"OK":"No se pudo desactivar el registro";
    }
    
    public int total(){
        return DATOS.total();
    }
    
    public int totalMostrados(){
        return registrosMostrados;
    }
    
}
