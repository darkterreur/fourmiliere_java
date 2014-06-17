package controler;

import modele.simulation;
import vue.MonJFrame;

public class controleur {
	int taille;
	MonJFrame fenetre;
	simulation sim;
	final int SleepDuration = 100; 
	

	public controleur(int taille) {
		this.taille = taille;
		sim = new simulation(1000);
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
