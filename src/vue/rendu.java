package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modele.food;
import modele.fourmi;
import modele.fourmiliere;
import modele.monde;
import modele.obstacle;
import modele.pheromone;
import modele.simulation;

public class rendu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private simulation sim;
	
	public rendu(simulation sim) {
		super();
		this.sim = sim;
		this.setPreferredSize(new Dimension(sim.getHauteur(), sim.getLargeur()));
	}
	
	public void paintComponent(Graphics g) {
		monde m = this.sim.listeMondes.get(0);
		// Initialisations des objets du monde
		//if (this.sim.isStart()) {
			// Fourmilière
			ArrayList<fourmiliere> fourmilieres = m.getFourmilieres();
			g.setColor(Color.GREEN);
			
			for (int i=0; i<fourmilieres.size(); i++) {
		    	fourmiliere fourm = fourmilieres.get(i);
		    	
		    	Polygon p = new Polygon();
		    	p.addPoint(fourm.getX(), fourm.getY());
		    	p.addPoint(fourm.getX()+35, fourm.getY()+35);
		    	p.addPoint(fourm.getX()-35, fourm.getY()+35);
		    	
		    	g.fillPolygon(p);
		    }
			
			// Obstacles
			ArrayList<obstacle> obstacles = m.getObstacles();
			g.setColor(Color.BLUE);
			
		    for (int i=0; i<obstacles.size(); i++) {
		    	obstacle obstacle = obstacles.get(i);
		    	
		    	if (obstacle.getForme() == obstacle.cailloux) {
		    		g.fillRect(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight());
		    	} else if (obstacle.getForme() == obstacle.flac) {
		    		g.fillOval(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight());
		    	} else if (obstacle.getForme() == obstacle.branche) {
		    		g.fillRect(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight());
		    	}
		    }
		    
		    // Nourriture
		    ArrayList<food> foods = m.getFoods();
			g.setColor(Color.RED);
			
			for (int i=0; i<foods.size(); i++) {
		    	food f = foods.get(i);
		    	
		    	if (f.getForme() == food.feuille) {
		    		int pourcentageUtilise = f.testValeurFood();
		    		int width = 0, height = 0;
		    		
		    		if (pourcentageUtilise >= 50 && pourcentageUtilise <= 100) {
		    			width = f.getWidth();
		    			height = f.getHeight();
		    		} else if (pourcentageUtilise >= 25 && pourcentageUtilise <= 49) {
		    			width = f.getWidth();
		    			height = 50;
		    		} else if (pourcentageUtilise >= 1 && pourcentageUtilise <= 24) {
		    			width = 10;
		    			height = 25;
		    		}
		    		
		    		g.fillOval(f.getX(), f.getY(), width, height);
				}
		    }
		//} else {
		// Les objets changeants d'apparence (fourmis et nourriture)
			// Fourmis
			g.setColor(Color.BLACK);
			
			for (int i=0; i<fourmilieres.size(); i++) {
		    	fourmiliere fourmiliereCourante = fourmilieres.get(i);
		    	ArrayList<fourmi> fourmis = fourmiliereCourante.getFourmis();
		    	
				for (int j=0; j<fourmis.size(); j++) {
					fourmi fourmiCourante = fourmis.get(j);
					
					fourmiCourante.avance();
					
					g.fillOval(fourmiCourante.getX(), fourmiCourante.getY(), fourmiCourante.getWidth(), fourmiCourante.getHeight());
				}
		    }
			
			// Phéromones
			ArrayList<pheromone> pheromones = m.getPheromones();
			g.setColor(Color.DARK_GRAY);
			
		    for (int i=0; i<pheromones.size(); i++) {
		    	pheromone pheromoneCourante = pheromones.get(i);
		    	
		    	g.fillRect(pheromoneCourante.getX(), pheromoneCourante.getY(), 1, 1);
		    	
		    }
		//}
	}
	
	void setSimulation(simulation sim) {
		this.sim = sim;
	}
	
}
