package Modelo;

public class Venta {
    private int idVenta;
    private String fechaVenta;
    private String formaPago;
    private double monto;
    private int idEmpleado;
    private int idPersona;

    public Venta(String fechaVenta, String formaPago, double monto, int idEmpleado, int idPersona) {
        this.idVenta = 0;
        this.fechaVenta = fechaVenta;
        this.formaPago = formaPago;
        this.monto = monto;
        this.idEmpleado = idEmpleado;
        this.idPersona = idPersona;
    }

    public Venta() {
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
}
