package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import modele.food;
import modele.fourmi;
import modele.fourmiliere;
import modele.monde;
import modele.obstacle;
import modele.pheromone;
import modele.simulation;

/**
 * Se charge du rendu graphique
 */
public class rendu extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private simulation sim;
	private JTextArea jTextArea = new JTextArea();	// Sert pour donner les informations sur la simulation
	
	/**
	 * Lie le rendu à la simulation qui contient les données nécessaires à l'affichage des éléments
	 * @param sim
	 */
	public rendu(simulation sim) {
		super();
		this.sim = sim;
		
		this.setPreferredSize(new Dimension(sim.getHauteur(), sim.getLargeur()));
		
		this.add(this.jTextArea);
	}
	
	/**
	 * Dessine les éléments du monde
	 */
	public void paintComponent(Graphics g) {
		monde m = this.sim.listeMondes.get(0);
		
		// Fourmilière
		ArrayList<fourmiliere> fourmilieres = m.getFourmilieres();
		g.setColor(Color.GREEN);
		
		for (int i=0; i<fourmilieres.size(); i++) {
	    	fourmiliere fourm = fourmilieres.get(i);
	    	
	    	g.fillRect(fourm.getX(), fourm.getY(), fourm.getWidth(), fourm.getHeight());
	    }
		
		// Obstacles
		java.util.Iterator<obstacle> obstaclesIterator = m.getObstacles().iterator();
		g.setColor(Color.BLUE);
		
	    while (obstaclesIterator.hasNext()) {
	    	obstacle obstacle = obstaclesIterator.next();
	    	
	    	g.fillRect(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight());
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
		
		// Fourmis
		g.setColor(Color.BLACK);
		
		for (int i=0; i<fourmilieres.size(); i++) {
	    	fourmiliere fourmiliereCourante = fourmilieres.get(i);
	    	ArrayList<fourmi> fourmis = fourmiliereCourante.getFourmis();
	    	
			for (int j=0; j<fourmis.size(); j++) {
				fourmi fourmiCourante = fourmis.get(j);
				
				fourmiCourante.avance();
				
				g.fillOval(fourmiCourante.getX(), fourmiCourante.getY(), fourmiCourante.getWidth(), fourmiCourante.getHeight());
				if (fourmiCourante.isRetourFourmiliere()) {
					g.setColor(Color.WHITE);
					g.fillOval(fourmiCourante.getX()+(fourmiCourante.getWidth()/2), fourmiCourante.getY()+(fourmiCourante.getHeight()/2), 2, 2);
					g.setColor(Color.BLACK);
				}
			}
	    }
		
		// Phéromones
		java.util.Iterator<pheromone> pheroIterator = m.getPheromones().iterator();
		pheromone pheroCourante = null;
		
		while (pheroIterator.hasNext()) {
			try {
				pheroCourante = pheroIterator.next();
				
				if (pheroCourante.pourcentageRestant() >= 50) {
					g.setColor(Color.DARK_GRAY);
				} else if (pheroCourante.pourcentageRestant() >= 25 && pheroCourante.pourcentageRestant() <= 49) {
					g.setColor(Color.GRAY);
				} else if (pheroCourante.pourcentageRestant() >= 1 && pheroCourante.pourcentageRestant() <= 24) {
					g.setColor(Color.LIGHT_GRAY);
				}
				
				g.fillRect(pheroCourante.getX(), pheroCourante.getY(), 1, 1);
			} catch (Exception e) {
				break;
			}
		}
		
		// Cadre d'information sur l'avancé de la simulation
		this.jTextArea.setText("Numéro du pas de la simulation : "+sim.getInfosModele().getNumeroPasSim()+"\r\n"+
				   "Quantité de nourriture apportée à la fourmilière : "+sim.getInfosModele().getQteNourritureFourmiliere()+"\r\n"+
				   "Quantité de nourriture restante dans l'environnement : "+sim.getInfosModele().getQteNourritureEnvironement()+"\r\n"+
				   "Quantité totale de phéromones dans l'environnement : "+sim.getInfosModele().getQteTotalPheroDansEnv());
	}
	
	public void setSimulation(simulation sim) {
		this.sim = sim;
	}
}
