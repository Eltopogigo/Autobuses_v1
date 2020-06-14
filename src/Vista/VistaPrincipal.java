package Vista;

import Modelo.SlideShow;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Laura
 */
public class VistaPrincipal extends JFrame{
    private JPanel contenedor;
    private JPanel header;
    private JPanel pp;
    private JButton registrar;
    private JButton comprarBoleto;
    private JButton buscarViaje;
    private JButton monitoreoViajes;


    public VistaPrincipal (){
        setBounds(0, 0, 1350, 700);
        setTitle("QUChao2.0");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        contenedor = new JPanel();
        header = new JPanel();
        pp = new JPanel();
        getContentPane().add(contenedor);
        contenedor.setBackground(Color.WHITE);

        SpringLayout sp = new SpringLayout();

        contenedor.setLayout(sp);
        header.setLayout(sp);

        JLabel titulo = new JLabel("Bienvenidos");
        contenedor.add(titulo);
        Font fuente = new Font("Rockwell",1,60);
        titulo.setFont(fuente);
        sp.putConstraint(SpringLayout.NORTH, titulo, 100, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST,titulo,  70, SpringLayout.WEST, contenedor);

        /*JLabel titulo2 = new JLabel("a QUChao2.0");
        contenedor.add(titulo2);
        titulo2.setFont(fuente);
        sp.putConstraint(SpringLayout.NORTH, titulo2, 190, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST,titulo2,  100, SpringLayout.WEST, contenedor);*/

        JLabel imagen = new JLabel();
        Thread i=new Thread(new SlideShow(imagen));
        i.start();
        contenedor.add(imagen);
        sp.putConstraint(SpringLayout.NORTH, imagen, 50, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST,imagen,  1000, SpringLayout.WEST, contenedor);
        //sp.putConstraint(SpringLayout.SOUTH, imagen, -520, SpringLayout.SOUTH, contenedor);
        //sp.putConstraint(SpringLayout.EAST,imagen,  0, SpringLayout.EAST, contenedor);

        contenedor.add(header);
        header.setBackground(Color.BLACK);
        sp.putConstraint(SpringLayout.NORTH, header, 0, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST,header,  0, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.SOUTH, header, -620, SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.EAST,header,  0, SpringLayout.EAST, contenedor);

        contenedor.add(pp);
        pp.setBackground(Color.BLACK);
        sp.putConstraint(SpringLayout.NORTH, pp, 620, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST,pp,  0, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.SOUTH,pp, 0, SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.EAST,pp,  0, SpringLayout.EAST, contenedor);


        ImageIcon logo1 =new ImageIcon("src/Imagenes/175.png");
        Icon logopr1 = new ImageIcon(logo1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT));
        JLabel tarifa =new JLabel ();
        tarifa.setIcon(logopr1);
        contenedor.add(tarifa);
        sp.putConstraint(SpringLayout.NORTH, tarifa, 295, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST,tarifa,  50, SpringLayout.WEST, contenedor);

        ImageIcon logo2=new ImageIcon("src/Imagenes/logo.png");
        Icon logopr2= new ImageIcon(logo2.getImage().getScaledInstance(550,200,Image.SCALE_DEFAULT));
        JLabel logo =new JLabel ();
        logo.setIcon(logopr2);
        contenedor.add(logo);
        sp.putConstraint(SpringLayout.NORTH, logo, 150, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST,logo,  50, SpringLayout.WEST, contenedor);

        Font fuente2 = new Font("Rockwell",1,25);

        registrar =new JButton("         Registarse         ");
        contenedor.add(registrar);
        registrar.setBackground(Color.BLACK);
        registrar.setForeground(Color.white);
        registrar.setFont(fuente2);
        sp.putConstraint(SpringLayout.NORTH, registrar, 140, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST,registrar,  660, SpringLayout.WEST, contenedor);

        comprarBoleto =new JButton("  Monitoreo de Viajes   ");
        contenedor.add(comprarBoleto);

        comprarBoleto.setBackground(Color.BLACK);
        comprarBoleto.setForeground(Color.WHITE);
        comprarBoleto.setFont(fuente2);
        sp.putConstraint(SpringLayout.NORTH, comprarBoleto, 220, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST,comprarBoleto,  660, SpringLayout.WEST, contenedor);

        buscarViaje =new JButton("          Buscar Viaje          ");
        contenedor.add(buscarViaje);
        buscarViaje.setBackground(Color.BLACK);
        buscarViaje.setForeground(Color.white);
        buscarViaje.setFont(fuente2);
        sp.putConstraint(SpringLayout.NORTH, buscarViaje, 300, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST,buscarViaje,  660, SpringLayout.WEST, contenedor);

        this.setVisible(true);
    }

    public void conectarControladorRegistar(ActionListener ac){
        registrar.addActionListener(ac);
    }

    public void conectarControladorBusquedaViajes(ActionListener ac){
        buscarViaje.addActionListener(ac);
    }

    public void conectarControladorMonitoreoViajes(ActionListener ac){
        comprarBoleto.addActionListener(ac);
    }


}