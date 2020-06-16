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
Esta clase se encarga de el monitoreo de los diversos viajes, en ella mediante la implementacion
de hilos podemos ver el avance de los autobuses
 */
public class VentanaMonitoreo extends JFrame {
    public JPanel superior,central; //Declaracion de las variables que se utilizaran en la interfaz
    JTextField cuadrobusqueda;
    JButton buscar,restablecer, volver;
    JComboBox viajes;

    public VentanaMonitoreo(){
        setTitle("Busqueda de un viaje");    //Barra de título del frame
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); //Operacion de cierre
        setVisible(true);                       //Visibilidad del Frame
        initComponents();                       // Inicializacion de todos los componentes
        setExtendedState(MAXIMIZED_BOTH);

    }

    public void initComponents(){ // Metodo para inicializar todos los componentes dentro del frame
        setLayout(new BorderLayout());  //Colocacion de un BorderLayout para el frame y ubicar los paneles por zonas
        
       // Creacion del panel superior del frame
        superior= new JPanel();
        viajes= new JComboBox();
        buscar= new JButton("Buscar");
        superior.add(viajes);
        superior.add(buscar);
        restablecer= new JButton("Restablecer");
        superior.add(restablecer);
        volver= new JButton("Volver");
        superior.add(volver);
        
        //Creacion del panel central donde ubicaremos los paneles que nos serviran para vizualizar
        //los autobuses y su avance
        central = new JPanel();
        central.setLayout(new BoxLayout(central,BoxLayout.Y_AXIS));
        
        //Se añaden los paneles al frame en sus respectivas zonas
        add(superior,BorderLayout.NORTH);
        add(central,BorderLayout.CENTER);

    }
    
    //Metodo usado para llenar el combo box para elegir una terminal
    public void estados(ArrayList<String> ar){
        for(String es:ar){
            viajes.addItem(es);
        }
    }
    
    //Metodo para obtener la terminal escogida en el combo box
    public String getDestino(){
        return viajes.getSelectedItem().toString();
    }
    
    /*Metodo para crear un arreglo de paneles del tamaño de viajes de la terminal escogida en los cuales 
    se ejecutaran los hilos que nos permitiran ver el avanze de los camiones
    */
    public JPanel[] panAnim(int i){
        JPanel[] anim = new JPanel[i]; //Creacion del arreglo de paneles
        Thread[] t = new Thread[i]; //Creacion del numero de hilos correspondientes
        for(int j=0;j<i;j++){
            anim[j]= new JPanel();
            anim[j].setLayout(null);
            t[j]= new Thread(new Hilos(anim[j]));
            t[j].start();
        }
        return anim;
    }
    //Conexion del boton buscar para ejecutar los hilos
    public void conectarControladorBuscar(ActionListener ac){
        buscar.addActionListener(ac);
    }
    //Conexion del boton restablecer para vaciar el panel central de las animaciones
    public void concectarControladorRestablecer(ActionListener ac){
        restablecer.addActionListener(ac);
    }
    //Conexion de boton volver para regresar al menu principal 
    public void conectarControladorVolver(ActionListener ac){ volver.addActionListener(ac); }
}
