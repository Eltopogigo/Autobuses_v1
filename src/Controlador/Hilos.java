package Controlador;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author antonio
 */
public class Hilos implements Runnable {
    JPanel panel;
    JLabel anim;
    Icon camion;

    public Hilos(JPanel pan){
        panel=pan;
        anim=new JLabel();
        ImageIcon logo =new ImageIcon("src/imagenes/camion.png");
        Icon camion = new ImageIcon(logo.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
        anim.setIcon(camion);
        panel.add(anim);
    }

    public void run() {
        int rnd = (int) (Math.random()*20 + 1);
        int x = panel.getLocation().x;
        int y = panel.getLocation().y;
        anim.setBounds(x, y,200,200);
        //System.out.println(panel.getWidth());
        while (x < 700) {
            anim.setLocation(x,y);
            //System.out.println(anim.getX() + " " + anim.getY()+ " " + rnd );
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Aqui esta el pedo");
            }
            x += rnd;
        }
    }
}
