package modele;

import java.util.ArrayList;
import java.util.Hashtable;

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
	//pas besoin de cela les phŽromones seront mit en place lorsque la fourmit se dŽplace et qu'elle est pleinne via un controleur plus haut
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
	// Récupère la nourriture
	/*public void getNourriture(){
		// Récupère une quantité de nourriture
		this.charge_porter++;
		
		// Met à jour la quantité dans l'objet nourriture
		
		
		// Retourne à la fourmilière
		this.isRetourFourmiliere = true;
		
		// Et dépose des phéromones en chemin
		this.deposePheromone = true;
	}*/
	
	//pareil existe deja et c'est pas le bon endrois 
	// Dépose la nourriture à la fourmilière
	/*public void deposeNourriture(){
		// Met à jour la quantité dans l'objet fourmilière
		this.fourmiliere.qte_food_recolter += this.charge_porter;
		
		// Enlève une quantité de nourriture
		this.charge_porter--;
		
		// Désactive le retour à la fourmilière
		this.isRetourFourmiliere = false;
		
		// Et ne dépose plus de phéromones en chemin
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
	
	public ArrayList calculPositionDirectPossible(){
		/*Quand nous avons deux point x et y en position inconnu tel que i soit xi et yi
		 * 		
		 * 		xi+1, yi
		 * 		xi, yi+1
		 * 		xi-1, yi
		 * 		xi, yi-1
		 * 		xi+1, yi+1
		 * 		xi-1, yi-1
		 * 		xi-1, yi+1
		 * 		xi+1, yi-1
		 * 
		*/
		ArrayList listDeplacement = new ArrayList();
		int value = 1;
		
		switch (value){
			case 1:
				Hashtable ht1 = new Hashtable();
				ht1.put("x", this.getX()+1);
				ht1.put("y", this.getY());
				listDeplacement.add(ht1);
				;
				
			case 2:
				Hashtable ht2 = new Hashtable();
				ht2.put("x", this.getX());
				ht2.put("y", this.getY()+1);
				listDeplacement.add(ht2);
				;
				
			case 3:
				Hashtable ht3 = new Hashtable();
				ht3.put("x", this.getX()-1);
				ht3.put("y", this.getY());
				listDeplacement.add(ht3);
				;
				
			case 4:
				Hashtable ht4 = new Hashtable();
				ht4.put("x", this.getX());
				ht4.put("y", this.getY()-1);
				listDeplacement.add(ht4);
				;
				
			case 5:
				Hashtable ht5 = new Hashtable();
				ht5.put("x", this.getX()+1);
				ht5.put("y", this.getY()+1);
				listDeplacement.add(ht5);
				;
				
			case 6:
				Hashtable ht6 = new Hashtable();
				ht6.put("x", this.getX()-1);
				ht6.put("y", this.getY()-1);
				listDeplacement.add(ht6);
				;
				
			case 7:
				Hashtable ht7 = new Hashtable();
				ht7.put("x", this.getX()-1);
				ht7.put("y", this.getY()+1);
				listDeplacement.add(ht7);
				;
				
			case 8:
				Hashtable ht8 = new Hashtable();
				ht8.put("x", this.getX()+1);
				ht8.put("y", this.getY()-1);
				listDeplacement.add(ht8);
				;
		}
		
		return listDeplacement;
		
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
