import java.awt.*;
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent; 

import javax.swing.*;
import javax.swing.JOptionPane; 
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField; 
import javax.swing.JPasswordField; 
import javax.swing.ImageIcon;

import java.io.*;
import java.util.ArrayList;

/**
 * Programa que representa a una clínica dental
 */
@SuppressWarnings("unchecked") public class Clinica extends JFrame{
   
   private String nom_archivo = "clinica.ser";
   ArrayList<Paciente> consultas = new ArrayList<Paciente>();
   JTabbedPane fichas = new JTabbedPane();

   /* Constructor
      Ventana de pestañas */
   public Clinica(){
      super("Clínica Dental");
      consultas = leerConsultas();
      /* Pestaña de bienvenida */
      pestaniaInicio();
      /* Pestaña de ver todas las citas */
      pestaniaVerCitas();
      /* Pestaña para registrar una cita */
      pestaniaRegistrarCita();
      /* Pestaña para cancelar una cita */
      pestaniaCancelarCita();
      /* Pestaña para cerrar sesión */
      pestaniaSalir();
      add(fichas);
      setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      setSize( 850, 400 );
      setVisible( true );
      setResizable(false);
   }

   /**
    * Pestaña de inicio de sesión.
    * Mostrará una imagen de la clínica
    * así como una breve info de la misma.
    */
   public void pestaniaInicio(){
      JPanel panel = new JPanel(new GridLayout(1,2));
      JPanel panel_1 = new JPanel(new GridLayout(8,1));

      /* Imagen de la clínica */
      Icon imagen = new ImageIcon("images/clinica_recepcion.jpg");
      JLabel estampa = new JLabel(imagen);

      /* Info de la clínica dental */
      panel_1.add(new JLabel("R&H Clínica Dental"));
      panel_1.add(new JLabel("'Tu sonrisa es nuestra sonrisa'"));
      panel_1.add(new JLabel(""));
      panel_1.add(new JLabel("Col. Jardín Balbuena"));
      panel_1.add(new JLabel("Del. Venustiano Carranza"));
      panel_1.add(new JLabel("Ciudad de México, México."));
      panel_1.add(new JLabel(""));
      panel_1.add(new JLabel("Abierto hasta las 21:00 hrs."));

      /* Se agregan al panel */
      panel.add(panel_1);
      panel.add(estampa);
      /* Se agrega el panel a las pestañas */
      fichas.addTab("Inicio", null, panel);
   }

   /**
    * Pestaña para ver todas las citas.
    * Mostrará todas las citas del día que
    * atenderá la clínica.
    */
   public void pestaniaVerCitas(){
      JPanel panel = new JPanel(new GridLayout(1,2));
      JPanel panel_1 = new JPanel(new GridLayout(2,1));
      JLabel todas_citas = new JLabel();
      JButton actualizar = new JButton("Actualizar lista de citas");

      /* Agregamos una imagen porque es bonito y está bien */
      Icon imagen = new ImageIcon("images/agenda_citas.png");
      JLabel estampa = new JLabel(imagen);

      panel_1.add(todas_citas);
      panel_1.add(actualizar);
      panel.add(estampa);
      panel.add(panel_1);

      /* Cuando se oprima el botón actualizar... */
      actualizar.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evento){
            String respuesta = "<html>";
            /* Se buscarán todas las consultas en el archivo...*/
            for (int i = 0; i<consultas.size(); i++){
               /* Y se mostrará al usuario */
               respuesta+="<br>"+consultas.get(i);
            }
            respuesta+="</html>";
            todas_citas.setText(respuesta);
         }
      });

      fichas.addTab("Ver citas", null, panel);
   }

   /**
    * Pestaña para registar una cita.
    */
   public void pestaniaRegistrarCita(){
      JPanel panel = new JPanel(new GridLayout(5,2));
      JTextField paciente = new JTextField();
      JButton boton_registrar = new JButton("Aceptar");

      JComboBox hora_jcb;
      JComboBox min_jcb;
      String[] horas = new String[24];
      String[] min = new String[60];
      /* ComboBox para las horas 0-23 hrs. */
		for (int i=0; i<24; i++){
         String n = Integer.toString(i)+" hrs.";
			horas[i] = n;
		}
      /* ComboBox para los minutos 0-59 min. */
      for(int i=0; i<10; i++){
         String n = "0"+Integer.toString(i)+" min.";
         min[i] = n;
      }
      for(int i=10; i<60; i++){
         String n = Integer.toString(i)+" min.";
         min[i] = n;
      }

		hora_jcb = new JComboBox(horas);
		hora_jcb.setMaximumRowCount(5);
      min_jcb = new JComboBox(min);
		min_jcb.setMaximumRowCount(10);

      panel.add(new JLabel("Registra una cita"));
      panel.add(new JLabel(""));
      /* Nivel de nombre del paciente */
      panel.add(new JLabel("Nombre del paciente: "));
      panel.add(paciente);
      /* Nivel de nombre de ComboBox de Horas */
      panel.add(new JLabel("Hora: "));
      panel.add(hora_jcb);
      panel.add(new JLabel(" "));
      /* Nivel de nombre de ComboBox de minutos */
      panel.add(min_jcb);
      panel.add(new JLabel(" "));
      panel.add(boton_registrar);

      /* Cuando se oprima el botón aceptar... */
      boton_registrar.addActionListener( new ActionListener() {
         public void actionPerformed(ActionEvent evento){

            String nombre_paciente = paciente.getText();
            int hora = hora_jcb.getSelectedIndex();
            int min = min_jcb.getSelectedIndex();

            /* Se verifica que el nombre del paciente no haya quedado en blanco */
            if(nombre_paciente.equals("")){
					JOptionPane.showMessageDialog(null, "No escribiste el nombre del paciente", "ERROR", JOptionPane.ERROR_MESSAGE);               
            }
            /* Se verifica que el nombre del paciente no contenga carácteres especiales */
            if(nombre_paciente.matches("([a-z]|[A-Z]|\\s)+")==false){
					JOptionPane.showMessageDialog(null, "El nombre está escrito incorrectamente\nNo debe contener números ni carácteres especiales", "ERROR", JOptionPane.ERROR_MESSAGE);
            /* Se verifica que el paciente no se ingrese dos veces */
            }else if( buscaPaciente(nombre_paciente) ) {
					JOptionPane.showMessageDialog(null, "El paciente ya tiene agendada una cita", "ERROR", JOptionPane.ERROR_MESSAGE);
            }else{
               /* Se verifica que no se traspongan las horas de consultas
                  Mínimo, 30 min. de diferencia entre cada consulta */
               boolean hora_aceptada = aceptarHora(hora, min);
               if(hora_aceptada==true)
                  registraPaciente(nombre_paciente, hora, min);
               else
   					JOptionPane.showMessageDialog(null, "Lo sentimos, hay consulta próxima a esa hora\nPor favor, ingresa otra hora","ERROR", JOptionPane.ERROR_MESSAGE);
            }
         }
      });

      fichas.addTab("Registrar cita", null, panel);
   }

   /**
    * Pestaña para cancelar una cita.
    */
   public void pestaniaCancelarCita(){
      JPanel panel = new JPanel(new GridLayout(5,2));
      JPanel panel_1 = new JPanel(new GridLayout(consultas.size(),1));
      JButton boton_cancelar = new JButton("Aceptar");

      /* Creamos un CheckBox de todas las citas que se encuentran en la base de datos */
      JCheckBox[] cb = new JCheckBox[consultas.size()];

      for (int i = 0; i<consultas.size(); i++){
         cb[i] = new JCheckBox(consultas.get(i).toString());
         panel_1.add(cb[i]);
      }

      panel.add(new JLabel("Cancela una o varias citas"));
      panel.add(panel_1);
      panel.add(new JLabel(" "));
      panel.add(boton_cancelar);

      /* Cuando se oprima el botón cancelar... */
      boton_cancelar.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evento){
            /* Se verifica todas aquéllas CheckBox que fueron seleccionadas */
            for (int i = 0; i<cb.length; i++){
               if( cb[i].isSelected() ){
                  /* Y se eliminan */
                  cb[i].setVisible(false);
                  eliminaCita(cb[i].getText());
               }
            }
         }
      });

      fichas.addTab("Cancelar cita", null, panel);
   }

   /**
    * Pestaña para cerrar sesión.
    */
   public void pestaniaSalir(){
      JPanel panel = new JPanel(new GridLayout(2,1));

      /* Imagen de despedida */
      Icon imagen = new ImageIcon("images/despedida.jpg");
      JLabel estampa = new JLabel(imagen);
      JButton boton_salir = new JButton("Cerrar sesión");

      panel.add(estampa);
      panel.add(boton_salir);

      /* Cuando se oprima el botón salir... */
      boton_salir.addActionListener(new ActionListener() {             
         public void actionPerformed(ActionEvent evento) {
           /* Se graba la info actual de las clínica */
           grabar();
           /* Y se cierra el programa */
           System.exit(1);
         }                       
      });
      
      fichas.addTab("Salir", null, panel);
   }

   /**
    * Método auxiliar para registrar un paciente.
    * @param nombre el nombre del paciente
    * @param hora
    *             La hora de consulta del paciente
    * @param min
    */
   private void registraPaciente(String nombre, int hora, int min){

      /* Transforma los enteros a String */
      String h = Integer.toString(hora);
      String m = "";

      if(min<10){
         m = "0"+Integer.toString(min);
      }else{
         m=Integer.toString(min);
      }

      /* Agregamos al paciente a las citas de la clínica */
      Paciente p = new Paciente(nombre, h, m);
      consultas.add(p);
   
      /* Se avisa que fue agregada la cita */
      JOptionPane.showMessageDialog(null, "Cita agregada exitosamente ", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
   }

   public boolean aceptarHora(int hora, int minutos){
      boolean aceptado = true;
      int m1 = minutos-30;
      int m2 = minutos+30;

      int h1 = 0;
      int m_h1 = 0;

      int h2 = 0;
      int m_h2 = 0;

      if (m1<0){
         m_h1 = 60+m1;
         h1 = hora-1;
      }
      if(m2>59){
         m_h2 = m2-60;
         h2 = hora+1;
      }

      for(int i=0; i<consultas.size(); i++){
         int m = Integer.parseInt(consultas.get(i).getMin());
         int h = Integer.parseInt(consultas.get(i).getHora());

         if(hora==h){
            if( (m1<m) || (m<m2) || (minutos==m) )
               aceptado = false;
         }
      }

      return aceptado;
   }

   /**
    * Método auxiliar para eliminar una cita.
    * @param text la información del paciente.
    */
   public void eliminaCita(String text){
      for (int i=0; i<consultas.size(); i++){
         String p = consultas.get(i).toString();
         if(p.equals(text)){
            consultas.remove(i);
         }
      }

      /* Se avisa al usuario que fue eliminada la cita*/
      JOptionPane.showMessageDialog(null, "Cita eliminada exitosamente", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
   }

   /**
    * Método auxiliar para buscar a un paciente.
    * @param nombre el nombre del paciente.
    * @return <code>true</code> si el paciente ya tiene agendada una cita.
    *         <code>false</code> en otro caso.
    */
   private boolean buscaPaciente(String nombre){
      boolean b = false;
      for(int i = 0; i<consultas.size(); i++){
         String n = consultas.get(i).getNombre();
         if(n.equals(nombre))
            b = true;
      }

      return b;
   }

   /**
    * Método que lee la información de las consultas de un archivo.
    * @return un ArrayList con todas las consultas que atenderá la clínica.
    */
   public ArrayList leerConsultas(){
      try{
         ObjectInputStream lector = new ObjectInputStream(new FileInputStream(nom_archivo));
         ArrayList<Paciente> c = (ArrayList<Paciente>) lector.readObject();
         lector.close();
         this.consultas = c;
      }
      catch(IOException e){
         System.out.println("IO Exception Lectura fallida: "+e);
      }
      catch(ClassNotFoundException e){
         System.out.println("Lectura fallida-Clase no encontrada: "+e);
      }
      return consultas;
   }

   /**
    * Método que graba la información de las consultas de un archivo.
    */
   public void grabar(){
      try{
         ObjectOutputStream a = new ObjectOutputStream(new FileOutputStream(nom_archivo));
         a.writeObject(consultas);
         a.close();
      }
      catch(NotSerializableException e){
         System.out.println("Error en la grabacion: "+e+"Objeto no serializable");
      }
      catch(IOException e){
         System.out.println("IO Exception Error en la grabacion: "+e);
      }

   }  
}
