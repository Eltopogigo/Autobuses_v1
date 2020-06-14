package Modelo;

public class Boleto {
    private int idBoleto;
    private  int noAsiento;
    private double precio;
    private int idPasajero;
    private int idViaje;

    public Boleto(int noAsiento, double precio, int idPasajero, int idViaje) {
        this.idBoleto = 0;
        this.noAsiento = noAsiento;
        this.precio = precio;
        this.idPasajero = idPasajero;
        this.idViaje = idViaje;
    }

    public Boleto() {
    }

    public int getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(int idBoleto) {
        this.idBoleto = idBoleto;
    }

    public int getNoAsiento() {
        return noAsiento;
    }

    public void setNoAsiento(int noAsiento) {
        this.noAsiento = noAsiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }
}
