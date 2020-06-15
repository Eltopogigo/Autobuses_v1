package Vista;
import Controlador.Hilos;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

/**
 *
 * @author antonio
 */
public class VentanaMonitoreo extends JFrame {
    public JPanel superior,central;
    JTextField cuadrobusqueda;
    JButton buscar,restablecer, volver;
    JComboBox viajes;

    public VentanaMonitoreo(){
        setTitle("Busqueda de un viaje");    //Barra de título del frame
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);

    }

    public void initComponents(){
        setLayout(new BorderLayout());
        superior= new JPanel();
        viajes= new JComboBox();
        cuadrobusqueda= new JTextField(10);
        buscar= new JButton("Buscar");
        superior.add(viajes);
        //superior.add(cuadrobusqueda);
        superior.add(buscar);
        restablecer= new JButton("Restablecer");
        superior.add(restablecer);
        volver= new JButton("Volver");
        superior.add(volver);
        central = new JPanel();
        central.setLayout(new BoxLayout(central,BoxLayout.Y_AXIS));
        add(superior,BorderLayout.NORTH);
        add(central,BorderLayout.CENTER);

    }
    public void estados(ArrayList<String> ar){
        for(String es:ar){
            viajes.addItem(es);
        }
    }

    public String getDestino(){
        return viajes.getSelectedItem().toString();
    }

    public JPanel[] panAnim(int i){
        JPanel[] anim = new JPanel[i];
        Thread[] t = new Thread[i];
        for(int j=0;j<i;j++){
            anim[j]= new JPanel();
            anim[j].setLayout(null);
            t[j]= new Thread(new Hilos(anim[j]));
            t[j].start();
        }
        return anim;
    }
    public void conectarControladorBuscar(ActionListener ac){
        buscar.addActionListener(ac);
    }

    public void concectarControladorRestablecer(ActionListener ac){
        restablecer.addActionListener(ac);
    }
    public void conectarControladorVolver(ActionListener ac){ volver.addActionListener(ac); }
}
