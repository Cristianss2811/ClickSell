/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import Datos.CategoriaDAO;
import Entidades.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author crist
 */
public class CategoriaControl {
    private final CategoriaDAO DATOS;
    private Categoria obj;
    private DefaultTableModel modeloTabla;
    private int registrosMostrados;
    
    public CategoriaControl(){
        DATOS=new CategoriaDAO();
        obj = new Categoria();
        registrosMostrados=0;
    }
    
    
    public DefaultTableModel listar(String texto){
        List <Categoria> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto, 0));
        
        //Crear el modelo y establecer los títulos del modelo
        String titulos[]={"Clave","Nombre","Descripción","Imagen","Estado"};
        modeloTabla=new DefaultTableModel(null,titulos);
        
        // Recorrer los elementos de la lista con for each
        String registro []= new String[5];
        registrosMostrados=0;
        for(Categoria item: lista){
            registro[0] = ""+item.getCvecategoria();
            registro[1] = item.getNombrec();
            registro[2] = item.getDescripcionc();
            registro[3] = item.getImagenc();
            registro[4] = (item.getEstado());
            
            //Insertar el registro en el modelo
            modeloTabla.addRow(registro);
            registrosMostrados+=1;
        }
        return modeloTabla;
    }
    
    public String insertar(String nombrec, String descripcionc, String imagenc){
    // Verificar si existe la categoria
        if(DATOS.existe(nombrec))
            return "El registro ya existe.";
        else
        {
            // Llenar el objeto
            obj.setNombrec(nombrec);
            obj.setDescripcionc(descripcionc);
            obj.setImagenc(imagenc);
            
            //Insertar el objeto en la base de datos
            return (DATOS.insertar(obj))?"OK":"Error al insertar el registro";
        }
    }
    
    public String actualizar(int cvecategoria, String nombrec, String nombreAnterior, String descripcionc, String imagenc){
        //Verificar si el usuario cambia el nombre de la categoría
        if(nombrec.equals(nombreAnterior)){
            // Llenar el objeto
                obj.setCvecategoria(cvecategoria);
                obj.setNombrec(nombrec);
                obj.setDescripcionc(descripcionc);
                obj.setImagenc(imagenc);

                //Actualizar el objeto en la base de datos
                return(DATOS.actualizar(obj))?"OK":"Error al actualizar el registro";
        }
        else{
        // Verificar si existe la categoria
            if(DATOS.existe(nombrec))
                return "El nombre de la categoria ya existe.";
            else
            {
                // Llenar el objeto
                obj.setNombrec(nombrec);
                obj.setDescripcionc(descripcionc);
                obj.setImagenc(imagenc);

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
