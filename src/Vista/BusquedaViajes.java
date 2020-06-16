package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 *
 * @author Laura
 */
public class BusquedaViajes extends JFrame {
    private JPanel contenedor;
    private JPanel header;
    private JPanel pp;
    private JComboBox origen,destino;
    private JButton buscar;
    private JButton volver;

    public BusquedaViajes(){
        setBounds(0, 0, 1350, 700);
        setTitle("QUChao2.0");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        contenedor = new JPanel();
        header = new JPanel();
        pp = new JPanel();
        getContentPane().add(contenedor);
        contenedor.setBackground(Color.WHITE);
        SpringLayout sp = new SpringLayout();

        contenedor.setLayout(sp);
        header.setLayout(sp);

        origen = new JComboBox();
        contenedor.add(origen);
        sp.putConstraint(SpringLayout.NORTH,origen, 240, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST,origen,  800, SpringLayout.WEST, contenedor);

        destino = new JComboBox();
        contenedor.add(destino);
        sp.putConstraint(SpringLayout.NORTH,destino,240, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST,destino, 1100, SpringLayout.WEST, contenedor);

        buscar= new JButton("Buscar viaje");
        contenedor.add(buscar);
        buscar.setBackground(Color.BLACK);
        buscar.setForeground(Color.pink);
        Font fuente2 = new Font("Rockwell",1,25);
        buscar.setFont(fuente2);
        sp.putConstraint(SpringLayout.NORTH, buscar, 350, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST,buscar,  960, SpringLayout.WEST, contenedor);

        volver= new JButton("      Volver      ");
        contenedor.add(volver);
        volver.setBackground(Color.BLACK);
        volver.setForeground(Color.pink);
        volver.setFont(fuente2);
        sp.putConstraint(SpringLayout.NORTH, volver, 450, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST,volver,  960, SpringLayout.WEST, contenedor);


        JLabel titulo = new JLabel("Viajes Por toda la republica Mexicana");
        contenedor.add(titulo);
        Font fuente = new Font("Rockwell",1,40);
        titulo.setFont(fuente);
        sp.putConstraint(SpringLayout.NORTH, titulo, 100, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST,titulo,  70, SpringLayout.WEST, contenedor);

        JLabel org = new JLabel("Origen");
        contenedor.add(org);
        org.setFont(fuente2);
        sp.putConstraint(SpringLayout.NORTH,org, 190, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST,org,  820, SpringLayout.WEST, contenedor);

        JLabel dest = new JLabel("Destino");
        contenedor.add(dest);
        dest.setFont(fuente2);
        sp.putConstraint(SpringLayout.NORTH,dest, 190, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST,dest,  1120, SpringLayout.WEST, contenedor);

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


        ImageIcon logo1 =new ImageIcon("src/Imagenes/mapa.png");
        Icon logopr1 = new ImageIcon(logo1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT));
        JLabel tarifa =new JLabel ();
        tarifa.setIcon(logopr1);
        contenedor.add(tarifa);
        sp.putConstraint(SpringLayout.NORTH, tarifa, 200, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST,tarifa,  50, SpringLayout.WEST, contenedor);

        this.setVisible(true);
    }
    public void OrigenYDestino(ArrayList<String>list){

        for(String or:list){
            origen.addItem(or);
        }

        for(String or:list){
            destino.addItem(or);
        }

    }

    public void conectarControlador(ActionListener ac){
        buscar.addActionListener(ac);
    }

    public void conectarControladorVolver(ActionListener ac){
        volver.addActionListener(ac);
    }


    public String getOrigen(){
        return origen.getSelectedItem().toString();
    }

    public String getDestino(){
        return destino.getSelectedItem().toString();
    }


}