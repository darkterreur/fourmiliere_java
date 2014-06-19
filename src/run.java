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
		monde monde1 = new monde(1, 10, 3);
		
		monde1.addCailloux(100, 10);
		monde1.addBranche(200, 100);
		monde1.addFeuille(300, 300);
		monde1.addFlac(450, 300);
		
		sim.addMonde(monde1);
		
		controleur c = new controleur(sim, taille);
		c.run();
	}

}
