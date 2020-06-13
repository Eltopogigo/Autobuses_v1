package Modelo;

public class Empleado extends Persona {
    private int idEmpleado;
    private  String rfc;
    private String puesto;
    private String fechaContratación;
    private String fechaNacEmp;

    public Empleado(String nombre, String apellidopaterno, String apellidomaterno,int edad, String rfc, String idPuesto, String fechaContratación, String fechaNacEmp) {
        super(nombre, apellidopaterno, apellidomaterno, edad);
        idEmpleado=0;
        this.rfc=rfc;
        this.puesto=idPuesto;
        this.fechaContratación=fechaContratación;
        this.fechaNacEmp=fechaNacEmp;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getPuesto() { return puesto; }

    public void setPuesto(String puesto) { this.puesto = puesto; }

    public String getFechaContratación() {
        return fechaContratación;
    }

    public void setFechaContratación(String fechaContratación) {
        this.fechaContratación = fechaContratación;
    }

    public String getFechaNacEmp() {
        return fechaNacEmp;
    }

    public void setFechaNacEmp(String fechaNacEmp) {
        this.fechaNacEmp = fechaNacEmp;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}
