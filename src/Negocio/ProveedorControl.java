/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import Datos.ProveedorDAO;
import Entidades.Proveedor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author juanp
 */
public class ProveedorControl {
    private final ProveedorDAO DATOS;
    private Proveedor obj;
    private DefaultTableModel modeloTabla;
    private int registrosMostrados;

    public ProveedorControl() {
        DATOS = new ProveedorDAO();
        obj=new Proveedor();
        registrosMostrados=0;
    }
    
     public DefaultTableModel listar(String texto){
        List <Proveedor> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));
        
        //Crear el modelo y establecer los títulos del modelo
        String titulos[]={"Clave Proveedor", "Nombre Proveedor", "telefono", "localidad", "Estado P","Empresa", "Estado"};
        modeloTabla=new DefaultTableModel(null,titulos);
        
        // Recorrer los elementos de la lista con for each
        String registro []= new String[9];
        registrosMostrados=0;
        for(Proveedor item: lista){
            registro[0] = ""+item.getCVEPROVEEDORES();
            registro[1] = item.getNombrep();
            registro[2] = item.getTelp();
            registro[3] = item.getLocalidadp();
            registro[4] = item.getEstadop();
            registro[5] = item.getEmpresap();
            registro[6] = item.getEstado();
            
            //Insertar el registro en el modelo
            modeloTabla.addRow(registro);
            registrosMostrados+=1;
        }
        return modeloTabla;
    }
     
    public List <Proveedor> obtenerProveedores(String texto){
        return DATOS.listar(texto);
    }
    
    public String insertar(String nombrePro, String Telp, String localidad, String estado,String empresa){
    // Verificar si existe la categoria
        if(DATOS.existe(nombrePro))
            return "El registro ya existe.";
        else
        {
            // Llenar el objeto
            obj.setNombrep(nombrePro);
            obj.setTelp(Telp);
            obj.setLocalidadp(localidad);
            obj.setEstadop(estado);
            obj.setEmpresap(empresa);
            obj.setEstado("Activo");
            
            
            //Insertar el objeto en la base de datos
            return (DATOS.insertar(obj))?"OK":"Error al insertar el registro";
        }
    }
    
    public String actualizar(int clave, String nombrePro,String nombreanterior, String Telp, String localidad, String estado,String empresa){
        if(nombrePro.equals(nombreanterior))
        {
            obj.setCVEPROVEEDORES(clave);
            obj.setNombrep(nombrePro);
            obj.setTelp(Telp);
            obj.setLocalidadp(localidad);
            obj.setEstadop(estado);
            obj.setEmpresap(empresa);
            
            if(DATOS.actualizar(obj))
                return "OK";
            else
                return "Error al actualizar el registro.";
        }
        else
        {
            if(DATOS.existe(nombrePro))
                return "El usuario ya existe.";
            else
            {
                obj.setNombrep(nombrePro);
            obj.setTelp(Telp);
            obj.setLocalidadp(localidad);
            obj.setEstadop(estado);
            obj.setEmpresap(empresa);
                if(DATOS.actualizar(obj))
                    return "OK.";
                else
                    return "Error al actualizar el registro.";
            }
        }
    }
    
    public String Desactivar(int id) {
        if (DATOS.desactivar(id)) {
            return "OK";
        } else {
            return "No se pudo desactivar el registro";
        }
    }
    
     public int total() {
        return DATOS.total();
    }
}
