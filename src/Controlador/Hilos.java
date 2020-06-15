package Controlador;

import java.awt.Image;
import javax.swing.*;

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
        Icon camion = new ImageIcon(logo.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
        anim.setIcon(camion);
        panel.add(anim);
    }

    public void run() {
        JProgressBar barra = new JProgressBar();
        int rnd = (int) (Math.random()*2000+1) +1000;
        int z=0;
        int x = panel.getLocation().x;
        int y = panel.getLocation().y;
        anim.setBounds(x,y,200,200);
        barra.setBounds(250,y,300,20);
        panel.add(barra);
        while (x <= 700) {
            anim.setLocation(x,y);
            barra.setValue(z);
            barra.setString(String.valueOf(z)+"%");
            barra.setStringPainted(true);
            try {
                Thread.sleep(rnd);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            x += 10;
            z = Math.round(x/7);
        }
    }
}
