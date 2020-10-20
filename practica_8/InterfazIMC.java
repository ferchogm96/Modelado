import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Interfaz de IMC
 */
@SuppressWarnings("unchecked") public class InterfazIMC{
	
	IMC class_imc = new IMC();
	
	JPanel panel;
	JButton boton_aceptar;
	
	JLabel nombre_label;
	JLabel peso_label;
	JLabel estatura_label;
	JLabel genero_label;
	JLabel edad_label;
	
	JTextArea text;
	JTextArea vacio;
	
	JTextField nombre_field;
	JTextField peso_field;
	JTextField estatura_field;
	
	JRadioButton hombre;
	JRadioButton mujer;
	
	JComboBox edades_jcb;
	String edades[];
	int edad = 1;
	
	public InterfazIMC(){
		
		JFrame jf = new JFrame("Calcula tu IMC");
		
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
		
		/* Inicializa las etiquetas */
		nombre_label = new JLabel("Nombre: ");
		edad_label = new JLabel("Edad: ");
		genero_label = new JLabel("Género: ");
		estatura_label = new JLabel("Estatura (En mts.): ");
		peso_label = new JLabel("Peso (En kg.): ");
		
		
		
		/* Inicializa el botón de aceptar */
		boton_aceptar = new JButton("Aceptar");
		
		/* Inicializa etiquetas */
		JLabel indicacion = new JLabel("Registra la información que se pide");
		/* Necesitaremos espacios para ordenar la interfaz */
		JLabel espacio1 = new JLabel(" ");
		JLabel espacio2 = new JLabel(" ");
		JLabel espacio3 = new JLabel(" ");
		
		/* Inicializa los campos de texto */
		nombre_field = new JTextField();
		peso_field = new JTextField();
		estatura_field = new JTextField();
		
		/* Inicializa las opciones de género */
		hombre = new JRadioButton("Hombre",true);
		mujer = new JRadioButton("Mujer",false);
		/* Garantiza sólo poder seleccionar una opción */
		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(hombre);
		grupo1.add(mujer);
		
		/* Crea un arreglo de las edades disponibles
		 * [1-100] */
		edades = new String[99];
		for (int i = 0; i<99; i++){
			String n = Integer.toString(i+1);
			edades[i] = n;
		}
		edades_jcb = new JComboBox(edades);
		edades_jcb.setMaximumRowCount(5);
		
		/* Si el usuario aprieta el botón aceptar se realizará esta acción */
		boton_aceptar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me){
				
				String n = nombre_field.getText();
				String p = peso_field.getText();
				String e = estatura_field.getText();
				
				if(n.equals("")||p.equals("")||e.equals("")){
					/* Si los campos son vacíos, se le avisará al usuario */
					JOptionPane.showMessageDialog(null, "No debe de haber campos vacíos", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				int indice = edades_jcb.getSelectedIndex()+1;
				int p1 = Integer.parseInt(p);
				double e1 = Double.parseDouble( e.substring(0,3) );
				
				String g = "";
				/* Checa que opción de género fue elegida */
				if( hombre.isSelected()==true){
					g = "hombre";
				}else{
					g = "mujer";
				}
				
				if(n.matches("([a-z]|[A-Z]|\\s)+") == false ){
					/* Verifica que el nombre no tenga números ni carácteres especiales */
					JOptionPane.showMessageDialog(null, "El nombre está escrito incorrectamente\nNo debe contener números ni carácteres especiales", "ERROR", JOptionPane.ERROR_MESSAGE);
					
				}else if(e1>3){
					/* Condición necesaria para verificar que el usuario haya ingreso la estatura en mts. */
					JOptionPane.showMessageDialog(null, "El dato de estatura es incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
					
				}else{
					float imc = class_imc.calcularIMC(p1, e1);
					String res = class_imc.darResultado(g, imc);
					/* Da el resultado al usuario */
					JOptionPane.showMessageDialog(null, n+" Tu Estado de Salud Es: "+res);
				}
			}
		});
			
		/* Define las medidas del panel */
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
		panel.setLayout(new GridLayout(8, 3, 8, 15));
		/* Agrega todo al panel */
		panel.add(indicacion);
		panel.add(espacio1);
		panel.add(nombre_label);
		panel.add(nombre_field);
		panel.add(edad_label);
		panel.add(edades_jcb);
		panel.add(genero_label);
		panel.add(espacio2);
		panel.add(hombre);
		panel.add(mujer);		
		panel.add(estatura_label);
		panel.add(estatura_field);
		panel.add(peso_label);
		panel.add(peso_field);		
		panel.add(boton_aceptar);
		
		jf.add(panel);
		jf.pack();
		jf.setVisible(true);
	}
	
	/* Main */
	public static void main(String[] args){
		InterfazIMC cimc = new InterfazIMC();
	}
	
}
