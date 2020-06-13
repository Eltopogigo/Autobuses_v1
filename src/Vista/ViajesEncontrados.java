package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Laura
 */
public class ViajesEncontrados extends JFrame{
    private JPanel encabezado;
    private JPanel centro;
    private JPanel abajo;
    private JScrollPane scroll; //Panel de scroll que contiene la tabla
    protected Object[][] datos; //Cuerpo de la tabla
    protected String[] cabecera;    //Cabecera de la tabla
    public DefaultTableModel dtm;//Modelo de la tabla, el cual es el predeterminado
    public JTable tabla; //Tabla
    private JPanel contenedor;
    private JPanel header;
    private JPanel pp;
    private JButton elegir;
    private JButton volver;

    public ViajesEncontrados(){

        setBounds(150, 80, 1000, 600);//Dimensiones del frame
        setTitle("Viajes Encontrados");    //Barra de título del frame
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);    //Acción al pulsar salir

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



        scroll      = new JScrollPane();
        cabecera    = new String[] {"ID Viaje","Hora Salida","Fecha"};
        dtm         = new DefaultTableModel(datos,cabecera);
        tabla       = new JTable(dtm);
        scroll.setViewportView(tabla);
        //se coloca el scrollpane...
        contenedor.add(scroll); //añadir al contenedor
        sp.putConstraint(SpringLayout.NORTH, scroll, 120, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, scroll,   10, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, scroll,  -10, SpringLayout.EAST, contenedor);
        sp.putConstraint(SpringLayout.SOUTH, scroll, -80, SpringLayout.SOUTH, contenedor);

        JLabel titulo          = new JLabel("Resultado de tu busqueda");
        contenedor.add(titulo);
        Font fuente = new Font("Tahoma",1,20);
        titulo.setFont(fuente);
        sp.putConstraint(SpringLayout.NORTH, titulo, 50, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST,titulo,  150, SpringLayout.WEST, contenedor);

        contenedor.add(header);
        header.setBackground(Color.BLACK);
        sp.putConstraint(SpringLayout.NORTH, header, 0, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST,header,  0, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.SOUTH, header, -520, SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.EAST,header,  0, SpringLayout.EAST, contenedor);

        contenedor.add(pp);
        pp.setBackground(Color.BLACK);
        sp.putConstraint(SpringLayout.NORTH, pp, 520, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST,pp,  0, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.SOUTH,pp, 0, SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.EAST,pp,  0, SpringLayout.EAST, contenedor);

        JLabel iconopr = new JLabel();
        ImageIcon logo =new ImageIcon("src/Imagenes/rayo.png");
        Icon logopr = new ImageIcon(logo.getImage().getScaledInstance(90,60,Image.SCALE_DEFAULT));
        iconopr.setIcon(logopr);
        header.add(iconopr);
        sp.putConstraint(SpringLayout.NORTH, iconopr, 0, SpringLayout.NORTH, header);
        sp.putConstraint(SpringLayout.WEST,iconopr,  1, SpringLayout.WEST, header);

        elegir =new JButton("Elegir Viaje");
        contenedor.add(elegir);
        elegir.setBackground(Color.BLACK);
        elegir.setForeground(Color.pink);
        sp.putConstraint(SpringLayout.NORTH, elegir, 490, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST,elegir,  150, SpringLayout.WEST, contenedor);


        volver =new JButton("Volver");
        contenedor.add(volver);
        volver.setBackground(Color.BLACK);
        volver.setForeground(Color.pink);
        sp.putConstraint(SpringLayout.NORTH,volver, 490, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST,volver,  350, SpringLayout.WEST, contenedor);

        this.setVisible(true);
    }
    public void conectarControladorVolver(ActionListener ac){
        volver.addActionListener(ac);
    }

}