package Controlador;

import Modelo.Viaje;
import Modelo.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JPanel;

import Vista.*;

/**
 *
 * @author Laura
 */
public class Controlador {
    BusquedaViajes busqueda;
    VentanaMonitoreo mon;
    ViajesEncontrados ve;
    VistaPrincipal vp;
    Conexion c;
    ViajeSeleccionado vb;
    EmpleadoLogin vemp;

    public Controlador(VistaPrincipal vp, Conexion conexion) {
        this.vp = vp;
        c = conexion;
        c.ConexionBd();
        BuscarViajes btnBuscarViajes = new BuscarViajes();
        vp.conectarControladorBusquedaViajes(btnBuscarViajes);
        MonitoreoViajes btnMonViajes = new MonitoreoViajes();
        vp.conectarControladorMonitoreoViajes(btnMonViajes);
        Login l = new Login();
        vp.conectarControladorRegistar(l);
    }


    class Buscar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ve = new ViajesEncontrados();
            cargarTabla();
            VolverResultadosBusqueda btnVolver = new VolverResultadosBusqueda();
            ve.conectarControladorVolver(btnVolver);
            ComprarBoletos cv = new ComprarBoletos();
            ve.conectarControladorElegir(cv);
        }
    }

    class BuscarViajes implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            busqueda = new BusquedaViajes();
            cargarDestinoYOrigen();
            Buscar btnBuscar = new Buscar();
            VolverBusqueda btnVolver = new VolverBusqueda();
            busqueda.conectarControladorVolver(btnVolver);
            busqueda.conectarControlador(btnBuscar);

        }
    }
    class Login implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            vemp = new EmpleadoLogin();
        }
    }

    class ComprarBoletos implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //int totalAs = c.obtenerNumAsientos();
            vb = new ViajeSeleccionado();
            CerrarBoletos btnVolver=new CerrarBoletos();
            vb.conectarComprar(btnVolver);
        }
    }

    class CerrarBoletos implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            vb.dispose();
        }
    }

    class MonitoreoViajes implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            mon = new VentanaMonitoreo();
            cargarEstados();
            MonBuscar mBuscar = new MonBuscar();
            restablecerMonitoreo ResMon = new restablecerMonitoreo();
            mon.conectarControladorBuscar(mBuscar);
            mon.concectarControladorRestablecer(ResMon);
        }
    }

    class MonBuscar implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            cargaranim();
            mon.central.updateUI();
        }
    }

    class VolverResultadosBusqueda implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ve.dispose();

        }
    }

    class VolverBusqueda implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            busqueda.dispose();

        }
    }
    class restablecerMonitoreo implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            mon.central.removeAll();
            mon.central.updateUI();
        }
    }
    class tabla implements MouseListener
    {
        Viaje viaje = null;

        @Override
        public void mouseClicked(MouseEvent e) {
            //Recoger qué fila se ha pulsadao en la tabla
            int filaPulsada = ve.tabla.getSelectedRow();
            //Si se ha pulsado una fila
            if(filaPulsada>=0){
                //Se recoge el id de la fila marcada
                Viaje v = new Viaje();
                int id=  (Integer) ve.dtm.getValueAt(filaPulsada, 0);
                v.setIdViaje(id);
                Viaje c2 = (c.selectViaje(v));
                if (c2 != null){
                    viaje=c2;
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public void cargarDestinoYOrigen() {
        busqueda.OrigenYDestino(c.consultaTerminal());
    }

    public void cargarEstados() {
        mon.estados(c.consultaEstados());
    }

    protected void cargarTabla() {
        Vector<Object> fila;
        //Limpiar los datos de la tabla
        for (int i = this.ve.dtm.getRowCount(); i > 0; i--) {
            this.ve.dtm.removeRow(i - 1);
        }
        ArrayList<Integer> ar = c.idTerminales(busqueda.getOrigen(), busqueda.getDestino());

        // Listado de los clientes que retornó el modelo
        ArrayList<Viaje> viajes = c.listViajes(ar.get(0), ar.get(1));
        for (Viaje c : viajes) {
            //Añadir registro a registro en el vector
            fila = new Vector<Object>();
            fila.add(c.getIdViaje());
            fila.add(c.getHoraSalida());
            fila.add(c.getFechaSalida());
            //Añadir el vector a la tabla de la clase View
            this.ve.dtm.addRow(fila);
        }
    }

    public void cargaranim() {
        int terminal = c.idTerminal(mon.getDestino());
        ArrayList<Viaje> vi = c.listViajes(terminal);
        System.out.println(terminal);
        for (JPanel pan : mon.panAnim(vi.size())) {
            mon.central.add(pan);
        }
        for (Viaje via : vi) {
            System.out.println(via.getHorasDuracion());
        }
    }
}