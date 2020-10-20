import java.awt.Graphics;
import javax.swing.JPanel;

public class Curvas extends JPanel{
	
	public void paintComponent(Graphics g){
		int anchura = 250;
	    int altura = 250;
	    
	    int n1 = 0;
	    int n2 = 0;

	    while(n1 <= 15 & n2 <= 15){
			
			g.drawLine(anchura*(n1)/30, altura*(n2)/30, anchura/2 - anchura*(n1)/30, altura/2 + altura*(n2)/30);
			g.drawLine(anchura-anchura*(n1)/30,altura*(n1)/30, anchura/2 + anchura*(n1)/30, altura/2 + altura*(n2)/30);		
			
			g.drawLine(anchura*(n1)/30, 0, anchura/2, altura*(n2)/30);
			g.drawLine(anchura*(n1)/30, altura, anchura/2, altura - altura*(n2)/30);
			
			g.drawLine(anchura - anchura*(n1)/30, 0, anchura/2, altura*(n2)/30);
			g.drawLine(anchura - anchura*(n1)/30, altura, anchura/2, altura - altura*(n2)/30);
			
			n1 += 1;
			n2 += 1;
		}	   
	}
	
	
}
