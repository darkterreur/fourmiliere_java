package modele;

public class fourmi {
	//attribut
	public fourmiliere fourmiliere;
	public int x;
	public int y;
	public boolean isRetourFourmiliere = false;
	public boolean suitPheromone = false;
	public boolean isSurNourriture = false;
	public boolean deposePheromone = false;
	
	private int charge_max;
	private int charge_porter;
	private int plein;
	
	//methode
	public fourmi(int charge_max, fourmiliere fourmiliere) {
		this.charge_max = charge_max;
		this.charge_porter = 0;
		this.plein = 0;
		this.fourmiliere = fourmiliere;
	}
	
	// Fait avancer la fourmie d'un pas
	public void avance() {
		// Si la fourmi a l'�tat retour � la fourmili�re
			// Avancer vers la fourmili�re en ligne droite
		// Sinon si la fourmi se trouve sur de la nourriture, c'est � dire que les x et y correspondent � l'emplacement d'une nourriture du monde
			// La fourmi r�cup�re de la nourriture
		// Sinon si la fourmi rep�re de la nourriture, c'est � dire que de la nourriture se situe dans l'entourage proche de la fourmi
			// Se d�placer vers la nourriture
		// Sinon si la fourmi suit des ph�romones
			// Chercher une autre ph�romone
			// Se d�placer � l'emplacement de la ph�romone trouv�e
		// Sinon
			// Chercher une ph�romone � proximit�
			// Si une ph�romone est � proximit�
				// Se d�placer vers celle-ci
			// Sinon
				// Se d�placer d'un pas dans une direction al�atoire
		
		// Si la direction d�finie est un obstacle, lancer le contournement de l'obstacle
		// Sinon, se d�placer sur la case
	}
	
	// V�rifie si des ph�romones sont proches de la position de la fourmi
	public void pheromoneAProximite(){
	
	}
	
	// Cherche le prochain ph�romone � suivre
	public void searchNextPheromone(){
		
	}
	
	// V�rifie si de la nourriture est proche de la position de la fourmi
	public void hasNourritureProximite(){
	
	}
	
	// R�cup�re la nourriture
	public void getNourriture(){
		// R�cup�re une quantit� de nourriture
		this.charge_porter++;
		
		// Met � jour la quantit� dans l'objet nourriture
		
		
		// Retourne � la fourmili�re
		this.isRetourFourmiliere = true;
		
		// Et d�pose des ph�romones en chemin
		this.deposePheromone = true;
	}
	
	// D�pose la nourriture � la fourmili�re
	public void deposeNourriture(){
		// Met � jour la quantit� dans l'objet fourmili�re
		this.fourmiliere.qte_food_recolter += this.charge_porter;
		
		// Enl�ve une quantit� de nourriture
		this.charge_porter--;
		
		// D�sactive le retour � la fourmili�re
		this.isRetourFourmiliere = false;
		
		// Et ne d�pose plus de ph�romones en chemin
		this.deposePheromone = false;
	}
	
	// V�rifie si un obstacle est proche de la position de la fourmi
	public void hasObstacleProximite(){
	
	}
	
	// Contourne un obstacle selon la strat�gie d'�vitement d�finie par l'utilisateur
	public void contourneObstacle(){
	
	}
	
	@Override
	public String toString() {
		return "fourmi [charge_max=" + charge_max + ", charge_porter=" + charge_porter + ", plein=" + plein + "]";
	}
	
	public void incrementCharge(){
		this.setCharge_porter(this.getCharge_porter()+1);
	}
	
	public void decrementCharge(){
		this.setCharge_porter(this.getCharge_porter()-1);
	}
	
	//accesseur
	public int getCharge_max() {
		return charge_max;
	}
	public void setCharge_max(int charge_max) {
		this.charge_max = charge_max;
	}
	public int getCharge_porter() {
		return charge_porter;
	}
	public void setCharge_porter(int charge_porter) {
		this.charge_porter = charge_porter;
	}
	
	public int getPlein() {
		return plein;
	}
	public void setPlein(int plein) {
		this.plein = plein;
	}
	
}
