
package Vista;

import Modelo.Boleto;
import Modelo.Conexion;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author juani
 */
public class ViajeSeleccionado extends JFrame{
    private JLabel lTitulo;
    private JLabel lNombre;
    private JLabel lApellidoP;
    private JLabel lApellidoM;
    private JLabel lAsientosDisp;
    private JLabel lTipo;
    private JTextField txtNombre;
    private JTextField txtApellidoP;
    private JTextField txtApellidoM;
    private JRadioButton adulto;
    private JRadioButton niño;
    private JRadioButton inapam,estudiante;
    private ButtonGroup grupoTipo = new ButtonGroup();
    private JButton comprar, agregar;
    JLabel[] asientos;
    Boleto[] boletos;
    ArrayList<Integer> asientosOc;
    ImageIcon imAsientoNo;
    Icon icAsientoNo;

    public ViajeSeleccionado(int asientosT, ArrayList<Integer> asientosOcupados){
        setBounds(100, 100, 500, 550);//Dimensiones del frame
        setTitle("Viajes Encontrados");    //Barra de título del frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);    //Acción al pulsar salir
        setVisible(true);
        setLayout(null); //null para usar distribucion absoluta
        setResizable(false);


        int asientosTotales= asientosT;
        asientos= new JLabel[asientosTotales];
        boletos= new Boleto[asientosTotales];
        asientosOc=asientosOcupados;

        Font fuente = new Font("Arial", Font.PLAIN, 12);
        
        lTitulo = new JLabel("Compra de Boletos");
        lTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(lTitulo);
        lTitulo.setBounds(160, 10, 200, 30);
        
        lNombre = new JLabel("Nombre");
        add(lNombre);
        lNombre.setBounds(20, 50, 50, 20);
        lNombre.setFont(fuente);
       
        txtNombre = new JTextField("");
        add(txtNombre);
        txtNombre.setBounds(20, 70, 100, 20);
        txtNombre.setFont(fuente);
        
        lApellidoP= new JLabel("Apellido Paterno");
        add(lApellidoP);
        lApellidoP.setBounds(140, 50,100, 20);
        lApellidoP.setFont(fuente);
        
        lApellidoM = new JLabel("Apellido Materno");
        add(lApellidoM);
        lApellidoM.setBounds(280, 50, 100, 20);
        lApellidoM.setFont(fuente);
        
        txtApellidoP = new JTextField("");
        add(txtApellidoP);
        txtApellidoP.setBounds(140, 70, 100, 20);
        txtApellidoP.setFont(fuente);
        
        txtApellidoM = new JTextField("");
        add(txtApellidoM);
        txtApellidoM.setBounds(280, 70, 100, 20);
        txtApellidoM.setFont(fuente);
        
        
        lTipo = new JLabel("Tipo de Boleto");
        add(lTipo);
        lTipo.setBounds(20, 120, 90, 20);
        lTipo.setFont(new Font("Arial",Font.BOLD,12));
        
        adulto = new JRadioButton("Normal");
        adulto.setFont(fuente);
        niño = new JRadioButton("Menor a 12 años");
        niño.setFont(fuente);
        inapam = new JRadioButton("Adulto Mayor");
        inapam.setFont(fuente);
        estudiante = new JRadioButton("Estudiante");
        inapam.setFont(fuente);
        
        grupoTipo.add(adulto);
        grupoTipo.add(niño);
        grupoTipo.add(inapam);
        grupoTipo.add(estudiante);

        agregar = new JButton("Agregar");
        add(agregar);
        agregar.setBounds(170, 450, 150, 30);
        
        JPanel panelTipo = new JPanel(new GridLayout(0, 1));
        panelTipo.add(adulto);
        panelTipo.add(niño);
        panelTipo.add(inapam);
        panelTipo.add(estudiante);
        panelTipo.add(agregar);
        add(panelTipo);
        panelTipo.setBounds(20, 150, 100, 100);
        
        ImageIcon imAsiento =new ImageIcon("src/Imagenes/AsientoDis.png");
        Icon icAsiento = new ImageIcon(imAsiento.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT));

        imAsientoNo =new ImageIcon("src/Imagenes/Asientono.png");
        icAsientoNo = new ImageIcon(imAsientoNo.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT));
        
        JPanel panelAsientosIzq = new JPanel();
        panelAsientosIzq.setLayout(new GridLayout(0,2));
        
        selecionAsientos selector = new selecionAsientos();

        for (int i = 0; i <asientos.length/2+1; i++) {
            if(asientosOcupados.contains((Integer)i)){
                asientos[i]= new JLabel(icAsientoNo);
            }else{ asientos[i]= new JLabel(icAsiento);}
            if(i<9) asientos[i].setText("0"+(i+1));
            else    asientos[i].setText(""+ (i+1));
            asientos[i].addMouseListener(selector);
            panelAsientosIzq.add(asientos[i]);    
        }
        
        add(panelAsientosIzq);
        panelAsientosIzq.setBounds(160, 150, 120, 250);
        
        JPanel panelAsientosDer = new JPanel();
        setBackground(Color.white);
        panelAsientosDer.setLayout(new GridLayout(0,2));
        
        for (int i = asientos.length/2+1; i <asientos.length; i++) {
            if(asientosOcupados.contains((Integer)i)){
                asientos[i]= new JLabel(icAsientoNo);
            }else{ asientos[i]= new JLabel(icAsiento);}
            asientos[i].setText(""+(i+1));
            asientos[i].addMouseListener(selector);
            panelAsientosDer.add(asientos[i]);  
            
        }
        add(panelAsientosDer);
        panelAsientosDer.setBounds(340, 150, 120, 250);
        
        lAsientosDisp = new JLabel("Asientos Disponibles");
        add(lAsientosDisp);
        lAsientosDisp.setBounds(260, 120, 120, 20);
        
        
        comprar = new JButton("Confirmar Compra");
        add(comprar);
        comprar.setBounds(170, 450, 150, 30);
        
       comprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(JOptionPane.showConfirmDialog(null,"Confirmar Venta","Confirmación",JOptionPane.OK_OPTION)==0){

                    }
                } catch (Throwable ex) {
                    Logger.getLogger(ViajeSeleccionado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void conectarComprar(ActionListener ac){
       comprar.addActionListener(ac);
     }
    
     
    private class selecionAsientos implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            JLabel bo = (JLabel)e.getSource();
            if(bo.getIcon().equals(icAsientoNo)){

            }else {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    for (int nb = 0; nb < asientos.length; nb++) {
                        ImageIcon imAsiento = new ImageIcon("src/Imagenes/AsientoDis.png");
                        Icon icAsiento = new ImageIcon(imAsiento.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
                        bo.setIcon(icAsiento);
                    }
                } else {
                    for (int nb = 0; nb < asientos.length; nb++) {
                        ImageIcon imAsiento = new ImageIcon("src/Imagenes/AsientoSel.png");
                        Icon icAsiento = new ImageIcon(imAsiento.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
                        bo.setIcon(icAsiento);
                    }
                }
            }
        }
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
    }  
}