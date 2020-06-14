package Vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class EmpleadoLogin extends JFrame{
    
    private JLabel lsignin;
    private JLabel user;
    private JLabel pass;
    private JLabel forgot;
    private JLabel newuser;
    private JTextField username;
    private JPasswordField password;
    private JButton signin;
    private JButton signup;
    private ImageIcon imagen;

    public EmpleadoLogin() {
        setBounds(100, 200, 560, 390);
        setTitle("Empleado");    //Barra de título del frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);    //Acción al pulsar salir
        setVisible(true);
        setLayout(null);
        setResizable(false);
       
        JPanel lienzo = new JPanel(null);
        lienzo.setBounds(300, 20, 200, 280 );
        lienzo.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        lienzo.setBackground(Color.white);
        
        Font fuente = new Font("Arial", Font.PLAIN, 12); 
        
        lsignin = new JLabel("Sign In");
        lsignin.setBounds(15, 10, 180, 25);
        lsignin.setFont(fuente);
        //lsignin.setForeground(Color.decode("#868686"));
        lsignin.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#ddeefe")));
        lienzo.add(lsignin);
        
        
        user = new JLabel("User Name:");
        user.setBounds(15, 40, 180, 20);
        user.setFont(fuente);
        //user.setForeground(Color.decode("#868686"));
        lienzo.add(user);
        
        username = new JTextField();
        username.setBounds(15, 60, 150, 25);
        lienzo.add(username);
        
        pass = new JLabel("Password:");
        pass.setBounds(15, 90, 150, 20);
        pass.setFont(fuente);
        lienzo.add(pass);
        
        password = new JPasswordField();
        password.setBounds(15, 110, 150, 25);
        lienzo.add(password);
        
        signin = new JButton("SIGN IN");
        signin.setBounds(30, 135, 80, 30);
        signin.setBackground(Color.decode("#66bcfe"));
        signin.setForeground(Color.white);
        signin.setFont(new Font("Arial", Font.BOLD, 16));
        signin.setBorder(BorderFactory.createEmptyBorder());       
        lienzo.add(signin);
        
        
        forgot = new JLabel("<HTML><U>Forgot Password?<U><HTML>");
        forgot.setBounds(15, 165, 180, 30);
        forgot.setForeground(Color.decode("#9c97f5"));
        forgot.setFont(fuente);
        forgot.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#ddeefe")));
        lienzo.add(forgot);
        
        newuser = new JLabel("New User");
        newuser.setBounds(15, 200, 180, 30);
        newuser.setFont(fuente);
        lienzo.add(newuser);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(30, 230, 80, 30);
        signup.setBackground(Color.decode("#66bcfe"));
        signup.setForeground(Color.white);
        signup.setFont(new Font("Arial", Font.BOLD, 16));
        signup.setBorder(BorderFactory.createEmptyBorder());       
        lienzo.add(signup);
        
        add(lienzo);
        
        
        imagen = new ImageIcon("src/Imagenes/loginImg.png");
        JLabel im = new JLabel(imagen);
        im.setBounds(30, 30, 250, 250);
        add(im);
    }
}
