/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import Datos.UsuariosDAO;
import Entidades.Usuarios;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author juanp
 */
public class UsuarioControl {
    private final UsuariosDAO DATOS;
    private Usuarios obj;
    private DefaultTableModel modeloTabla;
    private int registrosMostrados;

    public UsuarioControl() {
        DATOS = new UsuariosDAO();
        obj=new Usuarios();
        registrosMostrados=0;
        
    }
    
    public DefaultTableModel listar(String texto){
        List <Usuarios> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));
        
        //Crear el modelo y establecer los títulos del modelo
        String titulos[]={"ID Usuario", "Nombre Usuario", "Correo", "Contraseña", "Rol", "Estado"};
        modeloTabla=new DefaultTableModel(null,titulos);
        
        // Recorrer los elementos de la lista con for each
        String registro []= new String[9];
        registrosMostrados=0;
        for(Usuarios item: lista){
            registro[0] = ""+item.getCVEUSUARIO();
            registro[1] = item.getNombreu();
            registro[2] = item.getCorreou();
            registro[3] = item.getContraseñau();
            registro[4] = item.getRol();
            registro[5] = item.getEstado();
            
            //Insertar el registro en el modelo
            modeloTabla.addRow(registro);
            registrosMostrados+=1;
        }
        return modeloTabla;
    }
    // lista de usuarios solo por nombre, correo, rol y estado
    public DefaultTableModel listar2(String texto){
        List <Usuarios> lista = new ArrayList();
        lista.addAll(DATOS.listar2(texto));
        
        //Crear el modelo y establecer los títulos del modelo
        String titulos[]={"Nombre Usuario", "Correo", "Rol", "Estado"};
        modeloTabla=new DefaultTableModel(null,titulos);
        
        // Recorrer los elementos de la lista con for each
        String registro []= new String[9];
        registrosMostrados=0;
        for(Usuarios item: lista){
            registro[0] = item.getNombreu();
            registro[1] = item.getCorreou();
            registro[2] = item.getRol();
            registro[3] = item.getEstado();
            
            //Insertar el registro en el modelo
            modeloTabla.addRow(registro);
            registrosMostrados+=1;
        }
        return modeloTabla;
    }
    // lista de usuarios solo por nombre, correo, rol
    public DefaultTableModel listar3(String texto){
        List <Usuarios> lista = new ArrayList();
        lista.addAll(DATOS.listar3(texto));
        
        //Crear el modelo y establecer los títulos del modelo
        String titulos[]={"Nombre Usuario", "Correo", "Rol"};
        modeloTabla=new DefaultTableModel(null,titulos);
        
        // Recorrer los elementos de la lista con for each
        String registro []= new String[9];
        registrosMostrados=0;
        for(Usuarios item: lista){
            registro[0] = item.getNombreu();
            registro[1] = item.getCorreou();
            registro[2] = item.getRol();
            
            //Insertar el registro en el modelo
            modeloTabla.addRow(registro);
            registrosMostrados+=1;
        }
        return modeloTabla;
    }
    public String insertar(String nombreUsuario, String Correou, String contrasena, String rol){
    // Verificar si existe la categoria
        if(DATOS.existe(nombreUsuario))
            return "El registro ya existe.";
        else
        {
            // Llenar el objeto
            obj.setNombreu(nombreUsuario);
            obj.setCorreou(Correou);
            obj.setContraseñau(contrasena);
            obj.setRol(rol);
            obj.setEstado("Activo");
            
            
            //Insertar el objeto en la base de datos
            return (DATOS.insertar(obj))?"OK":"Error al insertar el registro";
        }
    }
    
    public String actualizar(int idUsuario, String nombreu, String nombreAnterior, String correo,  String contrasena, String rol){
        if(nombreu.equals(nombreAnterior))
        {
            obj.setCVEUSUARIO(idUsuario);
            obj.setNombreu(nombreu);
            obj.setCorreou(correo);
            obj.setContraseñau(contrasena);
            obj.setRol(rol);
            
            if(DATOS.actualizar(obj))
                return "OK";
            else
                return "Error al actualizar el registro.";
        }
        else
        {
            if(DATOS.existe(nombreu))
                return "El usuario ya existe.";
            else
            {
                obj.setNombreu(nombreu);
            obj.setCorreou(correo);
            obj.setContraseñau(contrasena);
            obj.setRol(rol);
                if(DATOS.actualizar(obj))
                    return "OK.";
                else
                    return "Error al actualizar el registro.";
            }
        }
    }
    
    public String eliminar(int id){
        return(DATOS.eliminar(id))?"OK":"No se pudo desactivar el registro";
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
    
    public String [] Logear(String texto, String texto2){
        List <Usuarios> lista = new ArrayList();
        lista.addAll(DATOS.Logear(texto,texto2));
        String registro []= new String[2];
        for(Usuarios item:lista){
            registro[0]=""+item.getCVEUSUARIO();
            registro[1]=item.getRol();
        }
        return registro;
    }
    
}
