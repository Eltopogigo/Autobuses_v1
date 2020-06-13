package Prueba;
import Controlador.Controlador;
import Modelo.Conexion;
import Vista.BusquedaViajes;
import Vista.VistaPrincipal;


/**
 *
 * @author Laura
 */
public class Prueba {
    public static void main(String arg[]){
        Conexion con=new Conexion("dbAutobuses");
        VistaPrincipal vp=new VistaPrincipal();
        Controlador controlador =new Controlador(vp,con);
    }
}
