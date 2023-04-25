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
        String titulos[]={"Clave","Nombre","Descripción","Imagen"};
        modeloTabla=new DefaultTableModel(null,titulos);
        
        // Recorrer los elementos de la lista con for each
        String registro []= new String[5];
        registrosMostrados=0;
        for(Categoria item: lista){
            registro[0] = ""+item.getCvecategoria();
            registro[1] = item.getNombrec();
            registro[2] = item.getDescripcionc();
            registro[3] = item.getImagenc();
            //registro[4] = (item.isActivoCategoria())?"Activo":"Inactivo";
            
            //Insertar el registro en el modelo
            modeloTabla.addRow(registro);
            registrosMostrados+=1;
        }
        return modeloTabla;
    }
    
    
}
