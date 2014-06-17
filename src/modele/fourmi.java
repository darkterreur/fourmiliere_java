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
		// Si la fourmi a l'état retour à la fourmilière
			// Avancer vers la fourmilière en ligne droite
		// Sinon si la fourmi se trouve sur de la nourriture, c'est à dire que les x et y correspondent à l'emplacement d'une nourriture du monde
			// La fourmi récupère de la nourriture
		// Sinon si la fourmi repère de la nourriture, c'est à dire que de la nourriture se situe dans l'entourage proche de la fourmi
			// Se déplacer vers la nourriture
		// Sinon si la fourmi suit des phéromones
			// Chercher une autre phéromone
			// Se déplacer à l'emplacement de la phéromone trouvée
		// Sinon
			// Chercher une phéromone à proximité
			// Si une phéromone est à proximité
				// Se déplacer vers celle-ci
			// Sinon
				// Se déplacer d'un pas dans une direction aléatoire
		
		// Si la direction définie est un obstacle, lancer le contournement de l'obstacle
		// Sinon, se déplacer sur la case
	}
	
	// Vérifie si des phéromones sont proches de la position de la fourmi
	public void pheromoneAProximite(){
	
	}
	
	// Cherche le prochain phéromone à suivre
	public void searchNextPheromone(){
		
	}
	
	// Vérifie si de la nourriture est proche de la position de la fourmi
	public void hasNourritureProximite(){
	
	}
	
	// Récupère la nourriture
	public void getNourriture(){
		// Récupère une quantité de nourriture
		this.charge_porter++;
		
		// Met à jour la quantité dans l'objet nourriture
		
		
		// Retourne à la fourmilière
		this.isRetourFourmiliere = true;
		
		// Et dépose des phéromones en chemin
		this.deposePheromone = true;
	}
	
	// Dépose la nourriture à la fourmilière
	public void deposeNourriture(){
		// Met à jour la quantité dans l'objet fourmilière
		this.fourmiliere.qte_food_recolter += this.charge_porter;
		
		// Enlève une quantité de nourriture
		this.charge_porter--;
		
		// Désactive le retour à la fourmilière
		this.isRetourFourmiliere = false;
		
		// Et ne dépose plus de phéromones en chemin
		this.deposePheromone = false;
	}
	
	// Vérifie si un obstacle est proche de la position de la fourmi
	public void hasObstacleProximite(){
	
	}
	
	// Contourne un obstacle selon la stratégie d'évitement définie par l'utilisateur
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
