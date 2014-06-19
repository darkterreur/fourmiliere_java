package controler;

import modele.monde;
import modele.simulation;
import vue.MonJFrame;

public class controleur {
	int taille;
	MonJFrame fenetre;
	simulation sim;
	final int SleepDuration = 100; 
	

	public controleur(simulation sim, int taille) {
		this.taille = taille;
		this.sim = sim;
		fenetre = new MonJFrame(1000, 1000, sim);
	}

	public void run() {
		while (true)  {
			sim.nextStep();
			 
			fenetre.paint(sim);
			try {Thread.sleep(SleepDuration);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
