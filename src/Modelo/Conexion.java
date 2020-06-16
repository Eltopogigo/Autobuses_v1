package Modelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private String host = "localhost";
    private String usuario = "postgres";
    private String clave ="123456";
    private int puerto = 5432;
    private String servidor = "";

    private String baseDatos;
    private static Connection conexion=null;

    public Conexion(String baseDatos){
        this.baseDatos=baseDatos;
        ConexionBd();
    }
    public void ConexionBd(){
        this.servidor="jdbc:postgresql://"+host+":"+ puerto+"/"+baseDatos;

        //Registrar el driver
        try {            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR AL REGISTRAR EL DRIVER "+ e);
            System.exit(0); //parar la ejecución
        }

        //Establecer la conexión con el servidor
        try {
            conexion = DriverManager.getConnection(this.servidor,
                    this.usuario, this.clave);
        } catch (SQLException e) {
            System.err.println("ERROR AL CONECTAR CON EL SERVIDOR "+e);
            System.exit(0); //parar la ejecución
        }
        System.out.println("Conectado a "+baseDatos);
    }
    //Devuelve el objeto Connection que se usará en la clase Controller
    public ArrayList<String> consultaTerminal() {
        PreparedStatement ps;
        ResultSet rs;
        String consultaSQL = "select nombre from scAutobuses.terminal;";
        ArrayList<String> terminal = new ArrayList<String>();
        try {
            ps  = conexion.prepareStatement(consultaSQL);

            rs  = ps.executeQuery();
            while(rs.next()){
                String c = new String();
                c=(rs.getString("nombre"));
                terminal.add(c);
            }
        } catch (SQLException e) {
            System.err.println("* " + e);
        }
        return terminal;
    }
    public ArrayList<Viaje> listViajes(int i, int j) {

        PreparedStatement ps;
        ResultSet rs;

        String consultaSQL = "select idviaje,horasalida,fechasalida from scAutobuses.viaje where idterminalsalida="+i+" and idterminalllegada="+j+";";

        ArrayList<Viaje> viajes = new ArrayList<Viaje>();
        try {
            ps  = conexion.prepareStatement(consultaSQL);

            rs  = ps.executeQuery();

            while(rs.next()){
                Viaje c = new Viaje();
                c.setIdViaje(rs.getInt("idviaje"));
                c.setHoraSalida(rs.getString("horasalida"));
                c.setFechaSalida(rs.getString("fechasalida"));
                viajes.add(c);
            }
        } catch (SQLException e) {
            System.err.println("* " + e);
        }
        return viajes;
    }

    public ArrayList<Integer> idTerminales(String o, String d) {
        String arg[]=o.split(",");
        String arg2[]=d.split(",");
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos
        ResultSet rs;
        String consultaSQL = "select idTerminal from scAutobuses.terminal where  nombre='"+o+"';";
        ArrayList<Integer> v = new ArrayList<Integer>();
        try {
            ps  = conexion.prepareStatement(consultaSQL);
            rs  = ps.executeQuery();
            while(rs.next()){
                int c;
                c=rs.getInt("idTerminal");
                v.add(c);
            }
            consultaSQL = "select idTerminal from scAutobuses.terminal where  nombre='"+d+"';";
            ps  = conexion.prepareStatement(consultaSQL);
            rs  = ps.executeQuery();
            while(rs.next()){
                int c;
                c=rs.getInt("idTerminal");
                v.add(c);
            }
        } catch (SQLException e) {
            System.err.println("* " + e);
        }
        return v;
    }
    public ArrayList<Viaje> listViajes(int i) {

        PreparedStatement ps;
        ResultSet rs;
        String consultaSQL = "select idviaje,horasalida,horasduracion,idterminalsalida,idterminalllegada from scAutobuses.viaje where idTerminalllegada="+i+";";

        ArrayList<Viaje> viajes = new ArrayList<Viaje>();
        try {
            ps  = conexion.prepareStatement(consultaSQL);
            rs  = ps.executeQuery();

            while(rs.next()){
                Viaje c = new Viaje();
                c.setIdViaje(rs.getInt("idviaje"));
                c.setHoraSalida(rs.getString("horasalida"));
                c.setHorasDuracion(rs.getInt("horasduracion"));
                c.setGetIdTerminalLlegada(rs.getInt("idterminalllegada"));
                c.setIdTerminalSalida(rs.getInt("idterminalsalida"));

                viajes.add(c);
            }
        } catch (SQLException e) {
            System.err.println("* " + e);
        }
        return viajes;
    }
    public ArrayList<Venta> listVentas() {

        PreparedStatement ps;
        ResultSet rs;
        String consultaSQL = "select * from scAutobuses.venta;";

        ArrayList<Venta> venta = new ArrayList<Venta>();
        try {
            ps  = conexion.prepareStatement(consultaSQL);
            rs  = ps.executeQuery();

            while(rs.next()){
                Venta c = new Venta();
                c.setIdVenta(rs.getInt("idventa"));
                c.setFechaVenta(rs.getString("fechaventa"));
                c.setFormaPago(rs.getString("formapago"));
                c.setMonto(rs.getDouble("monto"));
                c.setIdEmpleado(rs.getInt("idempleado"));
                c.setIdPersona(rs.getInt("idpersona"));

                venta.add(c);
            }
        } catch (SQLException e) {
            System.err.println("* " + e);
        }
        return venta;
    }

    public ArrayList<Terminal> consultaTerminal(int i) {
        PreparedStatement ps;
        ResultSet rs;
        String consultaSQL = "select nombre,estado from scAutobuses.terminal where idterminal =" + i + ";";

        ArrayList<Terminal> terminal = new ArrayList<Terminal>();
        try {
            ps  = conexion.prepareStatement(consultaSQL);
            rs  = ps.executeQuery();
            while(rs.next()){
                Terminal c = new Terminal();
                c.setNombre(rs.getString("nombre"));
                c.setEstado(rs.getString("estado"));
                terminal.add(c);
            }

        } catch (SQLException e) {
            System.err.println("* " + e);
        }
        return terminal;
    }
    public ArrayList<String> consultaEstados() {

        PreparedStatement ps;
        ResultSet rs;
        String consultaSQL = "select nombre from scAutobuses.terminal;";
        ArrayList<String> terminal = new ArrayList<String>();
        try {
            ps  = conexion.prepareStatement(consultaSQL);
            rs  = ps.executeQuery();
            while(rs.next()){
                String c = new String();
                c=rs.getString("nombre");
                terminal.add(c);
            }

        } catch (SQLException e) {
            System.err.println("* " + e);
        }
        return terminal;
    }
    public String consultaNombreTerminal(int i) {
        PreparedStatement ps;
        ResultSet rs;
        String consultaSQL = "select nombre from scAutobuses.terminal where idterminal="+i+";";
        String c="";
        try {
            ps  = conexion.prepareStatement(consultaSQL);
            rs  = ps.executeQuery();
            while(rs.next()){
                c = new String();
                c=rs.getString("nombre");
            }
        } catch (SQLException e) {
            System.err.println("* " + e);
        }
        return c;
    }
    public Integer idTerminal(String o) {
        int c=0;
        PreparedStatement ps;
        ResultSet rs;
        String consultaSQL = "select idTerminal from scAutobuses.terminal where  nombre='"+o+"';";
        ArrayList<Integer> v = new ArrayList<Integer>();
        try {
            ps  = conexion.prepareStatement(consultaSQL);
            rs  = ps.executeQuery();
            while(rs.next()){
                c=rs.getInt("idTerminal");
            }

        } catch (SQLException e) {
            System.err.println("* " + e);
        }
        return c;
    }
    public int obtenerNumAsientos(Viaje v) {
        PreparedStatement ps;
        ResultSet rs;
        String consultaSQL = "select numasientos from scAutobuses.autobus where  idautobus='"+v.getIdAutobus()+"';";
        int numAs = 0;
        try {
            ps  = conexion.prepareStatement(consultaSQL);
            rs  = ps.executeQuery();
            if(rs.next()){
                numAs = rs.getInt("numasientos");
            }
        }catch (SQLException ex)
        {
            ex.getStackTrace();
        }
        return numAs;
    }
    public ArrayList<Integer> obtenerAsientosOc(Viaje v) {
        PreparedStatement ps;
        ResultSet rs;
        String consultaSQL = "select noasiento from scAutobuses.boleto where  idboleto in (select idboleto from scAutobuses.viaje where idviaje ="+v.getIdViaje()+" );";
        ArrayList<Integer> asientos = null;
        try {
            ps  = conexion.prepareStatement(consultaSQL);
            rs  = ps.executeQuery();
            asientos = new ArrayList<>();
            while (rs.next()){
                asientos.add(rs.getInt("noasiento"));
            }
        }catch (SQLException ex)
        {
            ex.getStackTrace();
        }
        return asientos;
    }
    public Viaje selectViaje(Viaje v) {
        PreparedStatement ps;
        ResultSet rs;
        String consultaSQL = "select * from scAutobuses.viaje where  idviaje ="+v.getIdViaje()+" ;";
        Viaje viaje = null;
        try {
            ps  = conexion.prepareStatement(consultaSQL);
            rs  = ps.executeQuery();
            viaje = new Viaje();
            if (rs.next()){
                viaje.setIdViaje(rs.getInt("idviaje"));
                viaje.setHoraSalida(rs.getString("horasalida"));
                viaje.setFechaSalida(rs.getString("fechasalida"));
                viaje.setIdTerminalSalida(rs.getInt("idterminalsalida"));
                viaje.setGetIdTerminalLlegada(rs.getInt("idterminalllegada"));
                viaje.setHorasDuracion(rs.getInt("horasduracion"));
                viaje.setIdAutobus(rs.getInt("idautobus"));
                viaje.setIdEmpleado(rs.getInt("idempleado"));
            }
        }catch (SQLException ex)
        {
            ex.getStackTrace();
        }
        return viaje;
    }
    public void insertarBoleto(Boleto b){
        PreparedStatement ps;
        ResultSet rs;
        String consultaSQL = "insert into scAutobuses.boleto values ("+b.getNoAsiento()+","+b.getPrecio()+","+b.getIdPasajero()+","+b.getIdViaje()+");";
        Boleto bol = null;
        try {
            ps  = conexion.prepareStatement(consultaSQL);
            rs  = ps.executeQuery();
            bol = new Boleto();
            if (rs.next()){
                bol.setNoAsiento(rs.getInt("numasiento"));
                bol.setPrecio(rs.getDouble("precio"));
                bol.setIdPasajero(rs.getInt("idPasajero"));
                bol.setIdViaje(rs.getInt("idViaje"));
            }
        }catch (SQLException ex)
        {
            ex.getStackTrace();
        }
    }
    public void insertarPasajero(Pasajero b){
        PreparedStatement ps;
        ResultSet rs;
        String consultaSQL = "insert into scAutobuses.pasajero values ("+b.getNombre()+","+b.getApellido1()+","+b.getApellido2()+","+b.getEdad()+","+b.getStatus()+");";
        Pasajero bol = null;
        try {
            ps  = conexion.prepareStatement(consultaSQL);
            rs  = ps.executeQuery();
            bol = new Pasajero();
            if (rs.next()){
                bol.setNombre(rs.getString("nombre"));
                bol.setApellido1(rs.getString("apellidopaterno"));
                bol.setApellido2(rs.getString("apellidomaterno"));
                bol.setEdad(rs.getInt("edad"));
                bol.setStatus(rs.getString("status"));
            }
        }catch (SQLException ex)
        {
            ex.getStackTrace();
        }
    }
    public void insertarVenta(Venta b){
        PreparedStatement ps;
        ResultSet rs;

        String consultaSQL = "insert into scAutobuses.venta values ("+b.getFechaVenta()+","+b.getFormaPago()+","+b.getMonto()+","+b.getIdEmpleado()+","+b.getIdPersona()+");";
        Venta venta = null;
        try {
            ps  = conexion.prepareStatement(consultaSQL);
            rs  = ps.executeQuery();
            venta = new Venta();
            if (rs.next()){
                venta.setFechaVenta(rs.getString("fechaventa"));
                venta.setFormaPago(rs.getString("formapago"));
                venta.setMonto(rs.getDouble("monto"));
                venta.setIdEmpleado(rs.getInt("idempleado"));
                venta.setIdPersona(rs.getInt("idpersona"));
            }
        }catch (SQLException ex)
        {
            ex.getStackTrace();
        }
    }
}
