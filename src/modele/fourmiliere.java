package modele;

import controler.ctrl_fourmis;

public class fourmiliere {
	
	//attribut
	private int qte_food_recolter;
	private int qte_fourmi;
	private int max_fourmi;
	private int qte_food_creat_fourmi;
	ctrl_fourmis theCtrlFourmis = new ctrl_fourmis();
	
	//methode
	public fourmiliere(int qte_food_recolter, int qte_fourmi, int max_fourmi) {
		this.qte_food_recolter = qte_food_recolter;
		this.qte_fourmi = qte_fourmi;
		this.max_fourmi = max_fourmi;
		this.qte_food_creat_fourmi = 500;
	}

	@Override
	public String toString() {
		return "fourmiliere [qte_food_recolter=" + qte_food_recolter + ", qte_fourmi=" + qte_fourmi + 
				", max_fourmi=" + max_fourmi + ", qte_food_creat_fourmi=" + qte_food_creat_fourmi +"]";
	}

	public void ajoutFoodStock(){
		this.setQte_food_recolter(this.getQte_food_recolter()+1);
	}
	
	public void retirerFoodStock(int qte){
		this.setQte_food_recolter(this.getQte_food_recolter() - qte);
	}
	
	public void ajoutFourmi(){
		theCtrlFourmis.ajoutFourmi(10);
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
