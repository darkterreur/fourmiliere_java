package modele;

import controler.ctrl_fourmis;

public class fourmiliere {
	
	//attribut
	private int x;
	private int y;
	private monde monde;
	private int qte_food_recolter;
	private int qte_fourmi;
	private int max_fourmi;
	private int qte_food_creat_fourmi;
	private int qte_food_creat_fourmiliere;
	ctrl_fourmis theCtrlFourmis = new ctrl_fourmis();
	
	//methode
	public fourmiliere(int qte_food_recolter,int X, int Y,  int qte_fourmi, int max_fourmi,int qte_food_creat_fourmi,int qte_food_creat_fourmiliere, monde monde) {
		this.qte_food_recolter = qte_food_recolter;
		this.qte_fourmi = qte_fourmi;
		this.max_fourmi = max_fourmi;
		this.qte_food_creat_fourmi = qte_food_creat_fourmi;//500
		this.qte_food_creat_fourmiliere = qte_food_creat_fourmiliere; //10000
		this.monde = monde;
		this.x = X;
		this.y = Y;
	}
	
	public void nextStep() {
		// Parcours toutes les fourmis de la fourmiliere et les fait avancer
		
		
		
	}

	
	
	@Override
	public String toString() {
		return "fourmiliere [qte_food_recolter=" + qte_food_recolter + ", qte_fourmi=" + qte_fourmi + 
				", max_fourmi=" + max_fourmi + ", qte_food_creat_fourmi=" + qte_food_creat_fourmi +
				", qte_food_creat_fourmiliere=" + qte_food_creat_fourmiliere +"]";
	}

	public void ajoutFoodStock(int quantite){
		this.setQte_food_recolter(this.getQte_food_recolter()+quantite);
	}
	
	public void retirerFoodStock(int qte){
		this.setQte_food_recolter(this.getQte_food_recolter() - qte);
	}
	
	public void ajoutFourmi(int charge_max, int X, int Y, fourmiliere fourmiliere, food theFood){
		theCtrlFourmis.ajoutFourmi(charge_max,X, Y, this, theFood);
	}
	
	//non c'est pas ici ca c'est dans une vue ou la vue gŽnŽral
	/*
	public void createView() {
		// Crée et dessine la fourmilière
	}*/
	
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
	public int getQte_food_creat_fourmiliere() {
		return qte_food_creat_fourmi;
	}
	public void setQte_food_creat_fourmiliere(int qte_food_creat_fourmiliere) {
		this.qte_food_creat_fourmiliere = qte_food_creat_fourmiliere;
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
	public ctrl_fourmis getCtrlFourmis(){
		return theCtrlFourmis;
	}
	
	
}
