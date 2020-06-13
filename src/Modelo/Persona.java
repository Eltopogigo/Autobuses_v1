package Modelo;

public class Persona {
    private int identificador;
    private String nombre;
    private String apellidopaterno;
    private String apellidomaterno;
    private int edad;

    public Persona(String nombre, String apellido1, String apellido2, int edad){
        this.identificador=0;
        this.nombre=nombre;
        this.apellidopaterno=apellido1;
        this.apellidomaterno=apellido2;
        this.edad=edad;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellidopaterno;
    }

    public void setApellido1(String apellido1) {
        this.apellidopaterno= apellido1;
    }

    public String getApellido2() {return apellidomaterno; }

    public void setApellido2(String apellido2) {
        this.apellidomaterno = apellido2;
    }

    public int getEdad() { return edad; }

    public void setEdad(int edad) { this.edad = edad; }
}
