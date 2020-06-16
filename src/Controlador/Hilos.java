package Controlador;

import java.awt.Image;
import javax.swing.*;

/**
    En esta clase implementamos los hilos para el uso en la ventana de monitoreo de los viajes
 */
public class Hilos implements Runnable {
    JPanel panel; //Creacion de las variables que se utilizaran
    JLabel anim;
    Icon camion;

    public Hilos(JPanel pan){ //Constructor para inicializar las variables del panel
        panel=pan;
        anim=new JLabel();
        ImageIcon logo =new ImageIcon("src/imagenes/camion.png");
        Icon camion = new ImageIcon(logo.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
        anim.setIcon(camion);
        panel.add(anim);
    }

    public void run() { //Sobreescritura del metodo run de la interfaz Runnable
        JProgressBar barra = new JProgressBar();
        int rnd = (int) (Math.random()*2000+1) +1000;
        int z=0;
        int x = panel.getLocation().x;
        int y = panel.getLocation().y;
        anim.setBounds(x,y,200,200);
        barra.setBounds(250,y,300,20);
        panel.add(barra);
        /* 
        Mediante un ciclo while como solo nos interesa que la animacion sea en el eje x
        medimos la ubicacion en el frame del panel donde se correra el hilo tanto de x como y,
        aumentamos ese valor hasta el limite del panel,y ubicamos la imagen en su valor en x y y,
        tambien aumentamos los valores en la progress bar par tener un poco mas de informacion respecto al viaje
        mediante el metodo sleep variamos el tiempo que duerme cada hilo quese ejecute,
        */
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
