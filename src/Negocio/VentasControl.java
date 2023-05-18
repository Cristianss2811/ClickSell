package Negocio;

import Datos.VentasDAO;
import Entidades.Ventas;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.table.DefaultTableModel;

public class VentasControl {
   private final VentasDAO DATOS;
    private Ventas obj;
    private DefaultTableModel modeloTabla;
    private int registrosMostrados;
    
    public VentasControl(){
        DATOS = new VentasDAO();
        obj = new Ventas();
        registrosMostrados = 0;
    }
    
    public DefaultTableModel listar(String texto){
        List<Ventas> lista = new ArrayList();
        lista.addAll(DATOS.Listar(texto));
        
        String titulos[] ={"Clave de Venta", "Subtotal", "IVA", "Fecha de la venta"};
        modeloTabla = new DefaultTableModel(null, titulos);
        
        String registro[] = new String[4];
        registrosMostrados = 0;
        for(Ventas item: lista){
            registro[0] = ""+item.getCveVentas();
            registro[1] = ""+item.getSubTotalB();
            registro[2] = ""+item.getIVAV();
            registro[3] = item.getFechaV();
            
            modeloTabla.addRow(registro);
            registrosMostrados+=1;
        }
        return modeloTabla;
    }
    
    public String insertar(int cveUsuario){
        obj.setCveUsuario(cveUsuario);
        return (DATOS.insertar(obj))?"OK":"Error al insertar la compra";
    }
    
    public String insertarDetalle(int cveProducto, int canProVen){
        obj.setCveProducto(cveProducto);
        obj.setCanProVen(canProVen);
        return (DATOS.insertarDetalle(obj))?"OK":"Error al insertar el detalle de la compra";
    }
}
