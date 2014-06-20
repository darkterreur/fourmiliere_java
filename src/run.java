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
		monde1.addCailloux(200, 100);
		monde1.addCailloux(200, 110);
		monde1.addCailloux(200, 120);
		monde1.addCailloux(200, 130);
		
		monde1.addCailloux(210, 90);
		monde1.addCailloux(210, 100);
		monde1.addCailloux(210, 110);
		monde1.addCailloux(210, 120);
		
		monde1.addCailloux(190, 120);
		monde1.addCailloux(230, 120);
		
		monde1.addCailloux(210, 130);
		monde1.addCailloux(210, 140);
		monde1.addCailloux(210, 150);
		
		monde1.addCailloux(210, 150);
		monde1.addCailloux(200, 150);
		monde1.addCailloux(220, 150);
		
		monde1.addCailloux(210, 160);
		monde1.addCailloux(210, 170);
		
		monde1.addCailloux(220, 100);
		monde1.addCailloux(220, 110);
		monde1.addCailloux(220, 120);
		monde1.addCailloux(220, 130);
		
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
