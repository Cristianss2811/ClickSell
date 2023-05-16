package Entidades;

public class Compras {
    private int cveProveedores;
    private int cveUsuario;
    private int cveProducto;
    private int cveCompras;
    private int canProCom;
    private double totalC;
    private String fechaC;
    
    public Compras(){
        
    }

    public Compras(int cveCompras, double totalC, String fechaC) {
        this.cveCompras = cveCompras;
        this.totalC = totalC;
        this.fechaC = fechaC;
    }

    public Compras(int cveProveedores, int cveUsuario, int cveProducto, int cveCompras, double totalC, String fechaC) {
        this.cveProveedores = cveProveedores;
        this.cveUsuario = cveUsuario;
        this.cveProducto = cveProducto;
        this.cveCompras = cveCompras;
        this.totalC = totalC;
        this.fechaC = fechaC;
    }

    public int getCanProCom() {
        return canProCom;
    }

    public void setCanProCom(int canProCom) {
        this.canProCom = canProCom;
    }

    public int getCveProveedores() {
        return cveProveedores;
    }

    public void setCveProveedores(int cveProveedores) {
        this.cveProveedores = cveProveedores;
    }

    public int getCveUsuario() {
        return cveUsuario;
    }

    public void setCveUsuario(int cveUsuario) {
        this.cveUsuario = cveUsuario;
    }

    public int getCveProducto() {
        return cveProducto;
    }

    public void setCveProducto(int cveProducto) {
        this.cveProducto = cveProducto;
    }

    public int getCveCompras() {
        return cveCompras;
    }

    public void setCveCompras(int cveCompras) {
        this.cveCompras = cveCompras;
    }

    public double getTotalC() {
        return totalC;
    }

    public void setTotalC(double totalC) {
        this.totalC = totalC;
    }

    public String getFechaC() {
        return fechaC;
    }

    public void setFechaC(String fechaC) {
        this.fechaC = fechaC;
    }

    @Override
    public String toString() {
        return "Compras{" + "cveProveedores=" + cveProveedores + ", cveUsuario=" + cveUsuario + ", cveProducto=" + cveProducto + ", cveCompras=" + cveCompras + ", canProCom=" + canProCom + ", totalC=" + totalC + ", fechaC=" + fechaC + '}';
    }
}