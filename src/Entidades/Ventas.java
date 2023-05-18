package Entidades;

public class Ventas {
    private int cveUsuario;
    private int cveProducto;
    private int cveVentas;
    private double subTotalB;
    private double IVAV;
    private String fechaV;
    private int canProVen;

    public Ventas() {
    }

    public Ventas(int cveVentas, double subTotalB, double IVAV, String fechaV) {
        this.cveVentas = cveVentas;
        this.subTotalB = subTotalB;
        this.IVAV = IVAV;
        this.fechaV = fechaV;
    }

    public Ventas(int cveUsuario, int cveProducto, int cveVentas, double subTotalB, double IVAV, String fechaV) {
        this.cveUsuario = cveUsuario;
        this.cveProducto = cveProducto;
        this.cveVentas = cveVentas;
        this.subTotalB = subTotalB;
        this.IVAV = IVAV;
        this.fechaV = fechaV;
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

    public int getCveVentas() {
        return cveVentas;
    }

    public void setCveVentas(int cveVentas) {
        this.cveVentas = cveVentas;
    }

    public double getSubTotalB() {
        return subTotalB;
    }

    public void setSubTotalB(double subTotalB) {
        this.subTotalB = subTotalB;
    }

    public double getIVAV() {
        return IVAV;
    }

    public void setIVAV(double IVAV) {
        this.IVAV = IVAV;
    }

    public String getFechaV() {
        return fechaV;
    }

    public void setFechaV(String fechaV) {
        this.fechaV = fechaV;
    }

    public int getCanProVen() {
        return canProVen;
    }

    public void setCanProVen(int canProVen) {
        this.canProVen = canProVen;
    }

    @Override
    public String toString() {
        return "Ventas{" + "cveUsuario=" + cveUsuario + ", cveProducto=" + cveProducto + ", cveVentas=" + cveVentas + ", subTotalB=" + subTotalB + ", IVAV=" + IVAV + ", fechaV=" + fechaV + ", canProVen=" + canProVen + '}';
    }
}
