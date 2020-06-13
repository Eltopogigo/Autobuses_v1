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
    public Connection getConexion() {
        return conexion;
    }
    public void agregaCliente(String sql) {

        try {
            PreparedStatement ps= conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
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
        String consultaSQL = "select idviaje,horasalida,horasduracion,idterminalsalida,idterminalllegada from scAutobuses.viaje where idTerminalLlegada="+i+";";

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

    public ArrayList<Terminal> consultaTerminal(int i) {
        PreparedStatement ps;
        ResultSet rs;
        String consultaSQL = "select nombre,estado from scAutobuses.terminal where idterminalllegada =" + i + ";";

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
}
