import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;

public class Mandala extends JPanel{
	
	public void paintComponent(Graphics g){
		int anchura = 400;
		int altura = 400;
		
		g.setColor( new Color(250, 250, 250 ) );
	    g.fillOval(25, 25, anchura, altura);
	    
	    /* Círculos rojos arriba y abajo verticales */
	    g.setColor(Color.red);
	    g.fillOval(180, 25, 90, 90);
	    g.setColor(Color.red);
	    g.fillOval(180, 335, 90, 90);
	    /* Círculos pequeños */
	    g.setColor( new Color(255, 190, 190) );
	    g.fillOval(200, 25, 50, 50);
	    g.setColor( new Color(255, 190, 190) );
	    g.fillOval(200, 375, 50, 50);
	    /* Círculos rojos esquinas superiores */
	    g.setColor(Color.red);
	    g.fillOval(48, 97, 97, 97);
	    g.setColor(Color.red);
	    g.fillOval(304, 97, 97, 97);
	    /* Círculos pequeños */
	    g.setColor( new Color(255, 190, 190) );
	    g.fillOval(53, 106, 50, 50);
	    g.setColor( new Color(255, 190, 190) );
	    g.fillOval(346, 106, 50, 50);
	    /* Círculos rojos equinas inferiores */
	    g.setColor(Color.red);
	    g.fillOval(48, 256, 97, 97);
	    g.setColor(Color.red);
	    g.fillOval(305, 256, 97, 97);
	    /* Círculos pequeños */
	    g.setColor( new Color(255, 190, 190) );
	    g.fillOval(53, 295, 50, 50);
	    g.setColor( new Color(255, 190, 190) );
	    g.fillOval(346, 295, 50, 50);
	    
	    /* Círculo amarillo esquina superior izquierda */
		g.setColor( new Color(255, 255, 0) );
		g.fillOval(149, 163, 74, 74);
	    /* Círculo anaranjado arriba vertical */
		g.setColor( new Color(255, 200, 0) );
		g.fillOval(188, 145, 74, 74);
	    /* Círculo amarillo esquina superior derecha */
		g.setColor( new Color(255, 255, 0) );
		g.fillOval(221, 163, 74, 74);
	    /* Círculo anaranjado esquina inferior derecha */
		g.setColor( new Color(255, 200, 0) );
		g.fillOval(221, 213, 74, 74);
	    /* Círculo amarillo abajo vertical */
		g.setColor( new Color(255, 255, 0) );
		g.fillOval(188, 230, 74, 74);
		/* Círculo anaranjado esquina inferior izquierda */
		g.setColor( new Color(255, 200, 0) );
		g.fillOval(149, 213, 74, 74);
		
		/* Círculo azules esquina superior izquierda */
		g.setColor( new Color(0, 0, 85) );
		g.fillOval( 144, 98, 67, 67 );
		g.setColor( new Color(180, 200, 255) );
		g.fillOval( 155, 115, 50, 50 );
		/* Círculos azules esquina superior derecha */
		g.setColor( new Color(0, 0, 85) );
		g.fillOval( 239, 98, 67, 67 );
		g.setColor( new Color(180, 200, 255) );
		g.fillOval( 246, 115, 50, 50 );
		/* Círculos azules esquina inferior izquierda */
		g.setColor( new Color(0, 0, 85) );
		g.fillOval( 144, 285, 67, 67 );
		g.setColor( new Color(180, 200, 255) );
		g.fillOval( 155, 286, 50, 50 );
		/* Círculos azules esquina inferior derecha */
		g.setColor( new Color(0, 0, 85) );
		g.fillOval( 239, 285, 67, 67 );
		g.setColor( new Color(180, 200, 255) );
		g.fillOval( 246, 285, 50, 50 );
		/* Círculos azules en medio derecha */
		g.setColor( new Color(0, 0, 85) );
		g.fillOval( 87, 192, 67, 67 );
		g.setColor( new Color(180, 200, 255) );
		g.fillOval( 105, 200, 50, 50 );
		/* Círculos azules en medio izquierda */
		g.setColor( new Color(0, 0, 85) );
		g.fillOval( 290, 192, 67, 67 );
		g.setColor( new Color(180, 200, 255) );
		g.fillOval( 290, 200, 50, 50 );
		
		/* Círculo gris esquina superior izquierda */
		g.setColor( new Color(192, 192, 192) );
		g.fillOval( 135, 70, 35, 35 );
		/* Círculo gris esquina superior derecha */
		g.setColor( new Color(192, 192, 192) );
		g.fillOval( 280, 70, 35, 35 );
		/* Círculo gris esquina inferior izquierda */
		g.setColor( new Color(192, 192, 192) );
		g.fillOval( 135, 345, 35, 35 );
		/* Círculo gris esquina inferior derecha */
		g.setColor( new Color(192, 192, 192) );
		g.fillOval( 280, 345, 35, 35 );
		/* Círculo gris esquina en medio derecha */
		g.setColor( new Color(192, 192, 192) );
		g.fillOval( 53, 205, 35, 35 );
		/* Círculo gris esquina en medio izquierda */
		g.setColor( new Color(192, 192, 192) );
		g.fillOval( 356, 205, 35, 35 );
		
	}
	
}
