package Modelo;

public class Terminal {
    private int idTerminal;
    private String nombre;
    private String direccion;
    private String localidad;
    private String estado;

    public Terminal(){}
    public Terminal(int id,String n,String d,String l,String e){
        idTerminal=id;
        nombre=n;
        direccion=d;
        localidad=l;
        estado=e;
    }

    public void setIdTerminal(int id){
        idTerminal=id;
    }

    public int getIdTerminal(){
        return idTerminal;
    }

    public void setNombre(String n){
        nombre=n;
    }

    public String getNombre(){
        return nombre;
    }

    public void setDireccion(String n){
        direccion=n;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setLocalidad(String n){
        localidad=n;
    }

    public String getLocalidad(){
        return localidad;
    }

    public void setEstado(String n){
        estado=n;
    }

    public String getEstado(){
        return estado;
    }
}
