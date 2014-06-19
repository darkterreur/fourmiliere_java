package vue;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modele.monde;
import modele.obstacle;
import modele.simulation;

public class rendu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private simulation sim;
	
	public rendu(simulation sim, int taille) {
		super();
		this.sim = sim;
		this.setPreferredSize(new Dimension(taille, taille));
	}
	
	public void paintComponent(Graphics g) {
		monde m = this.sim.listeMondes.get(0);
	    
		
		
		
		ArrayList<obstacle> obstacles = m.getObstacles();
		
	    for (int i=0; i<obstacles.size(); i++) {
	    	obstacle obstacle = obstacles.get(i);
	    	
	    	if (obstacle.getForme() == obstacle.cailloux) {
	    		g.fillRect(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight());
	    	} else if (obstacle.getForme() == obstacle.feuille) {
	    		g.fillOval(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight());
	    	} else if (obstacle.getForme() == obstacle.flac) {
	    		g.fillOval(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight());
	    	} else if (obstacle.getForme() == obstacle.branche) {
	    		g.fillRect(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight());
	    	}
	    }
	}
	
	void setSimulation(simulation sim) {
		this.sim = sim;
	}
	
}
