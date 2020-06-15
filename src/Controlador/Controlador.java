package Controlador;

import Modelo.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

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
            Tabla tabla= new Tabla();
            ve.conectarControladorTabla(tabla);
            cv.setT(tabla);
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

    class AgregarPasajero implements ActionListener{
        ArrayList<Pasajero> pas=null;
        ArrayList<Boleto> boletos=null;
        Viaje v;
        double total=0;

        public void setV(Viaje v) {
            this.v = v;
        }

        public ArrayList<Pasajero> getPas() {
            return pas;
        }

        public void setPas(ArrayList<Pasajero> pas) {
            this.pas = pas;
        }

        public ArrayList<Boleto> getBoletos() {
            return boletos;
        }

        public void setBoletos(ArrayList<Boleto> boletos) {
            this.boletos = boletos;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre, apP,apM, botonRes=vb.seleccionRadioButton();
            int edad;

            if(vb.getAgregar()==e.getSource()){
                nombre=vb.getTxtNombre().getText();
                apP=vb.getTxtApellidoP().getText();
                apM=vb.getTxtApellidoM().getText();
                edad=Integer.parseInt(vb.getEdadTxt().getText());
                Pasajero p = new Pasajero(nombre,apP,apM,edad,botonRes);
                pas.add(p);
                Boleto b= new Boleto(vb.getIndiceAsiento(),vb.calculoPrecio(botonRes),p.getIdPasajero(),v.getIdViaje());
                boletos.add(b);
            }

        }
    }
    class ConfirmarCompra implements ActionListener{
        ArrayList<Pasajero> pasajeros=null;
        ArrayList<Boleto>boletos=null;
        String ticket;
        public void setPasajeros(ArrayList<Pasajero> pasajeros) {
            this.pasajeros = pasajeros;
        }

        public void setBoletos(ArrayList<Boleto> boletos) {
            this.boletos = boletos;
        }

        public void actionPerformed(ActionEvent e) {
            try {
                if(JOptionPane.showConfirmDialog(null,"Confirmar Venta","Confirmación",JOptionPane.OK_OPTION)==0){
                    for(int i=0; i<pasajeros.size(); i++) {
                        c.insertarPasajero(pasajeros.get(i));
                        Pasajero p = pasajeros.get(i);
                        c.insertarBoleto(boletos.get(i));
                        Boleto b = boletos.get(i);
                        String aux = "" + p.getNombre() + p.getApellido1();
                        Viaje v = new Viaje();
                        v.setIdViaje(b.getIdViaje());
                        Viaje v2 = c.selectViaje(v);
                        String bol = String.format("%-Folio: 8d \n%-Asiento: 3d \n%-Precio:  6f \n%-Pasajero: 30s \n%-Origen:  15s \n%-Destino:  15s",
                                b.getIdBoleto(), b.getNoAsiento(), aux, c.consultaNombreTerminal(v2.getIdTerminalSalida()), c.consultaNombreTerminal(v.getGetIdTerminalLlegada()));
                        Writer writer = new BufferedWriter(new OutputStreamWriter(
                                new FileOutputStream("recibo.txt"), "utf-8"));
                            writer.write(bol);
                    }
                }
            } catch (Throwable ex) {
                Logger.getLogger(ViajeSeleccionado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    class ComprarBoletos implements ActionListener{
        Tabla t;
        Viaje v;
        public void setT(Tabla t) {
            this.t = t;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            v= t.getViaje();
            int totalAs = c.obtenerNumAsientos(v);
            vb = new ViajeSeleccionado(totalAs,c.obtenerAsientosOc(v));
            AgregarPasajero ap= new AgregarPasajero();
            ap.setV(v);
            vb.conectarAgregar(ap);
            ConfirmarCompra cc= new ConfirmarCompra();
            cc.setPasajeros(ap.getPas());
            cc.setBoletos(ap.getBoletos());
            vb.conectarComprar(cc);
        }

    }

    class CerrarBoletos implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            vb.dispose();
        }
    }
    class VolverMonitoreo implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            mon.dispose();

        }
    }

    class MonitoreoViajes implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            mon = new VentanaMonitoreo();
            cargarEstados();
            MonBuscar mBuscar = new MonBuscar();
            restablecerMonitoreo ResMon = new restablecerMonitoreo();
            VolverMonitoreo vol = new VolverMonitoreo();
            mon.conectarControladorBuscar(mBuscar);
            mon.concectarControladorRestablecer(ResMon);
            mon.conectarControladorVolver(vol);
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
    class Tabla implements MouseListener {
        Viaje viaje = null;

        public Viaje getViaje() {
            return viaje;
        }

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
                System.out.println(c2.toString());
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

    public JLabel datosanim(){
        int terminal=c.idTerminal(mon.getDestino());
        JLabel datos= new JLabel();
        ArrayList<Viaje> vi= c.listViajes(terminal);
        for(Viaje viaje:vi){
            ArrayList<Terminal> ter = c.consultaTerminal(terminal);
            String terminalS= ter.get(0).getNombre();
            datos=new JLabel("Id del viaje: "+viaje.getIdViaje()+"Terminal de salida: "+terminalS);//+"Termina de llegada: "+viaje.getGetIdTerminalLlegada());
        }
        return datos;
    }
    public void cargaranim(){
        Font fuente = new Font("Tahoma",1,12);
        int terminal=c.idTerminal(mon.getDestino());
        ArrayList<Viaje> vi= c.listViajes(terminal);
        JPanel panelAnimacion[] = mon.panAnim(vi.size());
        int i=0;
        for(JPanel pan:panelAnimacion){
            pan.setBackground(Color.WHITE);
            ArrayList<Terminal> ter = c.consultaTerminal(vi.get(i).getIdTerminalSalida());
            ArrayList<Terminal> ter2 = c.consultaTerminal(vi.get(i).getGetIdTerminalLlegada());
            String terminalS= ter.get(0).getNombre();
            String terminalL= ter2.get(0).getNombre();
            String formato= String.format("%-22s %-5d %-22s %-20s %-22s %-10s %-22s %-20s %-22s %-3d","Id del viaje: ",vi.get(i).getIdViaje(),"Terminal de salida: ",
                    terminalS, "Hora de salida: ", vi.get(i).getHoraSalida(), "Terminal de llegada: ", terminalL ,"Horas de duracion: " , vi.get(i).getHorasDuracion());
            JLabel datos=new JLabel(formato);
            datos.setFont(fuente);
            datos.setBounds(pan.getX()+40,pan.getY()+100,1000,90);
            pan.add(datos);
            mon.central.add(pan);
            i++;
        }

    }
}