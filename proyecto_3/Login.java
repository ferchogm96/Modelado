import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Programa que representa el inicio de sesión.
 */
public class Login extends JFrame implements ActionListener{

   JPanel panel;
   JButton boton_envio;
   JLabel usuario_label;
   JLabel pass_label;
   JTextField user_tf;
   JTextField pass_tf;

   /* Constructor */
   public Login()  {
      usuario_label = new JLabel();
      usuario_label.setText("Nombre de usuario:");
      user_tf = new JTextField(10);
   
      pass_label = new JLabel();
      pass_label.setText("Password:");
      pass_tf = new JPasswordField(10);
    
      boton_envio=new JButton("Acceder");

      /* Panel */
      panel=new JPanel(new GridLayout(3,2));
      /* Nivel de usuario */
      panel.add(usuario_label);
      panel.add(user_tf);
      /* Nivel de contraseña */
      panel.add(pass_label);
      panel.add(pass_tf);
      /* Botón de aceptar */
      panel.add(boton_envio);
      
      add(panel);
      boton_envio.addActionListener(this);
      setTitle("Iniciar sesión");
   }


   public void actionPerformed(ActionEvent ae)  {
      String value1=user_tf.getText();
      String value2=pass_tf.getText();
      /* el nombre de usuario es doc
         la contraseña es dientes */
      if (value1.equals("doc") && value2.equals("dientes")) {
         /* Si coinciden, se presentará el programa */
         Clinica c = new Clinica();
         JOptionPane.showMessageDialog(this,"BIENVENIDO","ACCESO",JOptionPane.INFORMATION_MESSAGE);
      } else {
         /* Si no, se le avisará al usuario */
         JOptionPane.showMessageDialog(this,"Usuario o password incorrectos","Error",JOptionPane.ERROR_MESSAGE);
      }
   }

}
