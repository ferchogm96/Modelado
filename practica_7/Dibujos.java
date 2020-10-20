import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

public class Dibujos{
	
	public static void main(String[] args){
		Curvas panel = new Curvas();
		Mandala panel2 = new Mandala();
		
		/* JFrame para las curvas */
		JFrame curv = new JFrame();
		curv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		curv.add(panel);
		curv.setSize(300, 300);
		curv.setResizable(false);
		curv.setVisible(true);
		curv.setTitle("Curvas");
		
		/* JFrame para el mandala */
		JFrame circ = new JFrame();
		circ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		circ.add(panel2);
		circ.setSize(450, 450);
		circ.setResizable(false);
		circ.setVisible(true);
		circ.setTitle("Mandala");
    }
	
}
