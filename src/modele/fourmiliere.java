package modele;

import controler.ctrl_fourmis;

public class fourmiliere {
	
	//attribut
	public int x;
	public int y;
	public monde monde;
	
	public int qte_food_recolter;
	public int qte_fourmi;
	public int max_fourmi;
	public int qte_food_creat_fourmi;
	ctrl_fourmis theCtrlFourmis = new ctrl_fourmis();
	
	//methode
	public fourmiliere(int qte_food_recolter, int qte_fourmi, int max_fourmi, monde monde) {
		this.qte_food_recolter = qte_food_recolter;
		this.qte_fourmi = qte_fourmi;
		this.max_fourmi = max_fourmi;
		this.qte_food_creat_fourmi = 500;
		this.monde = monde;
	}
	
	public void nextStep() {
		// Parcours toutes les fourmis de la fourmiliere et les fait avancer
	}

	@Override
	public String toString() {
		return "fourmiliere [qte_food_recolter=" + qte_food_recolter + ", qte_fourmi=" + qte_fourmi + 
				", max_fourmi=" + max_fourmi + ", qte_food_creat_fourmi=" + qte_food_creat_fourmi +"]";
	}

	public void ajoutFoodStock(int quantite){
		this.setQte_food_recolter(this.getQte_food_recolter()+quantite);
	}
	
	public void retirerFoodStock(int qte){
		this.setQte_food_recolter(this.getQte_food_recolter() - qte);
	}
	
	public void ajoutFourmi(){
		theCtrlFourmis.ajoutFourmi(10);
	}
	
	public void createView() {
		// Crée et dessine la fourmilière
	}
	
	public void suppressionFourmi(fourmi theFourmi){
		theCtrlFourmis.deleteFourmi(theFourmi);
	}
	
	//accesseur
	public int getQte_food_recolter() {
		return qte_food_recolter;
	}

	public void setQte_food_recolter(int qte_food_recolter) {
		this.qte_food_recolter = qte_food_recolter;
	}

	public int getQte_fourmi() {
		return qte_fourmi;
	}

	public void setQte_fourmi(int qte_fourmi) {
		this.qte_fourmi = qte_fourmi;
	}

	public int getMax_fourmi() {
		return max_fourmi;
	}

	public void setMax_fourmi(int max_fourmi) {
		this.max_fourmi = max_fourmi;
	}
	
	public int getQte_food_creat_fourmi() {
		return qte_food_creat_fourmi;
	}

	public void setQte_food_creat_fourmi(int qte_food_creat_fourmi) {
		this.qte_food_creat_fourmi = qte_food_creat_fourmi;
	}
	
	
	
	
	
}
