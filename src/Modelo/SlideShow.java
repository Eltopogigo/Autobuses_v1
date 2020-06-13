package Modelo;
import java.awt.Image;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Laura
 */
public class SlideShow implements Runnable{
    JLabel vista;
    Icon ar[];
    public SlideShow(JLabel v){
        vista=v;
        ar=new ImageIcon[2];
        ImageIcon logo1 =new ImageIcon("src/Imagenes/sld1.png");
        Icon logopr1 = new ImageIcon(logo1.getImage().getScaledInstance(300,550,Image.SCALE_DEFAULT));
        ImageIcon logo =new ImageIcon("src/Imagenes/sld2.png");
        Icon logopr = new ImageIcon(logo.getImage().getScaledInstance(300,550,Image.SCALE_DEFAULT));

        ar[0]=logopr1;
        ar[1]=logopr;

    }

    @Override
    public void run() {
        Random r=new Random();
        int cont=0;
        for(int i=0; i<1000;i++){

            if(cont==ar.length){cont=0;}

            vista.setIcon(ar[cont]);

            try {
                //vista.setText("j"+i);

                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SlideShow.class.getName()).log(Level.SEVERE, null, ex);
            }

            cont++;
        }
    }

}