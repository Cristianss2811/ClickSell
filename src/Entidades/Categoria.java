/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author crist
 */
public class Categoria {
    private int cvecategoria;
    private String nombrec;
    private String descripcionc;
    private String imagenc;
    private String estado;

    public Categoria() {
    }
    
    public Categoria(int cvecategoria, String nombrec){
        
    }

    public Categoria(int cvecategoria, String nombrec, String descripcionc, String imagenc, String estado) {
        this.cvecategoria = cvecategoria;
        this.nombrec = nombrec;
        this.descripcionc = descripcionc;
        this.imagenc = imagenc;
        this.estado = estado;
    }

    public int getCvecategoria() {
        return cvecategoria;
    }

    public void setCvecategoria(int cvecategoria) {
        this.cvecategoria = cvecategoria;
    }

    public String getNombrec() {
        return nombrec;
    }

    public void setNombrec(String nombrec) {
        this.nombrec = nombrec;
    }

    public String getDescripcionc() {
        return descripcionc;
    }

    public void setDescripcionc(String descripcionc) {
        this.descripcionc = descripcionc;
    }

    public String getImagenc() {
        return imagenc;
    }

    public void setImagenc(String imagenc) {
        this.imagenc = imagenc;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

    @Override
    public String toString() {
        return "Categoria{" + "cvecategoria=" + cvecategoria + ", nombrec=" + nombrec + ", descripcionc=" + descripcionc + ", imagenc=" + imagenc + ", estado=" + estado + '}';
    }
    
}
