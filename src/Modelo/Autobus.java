package Modelo;

public class Autobus {
    private int idAutobus;
    private int numAsientos;
    private String marca;
    private String modelo;

    public Autobus( int numAsientos, String marca, String modelo){
        this.idAutobus=0;
        this.numAsientos=numAsientos;
        this.marca=marca;
        this.modelo=modelo;
    }

    public Autobus() {
    }

    public int getIdAutobus() {
        return idAutobus;
    }

    public void setIdAutobus(int idAutobus) {
        this.idAutobus = idAutobus;
    }

    public int getNumAsientos() {
        return numAsientos;
    }

    public void setNumAsientos(int numAsientos) {
        this.numAsientos = numAsientos;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
