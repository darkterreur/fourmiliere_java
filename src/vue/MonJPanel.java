package vue;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

import modele.simulation;

public class MonJPanel extends JPanel {

	private simulation sim;
 

	public MonJPanel(simulation sim, int hauteur) {
		super();
		this.sim = sim;
		this.setPreferredSize(new Dimension(hauteur, hauteur));

	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.gray);
		g.fillRect(sim.x, sim.y, 10, 10);
  
	 

	}

	 
	void setsimulation(simulation sim) {
		this.sim = sim;

	}

	 

}
