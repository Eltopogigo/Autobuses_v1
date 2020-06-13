package Modelo;

public class Cliente extends Persona {
    private int idCliente;
    private String nickname;
    private String password;
    private String noTarjeta;
    private String fechaNac;
    private char sexo;
    public Cliente(String nombre, String apellidopaterno, String apellidomaterno, int edad,String nickname, String pasword, String noTarjeta, String fechaNac, char sexo){
        super(nombre, apellidopaterno, apellidomaterno, edad);
        idCliente=0;
        this.nickname=nickname;
        this.password= pasword;
        this.fechaNac= fechaNac;
        this.noTarjeta=noTarjeta;
        this.sexo=sexo;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getNoTarjeta() {
        return noTarjeta;
    }

    public void setNoTarjeta(String noTarjeta) {
        this.noTarjeta = noTarjeta;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
