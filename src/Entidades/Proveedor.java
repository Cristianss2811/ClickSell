/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author juanp
 */
public class Proveedor {
    private int CVEPROVEEDORES;
    private String nombrep;
    private String telp;
    private String localidadp;
    private String estadop;
    private String empresap;
    private String Estado;

    public Proveedor() {
    }

    public Proveedor(int CVEPROVEEDORES, String nombrep, String telp, String localidadp, String estadop, String empresap, String Estado) {
        this.CVEPROVEEDORES = CVEPROVEEDORES;
        this.nombrep = nombrep;
        this.telp = telp;
        this.localidadp = localidadp;
        this.estadop = estadop;
        this.empresap = empresap;
        this.Estado = Estado;
    }

    public int getCVEPROVEEDORES() {
        return CVEPROVEEDORES;
    }

    public void setCVEPROVEEDORES(int CVEPROVEEDORES) {
        this.CVEPROVEEDORES = CVEPROVEEDORES;
    }

    public String getNombrep() {
        return nombrep;
    }

    public void setNombrep(String nombrep) {
        this.nombrep = nombrep;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getLocalidadp() {
        return localidadp;
    }

    public void setLocalidadp(String localidadp) {
        this.localidadp = localidadp;
    }

    public String getEstadop() {
        return estadop;
    }

    public void setEstadop(String estadop) {
        this.estadop = estadop;
    }

    public String getEmpresap() {
        return empresap;
    }

    public void setEmpresap(String empresap) {
        this.empresap = empresap;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "CVEPROVEEDORES=" + CVEPROVEEDORES + ", nombrep=" + nombrep + ", telp=" + telp + ", localidadp=" + localidadp + ", estadop=" + estadop + ", empresap=" + empresap + ", Estado=" + Estado + '}';
    }
    
}
