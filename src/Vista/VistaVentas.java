package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author danir
 */
public class VistaVentas extends JFrame {
    public DefaultTableModel dtm;//Modelo de la tabla, el cual es el predeterminado
    public JTable tabla; //Tabla
    protected Object[][] datos; //Cuerpo de la tabla
    protected String[] cabecera;    //Cabecera de la tabla
    private JPanel encabezado;
    private JPanel centro;
    private JPanel abajo;
    private JScrollPane scroll; //Panel de scroll que contiene la tabla
    private JPanel contenedor;
    private JPanel header;
    private JPanel pp;
    private JButton elegir;
    private JButton volver;

    public VistaVentas() {

        setBounds(150, 80, 1000, 600);//Dimensiones del frame
        setTitle("Venta");    //Barra de título del frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);    //Acción al pulsar salir

        //INSTANCIAR EL CONTENEDOR PRINCIPAL Y AÑADIRLO AL FRAME
        contenedor = new JPanel();
        header = new JPanel();
        pp = new JPanel();
        getContentPane().add(contenedor);
        contenedor.setBackground(Color.WHITE);
        //USAR EL LAYOUTMANAGER SpringLayout
        SpringLayout sp = new SpringLayout();
        contenedor.setLayout(sp);
        header.setLayout(sp);


        scroll = new JScrollPane();
        cabecera = new String[]{"ID Venta", "Fecha Venta", "Forma de Pago", "Monto Total"};
        dtm = new DefaultTableModel(datos, cabecera);
        tabla = new JTable(dtm);
        scroll.setViewportView(tabla);
        //se coloca el scrollpane...
        contenedor.add(scroll); //añadir al contenedor
        sp.putConstraint(SpringLayout.NORTH, scroll, 120, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, scroll, 10, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, scroll, -10, SpringLayout.EAST, contenedor);
        sp.putConstraint(SpringLayout.SOUTH, scroll, -80, SpringLayout.SOUTH, contenedor);

        JLabel titulo = new JLabel("                                              VENTAS");
        contenedor.add(titulo);
        Font fuente = new Font("Tahoma", 1, 20);
        titulo.setFont(fuente);
        sp.putConstraint(SpringLayout.NORTH, titulo, 50, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, titulo, 150, SpringLayout.WEST, contenedor);

        contenedor.add(header);
        header.setBackground(Color.BLACK);
        sp.putConstraint(SpringLayout.NORTH, header, 0, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, header, 0, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.SOUTH, header, -520, SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.EAST, header, 0, SpringLayout.EAST, contenedor);

        contenedor.add(pp);
        pp.setBackground(Color.BLACK);
        sp.putConstraint(SpringLayout.NORTH, pp, 520, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, pp, 0, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.SOUTH, pp, 0, SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.EAST, pp, 0, SpringLayout.EAST, contenedor);

        JLabel iconopr = new JLabel();
        ImageIcon logo = new ImageIcon("src/Imagenes/rayo.png");
        Icon logopr = new ImageIcon(logo.getImage().getScaledInstance(90, 60, Image.SCALE_DEFAULT));
        iconopr.setIcon(logopr);
        header.add(iconopr);
        sp.putConstraint(SpringLayout.NORTH, iconopr, 0, SpringLayout.NORTH, header);
        sp.putConstraint(SpringLayout.WEST, iconopr, 1, SpringLayout.WEST, header);
        
        /*elegir =new JButton("Ventas");
        contenedor.add(elegir);
        elegir.setBackground(Color.BLACK);
        elegir.setForeground(Color.pink);
        sp.putConstraint(SpringLayout.NORTH, elegir, 490, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST,elegir,  150, SpringLayout.WEST, contenedor);*/


        volver = new JButton("Volver");
        contenedor.add(volver);
        volver.setBackground(Color.BLACK);
        volver.setForeground(Color.pink);
        sp.putConstraint(SpringLayout.NORTH, volver, 490, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, volver, 350, SpringLayout.WEST, contenedor);

        this.setVisible(true);
    }
    public void conectarControladorVolver(ActionListener ac){
        volver.addActionListener(ac);
    }
}