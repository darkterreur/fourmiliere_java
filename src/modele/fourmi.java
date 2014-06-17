package modele;

public class fourmi {
	//attribut
	// somme nous sur je ne suis pas persuader pour l'objet fourmiliere quoi que 
	private fourmiliere maFourmiliere;
	private food monFood;
	private int x;
	private int y;
	//on a plein pour cela
	//public boolean isRetourFourmiliere = false;
	private boolean suitPheromone = false;
	private boolean isSurNourriture = false;
	//pas besoin de cela les ph�romones seront mit en place lorsque la fourmit se d�place et qu'elle est pleinne via un controleur plus haut
	//public boolean deposePheromone = false;
	
	private int charge_max;
	private int charge_porter;
	private int plein;
	
	//methode
	public fourmi(int charge_max, int X, int Y, fourmiliere theFourmiliere, food theFood) {
		this.charge_max = charge_max;
		this.charge_porter = 0;
		this.plein = 0;
		this.x = X;
		this.y = Y;
		this.maFourmiliere = theFourmiliere;
		this.monFood = theFood;
	}
	
	//fonction existe deja et on met a jour l'objet nourriture plus haut dans un controleur
	// R�cup�re la nourriture
	/*public void getNourriture(){
		// R�cup�re une quantit� de nourriture
		this.charge_porter++;
		
		// Met � jour la quantit� dans l'objet nourriture
		
		
		// Retourne � la fourmili�re
		this.isRetourFourmiliere = true;
		
		// Et d�pose des ph�romones en chemin
		this.deposePheromone = true;
	}*/
	
	//pareil existe deja et c'est pas le bon endrois 
	// D�pose la nourriture � la fourmili�re
	/*public void deposeNourriture(){
		// Met � jour la quantit� dans l'objet fourmili�re
		this.fourmiliere.qte_food_recolter += this.charge_porter;
		
		// Enl�ve une quantit� de nourriture
		this.charge_porter--;
		
		// D�sactive le retour � la fourmili�re
		this.isRetourFourmiliere = false;
		
		// Et ne d�pose plus de ph�romones en chemin
		this.deposePheromone = false;
	}*/
	
	
	
	@Override
	public String toString() {
		return "fourmi [charge_max=" + charge_max + ", charge_porter=" + charge_porter + ", plein=" + plein + ", x=" + x + ", y=" + y + "" +
				", maFourmiliere=" + maFourmiliere + ", monFood=" + monFood + "]";
	}
	
	public void incrementCharge(){
		this.setCharge_porter(this.getCharge_porter()+1);
	}
	
	public void decrementCharge(){
		this.setCharge_porter(this.getCharge_porter()-1);
	}
	
	//on fait avancer la fourmit d'un pas oui mais tout les controle doivent se faire dans le controler
	// Fait avancer la fourmie d'un pas
	public void avance(int X, int Y) {
		this.setX(X);
		this.setY(Y);
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
	public int getX() {
		return x;
	}
	public void setX(int X) {
		this.x = X;
	}
	public int getY() {
		return y;
	}
	public void setY(int Y) {
		this.y = Y;
	}
	public fourmiliere getMaFourmiliere() {
		return maFourmiliere;
	}
	public void setMaFourmiliere(fourmiliere theFourmiliere) {
		this.maFourmiliere = theFourmiliere;
	}
	public food getMonFood() {
		return monFood;
	}
	public void setMonFood(food theFood) {
		this.monFood = theFood;
	}
}
