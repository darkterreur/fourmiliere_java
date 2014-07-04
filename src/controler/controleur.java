package controler;

import modele.simulation;
import vue.MonJFrame;

public class controleur {
	int taille;
	MonJFrame fenetre;
	simulation sim;
	int SleepDuration = 75;
	
	/**
	 * Initialisation
	 * @param sim
	 * @param taille
	 */
	public controleur(simulation sim, int taille) {
		this.taille = taille;
		this.sim = sim;
		fenetre = new MonJFrame(taille, taille, sim);
		this.SleepDuration = sim.getParams().getVitesseJeu();
	}
	
	/**
	 * Crée la vue selon le modèle et fait avancer la simulation d'un pas
	 * @param sim
	 */
	public void run(simulation sim) {
		fenetre.paint(sim);
		sim.setIsStart(false);
		
		while (true)  {
			sim.nextStep();
			
			fenetre.repaint();
			
			try {Thread.sleep(SleepDuration);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
