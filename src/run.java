import modele.fourmiliere;
import modele.monde;
import modele.simulation;
import controler.controleur;


public class run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int taille = 500;
		simulation sim = new simulation(taille);
		monde monde1 = new monde(1, 10, 3, sim);
		
		monde1.addCailloux(100, 10);
		monde1.addBranche(200, 100);
		monde1.addFeuille(300, 250);
		monde1.addFeuille(250, 300);
		
		monde1.addFlac(450, 300);
		
		// Fourmilière
		fourmiliere f = new fourmiliere(200, 220, monde1);
		
		for (int k=0; k<100; k++) {
			f.addFourmi();
		}
		
		monde1.addFourmilere(f);
		
		sim.addMonde(monde1);
		
		controleur c = new controleur(sim, taille);
		c.run();
	}

}
