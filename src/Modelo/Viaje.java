package Modelo;

public class Viaje {
    private int idViaje;
    private  String horaSalida;
    private String fechaSalida;
    private int idTerminalSalida;
    private int getIdTerminalLlegada;
    private int horasDuracion;
    private int idAutobus;
    private int idEmpleado;

    public Viaje() {
    }

    public Viaje( String horaSalida, String fechaSalida, int idTerminalSalida, int getIdTerminalLlegada, int horasDuracion, int idAutobus, int idEmpleado) {
        this.idViaje = 0;
        this.horaSalida = horaSalida;
        this.fechaSalida = fechaSalida;
        this.idTerminalSalida = idTerminalSalida;
        this.getIdTerminalLlegada = getIdTerminalLlegada;
        this.horasDuracion = horasDuracion;
        this.idAutobus = idAutobus;
        this.idEmpleado = idEmpleado;
    }

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getIdTerminalSalida() {
        return idTerminalSalida;
    }

    public void setIdTerminalSalida(int idTerminalSalida) {
        this.idTerminalSalida = idTerminalSalida;
    }

    public int getGetIdTerminalLlegada() {
        return getIdTerminalLlegada;
    }

    public void setGetIdTerminalLlegada(int getIdTerminalLlegada) {
        this.getIdTerminalLlegada = getIdTerminalLlegada;
    }

    public int getHorasDuracion() {
        return horasDuracion;
    }

    public void setHorasDuracion(int horasDuracion) {
        this.horasDuracion = horasDuracion;
    }

    public int getIdAutobus() {
        return idAutobus;
    }

    public void setIdAutobus(int idAutobus) {
        this.idAutobus = idAutobus;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}
