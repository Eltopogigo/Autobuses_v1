package Modelo;

public class VentaBoleto {
    private int idVenta;
    private int idBoleto;

    public VentaBoleto(int idVenta, int idBoleto) {
        this.idVenta = idVenta;
        this.idBoleto = idBoleto;
    }

    public VentaBoleto() {
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(int idBoleto) {
        this.idBoleto = idBoleto;
    }
}
