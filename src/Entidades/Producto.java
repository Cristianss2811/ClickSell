/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author crist
 */
public class Producto {
    private int cveProducto;
    private int cveCategoria;
    private String nombre;
    private String descripcion;
    private String imgProducto;
    private double precioVenta;
    private int existencia;
    private double precioCompra;
    private double ganancia;
    private String estado;
    
     public Producto() {
        
    }

    public Producto(int cveProducto, String nombre, double precioVenta, int existencia, double precioCompra, double ganancia) {
        this.cveProducto = cveProducto;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.existencia = existencia;
        this.precioCompra = precioCompra;
        this.ganancia = ganancia;
    }

    public Producto(int cveProducto, int cveCategoria, String nombre, String descripcion, String imgProducto, double precioVenta, int existencia, double precioCompra, double ganancia, String estado) {
        this.cveProducto = cveProducto;
        this.cveCategoria = cveCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imgProducto = imgProducto;
        this.precioVenta = precioVenta;
        this.existencia = existencia;
        this.precioCompra = precioCompra;
        this.ganancia = ganancia;
        this.estado = estado;
    }

   
    public int getCveProducto() {
        return cveProducto;
    }

    public void setCveProducto(int cveProducto) {
        this.cveProducto = cveProducto;
    }

    public int getCveCategoria() {
        return cveCategoria;
    }

    public void setCveCategoria(int cveCategoria) {
        this.cveCategoria = cveCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImgProducto() {
        return imgProducto;
    }

    public void setImgProducto(String imgProducto) {
        this.imgProducto = imgProducto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getGanancia() {
        return ganancia;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

    

    @Override
    public String toString() {
        return "Producto{" + "cveProducto=" + cveProducto + ", cveCategoria=" + cveCategoria + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imgProducto=" + imgProducto + ", precioVenta=" + precioVenta + ", existencia=" + existencia + ", precioCompra=" + precioCompra + ", ganancia=" + ganancia + ", estado=" + estado + '}';
    }
    
    
    
}
