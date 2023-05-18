/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author juanp
 */
public class Usuarios {

    private int CVEUSUARIO;
    private String nombreu;
    private String correou;
    private String contraseñau;
    private String rol;
    private String estado;

    public Usuarios() {
    }

    public Usuarios(int CVEUSUARIO, String nombreu, String correou, String contraseñau, String rol, String estado) {
        this.CVEUSUARIO = CVEUSUARIO;
        this.nombreu = nombreu;
        this.correou = correou;
        this.contraseñau = contraseñau;
        this.rol = rol;
        this.estado = estado;
    }

    public Usuarios(int CVEUSUARIO, String rol) {
        this.CVEUSUARIO = CVEUSUARIO;
        this.rol = rol;
    }

    public Usuarios(int CVEUSUARIO, String nombreu, String correou, String contraseñau, String rol) {
        this.CVEUSUARIO = CVEUSUARIO;
        this.nombreu = nombreu;
        this.correou = correou;
        this.contraseñau = contraseñau;
        this.rol = rol;
    }

    public Usuarios(String nombreu, String correou, String rol, String estado) {
        this.nombreu = nombreu;
        this.correou = correou;
        this.rol = rol;
        this.estado = estado;
    }
    
    public Usuarios(String nombreu, String correou, String rol) {
        this.nombreu = nombreu;
        this.correou = correou;
        this.rol = rol;
    }
    public int getCVEUSUARIO() {
        return CVEUSUARIO;
    }

    public void setCVEUSUARIO(int CVEUSUARIO) {
        this.CVEUSUARIO = CVEUSUARIO;
    }

    public String getNombreu() {
        return nombreu;
    }

    public void setNombreu(String nombreu) {
        this.nombreu = nombreu;
    }

    public String getCorreou() {
        return correou;
    }

    public void setCorreou(String correou) {
        this.correou = correou;
    }

    public String getContraseñau() {
        return contraseñau;
    }

    public void setContraseñau(String contraseñau) {
        this.contraseñau = contraseñau;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "CVEUSUARIO=" + CVEUSUARIO + ", nombreu=" + nombreu + ", correou=" + correou + ", contrase\u00f1au=" + contraseñau + ", rol=" + rol + ", estado=" + estado + '}';
    }

}
