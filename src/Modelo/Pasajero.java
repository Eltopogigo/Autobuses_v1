package Modelo;

public class Pasajero extends Persona {
    private int idPasajero;
    private String status;

    public Pasajero(String nombre, String apellido1, String apellido2, int edad, String status){
        super(nombre, apellido1, apellido2, edad);
        this.idPasajero=0;
        this.status=status;
    }

    public Pasajero() {
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public String getStatus() { return status; }

    public void setStatus(String status) {
        this.status = status;
    }
}
