package Negocio;

import Datos.ComprasDAO;
import Entidades.Compras;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.table.DefaultTableModel;

public class ComprasControl {
    private final ComprasDAO DATOS;
    private Compras obj;
    private DefaultTableModel modeloTabla;
    private int registrosMostrados;
    
    
    public ComprasControl(){
        DATOS = new ComprasDAO();
        obj = new Compras();
        registrosMostrados = 0;
    }
    
    public DefaultTableModel listar(String texto){
        List<Compras> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));
        
        String titulos[] ={"Clave de compra", "Monto de compra", "Fecha de compra"};
        modeloTabla = new DefaultTableModel(null, titulos);
        
        String registro[] = new String[3];
        registrosMostrados = 0;
        for(Compras item: lista){
            registro[0] = ""+item.getCveCompras();
            registro[1] = ""+item.getTotalC();
            registro[2] = item.getFechaC();
            
            modeloTabla.addRow(registro);
            registrosMostrados+=1;
        }
        return modeloTabla;
    }
    
    public String insertar(int cveProveedores, int cveUsuario){
        obj.setCveProveedores(cveProveedores);
        obj.setCveUsuario(cveUsuario);
        return (DATOS.insertar(obj))?"OK":"Error al insertar la compra";
    }
    
    public String insertarDetalle(int cveProducto, int canProCom, double precioCompra, double ganancia){
        obj.setCveProducto(cveProducto);
        obj.setCanProCom(canProCom);
        return (DATOS.insertarDetalle(obj, precioCompra, ganancia))?"OK":"Error al insertar el detalle de la compra";
    }
}