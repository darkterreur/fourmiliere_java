package modele;

import java.util.ArrayList;

public class fourmiliere {
	
	//attribut
	private int x;
	private int y;
	private monde monde;
	private int qte_food_recolter = 0;
	private int qte_fourmi = 0;
	private int max_fourmi;
	private int qte_food_creat_fourmi;
	private int qte_food_creat_fourmiliere;
	private int width = 0;
	private int height = 0;
	private ArrayList<fourmi> fourmis = new ArrayList<fourmi>();
	
	//methode
	public fourmiliere(int X, int Y, monde m) {//int qte_food_recolter,int X, int Y,  int qte_fourmi, int max_fourmi,int qte_food_creat_fourmi,int qte_food_creat_fourmiliere, monde monde) {
		/*this.qte_food_recolter = qte_food_recolter;
		this.qte_fourmi = qte_fourmi;
		this.max_fourmi = max_fourmi;
		this.qte_food_creat_fourmi = qte_food_creat_fourmi;//500
		this.qte_food_creat_fourmiliere = qte_food_creat_fourmiliere; //10000*/
		this.monde = m;
		this.x = X;
		this.y = Y;
		this.width = 70;
		this.height = 70;
	}
	
	
	
	public void nextStep() {
		// Parcours toutes les fourmis de la fourmiliere et les fait avancer
		ArrayList<fourmi> fourmis = this.fourmis;
		
		for (int i=0; i<fourmis.size(); i++) {
	    	fourmi fourmiCourante = fourmis.get(i);
	    	fourmiCourante.avance();
	    }
	}
	
	public void addFood(int quantite) {
		this.qte_food_recolter += quantite;
	}
	
	public void addFourmi() {
		this.fourmis.add(new fourmi(this));
	}
	
	public ArrayList<fourmi> getFourmis() {
		return this.fourmis;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public monde getMonde() {
		return this.monde;
	}
	
	public int getHeight() {
		return this.height;
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
	/*
	public void ajoutFourmi(int charge_max, int X, int Y, fourmiliere fourmiliere, food theFood){
		theCtrlFourmis.ajoutFourmi(charge_max,X, Y, this, theFood);
	}*/
	
	/*
	public void suppressionFourmi(fourmi theFourmi){
		theCtrlFourmis.deleteFourmi(theFourmi);
	}*/
	
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
		return this.x;
	}
	public void setX(int X) {
		this.x = X;
	}
	public int getY() {
		return this.y;
	}
	public void setY(int Y) {
		this.y = Y;
	}
}
